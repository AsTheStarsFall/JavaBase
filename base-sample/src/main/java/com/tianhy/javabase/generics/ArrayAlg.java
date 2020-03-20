package com.tianhy.javabase.generics;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/5/26
 **/
public class ArrayAlg {

    public static Pair<String> minmax(String[] s){

        if(s == null || s.length ==0){
            return null;
        }
        String min = s[0];
        String max = s[0];

        for (int i = 0; i < s.length; i++) {
            if(min.compareTo(s[i])>0){
                min = s[i];
            }
            if(max.compareTo(s[i])<0){
                max = s[i];
            }
        }
        return new Pair<>(min,max);
    }
}
