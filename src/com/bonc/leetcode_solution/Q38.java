package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-04 19:53
 * @description:
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 *
 */
public class Q38 {
    public static String countAndSay(int n) {
        if (n==1){
            return "1";
        }
        String pre = countAndSay(n-1);
        StringBuilder res = new StringBuilder();
//        res.append(pre.charAt(0));
        int i=0,len=pre.length(), count=0;
        while (i < len) {
            if (i==0){
                count++;
            }else{
                if(pre.charAt(i)==pre.charAt(i-1)){
                    count++;
                }else{
                    res.append(String.valueOf(count));
                    res.append(String.valueOf(pre.charAt(i-1)));
                    count=1;
                }
            }
            i++;
        }
        res.append(String.valueOf(count));
        res.append(String.valueOf(pre.charAt(i-1)));
        System.out.println(res.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        String result = countAndSay(4);
        System.out.println(result);
    }
}
