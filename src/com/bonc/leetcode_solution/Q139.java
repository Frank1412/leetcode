package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-04 21:53
 * @description:
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 */
public class Q139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] isBreak = new Boolean[s.length()+1];
        return dfs(s, s.length(), wordDict, isBreak);
    }

    public static boolean dfs(String s, int end, List<String> wordDict, Boolean[] isBreak){
        if (s.equals("")){
            isBreak[end] = true;
            return true;
        }
        if(isBreak[end]!=null){
            return isBreak[end];
        }
        isBreak[end] = false;
        for(int i=0;i<end;i++){
            boolean right = wordDict.contains(s.substring(i, end));
            if (!right){
                continue;
            }
            boolean left = dfs(s, i, wordDict, isBreak);
            if (left){
                isBreak[end] = true;
                break;
            }
        }

        return isBreak[end];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        Boolean res = wordBreak(s, dict);
        System.out.println(res);
    }
}

