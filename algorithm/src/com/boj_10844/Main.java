package com.boj_10844;

import java.util.Scanner;

class Main {
    static long[][] dp;
    static final Long div = 1000000000L;

    public long DFS(int L, int v) {
        if (dp[L][v] > 0) {
            return dp[L][v] % div;
        }

        if (L == 1) {
            return dp[L][v];
        }

        if (v == 0) {
            return dp[L][v] = DFS(L - 1, v + 1);
        } else if (v == 9) {
            return dp[L][v] = DFS(L - 1, v - 1);
        } else {
            return dp[L][v] = DFS(L - 1, v - 1) + DFS(L - 1, v + 1);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dp = new long[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result += T.DFS(n, i);
        }

        System.out.println(result % div);
    }
}