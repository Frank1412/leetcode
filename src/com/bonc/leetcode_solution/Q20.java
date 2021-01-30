package com.bonc.leetcode_solution;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;
public class Q20 {
	public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>(); 
        Map<Character, Character> pair = new HashMap<Character, Character>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
			if (pair.keySet().contains(s.charAt(i))) {
				st.push(s.charAt(i));
			} else {
				if (st.empty()) {
					return false;
				}
				if (pair.get(st.peek())==s.charAt(i)) {
					st.pop();
				} else {
					return false;
				}
			}
		}
        if (st.empty()) {
			return true;
		}
        return false;
        
    }
	public static void main(String[] args) {
		System.out.println(isValid("(){}[]"));
	}
}
