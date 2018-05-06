package cn.ehi.poi.configuration;

import cn.ehi.poi.handler.ExcelExportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableConfigurationProperties(value = ExcelProperties.class)
@ConditionalOnClass(ExcelExportHandler.class)
@ConditionalOnProperty(prefix = "excel",value = "enable",matchIfMissing = true)
public class ExcelAutoConfiguration {

    @Autowired
    private ExcelProperties excelProperties;

    @Bean(name = "excelDir")
    public String excelDir(){
        Path excelPath = Paths.get(excelProperties.getExportDir());
        if(!Files.exists(excelPath, LinkOption.NOFOLLOW_LINKS)){
            try {
                Files.createDirectory(excelPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return excelProperties.getExportDir();
    }

    @Bean(name = "excelExportHandler")
    @ConditionalOnMissingBean(ExcelExportHandler.class)
    public ExcelExportHandler excelExportHandler(){
        ExcelExportHandler excelExportHandler = new ExcelExportHandler();
        excelExportHandler.setExcelDir(excelProperties.getExportDir());
        return excelExportHandler;
    }

}
