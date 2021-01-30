package com.bonc.leetcode_solution;

import java.util.HashSet;

public class Q3 {

	public static int lengthOfLongestSubstring(String s) {
		
		// string�Դ��ķ���
//		if (s.equals("")) {
//			return 0;
//		}
//		int len = s.length();
//		int maxlen=1;
//		for (int i = 0; i<s.length();i++) {
//			int p = i, q=i+1;
//			
//			while(q < s.length()) {
//				if (!s.substring(p, q).contains(String.valueOf(s.charAt(q)))) {
////					System.out.println(s.substring(p, q-1));
//					q++;
//				}else {
//					
//					break;
//				}
//				
//			}
//			
//			maxlen = Math.max(maxlen, q-p);
//		}
//		return maxlen;
		
		// HashSet
		int len = s.length();
		int maxlen=1;
		int q = 1;
		HashSet<Character> curSet = new HashSet<>();
		for (int i = 0; i<s.length();i++) {
			int p = i;
			if (p==0) {
				curSet.add(s.charAt(p));
			}else {
				curSet.remove(s.charAt(p-1));
			}
			
			while(q < s.length()) {
				if (!curSet.contains(s.charAt(q))) {
					curSet.add(s.charAt(q));
					q++;
				}else {
					break;
				}
				
			}
			
			maxlen = Math.max(maxlen, curSet.size());
		}
		return maxlen;
	}

	public static void main(String[] args) {
		String a = "bbbbb";
		int len = lengthOfLongestSubstring(a);
		System.out.println(len);
	}
}
