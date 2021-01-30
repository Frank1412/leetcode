package com.bonc.leetcode_solution;
import java.util.Stack;
public class Q503 {
	public static int[] nextGreaterElements(int[] nums) {
		
		// ����ջ ����ѭ��
		Stack<Integer> st = new Stack<>();
		int[] nextBigger = new int[nums.length];
		for (int i = 2*nextBigger.length-1; i >=0 ; i--) {
			while(!st.empty() && nums[i%nums.length]>=nums[st.peek()]) {
				st.pop();
			}
			if (st.empty()) {
				st.push(i%nums.length);
				nextBigger[i%nums.length] = -1;
			}else {
				nextBigger[i%nums.length] = nums[st.peek()];
				st.push(i%nums.length);
			}
		}
		return nextBigger;
    }
	
	public static void main(String[] args) {
		int[] a = {1,2,1};
		int[] b = nextGreaterElements(a);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
