package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-06 11:46
 * @description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 */
public class Q22 {

    public List<String> generateParenthesis1(int n){
        List<String> res = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        dfs(res, ans, n, n);
        return res;
    }

    public void dfs(List<String> res, StringBuilder ans, int left, int right){

        if (left==0){
            for(int i=0;i<right;i++){
                ans.append(')');
            }
            res.add(ans.toString());
            ans = ans.delete(ans.length()-right, ans.length()-1);
            return;
        }

        if (left == right) {
            ans.append('(');
            dfs(res, ans, left-1, right);
            ans.deleteCharAt(ans.length()-1);
        }else{
            ans.append('(');
            dfs(res, ans, left-1, right);
            ans.deleteCharAt(ans.length()-1);
            ans.append(')');
            dfs(res, ans, left, right-1);
            ans.deleteCharAt(ans.length()-1);
        }
    }




























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
