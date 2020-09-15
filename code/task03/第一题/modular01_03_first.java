package com.lagou.tack14.task;

public class modular01_03_first {

    public static void main(String[] args) {

        String sr = new String("ABCD123!@#$%ab");
        int large = 0;
        int small = 0;
        int number = 0;
        int character = 0;
        byte[] ca = sr.getBytes();
        for (byte ci : ca) {
            if (ci > 47 && ci < 58) {
                number += 1;
                System.out.println("发现数字" + (char)ci + "，目前数字有" + number + "个");
            } else if (ci > 64 && ci < 91) {
                large += 1;
                System.out.println("发现大写字母" + (char)ci + "，目前大写字母有" + large + "个");
            } else if (ci < 123 && ci > 96) {
                small += 1;
                System.out.println("发现小写字母" + (char)ci + "，目前小写字母有" + small + "个");
            } else {
                character += 1;
                System.out.println("发现特殊字符" + (char)ci + "，目前特殊字符有" + character + "个");
            }
        }
    }
}
