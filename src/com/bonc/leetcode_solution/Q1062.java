package com.bonc.leetcode_solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-04-05 21:22
 * @description:
 */
public class Q1062 {

    public int longestRepeatingSubstring(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            int mid = i + (j-i+1)/2;
            if (isValid(mid, s)){
                i = mid;
            }else{
                j = mid-1;
            }
        }
        return j;
    }

    private boolean isValid(int pos, String s){
        Set<String> stringSet = new HashSet<>();
        for(int i=0;i<s.length()-pos;i++){
            String cur = s.substring(i, i+pos+1);
            if (stringSet.contains(cur)){
                return true;
            }
            stringSet.add(cur);
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
