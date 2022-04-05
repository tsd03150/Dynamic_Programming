package com.boj_1890;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && i == n - 1 && j == n - 1) {
                    break;
                } else {
                    int down = i + board[i][j];
                    int right = j + board[i][j];

                    if (down < n) {
                        dp[down][j] += dp[i][j];
                    }

                    if (right < n) {
                        dp[i][right] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}