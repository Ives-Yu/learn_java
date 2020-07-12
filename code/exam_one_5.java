//使用二维数组和循环实现五子棋游戏棋盘的绘制
import java.util.Scanner;
import java.util.Random;


public class exam_one_5 {
	
	public static void main (String[] ages) {
		
		//定义一个二维数组
		String[][] list = new String[17][17];
		
		
		//循环存入数组数据
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				
				//判断0，0，如果是0，0输入空
				if (0 == i && 0 == j) {
					list[i][j] = " ";
					
					//进行第一行的数据输入0-9，a-f
				} else if (0 == i && 0 != j) {
					switch (j) {
						case 1: list[i][j] = "0";break;
						case 2: list[i][j] = "1";break;
						case 3: list[i][j] = "2";break;
						case 4: list[i][j] = "3";break;
						case 5: list[i][j] = "4";break;
						case 6: list[i][j] = "5";break;
						case 7: list[i][j] = "6";break;
						case 8: list[i][j] = "7";break;
						case 9: list[i][j] = "8";break;
						case 10: list[i][j] = "9";break;
						case 11: list[i][j] = "a";break;
						case 12: list[i][j] = "b";break;
						case 13: list[i][j] = "c";break;
						case 14: list[i][j] = "d";break;
						case 15: list[i][j] = "e";break;
						case 16: list[i][j] = "f";break;
						default: break;
					}
					//进行第一列的数据输入0-9，a-f
				} else if (0 == j && 0 != i) {
					switch (i) {
						case 1: list[i][j] = "0";break;
						case 2: list[i][j] = "1";break;
						case 3: list[i][j] = "2";break;
						case 4: list[i][j] = "3";break;
						case 5: list[i][j] = "4";break;
						case 6: list[i][j] = "5";break;
						case 7: list[i][j] = "6";break;
						case 8: list[i][j] = "7";break;
						case 9: list[i][j] = "8";break;
						case 10: list[i][j] = "9";break;
						case 11: list[i][j] = "a";break;
						case 12: list[i][j] = "b";break;
						case 13: list[i][j] = "c";break;
						case 14: list[i][j] = "d";break;
						case 15: list[i][j] = "e";break;
						case 16: list[i][j] = "f";break;
						default: break;
					}
					//进行+号的输入
				} else {
					list[i][j] = "+";
				}
			}
		}
		
		//打印
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				System.out.print(list[i][j] + "\t");
			}
			System.out.println();
		}
	}
}