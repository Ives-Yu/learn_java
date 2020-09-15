package com.lagou.task14;

import java.io.*;
import java.net.Socket;

public class modular_01_04_fourth_customer {

    public static void main(String[] args) {

        Socket sk = null;
        String url = "127.0.0.1";
        ObjectOutputStream p1 = null;
        UserMessage us = null;
        ObjectInputStream is = null;

        try {
            sk = new Socket(url, 6000);
            System.out.println("连接成功");

            us = new UserMessage("aaa", new User("admin", "123456"));
            p1 = new ObjectOutputStream(sk.getOutputStream());
            p1.writeObject(us);

            is = new ObjectInputStream(sk.getInputStream());
            UserMessage se = (UserMessage) is.readObject();

            if ("success".equals(se.getClas())) {
                System.out.println("登陆成功！");
            } else {
                System.out.println("登陆失败！");
            }

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
            if (p1 != null) {
                try {
                    p1.close();
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
