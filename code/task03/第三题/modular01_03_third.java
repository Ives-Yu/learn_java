package com.lagou.tack14.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class modular01_03_third {

    public static void main(String[] args) {

        int num = 0;
        String s1 = "123,456,23,123,890,890,456,123";
        String[] s2 = s1.split(",");

        Map h1 = new HashMap();

        for (String s3 : s2) {
            if (h1.containsKey(s3)) {
                Object obj = h1.get(s3);
                num = (int)obj;
                num += 1;
                h1.put(s3, num);
            } else {
                int i = 1;
                h1.put(s3, i);
            }
        }
        Set st = h1.keySet();
        for (Object sst : st) {
            System.out.println(sst + "出现了" + h1.get(sst) + "次");
        }
    }
}
