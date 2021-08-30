package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-05 19:44
 * @description:
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 */
public class Q43 {

    // 结果位数为 m+n~m+n+1之间
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] num=new int[len1+len2];
        for (int i=len1-1;i>-1;i--) {
            for (int j=len2-1;j>-1;j--) {
                int temp= (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                temp+=num[i+j+1];

                num[i+j+1]=temp%10;
                num[i+j]+=temp/10;
            }
        }

        int start=0;
        while(start<num.length-1) {
            if (num[start]!=0) {
                break;
            }else {
                start++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=start;i<num.length;i++) {
            result.append(String.valueOf(num[i]));
        }

        return result.toString();
    }
}
