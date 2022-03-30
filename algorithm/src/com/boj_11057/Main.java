package com.boj_11057;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        long[][] dp = new long[n + 1][10];

        long answer = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
                if (i == n) {
                    answer += dp[i][j];
                }
            }
        }

        System.out.println(answer % 10007);
    }
}
