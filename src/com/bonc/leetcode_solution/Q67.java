package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-13 22:33
 * @description: 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Q67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, jinwei = 0;
        while (i >= 0 && j >= 0) {
            int tmp = (a.charAt(i) - '0') + (b.charAt(j) - '0') + jinwei;
            if (tmp <= 1) {
                sb.append(tmp);
                jinwei = 0;
            }else if (tmp == 2){
                sb.append(0);
                jinwei = 1;
            }else{
                sb.append(1);
                jinwei = 1;
            }
            i--;
            j--;
        }
        if (i==-1&&j==-1){
            if (jinwei==1){
                sb.append(jinwei);
                return sb.reverse().toString();
            }else{
                return sb.reverse().toString();
            }
        }else if (i==-1){
            for (;j>=0;j--){
                int tmp = b.charAt(j)-'0'+jinwei;
                if(tmp==2){
                    sb.append(0);
                    jinwei = 1;
                }else{
                    sb.append(tmp);
                    jinwei = 0;
                }
            }
        }else{
            for (;i>=0;i--){
                int tmp = a.charAt(i)-'0'+jinwei;
                if(tmp==2){
                    sb.append(0);
                    jinwei = 1;
                }else{
                    sb.append(tmp);
                    jinwei = 0;
                }
            }
        }
        if (jinwei != 0) {
            sb.append(jinwei);
        }
        return sb.reverse().toString();
    }
}
