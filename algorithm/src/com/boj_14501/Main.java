package com.boj_14501;

import java.util.Scanner;

class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            int time = kb.nextInt();
            int point = kb.nextInt();

            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + time <= n + 1) {
                dp[i + time] = Math.max(dp[i + time], dp[i] + point);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            max = Math.max(num, max);
        }
        System.out.println(max);
    }
}
