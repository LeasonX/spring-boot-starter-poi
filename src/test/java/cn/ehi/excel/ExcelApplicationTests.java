package cn.ehi.excel;

import cn.ehi.poi.handler.ExcelExportHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelApplicationTests {

	@Autowired
	private ExcelExportHandler excelExportHandler;

	@Test
	public void contextLoads() throws IOException {

		Grade grade = new Grade();

		List<Clazz> clazzes = new ArrayList<>();
		Clazz clazz1 = new Clazz();
		clazz1.setAge(10);
		clazz1.setName("hehe");
		clazzes.add(clazz1);
		Clazz clazz2 = new Clazz();
		clazz2.setAge(100);
		clazz2.setName("haa");
		clazzes.add(clazz2);
		grade.setClazzes(clazzes);

		excelExportHandler.exportExcel(grade);
	}

}
