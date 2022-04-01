package com.boj_11051;

import java.util.Scanner;

class Main {
    static int[][] dp;

    public int DFS(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }

        return dp[n][r] = (DFS(n - 1, r - 1) + DFS(n - 1, r)) % 10007;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        dp = new int[n + 1][r + 1];

        System.out.println(T.DFS(n, r));
    }
}
