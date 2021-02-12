package com.bonc.leetcode_solution;

import java.util.Deque;
import java.util.LinkedList;

public class Q2 {

	
	
	public static void main(String[] args) {
		Deque<Integer> queue = new LinkedList<>();
		queue.offerLast(1);
		queue.offerLast(2);
		queue.offerLast(3);
		System.out.println(queue);
	}
}
