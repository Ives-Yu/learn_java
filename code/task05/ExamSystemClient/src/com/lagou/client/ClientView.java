package com.lagou.client;

import com.lagou.model.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClientView {
    /**
     * 定义输入输出流对象，采用合成复用原则
     */
    ClientInitClose cic;
    Scanner sn = new Scanner(System.in);
    UserMessage message;
    static String[] l = null;
    static String[] sj_l = null;


    public ClientView (ClientInitClose cic) {
        setCic(cic);
    }

    public void setCic(ClientInitClose cic) {
        this.cic = cic;
    }

    /**
     * 定义clientMainPage方法，用于展示客户端首页
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void clientMainPage () throws IOException, ClassNotFoundException {
        System.out.println("\t    欢迎光临在线考试系统");
        System.out.println("\t1、学员系统        2、管理员系统");
        System.out.println("\t0、退出系统");
        System.out.print("请选择进入的系统：");
        int s = sn.nextInt();
        switch (s) {
            case 1:
                System.out.println("欢迎光临学员系统！");
                clientStudentLogin();
                break;
            case 2:
                System.out.println("欢迎光临管理员系统！");
                clientManagerLogin();
                break;
            case 0:
                System.out.println("退出成功!");
                cic.getOos().writeObject(null);
                return;
            default:
                System.out.println("输入有误！请重新输入！");
        }
    }

    /**
     * 定义clientManagerLogin方法，用于管理员输入用户名和密码
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void clientManagerLogin () throws IOException, ClassNotFoundException {
        System.out.print("请输入用户名：");
        String username = sn.next();
        System.out.print("请输入密码：");
        String password = sn.next();
        message = new UserMessage("managerCheck", new User(username, password));
        cic.getOos().writeObject(message);

        //开始接受信息！
        message = (UserMessage) cic.getOis().readObject();
        if ("success".equals(message.getMessage())) {
            System.out.println("管理员登陆成功！");
            clientManageModular();
        } else {
            System.out.println("用户名或密码输入错误，请重试！");
            clientMainPage();
        }
    }

    /**
     * 定义clientManageModular方法，用于展示管理员系统页面
     */
    public void clientManageModular () throws IOException, ClassNotFoundException {
        System.out.println("\t      欢迎登录管理员系统");
        System.out.println("\t 1. 学员管理模块     2. 考题管理模块");
        System.out.println("\t 0. 退出管理系统     3. 返回上一级");
        System.out.print("请选择要进入的模块：");
        switch (sn.nextInt()) {
            case 1:
                clientStudentManageModular();
                break;
            case 2:
                clientSubjectManageModular();
                break;
            case 0:
            case 3:
                clientMainPage();
                break;
            default:
                System.out.println("输入错误，请重新输入!");
                clientManageModular();
        }
    }

    public void clientStudentManageModular () throws IOException, ClassNotFoundException {
        System.out.println("\t      欢迎进入学员管理模块");
        System.out.println("\t  1. 添加学员        2. 查询学员");
        System.out.println("\t  3. 修改学员        4. 删除学员");
        System.out.println("\t  5. 退出系统        0. 返回上一级");
        System.out.print("请选择要进行操作的序号：");
        switch (sn.nextInt()) {
            case 1:
                clientAddStudent();
                break;
            case 2:
                clientStaticStudent();
                break;
            case 3:
                clientUpdateStudent();
                break;
            case 4:
                clientDeleteStudent();
                break;
            case 5:
            case 0:
                clientManageModular();
                break;
            default:
                System.out.println("输入有误，请重新输入!");
                clientStudentManageModular();
        }
    }

    /**
     * 定义clientAddStudent方法，用于向服务端输入学员信息
     * @throws IOException
     */
    public void clientAddStudent () throws IOException, ClassNotFoundException {
        System.out.println("请输入要添加学员的姓名、年龄、性别：");
        String name = sn.next();
        int age = sn.nextInt();
        String sex = sn.next();
        System.out.println("请输入学员用户名：");
        String username = sn.next();
        System.out.println("请输入学员密码：");
        String password = sn.next();


        message = new UserMessage("addStudent", new Student(name, age, sex), new User(username, password));
        cic.getOos().writeObject(message);
        clientStudentManageModular();
    }

    public void clientStaticStudent () throws IOException, ClassNotFoundException {
        message = new UserMessage("StaticStudent");
        cic.getOos().writeObject(message);
        l = (String[]) cic.getOis().readObject();
        for (int i = 0; i < l.length; i++) {
            System.out.print(i + 1 + "：");
            System.out.println(l[i]);
        }
        System.out.println("0：返回上一级");
        System.out.print("请输入要查询的人的编号：");
        int number = sn.nextInt();
        cic.getOos().writeObject(number);

        message = (UserMessage) cic.getOis().readObject();
        System.out.println(message);
        ClientDao clientDao = new ClientDao();
        clientDao.clientSelectStudent(message);
        clientStudentManageModular();
    }

    public void clientDeleteStudent () throws IOException, ClassNotFoundException {
        message = new UserMessage("DeleteStudent");
        cic.getOos().writeObject(message);
        if(null == l) {
            l = (String[]) cic.getOis().readObject();
        }
        for (int i = 0; i < l.length; i++) {
            System.out.print(i + 1 + "：");
            System.out.println(l[i]);
        }
        System.out.print("请输入要删除的人的编号：");
        int number = sn.nextInt();
        cic.getOos().writeObject(number);
        clientStudentManageModular();
    }

    public void clientUpdateStudent () throws IOException, ClassNotFoundException {
        message = new UserMessage("updateStudent");
        cic.getOos().writeObject(message);
        l = (String[]) cic.getOis().readObject();
        for (int i = 0; i < l.length; i++) {
            System.out.print(i + 1 + "：");
            System.out.println(l[i]);
        }
        System.out.println("0：返回上一级");
        System.out.print("请输入要修改的人的编号：");
        int number = sn.nextInt();
        if (0 != number) {
            System.out.println("请输入要修改学员的姓名、年龄、性别：");
            String name = sn.next();
            int age = sn.nextInt();
            String sex = sn.next();
            System.out.println("请输入学员用户名：");
            String username = sn.next();
            System.out.println("请输入学员密码：");
            String password = sn.next();

            message = new UserMessage("updateStudent", new Student(name, age, sex), new User(username, password));
            System.out.println(number);
            System.out.println(message.getUser());
            cic.getOos().writeObject(number);
            cic.getOos().writeObject(message);
            clientStudentManageModular();
        }
    }

    public void clientSubjectManageModular () throws IOException, ClassNotFoundException {
        System.out.println("\t      欢迎进入考题管理模块");
        System.out.println("\t  1. 添加考题        2. 查询考题");
        System.out.println("\t  3. 修改考题        4. 删除考题");
        System.out.println("\t  5. 退出系统        0. 返回上一级");
        System.out.print("请选择要进行操作的序号：");
        int num = sn.nextInt();

        switch (num) {
            case 1 :
                clientAddSubject();
                break;
            case 2 :
                clientSelectSubject();
                break;
            case 3 :
                clientUpdateSubject();
                break;
            case 4 :
                clientDeleteSubject();
                break;
            case 5 :
            case 0 :
                clientManageModular();
                break;
            default:
                System.out.println("选择错误，请重新选择！");
                break;
        }
    }

    public void clientAddSubject () throws IOException, ClassNotFoundException {
        System.out.println("请输入考题内容：");
        String subject_next = sn.next();
        System.out.println("请输入答案A：");
        String answer_a = sn.next();
        System.out.println("请输入答案B：");
        String answer_b = sn.next();
        System.out.println("请输入答案C：");
        String answer_c = sn.next();
        System.out.println("请输入答案D：");
        String answer_d = sn.next();
        System.out.println("请输入正确答案对应序号：");
        String answer = sn.next();
        UserMessage userMessage = new UserMessage("AddSubject", new Subject(subject_next, answer, new SubjectAnswer(answer_a, answer_b, answer_c, answer_d)));
        System.out.println(userMessage);
        cic.getOos().writeObject(userMessage);
        System.out.println("添加成功！");
        clientSubjectManageModular();
    }

    public void clientSelectSubject () throws IOException, ClassNotFoundException {
        UserMessage userMessage = new UserMessage("SelectSubject");
        cic.getOos().writeObject(userMessage);
        sj_l = (String[]) cic.getOis().readObject();
        for (int i = 0; i < sj_l.length; i++) {
            System.out.print(i + 1 + ":");
            System.out.println(sj_l[i]);
        }
        System.out.print("请选择要查询的问题：");
        int subject_num = sn.nextInt();
        cic.getOos().writeObject(subject_num);
        System.out.println("-----------------------");
        Subject subject = (Subject) cic.getOis().readObject();
        System.out.println(subject);
        System.out.print("问题：");
        System.out.println(subject.getSubject());
        System.out.print("答案A：");
        System.out.println(subject.getSubjectAnswer().getA());
        System.out.print("答案B：");
        System.out.println(subject.getSubjectAnswer().getB());
        System.out.print("答案C：");
        System.out.println(subject.getSubjectAnswer().getC());
        System.out.print("答案D：");
        System.out.println(subject.getSubjectAnswer().getD());
        System.out.print("正确答案：");
        System.out.println(subject.getAnswer());
        clientSubjectManageModular();
    }

    public void clientDeleteSubject () throws IOException, ClassNotFoundException {
        cic.getOos().writeObject(new UserMessage("DeleteSubject"));
        if (null == sj_l) {
            sj_l = (String[]) cic.getOis().readObject();
        }
        for (int i = 0; i < sj_l.length; i++) {
            System.out.print(i + 1 + ":");
            System.out.println(sj_l[i]);
        }
        System.out.println("请输入要删除的题目编号：");
        int delete_num = sn.nextInt();
        System.out.println(delete_num);
        cic.getOos().writeObject(delete_num);
        System.out.println("删除成功！");
        clientSubjectManageModular();
    }

    public void clientUpdateSubject () throws IOException, ClassNotFoundException {
        cic.getOos().writeObject(new UserMessage("UpdateSubject"));
        sj_l = (String[]) cic.getOis().readObject();
        for (int i = 0; i < sj_l.length; i++) {
            System.out.print(i + 1 + ":");
            System.out.println(sj_l[i]);
        }
        System.out.println("请选择要修改的题目：");
        int update_num = sn.nextInt();

        System.out.println("请输入修改后的考题内容：");
        String subject_next = sn.next();
        System.out.println("请输入答案A：");
        String answer_a = sn.next();
        System.out.println("请输入答案B：");
        String answer_b = sn.next();
        System.out.println("请输入答案C：");
        String answer_c = sn.next();
        System.out.println("请输入答案D：");
        String answer_d = sn.next();
        System.out.println("请输入正确答案对应序号：");
        String answer = sn.next();
        UserMessage userMessage = new UserMessage("AddSubject", new Subject(subject_next, answer, new SubjectAnswer(answer_a, answer_b, answer_c, answer_d)));
        System.out.println(userMessage);
        cic.getOos().writeObject(userMessage);
        cic.getOos().writeObject(update_num);
        clientSubjectManageModular();
    }

    public void clientStudentLogin () throws IOException, ClassNotFoundException {
        System.out.print("请输入用户名：");
        String name = sn.next();
        System.out.print("请输入密码：");
        String password = sn.next();

        UserMessage userMessage = new UserMessage("StudentLogin", new User(name, password));
        cic.getOos().writeObject(userMessage);
        String message = (String) cic.getOis().readObject();
        System.out.println("---------");
        if ("message".equals(message)) {
            System.out.println("学员登录成功");
            clientStudentIndex();
        } else {
            System.out.println(message + "请重新登录！");
            clientMainPage();
        }
    }

    public void clientStudentIndex () throws IOException, ClassNotFoundException {
        System.out.println("\t      欢迎进入考题管理模块");
        System.out.println("\t  1. 修改密码        2. 考题模块");
        System.out.println("\t  3. 退出系统        0. 返回上一级");
        System.out.print("请选择要进行操作的序号：");
        int num = sn.nextInt();
        switch (num) {
            case 1:
                clientStudentUpdatePassword();
                break;
            case 2:
                clientExaminationIndex();
                break;
            case 3:
            case 0:
                clientMainPage();
                break;
            default:
                System.out.println("输入有误，请重新输入!");
                clientStudentIndex();
        }
    }

    public void clientStudentUpdatePassword () throws IOException, ClassNotFoundException {
        System.out.print("请输入新密码：");
        String password = sn.next();
        cic.getOos().writeObject(new UserMessage("StudentUpdatePassword"));
        cic.getOos().writeObject(password);
        System.out.println("修改成功！请重新登录！");
        clientMainPage();
    }

    public void clientExaminationIndex () throws IOException, ClassNotFoundException {
        System.out.println("\t      欢迎进入考题管理模块");
        System.out.println("\t  1. 开始考试        2. 查询成绩");
        System.out.println("\t  3. 退出系统        0. 返回上一级");
        System.out.print("请选择要进行操作的序号：");
        int num = sn.nextInt();
        switch (num) {
            case 1:
                clientStartExamination();
                break;
            case 2:
                clientSelectAnswer();
                break;
            case 3:
            case 0:
                clientStudentIndex();
                break;
            default:
                System.out.println("输入有误，请重新输入！");
                clientExaminationIndex();
        }
    }

    public void clientStartExamination () throws IOException, ClassNotFoundException {
        cic.getOos().writeObject(new UserMessage("StartExamination"));
        List<UserMessage> paper = (List<UserMessage>) cic.getOis().readObject();
        int num = 1;
        String[] answer = new String[paper.size()];
        for (UserMessage pa : paper) {
            System.out.println("\t" + num + "：" + pa.getSubject1().getSubject());
            System.out.println("\tA：" + pa.getSubject1().getSubjectAnswer().getA() + "        B：" + pa.getSubject1().getSubjectAnswer().getB());
            System.out.println("\tC：" + pa.getSubject1().getSubjectAnswer().getC() + "        D：" + pa.getSubject1().getSubjectAnswer().getD());
            System.out.print("请选择：");
            answer[num - 1] = sn.next();
            num += 1;
        }
        System.out.println("考试结束！");
        cic.getOos().writeObject(answer);
        clientExaminationIndex();
    }

    public void clientSelectAnswer () throws IOException, ClassNotFoundException {
        cic.getOos().writeObject(new UserMessage("SelectAnswer"));
        int result = (int) cic.getOis().readObject();
        System.out.println("您的成绩是：" + result);
    }
}
