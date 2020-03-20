package com.tianhy.javabase.io;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * {@link}
 *
 * @Desc: 扫描文件内容
 * <p>
 * 例如有一个文件，其中包含一个类似 user@host.domain的内容，提取用户名和驻地地址
 * @Author: thy
 * @CreateTime: 2020/3/2 5:29
 **/
public class ScanStringTok {

    protected LineNumberReader is;

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = System.getProperty("user.dir") + File.separator + "users.txt";
        new ScanStringTok(filePath).process();

    }

    //由文件名构成一个文件扫描器
    public ScanStringTok(String fileName) throws FileNotFoundException {
        is = new LineNumberReader(new FileReader(fileName));
    }

    public ScanStringTok(Reader r) {
        if (r instanceof LineNumberReader) {
            is = (LineNumberReader) r;
        } else {
            is = new LineNumberReader(r);
        }
    }

    protected void process() {
        String s = null;
        try {
            while ((s = is.readLine()) != null) {
                //将字符串 s ，以 @ 分隔
                StringTokenizer stringTokenizer = new StringTokenizer(s, "@", true);
                String user = (String) stringTokenizer.nextElement();
                stringTokenizer.nextElement();
                String host = (String) stringTokenizer.nextElement();
                System.out.println("User name :" + user + "\nhost name :" + host);
                /**
                 * User name :tianhy
                 * host name :127.0.0.1.domain
                 */
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (NoSuchElementException e) {
            System.err.println("Line " + is.getLineNumber() + "invalid input" + s);
        }
    }
}
