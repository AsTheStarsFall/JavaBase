package com.tianhy.javabase.multithread.webserver;

import com.tianhy.javabase.multithread.webserver.Httpd;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.*;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/4 3:07
 **/
public class Handler {
    //from viewer
    protected BufferedReader is;
    //to viewer
    protected PrintStream os;
    //main
    protected Httpd parent;
    //目录中默认文件名
    protected static final String DEF_NAME = "index.html";
    public static final String CRLF = "\r\n";

    /**
     * 哈希表存储读取到的URL
     * 静态的全局共享
     */
    private static Map<String, Object> cache = new HashMap<>();

    static {
        cache.put("", "<html><body><b>Unknown server error</b>".getBytes());
    }

    //Construct
    public Handler(Httpd parent) {
        this.parent = parent;
    }

    protected static final int RQ_INVALID = 0, RQ_GET = 1, RQ_HEAD = 2, RQ_POST = 3;


    public void process(Socket socket) {
        String request;
        try {

            //请求方法类型
            int methodType = RQ_INVALID;
            System.out.println("Connection accepted from " + socket.getInetAddress());

            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //在任何errorResponse被调用之前, have do this
            os = new PrintStream(socket.getOutputStream());

            request = is.readLine();
            if (request == null || request.length() == 0) {
                System.err.println("no request info");
                return;
            }

            //StringTokenizer将请求分为三部分
            //HTTP方法、资源名称、HTTP版本
            StringTokenizer st = new StringTokenizer(request);
            //如果不是三个部分，解析异常
            if (st.countTokens() != 3) {
                errorResponse(444, "Unparseable input " + request);
                socket.close();
                return;
            }
            String rqCommand = st.nextToken();
            String rqName = st.nextToken();
            String rqVer = st.nextToken();
            System.out.println("Request:  command:" + rqCommand + ",name: " + rqName + "version:" + rqVer);

            //检查请求的类型
            if ("get".equalsIgnoreCase(rqCommand)) {
                methodType = RQ_GET;
            } else if ("head".equalsIgnoreCase(rqCommand)) {
                methodType = RQ_HEAD;
            } else if ("post".equalsIgnoreCase(rqCommand)) {
                methodType = RQ_POST;
            } else {
                errorResponse(400, "invalid method :" + rqCommand);
                socket.close();
                return;
            }

            //读取头部，直到正文之前的空行，如果是POST，正文可以直接被读取
            Map<String, String> headersMap = new HashMap<>();
            String hdLine;
            while ((hdLine = is.readLine()) != null && hdLine.length() != 0) {
                int x;
                if ((x = hdLine.indexOf(':')) != -1) {
                    String hdname = hdLine.substring(0, x);
                    String hdvalue = hdLine.substring(x + 1).trim();
                    System.out.println("hdname:" + hdname + ", hdvalue:" + hdvalue);
                    headersMap.put(hdname, hdvalue);
                } else {
                    System.err.println("INVALID HEADER: " + hdLine);
                }
            }
            doFile(rqName, methodType == RQ_HEAD, os /*, map */);
            os.flush();
            socket.close();

        } catch (IOException e) {
            System.err.println("IOexception " + e);
        }
        System.out.println("Request end");

    }

    private void doFile(String rqName, boolean headerOnly, PrintStream os) throws IOException {
        File f;
        byte[] content = null;
        Object o = cache.get(rqName);
        if (o != null && o instanceof byte[]) {
            content = (byte[]) o;
            System.out.println("Using cache file :" + rqName);
            sendFile(rqName, headerOnly, content, os);
            //make new file
        } else if ((f = new File(parent.getRootDir() + rqName)).isDirectory()) {
            // index.html?
            File index = new File(f, DEF_NAME);
            if (index.isFile()) {
                doFile(rqName + DEF_NAME, index, headerOnly, os);
                return;
            } else {
                //如果是目录
                System.out.println("DIRECTORY FOUND");
                doDirList(rqName, f, headerOnly, os);
                sendEnd();
            }

        } else if (f.canRead()) {

            // REGULAR FILE
            doFile(rqName, f, headerOnly, os);
        } else {
            errorResponse(404, "File not found");
        }

    }

