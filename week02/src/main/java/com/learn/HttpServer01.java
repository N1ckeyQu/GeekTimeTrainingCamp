package com.learn;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 不知道哪里写错了，访问localhost:8805不返回自定义文本内容
 */
public class HttpServer01 {
    public static void main(String[] args) {
        //监听8801端口
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8805);

            //等待客户端访问8801端口
            while (true) {
                //有请求打进来，选择接受
                Socket socket = serverSocket.accept();
                //进入自定义逻辑
                service(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给客户端返回一段自定义报文
     *
     * @param socket
     * @throws IOException
     */
    private static void service(Socket socket) {
        try {
            //获取要返回给客户端的输出流
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            //HTTP请求头
            printWriter.write("HTTP/1.1 200 OK");
            printWriter.write("Content-Type:text/html;charset=utf-8");
            //写入自定义内容
            String body = "Hello,socket";
            //告知客户端body的长度
            printWriter.write("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            //关闭资源
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
