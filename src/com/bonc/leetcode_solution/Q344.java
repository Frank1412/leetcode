package com.bonc.leetcode_solution;

public class Q344 {

	public void reverseString(char[] s) {
		int p = 0,q=s.length-1;
		while(p<q) {
			char tmp = s[p];
			s[p] = s[q];
			s[q] = tmp;
			p++;
			q--;
		}
    }
	
	public static void main(String[] args) {
		
	}
}
