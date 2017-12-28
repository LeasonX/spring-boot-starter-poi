package cn.ehi.excel;

import cn.ehi.poi.annotation.ExcelField;

public class Clazz {

    @ExcelField(name = "姓名")
    private String name;

    @ExcelField(name = "年龄")
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
