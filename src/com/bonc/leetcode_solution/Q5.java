package com.bonc.leetcode_solution;

public class Q5 {

	public static String longestPalindrome(String s) {

		// ������ O(n^3)
//		String maxlenStr = s.substring(0, 1);
//		int maxlen = 1;

		// ��̬�滮
		System.out.println(s);
		if (s.length()==1) {
			return s;
		}
		String maxlenStr = s.substring(0, 1);
		int maxlen = 1;
		int start = 0;
		boolean[][] pij = new boolean[s.length()][s.length()];

		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i < s.length()-1; i++) {
				pij[i][i] = true;
				if (l==2) {
					System.out.println(s.charAt(i)==s.charAt(i+1));
					if (s.charAt(i)==s.charAt(i+1)) {
						pij[i][i+1] = true;
						maxlen = 2;
						start = i;
						
					}else {
						pij[i][i+1] = false;
					}
				} else {
					if (i+l-1<s.length()) {
						if (pij[i+1][i+l-2] && s.charAt(i)==s.charAt(i+l-1)) {
							pij[i][i+l-1] = true;
							maxlen = l;
							start = i;
						} else {
							pij[i][i+l-1] = false;
						}
					}
				}
			}
		}
		return s.substring(start, start+maxlen);

	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("bb"));
	}
}
