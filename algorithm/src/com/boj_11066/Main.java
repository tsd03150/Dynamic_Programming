package com.boj_11066;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-- > 0) {
            int k = kb.nextInt();
            int[] board = new int[k + 1];
            int[] sum = new int[k + 1];
            int[][] dp = new int[k + 1][k + 1];

            for (int i = 1; i <= k; i++) {
                board[i] = kb.nextInt();
                sum[i] = sum[i - 1] + board[i];
            }

            for (int i = 1; i <= k; i++) {
                for (int s = 1; s + i <= k; s++) {
                    int e = s + i;
                    dp[s][e] = Integer.MAX_VALUE;
                    for (int j = s; j < e; j++) {
                        dp[s][e] = Math.min(dp[s][e], dp[s][j] + dp[j + 1][e] + sum[e] - sum[s - 1]);
                    }
                }
            }
            answer.append(dp[1][k] + "\n");
        }

        System.out.println(answer);
    }
}