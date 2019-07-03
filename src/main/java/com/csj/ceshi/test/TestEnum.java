package com.csj.ceshi.test;

public enum TestEnum {
    基本账户(0),
    一般账户(1),
    其他(2);

    public Integer getStatus() {
        return status;
    }

    private Integer status;

    TestEnum(Integer status) {
        this.status = status;
    }
}
