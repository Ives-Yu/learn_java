package com.lagou.task20.task;

public class modular01_04_first_1 {
    private int sno;
    private int age;
    private String name;

    public modular01_04_first_1(){}

    public modular01_04_first_1(int sno, int age, String name) throws AgeException {
        setAge(age);
        setName(name);
        setSno(sno);
    }

    public int getSno() {
        return sno;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setSno(int sno) throws AgeException {
        if (sno > 50){
            this.sno = sno;
        } else {
            throw new AgeException("学号不合理哦！");
        }
    }

    public void setAge(int age) throws AgeException {
        if (age > 10 && age < 20){
            this.age = age;
        } else {
            throw new AgeException("年龄不合理哦！");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show (String name, int sno, int age) throws AgeException {
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
