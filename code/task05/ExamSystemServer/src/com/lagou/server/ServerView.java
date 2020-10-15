package com.lagou.server;


import com.lagou.model.Subject;
import com.lagou.model.User;
import com.lagou.model.UserMessage;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ServerView {

    private ServerInitClose sic;

    private static int list_num;

    static String[] li = null;
    static String[] sj_li = null;
    static String[] answer = null;
    static String[] interim_answer = null;

    static int result;

    static List<String> l2 = new LinkedList<String>();
    static List<String> sj_l2 = new LinkedList<String>();

    private static List<UserMessage> l1 = new LinkedList<>();
    private static List<UserMessage> sj_l1 = new LinkedList<>();

    public ServerView () {}

    public ServerView (ServerInitClose sic) {
        setSic(sic);
    }

    public void setSic(ServerInitClose sic) {
        this.sic = sic;
    }

    public ServerInitClose getSic() {
        return sic;
    }

    /**
     * 自定义成员方法实现接收客户端消息
     */
    public void serverReceive () throws IOException, ClassNotFoundException {
        UserMessage obj = (UserMessage) sic.getOis().readObject();
        System.out.println("接收到的消息是：" + obj);
        if (null == obj) {
            sic.close();
            return;
        }
        ServerDao sd = new ServerDao(l1);

        if ("managerCheck".equals(obj.getMessage())) {
            System.out.println("开始判断用户名和密码的是否正确。。。");
            User user = obj.getUser();
            if (sd.serverManagerCheck(user)) {
                obj.setMessage("success");
                System.out.println("用户名密码输入正确！");
            } else {
                obj.setMessage("fail");
                System.out.println("用户名或密码错误！");
            }
            sic.getOos().writeObject(obj);
            serverReceive();

        } else if ("addStudent".equals(obj.getMessage())) {
            System.out.println("开始向集合中添加对象。。。");
            //Student student = obj.getStudent();
            sd.serverAddStudentList(obj);
            serverReceive();

        } else if ("StaticStudent".equals(obj.getMessage())) {
            System.out.println("开始查询集合中的对象。。。");

            li = sd.serverSelectStudent();
            System.out.println("已返回对象。");
            sic.getOos().writeObject(li);
            int name_id = (int) sic.getOis().readObject();
            if (name_id != 0) {
                System.out.println(name_id - 1);
                UserMessage userMessage = l1.get(name_id - 1);
                System.out.println(userMessage);
                System.out.println(l1);
                sic.getOos().writeObject(userMessage);
            }
            System.out.println("已返回具体元素。");
            serverReceive();

        }else if ("DeleteStudent".equals(obj.getMessage())) {
            if (null == li) {
                li = sd.serverSelectStudent();
                sic.getOos().writeObject(li);
            }
            int name_id = (int) sic.getOis().readObject();
            if (name_id != 0) {
                l2.addAll(Arrays.asList(li));
                l2.remove(name_id - 1);
                li = l2.toArray(new String[l2.size()]);
                System.out.println("删除后的数组是：" + Arrays.toString(li));
                l1.remove(name_id - 1);
                System.out.println("删除后的集合是：" + l1);
            }
            serverReceive();
        } else if ("updateStudent".equals(obj.getMessage())) {
            if (null == li) {
                li = sd.serverSelectStudent();
            }
            sic.getOos().writeObject(li);
            int name_id = (int) sic.getOis().readObject();
            UserMessage userMessage = (UserMessage) sic.getOis().readObject();
            String name = sd.serverUpdateStudent(name_id - 1, userMessage);
            l2.clear();
            l2.addAll(Arrays.asList(li));
            l2.set(name_id - 1, name);
            li = l2.toArray(new String[l2.size()]);
            System.out.println("修改后的数组是：" + Arrays.toString(li));
            sic.getOos().flush();
            serverReceive();
        } else if ("AddSubject".equals(obj.getMessage())) {
            sj_l1.add(obj);
            System.out.println("-----------------");
            System.out.println(obj.getSubject1().getSubject());
            System.out.println("添加成功！");
            System.out.println("------------------");
            serverReceive();
        } else if ("SelectSubject".equals(obj.getMessage())) {
            System.out.println("------------   ---------");
            System.out.println(sj_l1);
            sj_li = new String[sj_l1.size()];
            for (int i = 0; i < sj_l1.size(); i++) {
                String subject = sj_l1.get(i).getSubject1().getSubject();
                sj_li[i] = subject;
            }
            sic.getOos().writeObject(sj_li);
            int subject_num = (int) sic.getOis().readObject();
            System.out.println(subject_num);
            Subject subject8 = sj_l1.get(subject_num - 1).getSubject1();
            System.out.println(subject8);
            sic.getOos().flush();
            sic.getOos().writeObject(subject8);
            System.out.println(subject8);
            System.out.println("问题已返回！");
            serverReceive();
        } else if ("DeleteSubject".equals(obj.getMessage())) {
            if (null == sj_li) {
                sj_li = new String[sj_l1.size()];
                for (int i = 0; i < sj_l1.size(); i++) {
                    String subject = sj_l1.get(i).getSubject1().getSubject();
                    sj_li[i] = subject;
                }
                sic.getOos().writeObject(sj_li);
            }
            int delete_num = (int)sic.getOis().readObject();
            if (delete_num != 0) {
                sj_l2.clear();
                sj_l2.addAll(Arrays.asList(sj_li));
                sj_l2.remove(delete_num - 1);
                sj_li = sj_l2.toArray(new String[sj_l2.size()]);
            }
            sj_l1.remove(delete_num - 1);
            System.out.println("删除后的数组是：" + Arrays.toString(sj_li));
            serverReceive();
        } else if ("UpdateSubject".equals(obj.getMessage())) {
            if (null == sj_li) {
                sj_li = new String[sj_l1.size()];
                for (int i = 0; i < sj_l1.size(); i++) {
                    String subject = sj_l1.get(i).getSubject1().getSubject();
                    sj_li[i] = subject;
                }
            }
            sic.getOos().writeObject(sj_li);
            UserMessage userMessage = (UserMessage) sic.getOis().readObject();
            int update_num = (int) sic.getOis().readObject();

            UserMessage message = sj_l1.get(update_num -1);
            message.getSubject1().getSubjectAnswer().setA(userMessage.getSubject1().getSubjectAnswer().getA());
            message.getSubject1().getSubjectAnswer().setB(userMessage.getSubject1().getSubjectAnswer().getB());
            message.getSubject1().getSubjectAnswer().setC(userMessage.getSubject1().getSubjectAnswer().getC());
            message.getSubject1().getSubjectAnswer().setD(userMessage.getSubject1().getSubjectAnswer().getD());
            message.getSubject1().setAnswer(userMessage.getSubject1().getAnswer());
            message.getSubject1().setSubject(userMessage.getSubject1().getSubject());

            sj_l2.clear();
            sj_l2.addAll(Arrays.asList(sj_li));
            sj_l2.set(update_num - 1, userMessage.getSubject1().getSubject());
            sj_li = sj_l2.toArray(new String[sj_l2.size()]);

            System.out.println(Arrays.toString(sj_li));
            System.out.println(sj_l1.get(update_num -1).getSubject1().getSubject());
            System.out.println("修改成功！");
            serverReceive();
        } else if ("StudentLogin".equals(obj.getMessage())) {
            User user = obj.getUser();
            System.out.println(user);
            if (null == li) {
                li = sd.serverSelectStudent();
            }
            System.out.println(l1);
            for (int i = 0; i < li.length; i++) {
                if (li[i].equals(user.getUserName())) {
                    if (l1.get(i).getUser().getPassword().equals(user.getPassword())) {
                        System.out.println("学员登陆成功！");
                        list_num = i;
                        sic.getOos().writeObject("message");
                    } else {
                        if (i == (li.length - 1)) {
                            sic.getOos().writeObject("用户名或密码错误！");
                            System.out.println("用户名或密码错误！");
                        }
                    }
                } else {
                    if (i == (li.length - 1)) {
                        sic.getOos().writeObject("用户名或密码错误！");
                        System.out.println("用户名或密码错误！");
                    }
                }
            }
            serverReceive();
        } else if ("StudentUpdatePassword".equals(obj.getMessage())) {
            String password = (String) sic.getOis().readObject();
            System.out.println(l1);
            System.out.println(list_num);
            l1.get(list_num).getUser().setPassword(password);
            System.out.println("修改成功！");
            serverReceive();
        } else if ("StartExamination".equals(obj.getMessage())) {
            interim_answer = null;
            System.out.println(sj_l1);
            sic.getOos().writeObject(sj_l1);
            System.out.println("问题已返回！");
            interim_answer = (String[]) sic.getOis().readObject();
            System.out.println("已接收到答案！");
            System.out.println(Arrays.toString(interim_answer));
            serverReceive();
        } else if ("SelectAnswer".equals(obj.getMessage())) {
            if (null == answer) {
                answer = new String[sj_l1.size()];
                for (int i = 0; i < sj_l1.size(); i++) {
                    answer[i] = sj_l1.get(i).getSubject1().getAnswer();
                }
            }
            for (int i = 0; i < answer.length; i++) {
                if (answer[i].equals(interim_answer[i])) {
                    result += 20;
                }
            }
            sic.getOos().writeObject(result);
            serverReceive();
        } else {
            System.out.println("哈哈哈，选错了！");
            obj.setMessage("fail");
            serverReceive();
        }
    }
}