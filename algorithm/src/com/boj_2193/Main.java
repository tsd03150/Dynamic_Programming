package com.boj_2193;

import java.util.Scanner;

class Main {
    static long[] dp;
    public long DFS(int v) {
        if (dp[v] > 0) {
            return dp[v];
        }

        if (v == 1 || v == 2) {
            return 1;
        }

        return dp[v] = DFS(v - 1) + DFS(v - 2);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dp = new long[n + 1];
        System.out.println(T.DFS(n));
    }
}