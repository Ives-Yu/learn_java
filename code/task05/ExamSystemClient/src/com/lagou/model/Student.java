package com.lagou.model;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 8701446711508463395L;
    private String name;
    private int age;
    private String sex;

    public Student() {}

    public Student(String name, int age, String sex) {
        setAge(age);
        setName(name);
        setSex(sex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Strdent{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
