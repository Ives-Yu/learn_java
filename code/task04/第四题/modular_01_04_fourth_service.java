package com.lagou.task14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class modular_01_04_fourth_service {

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket sk = null;
        ObjectInputStream is = null;
        String url = "127.0.0.1";
        ObjectOutputStream p1 = null;

        try {
            ss = new ServerSocket(6000);
            System.out.println("正在连接！");
            sk = ss.accept();
            System.out.println("连接成功！！！");

            is = new ObjectInputStream(sk.getInputStream());
            UserMessage se = (UserMessage) is.readObject();

            User us = se.getUs();
            String username = us.getUsername();
            String pwd = us.getPassword();
            if (("admin".equals(username)) && ("123456".equals(pwd))) {
                se.setClas("succss");
            } else {
                se.setClas("fail");
            }

            p1 =  new ObjectOutputStream(sk.getOutputStream());
            p1.writeObject(se);

            System.out.println(se);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (sk != null) {
                try {
                    sk.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
