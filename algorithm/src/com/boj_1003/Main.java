package com.boj_1003;

import java.util.Scanner;

class Main {
    static int[] dp;

    public int DFS(int v) {
        if (dp[v] > 0) {
            return dp[v];
        }

        if (v == 0) {
            return 0;
        }

        if (v == 1) {
            return 1;
        }

        return dp[v] = DFS(v - 2) + DFS(v - 1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-- > 0) {
            int n = kb.nextInt();
            dp = new int[n + 1];
            int a = 0;
            int b = 0;

            if (n == 0) {
                a = 1;
            } else if (n == 1) {
                b = 1;
            } else {
                a = T.DFS(n - 1);
                b = T.DFS(n);
            }
            answer.append(a + " " + b + "\n");
        }

        System.out.println(answer);
    }

}
