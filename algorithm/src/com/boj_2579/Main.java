package com.boj_2579;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] dp = new int[n + 1][2];
        dp[1][1] = kb.nextInt();

        for (int i = 2; i <= n; i++) {
            int num = kb.nextInt();

            dp[i][0] = dp[i - 1][1] + num;
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + num;
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
