package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-26 17:44
 * @description:
 */
public class Q9 {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        int res=0, raw=x;
        while (x!=0){
            System.out.println(x%10);
            res = x%10 + res*10;
            x /= 10;
        }
        return res==raw;
    }

    public static void main(String[] args) {
        isPalindrome(-121);
    }
}
