package com.boj_9095;

import java.util.Scanner;

class Main {
    static int[] dp;

    public int DFS(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }

        if (n == 1) {
            return dp[1] = 1;
        }
        if (n == 2) {
            return dp[2] = 2;
        }
        if (n == 3) {
            return dp[3] = 4;
        }

        return dp[n] = DFS(n - 1) + DFS(n - 2) + DFS(n - 3);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-- > 0) {
            int n = kb.nextInt();
            dp = new int[n + 1];
            answer.append(T.DFS(n) + "\n");
        }
        System.out.println(answer);
    }
}
