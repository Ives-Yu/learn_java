package com.lagou.tack14.task;

public class modular01_03_second {

    public static void main(String[] args) {
        String s1 = "asdafghjka";
        String s2 = "asdfasda";
        String s5 = "";
        int s6 = 0;

        //以下代码是减少结尾处的字母
        for (int i = s2.length(); i > 0; i--) {
            s6 = s2.length()-i;
            for (int q = 0; q < s6+1; q++){
                String s4 = s2.substring(0+q, i+q);
                for (int j = 0; j <= (s1.length() - s4.length()); j++) {
                    String s3 = s1.substring(j, s4.length()+j);
                    if (s3.equals(s4)) {
                        if (s4.length() > s5.length()) {
                            s5 = s4;
                        }
                    }
                }
            }
        }
        //以下代码是减少开头处的字母
        for (int i = 0; i < s2.length(); i++) {
            for (int q = 0; q < i; q++){
                String s4 = s2.substring(i-q, s2.length()-q);
                for (int j = 0; j <= (s1.length() - s4.length()); j++) {
                    String s3 = s1.substring(j, s4.length()+j);
                    if (s3.equals(s4)) {
                        if (s4.length() > s5.length()) {
                            s5 = s4;
                        }
                    }
                }
            }
        }
        System.out.println(s5);
    }
}
