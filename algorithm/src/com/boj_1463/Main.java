package com.boj_1463;

import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[n] = 0;

        int[] nums = {3, 2};

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (i % nums[j] == 0) {
                    dp[i / nums[j]] = Math.min(dp[i / nums[j]], dp[i] + 1);
                }
            }
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }

        System.out.println(dp[1]);
    }
}
