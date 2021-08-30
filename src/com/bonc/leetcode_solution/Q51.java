package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-08 13:24
 * @description:
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 */
public class Q51 {

    boolean[] verifyCol;
    Map<Integer, Boolean> mainDiag;
    Map<Integer, Boolean> subDiag;
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        verifyCol = new boolean[n];
        mainDiag = new HashMap<>();
        subDiag = new HashMap<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                mainDiag.put(i-j, false);
                subDiag.put(i+j, false);
            }
        }
        for (int j=0;j<n;j++){
            verifyCol[j] = true;
            mainDiag.put(-j, true);
            subDiag.put(j, true);
            StringBuilder sb = new StringBuilder();
            for (int k=0;k<n;k++){
                if (k!=j){
                    sb.append('.');
                }else{
                    sb.append('Q');
                }
            }
            path.add(sb.toString());
            dfs(result, path, n, 1);
            path.remove(path.size()-1);
            verifyCol[j] = false;
            mainDiag.put(-j, false);
            subDiag.put(j, false);
        }
        return result;
    }

    private void dfs(List<List<String>> result, List<String> path, int n, int row){
        if (row==n&&path.size()==n){
            result.add(new ArrayList<>(path));
        }

        for (int j=0;j<n;j++){
            if (!mainDiag.get(row-j)&&!subDiag.get(row+j)&&!verifyCol[j]){
                verifyCol[j] = true;
                mainDiag.put(row-j, true);
                subDiag.put(row+j, true);
                StringBuilder sb = new StringBuilder();
                for (int k=0;k<n;k++){
                    if (k!=j){
                        sb.append('.');
                    }else{
                        sb.append('Q');
                    }
                }
                path.add(sb.toString());
                dfs(result, path, n, row+1);
                path.remove(path.size()-1);
                verifyCol[j] = false;
                mainDiag.put(row-j, false);
                subDiag.put(row+j, false);
            }
        }
    }
}
