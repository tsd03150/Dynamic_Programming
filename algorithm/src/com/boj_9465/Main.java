package com.boj_9465;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-- > 0) {
            int n = kb.nextInt();
            int[][] board = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = kb.nextInt();
                }
            }

            int[][] dp = new int[2][n];
            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];

            if (n > 1) {
                dp[0][1] = board[1][0] + board[0][1];
                dp[1][1] = board[0][0] + board[1][1];
            }

            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1] + board[0][i], dp[1][i - 2] + board[0][i]);
                dp[1][i] = Math.max(dp[0][i - 1] + board[1][i], dp[0][i - 2] + board[1][i]);
            }

            answer.append(Math.max(dp[0][n - 1], dp[1][n - 1]) + "\n");
        }

        System.out.println(answer);
    }
}
