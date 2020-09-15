package com.lagou.task20.task;

import java.io.File;

public class modular_01_04_second {
    static File f1 = new File("/Users/yunshenbuzhichu/Desktop/java");
    static modular_01_04_second ms = new modular_01_04_second();

    void show (File f) {
        File[] fl = f.listFiles();
        for (File tf : fl) {
            String name = tf.getName();
            if (tf.isDirectory()) {
                show(tf);
            }
            tf.delete();
        }
    }

    public static void main(String[] args) {
        ms.show(f1);
    }
}
