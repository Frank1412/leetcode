package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-13 19:09
 * @description:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 */
public class Q66 {

    // 更好方法：对10取余
    public int[] plusOne(int[] digits) {
        int jinwei=0;
        for (int i=digits.length-1;i>=0;i--){
            if(i==digits.length-1){
                if (digits[i]+1==10){
                    digits[i] = 0;
                    jinwei=1;
                }else{
                    digits[i] += 1+jinwei;
                    break;
                }
            }else if (jinwei==1){
                if (digits[i]+jinwei==10){
                    digits[i] = 0;
                    jinwei = 1;
                }else{
                    digits[i] += jinwei;
                    break;
                }
            }else{
                break;
            }
        }
        if (digits[0]==0){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
