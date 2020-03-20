package com.tianhy.javabase.json;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/20
 **/
@Setter
@Getter
public class Human {
    private String name;
    private int age;
    private List Hobbies;
    private Date time;

}
