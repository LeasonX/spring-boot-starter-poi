package cn.ehi.excel;

import cn.ehi.poi.annotation.ExcelField;

public class Fruit {

    @ExcelField(name = "名称")
    private String name;

    @ExcelField(name = "价格")
    private double price;

    @ExcelField
    private String cityFrom;

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

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", cityFrom='" + cityFrom + '\'' +
                '}';
    }
}
