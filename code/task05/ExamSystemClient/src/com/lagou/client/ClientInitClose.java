package com.lagou.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientInitClose {
    private Socket s1;
    private Socket s2;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private ObjectInputStream oes;
    private ObjectOutputStream ows;


    public Socket getS1() {
        return s1;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectInputStream getOes() {
        return ois;
    }

    public ObjectOutputStream getOws() {
        return ows;
    }

    public void init () throws IOException {
        String url = "127.0.0.1";
        s1 = new Socket(url, 8050);
//        s2 = new Socket(url, 8050);
        oos = new ObjectOutputStream(s1.getOutputStream());
        ois = new ObjectInputStream(s1.getInputStream());

//
//        ows = new ObjectOutputStream(s2.getOutputStream());
//        oes = new ObjectInputStream(s2.getInputStream());

        System.out.println("客户端连接成功！");
    }

    public void close () throws IOException {
        oos.close();
        ois.close();
//        oes.close();
//        ows.close();
        s1.close();
    }
}
