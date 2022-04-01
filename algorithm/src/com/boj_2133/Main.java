package com.boj_2133;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        if (n % 2 != 0) {
            System.out.println(0);
        } else {
            if (n > 1) {
                dp[2] = 3;
            }

            for (int i = 4; i <= n; i += 2) {
                dp[i] = dp[i - 2] * 3;

                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }

            System.out.println(dp[n]);
        }
    }
}
