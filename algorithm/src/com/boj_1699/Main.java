package com.boj_1699;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (i == 1) {
                    dp[j] = j;
                }
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
