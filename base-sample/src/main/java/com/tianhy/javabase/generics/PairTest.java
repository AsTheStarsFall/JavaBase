package com.tianhy.javabase.generics;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/5/26
 **/
public class PairTest {

    public static void main(String[] args) {
        String[] strings = {"Mary", "had", "a", "little", "lamb" };
//        Pair<String> pair = ArrayAlg.minmax(strings);
//        System.out.println(pair.getFirst());
//        System.out.println(pair.getSecond());

        System.out.println(strings[0].compareTo(strings[2]));
    }


}
