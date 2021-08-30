package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-28 18:00
 * @description:
 */
public class Q17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        ArrayList<String> res = new ArrayList<>();
        StringBuilder tmpStr = new StringBuilder();

        dfs(res, tmpStr, hm, digits,0);
        return res;
    }

    public void dfs(ArrayList<String> res, StringBuilder tmpStr, HashMap<Character, String> hm, String digits, int index){
        if (index > digits.length() - 1) {
            res.add(tmpStr.toString());
            return;
        }
        for(char c: hm.getOrDefault(digits.charAt(index), "").toCharArray()){
            tmpStr.append(c);
            dfs(res, tmpStr, hm, digits, index+1);
            tmpStr.deleteCharAt(tmpStr.length()-1);
        }
    }
}
