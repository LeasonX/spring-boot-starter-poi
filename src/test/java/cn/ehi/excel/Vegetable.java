package cn.ehi.excel;

import cn.ehi.poi.annotation.ExcelField;

public class Vegetable {

    @ExcelField(name = "名称")
    private String name;

    @ExcelField
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
