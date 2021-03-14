package com.bonc.leetcode_solution;

public class Q5 {

	Boolean[][] memo;
	String result = "";
	public String longestPalindrome(String s) {
		int n = s.length();
		memo = new Boolean[n][n];
		isPalindrome(s, 0, n-1);

		return result;
	}

	private boolean isPalindrome(String s, int i, int j){
		if(i>=j){
		    if(result.length()<j-i+1){
		        result = s.substring(i, j+1);
            }
			return true;
		}
		if(memo[i][j]!=null){
		    return memo[i][j];
        }
        boolean res=false;
        if(isPalindrome(s, i+1, j-1) && s.charAt(i)==s.charAt(j)){
            if(result.length()<j-i+1){
                result = s.substring(i, j+1);
            }
            res = true;
        }else{
            isPalindrome(s, i, j-1);
            isPalindrome(s, i+1, j);
        }
        memo[i][j] = res;

        return res;
	}

	public static void main(String[] args) {
        Boolean[] a = new Boolean[2];
		System.out.println(a[0]==null);
//		System.out.println(new Q5().longestPalindrome("bb"));
	}
}
