package cn.ehi.excel;

import cn.ehi.poi.annotation.ExcelFile;
import cn.ehi.poi.annotation.ExcelSheet;

import java.util.List;

@ExcelFile(fileName = "grade.xlsx")
public class Grade {

    @ExcelSheet(name = "classsssss")
    private List<Clazz> clazzes;

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
}
