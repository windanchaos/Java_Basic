package algorithm.array;

/**
 * 斐波拉契数列Fibonacci 动态规划法
 * 
 * @author bojiang
 *
 */
public class Dynamic_Demo {
	static int numbers1 = 0;
	static int numbers2 = 0;
	static int numbers3 = 0;
	public static void main(String[] args) {
		// 动态规划的计算次数
		System.out.println(Fibonacci(10));
		System.out.println(numbers1);
		// 硬钢的计算次数
		System.out.println(directFibo(10));
		System.out.println(numbers2);
		System.out.println(Fibonacci_up(10));
		System.out.println(numbers3);
	}

	/*
	 * 硬钢
	 */
	public static int directFibo(int n) {
		int res = 0;
		if (n < 3)
			res = 1;
		else
			res = directFibo(n - 1) + directFibo(n - 2);
		numbers2++;
		return res;
	}

	/*
	 * 动态规划自顶向上
	 */
	public static int Fibonacci(int n) {
		if (n <= 0)
			return n;
		int[] Memo = new int[n + 1];
		for (int i = 0; i <= n; i++)
			Memo[i] = -1;
		return fib(n, Memo);
	}

	public static int fib(int n, int[] Memo) {
		numbers1++;
		if (Memo[n] != -1)
			return Memo[n];
		// 如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
		if (n <= 2)
			Memo[n] = 1;

		else
			Memo[n] = fib(n - 1, Memo) + fib(n - 2, Memo);

		return Memo[n];
	}

	/*
	 * 动态规划自底向上
	 */
	public static int Fibonacci_up(int n) {
		int res[] = new int[n + 1];
		numbers3++;
		res[0]=0;
		res[1]=1;
		res[2]=1;
		if (n > 2) {
			for (int i = 3; i < n + 1; i++)
				res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];

	}
}