    /**
     * Send one file, given the filename and contents.
     *
     * @param justHead - if true, send heading and return.
     */
    void sendFile(String fname, boolean justHead,
                  byte[] content, PrintStream out) throws IOException {
        out.print("HTTP/1.0 200 Here's your file" + CRLF);
        out.print("Content-type: " + guessMime(fname) + CRLF);
        out.print("Content-length: " + content.length + CRLF);
        out.print(CRLF);
        if (justHead)
            return;
        out.write(content);
    }

    protected void errorResponse(int errNum, String errMsg) {
        // Check for localized messages
//        ResourceBundle messages = ResourceBundle.getBundle("errors");
/*        ResourceBundle messages = ResourceBundle.getBundle("errors");

        String response;
        try {
            response = messages.getString(Integer.toString(errNum));
        } catch (MissingResourceException e) {
            response = errMsg;
        }*/
        String response;
        response = "xxxxxxxx";
        // Generate and send the response
        os.print("HTTP/1.0 " + errNum + " " + response + CRLF);
        os.print("Content-type: text/html" + CRLF);
        os.print(CRLF);
        os.println("<html>");
        os.println("<head><title>Error " + errNum + "--" + response +
                "</title></head>");
        os.println("<h1>" + errNum + " " + response + "</h1>");
        sendEnd();
    }

    /**
     * Send one file, given a File object.
     */
    void doFile(String rqName, File f, boolean headerOnly, PrintStream out) throws IOException {
        System.out.println("Loading file " + rqName);
        InputStream in = new FileInputStream(f);
        byte c_content[] = new byte[(int) f.length()];
        // Single large read, should be fast.
        in.read(c_content);
        //缓存
        cache.put(rqName, c_content);
        sendFile(rqName, headerOnly, c_content, out);
        in.close();
    }

    void doDirList(String rqName, File dir, boolean justAHead, PrintStream out) {
        out.print("HTTP/1.0 200 directory found" + CRLF);
        out.print("Content-type: text/html" + CRLF);
        out.print("Date: " + LocalDateTime.now() + CRLF);
        out.print(CRLF);
        if (justAHead)
            return;
        out.println("<html>");
        out.println("<head><title>Contents of directory " + rqName + "</title></head>");
        out.println("<body><h1>Contents of directory " + rqName + "</h1>");
        String fl[] = dir.list();
        Arrays.sort(fl);
        for (int i = 0; i < fl.length; i++)
            out.println("<br/><a href=\"" + rqName + File.separator + fl[i] + "\">" +
                    "<img align='center' border='0' src=\"/images/file.jpg\">" +
                    ' ' + fl[i] + "</a>");
    }

    /**
     * Send the tail end of any page we make up.
     */
    protected void sendEnd() {
        os.println("<hr>");
        os.println("<address>Java Web Server,");
        String myAddr = "http://www.darwinsys.com/freeware/";
        os.println("<a href=\"" + myAddr + "\">" +
                myAddr + "</a>");
        os.println("</address>");
        os.println("</html>");
        os.println();
    }

    /**
     * The type for unguessable files
     */
    final static String UNKNOWN = "unknown/unknown";

    protected String guessMime(String fn) {
        String lcname = fn.toLowerCase();
        int extenStartsAt = lcname.lastIndexOf('.');
        if (extenStartsAt < 0) {
            if (fn.equalsIgnoreCase("makefile"))
                return "text/plain";
            return UNKNOWN;
        }
        String exten = lcname.substring(extenStartsAt);
        String guess = parent.getMimeType(exten, UNKNOWN);

        return guess;
    }

}
