package com.tianhy.javabase.serialize.pojo;

import lombok.Data;

import java.io.*;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3566626784519023457L;


    //transient关键字禁止序列化
    private String name;
    private int age;

    //如果要绕开transient关键字，需要新增以下两个方法
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(name);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        name = (String) ois.readObject();
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
