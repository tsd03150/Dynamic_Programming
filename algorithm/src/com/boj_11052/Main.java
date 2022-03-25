package com.boj_11052;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] money = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            money[i] = kb.nextInt();
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + money[i]);
            }
        }

        System.out.println(dp[n]);
    }
}