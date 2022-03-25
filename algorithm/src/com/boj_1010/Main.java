package com.boj_1010;

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

        return dp[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-- > 0) {
            int n = kb.nextInt();
            int m = kb.nextInt();
            dp = new int[m + 1][m + 1];
            answer.append(T.DFS(m, n) + "\n");
        }

        System.out.println(answer);
    }
}
