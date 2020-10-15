package com.lagou.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerInitClose {

    public static ServerSocket s1;
    public static Socket s2;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void init () throws IOException, ClassNotFoundException {
        s1 = new ServerSocket(8050);
        System.out.println("等待客户端连接。。。");
        s2 = s1.accept();
        System.out.println("客户端连接成功。。。");
        ois = new ObjectInputStream(s2.getInputStream());
        oos = new ObjectOutputStream(s2.getOutputStream());

    }

    public void close () throws IOException {
        ois.close();
        oos.close();
        s1.close();
    }
}
