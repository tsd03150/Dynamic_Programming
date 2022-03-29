package com.boj_12865;

import java.util.ArrayList;
import java.util.Scanner;

class Bag {
    int w;
    int v;

    Bag(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        ArrayList<Bag> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            arr.add(new Bag(a, b));
        }

        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            Bag ob = arr.get(i);
            for (int j = k; j >= ob.w; j--) {
                dp[j] = Math.max(dp[j], dp[j - ob.w] + ob.v);
            }
        }

        System.out.println(dp[k]);
    }
}
