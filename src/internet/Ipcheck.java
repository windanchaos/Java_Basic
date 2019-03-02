package internet;

import java.util.ArrayList;
import java.util.List;

/*
 * 这是我面试前拿到的面试题，面试的时候又手撸了一个算法，没有过。面试官告诉我，正则表达式才是最简的。
 * 使用了eclipse调试，没有使用junit或testng验证case。
 * 整个笔试题设计算法(ip4，没有考虑ip6)、编码、调试、答题时间约4个小时，撸的过程中很多方法都不熟。
*/

/*
 * 题目：
 * 一、请以纸笔或者文本形式完成以下题目，勿使用IDE等开发工具

题目：完成一个函数，实现功能为判断一个字符串是否是一个合法的ip地址
输入：任意字符串
输出：如果是一个合法ip地址，返回true；否则，返回false
举例：输入10.0.0.1，输出true；输入aaaa，输出false

要求：
1.	可以用c/c++/java/php/python等任意熟悉语言，但不能使用规则表达式等已有算法；
 */

public class Ipcheck {

	public static void main(String[] args) {
		System.out.println(isIP(null)+" expect:false");
		// case
		System.out.println(isIP("abcdef")+" expect:false");
		System.out.println(isIP("abcdef1")+" expect:false");
		System.out.println(isIP("*&^123456.")+" expect:false");
		System.out.println(isIP("~!@#$%^&*nm12345")+" expect:false");

		System.out.println(isIP(".12.222.255")+" expect:false");
		System.out.println(isIP("255.0.254.")+" expect:false");
		System.out.println(isIP("255.255.254.254.")+" expect:false");
		System.out.println(isIP("255.12..254")+" expect:false");
		System.out.println(isIP("254.1233.11.255")+" expect:false");

		System.out.println(isIP("255.254.255.256")+" expect:false");
		System.out.println(isIP("-1.255.0.0")+" expect:false");
		System.out.println(isIP("256.256.256.256")+" expect:false");
		System.out.println(isIP("-1.-1.-1.255")+" expect:false");

		System.out.println(isIP("0.9.1.0")+" expect:true");
		System.out.println(isIP("127.0.255.1")+" expect:true");
		System.out.println(isIP("10.254.0.1")+" expect:true");
		System.out.println(isIP("255.255.255.255")+" expect:true");
		System.out.println(isIP("172.167.0.177")+" expect:true");
	}

	public static boolean isIP(String ip) {
		// 空检查
		if (null == ip)
			return false;
		int ipLength = ip.length();
		// 检查长度0.0.0.0-255.255.255.255，即7-15
		if (ipLength < 7 || ipLength > 15)
			return false;
		// 记录点在ip中的index
		List<Integer> pointIndex=new ArrayList<>();
		// 点字符串数检查
		for (int i = 0; i < ipLength; i++) {
			// string 到char
			char c = ip.charAt(i);
			if (c == 46 || (c >= 48 && c <= 57)) {
				// 什么也不做
				// 记录点在ip中的index
				if (c == 46) {
					pointIndex.add(i);
				}
			} else
				return false;
		}
		// 点的数量要求
		if (pointIndex.size() != 3)
			return false;
		// .的index不能在首位，不能在尾部
		if (pointIndex.get(0) == 0 || pointIndex.get(2) == (ipLength - 1)) {
			return false;
		}
		// 遍历检查点间距是否符合长度要求
		// 间距范围1-3,加减值2-4
		for (int i = 0; i < 2; i++) {
			int distanceOfIndex = pointIndex.get(i+1) - pointIndex.get(i);
			// 挨着的以及距离过大的
			if (distanceOfIndex == 1 || distanceOfIndex > 4)
				return false;
		}
		// 检查数值0-255 
		if (!checkNum(Integer.parseInt(ip.substring(0, pointIndex.get(0)))))
			return false;
		if (!checkNum(Integer.parseInt(ip.substring(pointIndex.get(0)+1, pointIndex.get(1)))))
			return false;
		if (!checkNum(Integer.parseInt(ip.substring(pointIndex.get(1)+1, pointIndex.get(2)))))
			return false;
		if (!checkNum(Integer.parseInt(ip.substring(pointIndex.get(2)+1, ipLength))))
			return false;
		return true;
	}

	public static boolean checkNum(int num) {
		if (num > 255 || num < 0) {
			return false;
		} else
			return true;

	}
}
