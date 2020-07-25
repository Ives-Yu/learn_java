package com.lagou.tack09.task;
import java.util.Scanner;

public class modular02_second {

    //定义初始棋盘
    public String[][] Checkerboard () {
        //定义一个数组，用于排序第一行和第一列
        String[] first = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        //定义一个二维数组
        String[][] checkerboard = new String[17][17];
        //循环二维数组
        for (int i = 0; i < checkerboard.length; i++) {

            for (int j = 0; j < checkerboard[i].length; j++) {
                //定义棋盘的第一个空
                if (0 == i && 0 == j) {
                    checkerboard[i][j] = "";
                    //定义棋盘的第一行
                } else if (0 == i && (0 != j)) {
                    checkerboard[i][j] = first[j-1];
                    //定义棋盘的第一列
                } else if (i != 0 && 0 == j) {
                    checkerboard[i][j] = first[i-1];
                    //定义棋盘的+号
                } else {
                    checkerboard[i][j] = "+";
                }
            }
        }
        //返回一个数组
        return checkerboard;
    }

    //用于判断落字位置是否有子且判断棋子是否超出棋盘且返回是否黑方或白方胜利
    public String Play_chess (boolean me, String[][] change_checkerboard) {
        //定义一个变量，用于记录
        String num = "0";
        Scanner position = new Scanner(System.in);
        if (me) {
            System.out.print("请黑方输入要下棋的位置：");
            int x = position.nextInt();
            int y = position.nextInt();
            if (x <= 0 || x >17 || y <= 0 || y > 16) {
                System.out.println("超出棋盘，请重新选择位置！");
                Play_chess(me, change_checkerboard);
            } else if (change_checkerboard[x][y] != "+"){
                System.out.println("该位置已有落字，请重新选择位置！");
                Play_chess(me, change_checkerboard);
            } else {
                change_checkerboard[x][y] = "黑";
                int tree = results(x, y, change_checkerboard);
                if (tree != 0) {
                    num = "1";
                } else {
                    num = "0";
                }
            }
        } else {
            System.out.print("请白方输入要下棋的位置：");
            int x = position.nextInt();
            int y = position.nextInt();
            if (x <= 0 || x >17 || y <= 0 || y > 16) {
                System.out.println("超出棋盘，请重新选择位置！");
                Play_chess(me, change_checkerboard);
            } else if (change_checkerboard[x][y] != "+"){
                System.out.println("该位置已有落字，请重新选择位置！");
                Play_chess(me, change_checkerboard);
            } else {
                change_checkerboard[x][y] = "白";
                int tree = results(x, y, change_checkerboard);
                if (tree != 0) {
                    num = "1";
                } else {
                    num = "0";
                }
            }
        }
        return num;
    }

    //用于判断黑方或白方是否胜利
    public int results(int x, int y, String[][] checkerboard) {
        String[] result_tree = new String[8];
        int nums = 0;
        //以下两个循环用于判断横向胜利
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x-i][y] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x + i][y] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        if (nums >= 4) {
            return nums;
        } else {
            nums = 0;
        }
        //以下两个循环用于竖向胜利
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x][y - i] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x][y + i] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        if (nums >= 4) {
            return nums;
        } else {
            nums = 0;
        }
        //以下两个循环用于左上到右下的胜利
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x - i][y - i] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x + i][y + i] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        if (nums >= 4) {
            return nums;
        } else {
            nums = 0;
        }
        //以下两个循环用于右上到左下的胜利
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x - i][y + i] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 4; i++) {
            if (checkerboard[x + i][y - i] == checkerboard[x][y]) {
                nums += 1;
            } else {
                break;
            }
        }
        if (nums >= 4) {
            return nums;
        } else {
            nums = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        //定义白方下棋或黑方下棋
        boolean me = true;
        //声明对象
        modular02_second coad = new modular02_second();
        //打印且返回棋盘的二维数组
        String[][] checkerboard = coad.Checkerboard();
        //循环下棋
        while (true) {
            //调用下棋方法，且返回是否胜利
            String num = coad.Play_chess(me, checkerboard);
            //判断返回值，是黑方还是白方胜利
            if ("1" == num) {
                System.out.println("黑子胜利！");
                break;
            } else if ("2" == num) {
                System.out.println("白子胜利！");
                break;
            } else {
                me = !me;
                //打印下棋后的棋盘
                for (int i = 0; i < checkerboard.length; i++) {
                    for (int j = 0; j < checkerboard[i].length; j++) {
                        System.out.print(checkerboard[i][j] + "\t");
                    }
                    System.out.println();
                }
            }
        }
    }
}
