package com.lagou.task14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class modular_01_04_fifth_service {

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket sk = null;

        try {
            ss = new ServerSocket(7000);
            while (true) {
                sk = ss.accept();
                new fifth_many(ss, sk).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
