package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-06 11:46
 * @description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 */
public class Q22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(result, n, n, cur);
        return result;
    }

    public static void dfs(List<String> res, int left, int right, StringBuilder cur){
        if (left==0&&right==0){
            res.add(cur.toString());
            return;
        }
        if(left>0){
            cur.append("(");
            dfs(res, left-1, right, cur);
            cur.deleteCharAt(cur.length()-1);
        }
        if(right>left){
            cur.append(")");
            dfs(res, left, right-1, cur);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
