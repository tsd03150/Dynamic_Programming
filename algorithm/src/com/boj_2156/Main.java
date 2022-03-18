package com.boj_2156;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] board = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            board[i] = kb.nextInt();
        }

        dp[1] = board[1];
        if (n > 1) {
            dp[2] = board[1] + board[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + board[i], dp[i - 3] + board[i - 1] + board[i]));
        }

        System.out.println(dp[n]);
    }
}