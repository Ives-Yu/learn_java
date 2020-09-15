package com.lagou.tack14.task;

public class modular01_03_fourth_1 {
    private int sno;
    private int age;
    private String name;

    public int getSno() {
        return sno;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show (String name, int sno, int age) {
        setAge(age);
        setName(name);
        setSno(sno);
    }

    @Override
    public String toString() {
        return "该信息为：{" +
                "sno=" + sno +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
