package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-11 11:16
 * @description: Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *  
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 */
public class Q79 {

    boolean[][] used;
    int m, n, len;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        len = word.length();
        used = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dfs(board, word, 0, i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j]) {
            return false;
        }
        if (index == len-1) {
            return board[i][j]==word.charAt(index);
        }
        if (board[i][j]!=word.charAt(index)){
            return false;
        }
        used[i][j] = true;

        boolean down = dfs(board, word, index+1, i+1, j);
        boolean top = dfs(board, word, index+1, i-1, j);
        boolean right = dfs(board, word, index+1, i, j+1);
        boolean left = dfs(board, word, index+1, i, j-1);

        if (top||down||left||right){
            return true;
        }else{
            used[i][j] = false;
            return false;
        }
    }
}
