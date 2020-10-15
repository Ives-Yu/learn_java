package com.lagou.model;

import java.io.Serializable;

public class SubjectAnswer implements Serializable {


    private static final long serialVersionUID = 5738693232953373019L;

    private String a;
    private String b;
    private String c;
    private String d;

    public SubjectAnswer () {}

    public SubjectAnswer (String a, String b, String c, String d) {
        setA(a);
        setB(b);
        setC(c);
        setD(d);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "SubjectAnswer{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
