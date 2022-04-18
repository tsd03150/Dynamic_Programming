package com.boj_10942;

import java.util.Scanner;

class Main {
    static int[][] dp;

    public void solution(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = kb.nextInt();
        }

        T.solution(arr, n);
        int m = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (m-- > 0) {
            int s = kb.nextInt();
            int e = kb.nextInt();

            if (dp[s][e] == 1) {
                answer.append(1 + "\n");
            } else {
                answer.append(0 + "\n");
            }
        }
        System.out.println(answer);
    }
}