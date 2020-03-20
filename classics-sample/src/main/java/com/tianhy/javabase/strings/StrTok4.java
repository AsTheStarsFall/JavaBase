

package com.tianhy.javabase.strings;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@link}
 *
 * @Desc: 按照规定好的分隔符分隔字符串
 * @Author: thy
 * @CreateTime: 2020/2/29 5:50
 **/
public class StrTok4 {
    public static final int MAXFIELDS = 5;
    public static final String DELIM = "|";

    //处理一个字符串，作为一个字符串数数组返回
    public static String[] process(String line) {
        String[] results = new String[MAXFIELDS];

        StringTokenizer st = new StringTokenizer(line, DELIM, true);

        int i = 0;
        //将每个标记填入数组当前索引
        while (st.hasMoreElements()) {
            String s = st.nextToken();
            if (s.equals(DELIM)) {
                if (i++ >= MAXFIELDS) {
                    throw new IllegalArgumentException("line input " + line + "has too many fields");
                }
                continue;
            }
            results[i] = s;
        }
        return results;
    }

    //打印结果
    public static void printResults(String input, String[] outputs) {
        System.out.println("Input:" + input);
        for (int i = 0; i < outputs.length; i++) {
            System.out.println("Output " + i + " was:" + outputs[i]);

        }
    }

    //正则表达式更灵活，比如从字符串取数字
    public static void tokInt(String string) {
        Matcher toke = Pattern.compile("\\d+").matcher(string);
        while (toke.find()) {
            String group = toke.group();
            int i = Integer.parseInt(group);
            System.out.println(i);
        }


    }

    public static void main(String[] args) {
//        printResults("A|B|C|D", process("A|B|C|D"));
        printResults("A||B|C|D", process("A||B|C|D"));

//        tokInt("He3ll0o Wor5l0d!");
    }

}



