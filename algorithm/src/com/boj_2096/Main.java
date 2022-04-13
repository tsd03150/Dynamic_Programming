package com.boj_2096;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        for (int i = 0; i < n; i++) {
            int x1 = kb.nextInt();
            int x2 = kb.nextInt();
            int x3 = kb.nextInt();

            if (i == 0) {
                maxDp[0] = minDp[0] = x1;
                maxDp[1] = minDp[1] = x2;
                maxDp[2] = minDp[2] = x3;
            } else {
                int preMaxDp_0 = maxDp[0];
                int preMaxDp_2 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + x1;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + x3;
                maxDp[1] = Math.max(Math.max(preMaxDp_0, maxDp[1]), preMaxDp_2) + x2;

                int preMinDp_0 = minDp[0];
                int preMinDp_2 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + x1;
                minDp[2] = Math.min(minDp[1], minDp[2]) + x3;
                minDp[1] = Math.min(Math.min(preMinDp_0, minDp[1]), preMinDp_2) + x2;
            }
        }

        System.out.print(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " ");
        System.out.println(Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
    }
}