package com.cqu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 实体类
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;


}
