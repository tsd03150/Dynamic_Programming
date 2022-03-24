package com.boj_9461;

import java.util.Scanner;

class Main {
    static long[] dp;

    public long DFS(int v) {
        if (dp[v] > 0) {
            return dp[v];
        }
        if (v == 0) {
            return 0;
        }
        if (v == 1 || v == 2) {
            return 1;
        }

        return dp[v] = DFS(v - 3) + DFS(v - 2);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-- > 0) {
            int n = kb.nextInt();
            dp = new long[n + 1];
            answer.append(T.DFS(n) + "\n");
        }
        System.out.println(answer);
    }
}