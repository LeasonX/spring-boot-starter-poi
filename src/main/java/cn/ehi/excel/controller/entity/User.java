package cn.ehi.excel.controller.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class User {


    @NotBlank(message = "名称不能为空")
    private String name;

    @Max(value = 100,message = "年龄最大为100")
    @Min(value = 1,message = "年龄最小为1")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
