package com.boj_1932;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] dp = new int[n][];

        for (int i = 0; i < n; i++) {
            dp[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                dp[i][j] = kb.nextInt();
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[i - 1][j] += Math.max(dp[i][j], dp[i][j + 1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
