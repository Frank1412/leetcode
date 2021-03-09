package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-09 20:38
 * @description:
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 */
public class Q338 {
    public int[] countBits(int num) {

        // 分奇偶, 奇数一定比前一个偶数多一, 偶数一定等于其一半的以的个数，因为二进制偶数的一半相当于右移一位！！
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
            if(i%2==1){
                res[i] = res[i-1]+1;
            }else{
                res[i] = res[i/2];
            }
        }
        return res;
    }
}
