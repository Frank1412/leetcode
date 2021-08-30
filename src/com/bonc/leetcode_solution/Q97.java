package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-17 21:21
 * @description: Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * <p>
 * Note: a + b is the concatenation of strings a and b.
 * <p>
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * <p>
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * <p>
 * Example 3:
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 */
public class Q97 {

    boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {

        // dynamic programming
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];


        // 回溯法超时
//        if (s1.length()+s2.length()!=s3.length()){
//            return false;
//        }
//
//        memo = new boolean[s1.length()+1][s2.length()+1];
//        dfs(s1.length(), s2.length(), s1, s2, s3);
//        return memo[s1.length()][s2.length()];
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3) {
        if (i == 0 && j == 0) return true;

        if (memo[i][j]) {
            return true;
        }

        boolean step1=false, step2=false;
        if (i > 0) {
            step1 = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dfs(i - 1, j, s1, s2, s3);
        }
        if (j > 0) {
            step2 = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dfs(i, j - 1, s1, s2, s3);
        }

        memo[i][j] = step1 || step2;
        return memo[i][j];
    }
}
