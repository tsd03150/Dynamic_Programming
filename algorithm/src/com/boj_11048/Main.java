package com.boj_11048;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] board = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int a = kb.nextInt();
                int b = Math.max(board[i - 1][j - 1], Math.max(board[i - 1][j], board[i][j - 1]));
                board[i][j] = a + b;
            }
        }

        System.out.println(board[n][m]);
    }
}