package com.boj_1149;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            int R = kb.nextInt();
            int G = kb.nextInt();
            int B = kb.nextInt();

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B;
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
