package com.cxy;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.Socket;



public class Client {

    public static void main(String[] args) throws Exception, IOException {

        //1，与服务器建立连接

        //同桌启动服务器，你当客户端发送

        Socket s = new Socket("127.0.0.1",8000);



        //2，取出双向的流

        InputStream in = s.getInputStream();

        OutputStream out = s.getOutputStream();



        //3，通信

        /*

         * 先发送Hello，再接收world

         */

        //给服务器发送数据

        out.write("hello".getBytes());

        out.flush();



        //接收服务器响应的数据

        for (int i = 0; i < 5 ; i++) {

            char c = (char) in.read();

            System.out.print(c);//同一行展示

        }



        //释放资源

        s.close();



    }



}