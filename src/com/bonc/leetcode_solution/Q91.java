package com.bonc.leetcode_solution;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-07 20:34
 * @description: A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * Given a string s containing only digits, return the number of ways to decode it.
 * The answer is guaranteed to fit in a 32-bit integer.
 */
public class Q91 {
    public static int numDecodings(String s) {
        int[] nums = new int[s.length()+1];
        int result = dfs(s, nums, s.length());
        return result;
    }

    public static int dfs(String s, int[] nums, int end) {
        if (end == 0) {
            return 1;
        }
        if (end == 1) {
            return s.charAt(end - 1) == '0' ? 0 : 1;
        }

        if (nums[end] != 0) {
            return nums[end];
        }

        int res = 0;
        char x = s.charAt(end - 1);
        if (x != '0') {
            res += dfs(s, nums, end - 1);
        }
        char y = s.charAt(end - 2);
        if ((x - '0') + 10 * (y - '0') <= 26 && (x - '0') + 10 * (y - '0') >= 10) {
            res += dfs(s, nums, end - 2);
        }
        nums[end] = res;

        return res;
    }


    public static void main(String[] args) {
        int res = numDecodings("226");
        System.out.println(res);
    }
}
