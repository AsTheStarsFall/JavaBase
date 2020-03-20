package com.tianhy.javabase.generics;

import lombok.Data;

/**
 * @Desc: 泛型，T(U/S) 表示任意类型, E 表示集合的元素类型，K/V 表示关键字与值得类型
 * @Author: thy
 * @CreateTime: 2019/3/21
 **/
@Data
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
}
