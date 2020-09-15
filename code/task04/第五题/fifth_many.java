package com.lagou.task14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class fifth_many extends Thread {

    ServerSocket ss;
    Socket sk;
    BufferedReader is;
    String url = "127.0.0.1";
    PrintStream p1;

    public fifth_many () {}

    public fifth_many(ServerSocket ss, Socket sk) {
        setSk(sk);
        setSs(ss);
    }

    public ServerSocket getSs() {
        return ss;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }

    public Socket getSk() {
        return sk;
    }

    public void setSk(Socket sk) {
        this.sk = sk;
    }

//    public BufferedReader getIs() {
//        return is;
//    }
//
//    public void setIs(BufferedReader is) {
//        this.is = is;
//    }
//
//    public PrintStream getP1() {
//        return p1;
//    }
//
//    public void setP1(PrintStream p1) {
//        this.p1 = p1;
//    }

    @Override
    public void run () {
        try {
            BufferedReader os = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            System.out.println(os.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sk != null) {
                try {
                    sk.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
