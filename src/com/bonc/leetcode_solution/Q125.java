package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-25 17:26
 * @description:
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 */
public class Q125 {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<j){

            while (i<j&&!Character.isAlphabetic(s.charAt(i))&&!Character.isDigit(s.charAt(i))){
                i++;
            }
            while (i<j&&!Character.isAlphabetic(s.charAt(j))&&!Character.isDigit(s.charAt(j))){
                j--;
            }
            if (Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
