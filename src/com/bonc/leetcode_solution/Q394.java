package com.bonc.leetcode_solution;

import java.util.Stack;

public class Q394 {
	public static String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		Stack<Character> st = new Stack<>();
		int multi = 0;
		for (int i = 0; i < s.length(); i++) {
			System.out.println(st);
			if (!(s.charAt(i)-'0'<=9&&s.charAt(i)-'0'>=0) && s.charAt(i)!='[' && s.charAt(i)!=']') {
				System.out.println(Character.toString(s.charAt(i)));
				st.push(s.charAt(i));
			}else if ((s.charAt(i)-'0'<=9&&s.charAt(i)-'0'>=0)) {
				System.out.println(s.charAt(i));
				st.push(s.charAt(i));
			}else if (s.charAt(i)=='[') {
				System.out.println(s.charAt(i));
				st.push('[');
			}else {
				System.out.println(s.charAt(i));
				
				StringBuilder tmpStr = new StringBuilder();
				while(st.peek()!='[') {
					tmpStr.append(st.peek());
					st.pop();
				}
				tmpStr = tmpStr.reverse();
				st.pop();
				StringBuilder numStr = new StringBuilder();
				while(st.peek() >='0' && st.peek() <='9') {
					numStr.append(st.peek());
					st.pop();
					if (st.empty()) {
						break;
					}
				}
				int k = Integer.valueOf(numStr.reverse().toString());
				String tmp = "";
				for(int m=0;m<k;m++) {
					tmp += tmpStr.toString();
				}
				for (int m = 0; m < tmp.length(); m++) {
					st.push(tmp.charAt(m));
				}
			}
		}
		System.out.println(st);
		
		while(!st.empty()) {
			res.append(st.peek());
			st.pop();
		}
		return res.reverse().toString();
	}
	
	public static void main(String[] args) {
		String s = "3[a20[c]]";
		String result = decodeString(s);
		System.out.println(result);
		System.out.println('1'-'0');
	}
}
