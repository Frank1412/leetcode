package com.bonc.leetcode_solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
public class Q20 {
	public static boolean isValid(String s) {
		HashMap<Character, Character> bracket = new HashMap<>();
		bracket.put('(', ')');
		bracket.put('[', ']');
		bracket.put('{', '}');

		Stack<Character> st = new Stack<>();
		for (char c:s.toCharArray()){
			if (bracket.containsKey(c)){
				st.push(c);
			}else{
				if (!st.isEmpty()&&bracket.get(st.peek()) == c) {
					st.pop();
				}else{
					return false;
				}
			}
		}
		return st.isEmpty();

































//        Stack<Character> st = new Stack<>();
//        Map<Character, Character> pair = new HashMap<Character, Character>();
//        pair.put('(', ')');
//        pair.put('[', ']');
//        pair.put('{', '}');
//        for (int i = 0; i < s.length(); i++) {
//			if (pair.keySet().contains(s.charAt(i))) {
//				st.push(s.charAt(i));
//			} else {
//				if (st.empty()) {
//					return false;
//				}
//				if (pair.get(st.peek())==s.charAt(i)) {
//					st.pop();
//				} else {
//					return false;
//				}
//			}
//		}
//        if (st.empty()) {
//			return true;
//		}
//        return false;
        
    }
	public static void main(String[] args) {
		System.out.println(isValid("(){}[]"));
	}
}
