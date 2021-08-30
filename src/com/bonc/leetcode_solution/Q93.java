package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-16 20:22
 * @description: Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
 * <p>
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * <p>
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * <p>
 * Example 3:
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * <p>
 * Example 4:
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 * <p>
 * Example 5:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class Q93 {

    int len;
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        len = s.length();
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, sb, 0);

        return res;
    }

    private void dfs(String s, int start, StringBuilder sb, int index) {
        if (index == 4) {
            if (sb.length() == len + 3) {
                res.add(sb.toString());
                return;
            } else {
                return;
            }
        }
        if (start>=len) return ;
        if (s.charAt(start) == '0') {
            sb.append("0");
            if (index < 3) {
                sb.append(".");
            }
            dfs(s, start + 1, sb, index + 1);
            if (index < 3) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > len) break;
            String tmpStr = s.substring(start, start + i);
            if (Integer.valueOf(tmpStr) >= 0 && Integer.valueOf(tmpStr) <= 255) {
                sb.append(tmpStr);
                if (index < 3) {
                    sb.append(".");
                }
                dfs(s, start + i, sb, index + 1);
                if (index < 3) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.delete(sb.length() - i, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = new Q93().restoreIpAddresses("25525511135");

        for(String s: res){
            System.out.println(s);
        }
    }
}
