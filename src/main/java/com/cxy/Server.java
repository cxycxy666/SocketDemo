package com.cxy;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws Exception {

        //1，在指定端口启动服务

        ServerSocket server = new ServerSocket(8000);



        //2，等待客户端发起连接，并建立通道

        Socket socket = server.accept();



        //3，取出双向的流

        InputStream in = socket.getInputStream();

        OutputStream out = socket.getOutputStream();



        //4，通信

        /*

         * 通信协议：

         * 1，通信流程

         * 2，数据格式

         * 先接收hello，在发送world

         */

        //接收客户端发来的hello

        for(int i = 0 ; i < 5 ;i++) {

            //一个一个字节从网络流中读取客户端发来的数据

            char c = (char) in.read();

            System.out.print(c);//一行展示收到的数据

        }



        //给客户端发送数据

        out.write("world".getBytes());

        out.flush();//刷出内存缓存



        //释放资源

        socket.close();//断开连接

        server.close();//释放端口



    }

}

