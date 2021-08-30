package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-12 22:59
 * @description:
 *
    给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
    单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

    示例 1：
    输入：s = "Hello World"
    输出：5

    示例 2：
    输入：s = " "
    输出：0
 */
public class Q58 {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1, len=0;
        while(i>=0&&s.charAt(i)==' '){
            i--;
        }
        if(i==-1){
            return 0;
        }else{
            while(i>=0){
                if(s.charAt(i)!=' '){
                    len++;
                }else break;
                i--;
            }
        }
        return len;

    }
}
