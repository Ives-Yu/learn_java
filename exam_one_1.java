import java.util.Scanner;
import java.util.Random;

//1. 编程题 提示用户输入年月日信息，判断这一天是这一年中的第几天并打印。

public class exam_one_1 {
	
	public static void main(String[] ages) {
		
		System.out.println("请输入年月日：以年 月 日形式。");
		Scanner syear = new Scanner(System.in);
		int year = syear.nextInt();
		int month = syear.nextInt();
		int day = syear.nextInt();
		
		//该变量记录于天数
		int days = 0;
		
		//判断年份是闰年还是平年
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			
			//判断月份是否符合
			if (month >= 13) {
				System.out.println("请输入正确月份!");
				
				//判断日份是否符合
			} else if ((month == 2 && day > 29) || ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31) || ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)) {
				System.out.println("请输入正确日份！");
				
			} else {
				
				//循环相加月份的天数
				while ((month - 1) > 0) {
					switch (month-1) {
						case 1: days += 31; month--; break;
						case 2: days += 29; month--; break;
						case 3: days += 31; month--; break;
						case 4: days += 30; month--; break;
						case 5: days += 31; month--; break;
						case 6: days += 30; month--; break;
						case 7: days += 31; month--; break;
						case 8: days += 31; month--; break;
						case 9: days += 30; month--; break;
						case 10: days += 31; month--; break;
						case 11: days += 30; month--; break;
						case 12: days += 31; month--; break;
					}
				}
				
				System.out.println("该年月日是第" + (days + day) + "天");
			}
		} else {
			
			if (month >= 13) {
				System.out.println("请输入正确月份!");
				
				//判断日份是否符合
			} else if ((month == 2 && day > 28) || ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31) || ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)) {
				System.out.println("请输入正确日份！");
				
			} else {
				
				//循环相加月份的天数
				while ((month - 1) > 0) {
					switch (month-1) {
						case 1: days += 31; month--; break;
						case 2: days += 28; month--; break;
						case 3: days += 31; month--; break;
						case 4: days += 30; month--; break;
						case 5: days += 31; month--; break;
						case 6: days += 30; month--; break;
						case 7: days += 31; month--; break;
						case 8: days += 31; month--; break;
						case 9: days += 30; month--; break;
						case 10: days += 31; month--; break;
						case 11: days += 30; month--; break;
						case 12: days += 31; month--; break;
					}
				}
				
				System.out.println("该年月日是第" + (days + day) + "天");
			}
		}
	}
}
