package cn.ehi.excel;

import cn.ehi.poi.annotation.ExcelFile;
import cn.ehi.poi.annotation.ExcelSheet;

import java.util.List;

@ExcelFile(fileName = "食物.xlsx")
public class Food {

    @ExcelSheet(name = "水果")
    private List<Fruit> fruits;

    @ExcelSheet(name = "蔬菜")
    private List<Vegetable> vegetables;

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }
}
