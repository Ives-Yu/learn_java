package com.lagou.task14;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class modular_01_04_fifth_customer {

    public static void main(String[] args) {
        PrintStream p1 = null;
        Socket s1 = null;

        try {
            s1 = new Socket("127.0.0.1", 7000);
            p1 = new PrintStream(s1.getOutputStream());
            p1.print("是心动啊！");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p1 != null) {
                p1.close();
            }
            if (s1 != null) {
                try {
                    s1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
