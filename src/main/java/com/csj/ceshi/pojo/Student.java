package com.csj.ceshi.pojo;

import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;
@ApiModel(value = "com.csj.ceshi.pojo.Student",description = "学生参数")
public class Student {
    private BigDecimal stuid;

    private String stuname;

    private BigDecimal stuage;

    private String stusex;

    private String height;

    private String weight;

    public BigDecimal getStuid() {
        return stuid;
    }

    public void setStuid(BigDecimal stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public BigDecimal getStuage() {
        return stuage;
    }

    public void setStuage(BigDecimal stuage) {
        this.stuage = stuage;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex == null ? null : stusex.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }
}