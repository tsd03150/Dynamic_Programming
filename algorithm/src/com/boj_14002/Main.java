package com.boj_14002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                idx = i;
            }
        }
        System.out.println(max);

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[idx]);
        for (int i = idx - 1; i >= 0; i--) {
            if (dp[i] == max - 1 && arr[i] < arr[idx]) {
                max--;
                answer.add(arr[i]);
                idx = i;
            }
        }

        Collections.sort(answer);
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}