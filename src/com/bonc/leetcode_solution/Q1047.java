package com.bonc.leetcode_solution;

public class Q1047 {
	public String removeDuplicates(String S) {

		// stack
		StringBuilder sb = new StringBuilder();
		int sb_len = 0;
		for (char c : S.toCharArray()) {
			if (sb_len!=0 && c == sb.charAt(sb_len-1)) {
				sb.deleteCharAt(sb_len-1);
				sb_len--;
			
			}else {
				sb.append(c);
				sb_len++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {

	}
}
