package com.lagou.test;

import com.lagou.client.ClientInitClose;
import com.lagou.client.ClientView;

import java.io.IOException;

public class ClientTest {

    public static void main(String[] args) {

        ClientInitClose cic = null;
        ClientView cv = null;
        try {
            System.out.println("1111");
            cic = new ClientInitClose();
            cic.init();
            System.out.println("11111");
            cv = new ClientView(cic);
            System.out.println("11111");
            cv.clientMainPage();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != cic) {
                try {
                    cic.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
