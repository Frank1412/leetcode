package com.bonc.leetcode_solution;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-03 22:40
 */
public class Q292 {
    public static String reorganizeString(String S) {
        HashMap<Character, Integer> char_cnt = new HashMap<>();
        for (Character c: S.toCharArray()){
            char_cnt.put(c, char_cnt.getOrDefault(c, 0)+1);
        }
        int max=0;
        for(int num: char_cnt.values()){
            max = Math.max(max, num);
        }
        if (max > (S.length()+1)/2) return "";

        PriorityQueue<Character> charHeap = new PriorityQueue<>((c1,c2)->(char_cnt.get(c2).compareTo(char_cnt.get(c1))));
        for (Character c: char_cnt.keySet()){
            charHeap.offer(c);
            char_cnt.replace(c, char_cnt.get(c)-1);
        }
        System.out.println(char_cnt);
        System.out.println(charHeap);
        StringBuffer sb = new StringBuffer();
        while (charHeap.size()!=0){
            System.out.println(charHeap);
            if (charHeap.size()>=2){
                char c1 = charHeap.poll();
                char c2 = charHeap.poll();
                sb.append(c1);
                sb.append(c2);
                if (char_cnt.get(c1)>0){
                    charHeap.offer(c1);
                }
                if (char_cnt.get(c2)>0){
                    charHeap.offer(c2);
                }
                char_cnt.replace(c1, char_cnt.get(c1)-1);
                char_cnt.replace(c2, char_cnt.get(c2)-1);
            }
            if (charHeap.size()==1){
                sb.append(charHeap.poll());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("geeqmvpgy"));
    }
}
