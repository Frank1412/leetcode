package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-01 20:14
 * @description:
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 */
public class Q29 {

    // 未完成
    public int divide(int dividend, int divisor) {
        int res = 0, beichushu=dividend, flag=dividend/Math.abs(dividend)*divisor/Math.abs(divisor)>0?1:-1;
        while (Math.abs(divisor)<Math.abs(beichushu-flag*divisor)){
            beichushu -= flag*divisor;
            res++;
        }
        return dividend/Math.abs(dividend)*res;
    }
}
