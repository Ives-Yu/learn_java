package com.lagou.server;

import com.lagou.model.Student;
import com.lagou.model.User;
import com.lagou.model.UserMessage;

import java.util.LinkedList;
import java.util.List;

public class ServerDao {

    private List l1;

    ServerDao () {}

    ServerDao (List l1) {
        setL1(l1);
    }

    public void setL1(List l1) {
        this.l1 = l1;
    }

    /**
     * 实现账户密码的校验并返回布尔值
     * @return
     */
    public boolean serverManagerCheck (User user) {
        if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public void serverAddStudentList (UserMessage message) {
        Student student = message.getStudent();
        message.setMessage(student.getName());
        boolean add = l1.add(message);
        System.out.println(l1);
    }

    public String[] serverSelectStudent () {
        String[] list = new String[l1.size()];
        for (int i = 0; i < l1.size(); i++) {
            UserMessage user = (UserMessage) l1.get(i);
            list[i] = user.getMessage();
        }
        return list;
    }

    public String serverUpdateStudent(int name_id, UserMessage userMessage) {
        UserMessage um = (UserMessage) l1.get(name_id);
        User user = um.getUser();
        Student student = um.getStudent();
        user.setUserName(userMessage.getUser().getUserName());
        user.setPassword(userMessage.getUser().getPassword());
        student.setName(userMessage.getStudent().getName());
        student.setAge(userMessage.getStudent().getAge());
        student.setSex(userMessage.getStudent().getSex());
        um.setMessage(userMessage.getUser().getUserName());
        System.out.println("修改成功！");
        System.out.println("修改后的集合是：" + l1);
        return userMessage.getUser().getUserName();
    }
}
