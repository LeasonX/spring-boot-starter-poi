package cn.ehi.poi.handler;

import cn.ehi.poi.annotation.ExcelField;
import cn.ehi.poi.annotation.ExcelFile;
import cn.ehi.poi.annotation.ExcelSheet;
import com.sun.istack.internal.NotNull;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ExcelExportHandler {

    private String excelDir;

    public void exportExcel(@NotNull Object exportObj) throws IOException {

        Class<?> exportObjClass = exportObj.getClass();
        ExcelFile excelFileAnnotation = exportObjClass.getAnnotation(ExcelFile.class);
        if (excelFileAnnotation == null) {
            throw new RuntimeException("导出对象类型必须存在@ExcelFile注解.");
        }

        Workbook workbook = new SXSSFWorkbook(500);

        String fileName = Optional.of(excelFileAnnotation.fileName()).orElse(exportObjClass.getSimpleName());

        if (exportObjClass.getDeclaredFields() != null && exportObjClass.getDeclaredFields().length > 0) {
            for (Field sheetListField : exportObjClass.getDeclaredFields()) {
                if (!Modifier.isStatic(sheetListField.getModifiers()) && sheetListField.getAnnotation(ExcelSheet.class) != null) {
//                    ExcelSheet excelSheetAnnotation = sheetListField.getAnnotation(ExcelSheet.class);
                    String filedName = sheetListField.getName();
                    filedName = filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
                    Method sheetListGetter;
                    try {
                        sheetListGetter = exportObjClass.getDeclaredMethod("get" + filedName);
                        List sheetList = (List) sheetListGetter.invoke(exportObj);
                        if (sheetList.isEmpty()) {
                            throw new RuntimeException("@ExcelSheet注解参数["+filedName+"]数据为空.");
                        }
                        makeSheet(workbook, sheetList);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException("@ExcelSheet注解参数["+filedName+"]无getter方法.");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("@ExcelSheet注解参数["+filedName+"]getter方法无权限访问.");
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("@ExcelSheet注解参数["+filedName+"]getter方法调用失败.");
                    }catch (ClassCastException e){
                        throw new RuntimeException("@ExcelSheet注解参数["+filedName+"]数据类型必须为java.util.List类型.");
                    }
                }
            }
            //file write
            FileOutputStream fos = new FileOutputStream(getExcelDir() + "/" + fileName);
            workbook.write(fos);
            fos.close();
        }

    }

    private static void makeSheet(Workbook workbook, List<?> sheetList) {
        Class<?> sheetDataClass = sheetList.get(0).getClass();
//        ExcelSheet excelSheetAnnotation = (ExcelSheet) sheetDataClass.getAnnotation(ExcelSheet.class);
//        String sheetName = Optional.of(sname).orElse(sheetDataClass.getSimpleName());
        Map<String, ExcelField> excelFieldMap = new HashMap<>();
        for (Field sheetDataField : sheetDataClass.getDeclaredFields()) {
            ExcelField excelFieldAnnotation = sheetDataField.getAnnotation(ExcelField.class);
            if (excelFieldAnnotation != null) {
                excelFieldMap.put(sheetDataField.getName(), excelFieldAnnotation);
            }
        }
        Sheet sheet;
        sheet = workbook.createSheet();

        Row headRow = sheet.createRow(0);
        int colIndex = 0;
        for (String sheetHeader : excelFieldMap.keySet()) {
            Cell cell = headRow.createCell(colIndex++);
            String headerName = excelFieldMap.get(sheetHeader).name();
            cell.setCellValue(headerName.isEmpty() ? sheetHeader : headerName);
        }

        int rowCount = sheetList.size();
        for (int i = 0; i < rowCount; i++) {
            colIndex = 0;
            Row row = sheet.createRow(i + 1);
            for (String sheetHeader : excelFieldMap.keySet()) {
                try {
                    sheetHeader = sheetHeader.substring(0, 1).toUpperCase() + sheetHeader.substring(1);
                    Method dataGetter = sheetDataClass.getDeclaredMethod("get" + sheetHeader);
                    Object data = dataGetter.invoke(sheetList.get(i));
                    Cell cell = row.createCell(colIndex++);
                    cell.setCellValue(String.valueOf(data));
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException("@ExcelFiled注解参数["+ sheetHeader +"]无getter方法.");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("@ExcelFiled注解参数["+ sheetHeader +"]getter方法无访问权限.");
                } catch (InvocationTargetException e) {
                    throw new RuntimeException("@ExcelFiled注解参数["+ sheetHeader +"]getter方法调用失败.");
                }
            }
        }
    }


    private String getExcelDir() {
        return excelDir;
    }

    public void setExcelDir(String excelDir) {
        this.excelDir = excelDir;
    }
}
