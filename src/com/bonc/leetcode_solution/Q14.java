package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-27 16:09
 * @description:
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int minlen = strs[0].length();
        for (String s: strs){
            minlen = Math.min(s.length(), minlen);
        }
        int len = strs.length;
        boolean flag = true;
        for(int i=0;i<minlen;i++){
            char cur = strs[0].charAt(i);
            for (int j=1;j<len;j++){
                if (cur!=strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                res.append(cur);
            }else{
                break;
            }
        }
        return res.toString();
    }
}
