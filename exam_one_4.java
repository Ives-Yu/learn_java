import java.util.Scanner;
import java.util.Random;



//自定义数组扩容规则，当已存储元素数量达到总容量的 80%时，扩容 1.5 倍。 例如，总容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15。


public class exam_one_4 {
	
	public static void main (String[] ages) {
		
		//输入容量的大小
		System.out.print("请输入容量大小:");
		Scanner snum = new Scanner(System.in);
		int num = snum.nextInt();
		
		//定义扩容前的数组
		int[] list = new int[num];
		//定义一个变量，用于判断容器是否达到80%
		int size = (int)(num * 0.8);
		
		//循环输入存储元素
		for (int i = 0; i < list.length; i++) {
			System.out.println();
			System.out.print("请输入第" + (i + 1) + "个存储元素：");
			Scanner num1 = new Scanner(System.in);
			int num2 = num1.nextInt();
			list[i] = num2;
			
			//判断容器是否使用到80%
			if (i == (size - 1)) {
				System.out.println();
				System.out.print("当前数组已到达容量的80%，需扩容");
				
				//定义扩容后的数组大小
				int num3 = (int)(num * 1.5);
				
				//定义容器
				int[] list1 = new int[num3];
				
				//循环把扩容前的容器数据存入扩容后的容器中
				for (int j = 0; j < list1.length; j++) {
					list1[j] = list[j];
					
					//将栈中存放的堆地址改为扩容后的地址
					list = list1;
					System.out.println();
					System.out.print("正在进行扩容，请稍后～～～～～～");
				}
				System.out.println();
				System.out.print("当前list1容量为：" + list1.length);
				System.out.println();
				System.out.print("当前list容量为：" + list.length);
			}
		}
	}
}
