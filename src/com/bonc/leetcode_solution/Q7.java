package com.bonc.leetcode_solution;

public class Q7 {
	public static int reverse(int x) {
		long rev = 0;
		while (x != 0) {
			rev = x % 10 + rev * 10;
			x = x / 10;
		}
		return (int) rev == rev ? (int) rev : 0;

	}

	public static void main(String[] args) {
		int a = reverse(684165182);
		System.out.println(a);
	}
}
