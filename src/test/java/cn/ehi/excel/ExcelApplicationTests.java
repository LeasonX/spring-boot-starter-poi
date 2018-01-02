package cn.ehi.excel;

import cn.ehi.poi.handler.ExcelExportHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelApplicationTests {

	@Autowired
	private ExcelExportHandler excelExportHandler;

	@Test
	public void contextLoads() throws IOException {

		Food food = new Food();

		List<Fruit> fruits = new ArrayList<>();
		for(int i =0;i<10000;i++){
			Fruit fruit = new Fruit();
			fruit.setName("水果"+i);
			fruit.setPrice(i*1.1);
			fruit.setCityFrom("上海");
			fruits.add(fruit);
		}

		List<Vegetable> vegetables = new ArrayList<>();
		for(int i =0;i<6000;i++){
			Vegetable vegetable = new Vegetable();
			vegetable.setName("蔬菜"+i);
			vegetable.setPrice(i*1.1);
			vegetables.add(vegetable);
		}

		food.setFruits(fruits);
		food.setVegetables(vegetables);

		excelExportHandler.exportExcel(food);
	}

}
