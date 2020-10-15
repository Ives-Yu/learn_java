package com.lagou.test;

import com.lagou.server.ServerInitClose;
import com.lagou.server.ServerView;

import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) {
        ServerInitClose sic = new ServerInitClose();
        ServerView sv = null;
        try {
            while (true) {

                sic.init();
                sv = new ServerView (sic);
                sv.serverReceive();
                sic.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                sic.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
