import java.util.Scanner;
import java.util.Random;



//实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。 其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。 其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。 

public class exam_one_3 {
	
	public static void main(String[] ages) {
		
		//先生成红球n个
		Random snumber = new Random();
		int number = snumber.nextInt(6);
		String num = "";
		
		int i, j;
		
		//随机生成n个红球
		for (i = 1; i <= (number + 1); i++) {
			Random num1 = new Random();
			int num2 = num1.nextInt(33);
			num = num + (num2 + 1) + "\t";
		}
		
		//随机生成一个篮球
		Random num3 = new Random();
		int num4 = num3.nextInt(16);
		num = num + (num4 + 1) + "\t";
 		
 		//生成剩下的红球
		for (j = 1; j < (6 - number); j++) {
			Random num5 = new Random();
			int num6 = num5.nextInt(33);
			num = num + (num6 + 1) + "\t";
		}

		System.out.print("生成的数字为：" + num);
	}
}