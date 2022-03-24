package com.boj_11727;

import java.util.Scanner;

class Main {
    static long[] dp;

    public long DFS(int v) {
        if (dp[v] > 0) {
            return dp[v] % 10007;
        }

        if (v == 1) {
            return 1;
        }
        if (v == 2) {
            return 3;
        }

        return dp[v] = DFS(v - 1) + (2 * DFS(v - 2));
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dp = new long[n + 1];
        long answer = T.DFS(n);
        System.out.println(answer % 10007);
    }
}
