package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-08 14:41
 * @description:
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 */
public class Q52 {
    boolean[] verifyCol;
    Map<Integer, Boolean> mainDiag;
    Map<Integer, Boolean> subDiag;
    int count;
    public int totalNQueens(int n) {
        verifyCol = new boolean[n];
        mainDiag = new HashMap<>();
        subDiag = new HashMap<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                mainDiag.put(i-j, false);
                subDiag.put(i+j, false);
            }
        }
        for (int j=0;j<n/2;j++){
            verifyCol[j] = true;
            mainDiag.put(-j, true);
            subDiag.put(j, true);
            dfs(n, 1, 1);
            verifyCol[j] = false;
            mainDiag.put(-j, false);
            subDiag.put(j, false);
        }
        count = 2*count;
        if (n%2==1){
            verifyCol[n/2] = true;
            mainDiag.put(-n/2, true);
            subDiag.put(n/2, true);
            dfs(n, 1, 1);
        }
        return count;
    }

    private void dfs(int n, int row, int size){
        if (row==n&&size==n){
            count++;
            return;
        }

        for (int j=0;j<n;j++){
            if (!mainDiag.get(row-j)&&!subDiag.get(row+j)&&!verifyCol[j]){
                verifyCol[j] = true;
                mainDiag.put(row-j, true);
                subDiag.put(row+j, true);
                size++;
                dfs(n, row+1, size);
                size--;
                verifyCol[j] = false;
                mainDiag.put(row-j, false);
                subDiag.put(row+j, false);
            }
        }
    }
}
