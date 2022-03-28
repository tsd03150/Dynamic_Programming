package com.boj_9251;

import java.util.Scanner;

class Main {
    static Integer[][] dp;
    static char[] a;
    static char[] b;

    public int DFS(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (a[x] == b[y]) {
                dp[x][y] = DFS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(DFS(x - 1, y), DFS(x, y - 1));
            }
        }

        return dp[x][y];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        a = kb.next().toCharArray();
        b = kb.next().toCharArray();
        dp = new Integer[a.length][b.length];

        System.out.println(T.DFS(a.length - 1, b.length - 1));
    }
}
