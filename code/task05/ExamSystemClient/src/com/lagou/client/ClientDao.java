package com.lagou.client;

import com.lagou.model.Student;
import com.lagou.model.UserMessage;

public class ClientDao {

    public void clientSelectStudent(UserMessage userMessage) {
        Student student = userMessage.getStudent();
        System.out.println("姓名：" + student.getName());
        System.out.println("年龄：" + student.getAge());
        System.out.println("性别：" + student.getSex());
    }
}
