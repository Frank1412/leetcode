package com.bonc.leetcode_solution;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Q394 {
    public static int ptr=0;
//    public static LinkedList<String> st;
    public static String decodeString(String s) {

		// 单调栈使用 Stack数据结构
//		StringBuilder res = new StringBuilder();
//		Stack<Character> st = new Stack<>();
//		int multi = 0;
//		for (int i = 0; i < s.length(); i++) {
//			System.out.println(st);
//			if (!(s.charAt(i)-'0'<=9&&s.charAt(i)-'0'>=0) && s.charAt(i)!='[' && s.charAt(i)!=']') {
//				System.out.println(Character.toString(s.charAt(i)));
//				st.push(s.charAt(i));
//			}else if ((s.charAt(i)-'0'<=9&&s.charAt(i)-'0'>=0)) {
//				System.out.println(s.charAt(i));
//				st.push(s.charAt(i));
//			}else if (s.charAt(i)=='[') {
//				System.out.println(s.charAt(i));
//				st.push('[');
//			}else {
//				System.out.println(s.charAt(i));
//
//				StringBuilder tmpStr = new StringBuilder();
//				while(st.peek()!='[') {
//					tmpStr.append(st.peek());
//					st.pop();
//				}
//				tmpStr = tmpStr.reverse();
//				st.pop();
//				StringBuilder numStr = new StringBuilder();
//				while(st.peek() >='0' && st.peek() <='9') {
//					numStr.append(st.peek());
//					st.pop();
//					if (st.empty()) {
//						break;
//					}
//				}
//				int k = Integer.valueOf(numStr.reverse().toString());
//				String tmp = "";
//				for(int m=0;m<k;m++) {
//					tmp += tmpStr.toString();
//				}
//				for (int m = 0; m < tmp.length(); m++) {
//					st.push(tmp.charAt(m));
//				}
//			}
//		}
//		System.out.println(st);
//
//		while(!st.empty()) {
//			res.append(st.peek());
//			st.pop();
//		}
//		return res.reverse().toString();


		// 使用LinkedList数据结构
		LinkedList<String> st = new LinkedList<>();
		ptr = 0;
		while (ptr<s.length()){
		    char cur = s.charAt(ptr);
//            System.out.println(cur);
            System.out.println(st);
		    if (Character.isDigit(cur)){
		        String digit = getDigits(s);
		        st.addLast(digit);
            }else if (cur=='[' || Character.isLetter(cur)){
		        st.addLast(String.valueOf(cur));
		        ptr++;
            }else {
		        ptr++;
		        LinkedList<String> sub = new LinkedList<>();
		        while (!"[".equals(st.peekLast())){
		            sub.addLast(st.peekLast());
		            st.removeLast();
                }
                Collections.reverse(sub);
                System.out.println("sub: "+sub);
		        st.removeLast(); // 左括号[ 出栈

                int repeatTime = Integer.parseInt(st.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while(repeatTime > 0){
                    t.append(o);
                    repeatTime--;
                }
                st.addLast(t.toString());
            }
        }
        return getString(st);
	}

	public static String getDigits(String s){
	    StringBuffer ret = new StringBuffer();
	    while (Character.isDigit(s.charAt(ptr))){
	        ret.append(s.charAt(ptr));
	        ptr++;
        }
        return ret.toString();
    }

    public static String getString(LinkedList<String> v){
	    StringBuffer ret = new StringBuffer();
	    for (String o: v){
            ret.append(o);
        }
        return  ret.toString();
    }
	
	public static void main(String[] args) {
		String s = "3[a5[c]]";
		String result = decodeString(s);
		System.out.println(result);
		System.out.println('1'-'0');
		String[] a = new String[] {s};

        System.out.println(a[0]);
        System.out.println(-1/2 >=0);
	}
}
