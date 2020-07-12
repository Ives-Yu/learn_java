

//2. 编程题 编程找出 1000 以内的所有完数并打印出来。 所谓完数就是一个数恰好等于它的因子之和，如：6=1＋2＋3

public class exam_one_2 {
	
	public static void main(String[] agews) {
		
		int j = 1;
		System.out.print("1000以内的完数有：");
		for (int i = 1; i <= 1000; i++) {
				int nums = 0;
				for (j = 1; j <= i - 1; j++) {
					if (i % j == 0) {
						nums += j;
					}
				}
				if (nums == j) {
					System.out.print(nums + "\t");
				}
		}
	}
}
