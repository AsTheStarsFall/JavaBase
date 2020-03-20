package com.tianhy.javabase.os.commond_args;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/2/29 4:27
 **/
public class GetOptDesc {
    private char c;

    private String number;

    private boolean b = false;

    public GetOptDesc(char c, String number, boolean b) {
        this.c = c;
        this.number = number;
        this.b = b;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
