package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-27 22:23
 * @description: Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * <p>
 * Example 2:
 * Input: board = [["X"]]
 * Output: [["X"]]
 */
public class Q130 {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for(int i=0;i<m;i++){
            if (board[i][0]=='O'){
                dfs(board, i, 0, m, n);
            }
            if (board[i][n-1]=='O'){
                dfs(board, i, n-1, m, n);
            }
        }

        for (int j=0;j<n;j++){
            if (board[0][j]=='O'){
                dfs(board, 0, j, m, n);
            }
            if (board[m-1][j]=='O'){
                dfs(board, m-1, j, m, n);
            }
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                if (board[i][j]=='A'){
                    board[i][j] = 'O';
                }else if (board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j, int m, int n) {

        if (i < 0 || i > m || j < 0 || j > n||board[i][j]!='O') {
            return ;
        }

        board[i][j] = 'A';

        dfs(board, i + 1, j , m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i-1, j, m, n);
        dfs(board, i , j-1, m, n);

    }
}
