package com.boj_11660;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int[][] board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j];
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            int x1 = kb.nextInt();
            int y1 = kb.nextInt();
            int x2 = kb.nextInt();
            int y2 = kb.nextInt();

            answer.append(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1] + "\n");
        }

        System.out.println(answer);
    }
}
