package com.bonc.leetcode_solution;

import java.util.HashSet;

public class Q3 {

	public static int lengthOfLongestSubstring(String s) {
		
		// 滑动窗口
		int left=0,right=0, maxlen=0;
		HashSet<Character> curSet = new HashSet<>();
        while(left<s.length()){
            while(right<s.length()&& !curSet.contains(s.charAt(right))){
                curSet.add(s.charAt(right));
                right++;
            }
            maxlen = Math.max(maxlen, curSet.size());
            curSet.remove(s.charAt(left));
            left++;
        }

        return maxlen;
		
		// HashSet
//		int len = s.length();
//		int maxlen=1;
//		int q = 1;
//		HashSet<Character> curSet = new HashSet<>();
//		for (int i = 0; i<s.length();i++) {
//			int p = i;
//			if (p==0) {
//				curSet.add(s.charAt(p));
//			}else {
//				curSet.remove(s.charAt(p-1));
//			}
//
//			while(q < s.length()) {
//				if (!curSet.contains(s.charAt(q))) {
//					curSet.add(s.charAt(q));
//					q++;
//				}else {
//					break;
//				}
//
//			}
//
//			maxlen = Math.max(maxlen, curSet.size());
//		}
//		return maxlen;
	}

	public static void main(String[] args) {
		String a = "bbbbb";
		int len = lengthOfLongestSubstring(a);
		System.out.println(len);
	}
}
