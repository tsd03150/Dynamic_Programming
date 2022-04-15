package com.boj_2407;

import java.math.BigInteger;
import java.util.Scanner;

class Main {

    static BigInteger[][] dp;

    public void DFS(int n, int r) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = new BigInteger("1");
                } else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        dp = new BigInteger[1001][1001];
        T.DFS(n, m);
        System.out.println(dp[n][m]);
    }
}