package com.lagou.task20.task;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class modular01_04_first_test {

    static Scanner s1 = new Scanner(System.in);

    void add (List<modular01_04_first_1> l1) throws AgeException {
        System.out.println("请输入姓名，年龄，学号：");
        modular01_04_first_1 l2 = new modular01_04_first_1();
        String name = s1.next();
        int age = s1.nextInt();
        int sno = s1.nextInt();
        l2.show(name, sno, age);
        l1.add(l2);
        System.out.println("添加成功！！！");
    }

    public void update (List<modular01_04_first_1> l1) {
        try {
            System.out.println("请输入要改信息的人的姓名：");
            String y_name = s1.next();
            System.out.println("请输入修改后的姓名，年龄，学号：");
            String name = s1.next();
            int age = s1.nextInt();
            int sno = s1.nextInt();
            for (modular01_04_first_1 l : l1) {
                if (l.getName().equals(y_name)) {
                    l.setName(name);
                    l.setSno(sno);
                    l.setAge(age);
                }
            }
            System.out.println("修改成功！");
        } catch (Exception e) {
            System.out.println("修改失败，请重试！");
        }
    }

    void delect (List<modular01_04_first_1> l1) {
        try {
            System.out.println("请输入要改信息的人的姓名：");
            String y_name = s1.next();
            for (modular01_04_first_1 l : l1) {
                if (l.getName().equals(y_name)) {
                    l1.remove(l);
                }
            }
            System.out.println("删除成功！！！");
        } catch (Exception e) {
            System.out.println("删除失败，请重试！");
        }
    }

    void selete (List<modular01_04_first_1> l1) {
        try {
            System.out.println("请输入要改信息的人的姓名：");
            String y_name = s1.next();
            for (modular01_04_first_1 l : l1) {
                if (l.getName().equals(y_name)) {
                    System.out.println(l.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("查询失败，请重试！");
        }
    }

    void deposit (List<modular01_04_first_1> l1) {
        try {
            BufferedWriter fi = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/yunshenbuzhichu/Desktop/deposit.txt")));
            for (modular01_04_first_1 l : l1) {
                fi.write(l.getName());
                fi.write("" + l.getAge());
                fi.write("" + l.getSno());
                fi.write("\n");
            }
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void read (List<modular01_04_first_1> l1) {
        try {
            BufferedReader fr = new BufferedReader(new FileReader("/Users/yunshenbuzhichu/Desktop/deposit.txt"));
            System.out.println(fr.readLine());
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws AgeException {
        List<modular01_04_first_1> l1 = new LinkedList<modular01_04_first_1>();
        modular01_04_first_test mt = new modular01_04_first_test();
        //mt.read(l1);
        while (true) {
            try {
                System.out.println("欢迎来到学生管理系统");
                System.out.println("【1】增加");
                System.out.println("【2】查看");
                System.out.println("【3】修改");
                System.out.println("【4】删除");
                System.out.println("【0】退出");
                System.out.print("请选择您的操作:");
                int i = s1.nextInt();
                if (1 == i) {
                    mt.add(l1);
                } else if (2 == i) {
                    mt.selete(l1);
                } else if (3 == i) {
                    mt.update(l1);
                } else if (4 == i) {
                    mt.delect(l1);
                } else {
                    mt.deposit(l1);
                    break;
                }
            } catch (InputMismatchException in) {
                System.out.println("输入错误，请重新运行此系统！");
                break;
            }
        }
        for (modular01_04_first_1 l : l1) {
            System.out.println(l.toString());
        }
    }
}
