package com.boj_1005;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int n;
    static int[] arr;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> outDegree;
    static int w;
    static int[] dp;

    public void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                Q.add(i);
                dp[i] = arr[i];
            }
        }

        while (!Q.isEmpty()) {
            int now = Q.poll();
            if (now == w) {
                return;
            }

            for (int i = 0; i < outDegree.get(now).size(); i++) {
                int next = outDegree.get(now).get(i);
                dp[next] = Math.max(dp[next], dp[now] + arr[next]);

                inDegree[next]--;
                if (inDegree[next] == 0) {
                    Q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        StringBuilder answer = new StringBuilder();

        while (t-- > 0) {
            n = kb.nextInt();
            int k = kb.nextInt();

            arr = new int[n + 1];
            inDegree = new int[n + 1];

            outDegree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                outDegree.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                arr[i] = kb.nextInt();
            }

            for (int i = 0; i < k; i++) {
                int a = kb.nextInt();
                int b = kb.nextInt();
                outDegree.get(a).add(b);
                inDegree[b]++;
            }

            w = kb.nextInt();
            dp = new int[n + 1];
            T.BFS();
            answer.append(dp[w] + "\n");
        }
        System.out.println(answer);
    }
}