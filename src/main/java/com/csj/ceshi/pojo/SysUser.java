package com.csj.ceshi.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class SysUser {
    private String userName;
    private String age;
    private String phone;
}
