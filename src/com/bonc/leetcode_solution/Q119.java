package com.bonc.leetcode_solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-23 19:55
 * @description:
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 */
public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new LinkedList<>();
        for (int i=0;i<=rowIndex;i++){
            List<Integer> res = new LinkedList<>();
            for (int j=0;j<=i;j++){
                if (j==0||j==i){
                    res.add(1);
                }else{
                    res.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre = res;

        }
        return pre;
    }
}
