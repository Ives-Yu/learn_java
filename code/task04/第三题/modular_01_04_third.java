package com.lagou.task20.task;

import java.io.*;

public class modular_01_04_third {

    static File f1 = new File("/Users/yunshenbuzhichu/Desktop/java");
    static File f2 = new File("/Users/yunshenbuzhichu/Desktop/javae");

    FileWriter fil1;

    {
        try {
            fil1 = new FileWriter("/Users/yunshenbuzhichu/Desktop/javae/1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static modular_01_04_third ms = new modular_01_04_third();

    void show (File f) throws IOException {
        File[] fl = f.listFiles();
        for (File tf : fl) {
            String name = tf.getName();
            //if (tf.isFile()) {
            FileReader fil2 =  new FileReader(tf.getAbsoluteFile());
            int t1 = 0;
            while ((t1 = fil2.read()) != -1) {
                fil1.write((char)t1);
            }
            fil2.close();
            //}
//            if (tf.isDirectory()) {
//                f2.mkdir();
//                f2 = new File()
//                show(tf);
//            }
        }
        fil1.close();
    }

    public static void main(String[] args) throws IOException {
        ms.show(f1);
    }
}
