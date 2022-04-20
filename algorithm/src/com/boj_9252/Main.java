package com.boj_9252;

import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        char[] a = kb.next().toCharArray();
        char[] b = kb.next().toCharArray();
        int n1 = a.length;
        int n2 = b.length;

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        answer.append(dp[n1][n2] + "\n");

        Stack<Character> stack = new Stack();
        while (n1 > 0 && n2 > 0) {
            if (dp[n1][n2] == dp[n1 - 1][n2]) {
                n1--;
            } else if (dp[n1][n2] == dp[n1][n2 - 1]) {
                n2--;
            } else {
                stack.push(a[n1 - 1]);
                n1--;
                n2--;
            }
        }

        while (!stack.empty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }
}