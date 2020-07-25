package com.lagou.tack09.task;
import java.util.Scanner;

//定义每行和的成员方法
public class modular02_first {
    //定义每行和的字段
    int line_num = 0;
    private int line(int num, int i) {
        //判断，如果列数i为0，则把每行和置为零
        if (i == 0) {
            line_num = 0;
            line_num += num;
        } else {
            line_num += num;
        }
        return line_num;
    }

    public static void main(String[] args) {
        //定义一个二维数组
        int[][] num = new int[5][5];
        //定义一个列数和的数组
        int[] kind = new int[5];
        //定义左上角到右下角和的字段
        int left_bevel = 0;
        //定义右上角到左下角的字段
        int right_bevel = 0;
        //接收每行和的返回值
        int line_num1 = 0;
        //创建对象
        modular02_first line = new modular02_first();
        //用于输入每行的元素
        for (int i = 0; i < num.length; i++) {
            System.out.println("请输入第" + (i + 1) +"行的元素：");
            Scanner num1 = new Scanner(System.in);
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = num1.nextInt();
            }
        }

        //用于打印二维数组
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();
        }

        //循环二维数组，计算行和斜的和
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                //计算每行的和
                line_num1 = line.line(num[i][j], j);
                //计算每列的和
                kind[j] += num[i][j];
                //计算左上角到右下角的和
                if (i == j) {
                    left_bevel += num[i][j];
                  //计算右上角到左下角的和
                } else if (i == (num[i].length-j)){
                    right_bevel += num[i][j];
                }
            }
            //打印每行的和
            System.out.print("第"+ (i + 1) +"行之和为：" + line_num1);
            System.out.println();
        }

        //打印每列的和
        for (int i = 0; i < kind.length; i++) {
            System.out.print("第"+ (i + 1) +"列之和为：" + kind[i]);
            System.out.println();
        }
        System.out.println("左上角到右下角的和为：" + left_bevel);
        System.out.println("右上角到左下角的和为：" + right_bevel);
    }
}
