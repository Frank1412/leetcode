package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-08 12:43
 * @description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 */
public class Q50 {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE)
            return (x == 1 || x == -1) ? 1 : 0;
        else if(n == 0)
            return 1;

        if (n<0) return myPow(1/x, -n);

        if (n%2!=0){
            return x*myPow(x, n-1);
        }else{
            double tmp = myPow(x, n/2);
            return tmp*tmp;
        }
    }
}
