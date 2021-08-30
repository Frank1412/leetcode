package com.bonc.leetcode_solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-27 20:34
 * @description: Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * <p>
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * <p>
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class Q76 {
    public String minWindow(String s, String t) {

        // 滑动窗口法
        Map<Character, Integer> tmap=new HashMap<>(), smap=new HashMap<>();
        for (char c: t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }
        int l=0, r=0, tLen=t.length(), ansLeft=0, ansRight=-1, minLen=Integer.MAX_VALUE;
        while (r<s.length()){
            smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0)+1);
            while (isValid(smap, tmap)&&l<=r){
                System.out.println(s.substring(l, r+1));
                if (r-l+1<minLen){
//                    smap.put(s.charAt(l), smap.getOrDefault(s.charAt(l), 0)-1);
                    ansLeft=l;
                    ansRight=r;
                    minLen = r-l+1;
                }
                if (tmap.containsKey(s.charAt(l))){
                    smap.put(s.charAt(l), smap.getOrDefault(s.charAt(l), 0)-1);
                }
                l++;
            }

            r++;
        }

        System.out.println(s.substring(ansLeft, ansRight+1));
        return ansRight==-1?"":s.substring(ansLeft, ansRight+1);
    }

    private boolean isValid(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for (Character c: tmap.keySet()){
            if (smap.getOrDefault(c, 0)<tmap.get(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Q76().minWindow("ADOBECODEBANC","ABC");
    }
}
