package com.boj_11726;

import java.util.Scanner;

class Main {
    static long[] dp;

    public long DFS(int v) {
        if (dp[v] > 0) {
            return dp[v];
        }

        if (v == 1) {
            return dp[1] = 1;
        }

        if (v == 2) {
            return dp[2] = 2;
        }

        return dp[v] = (DFS(v - 2) + DFS(v - 1)) % 10007;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dp = new long[n + 1];
        T.DFS(n);
        System.out.println(dp[n]);
    }
}
