package com.boj_1915;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] dp = new int[n + 1][m + 1];
        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            char[] str = kb.next().toCharArray();
            for (int j = 1; j <= m; j++) {
                int tmp = str[j - 1] - '0';

                if (tmp == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        System.out.println(answer * answer);
    }
}