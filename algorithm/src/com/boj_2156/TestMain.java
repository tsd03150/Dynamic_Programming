package com.boj_2156;

import java.util.ArrayList;
import java.util.Scanner;


class Problem {
    int ps; // 점수
    int pt; // 시간

    Problem(int ps, int pt) {
        this.ps = ps;
        this.pt = pt;
    }
}

class TestMain {
    static int n;
    static int m;
    static ArrayList<Problem> arr;

    public int solution() {
        int[] dy = new int[m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= arr.get(i).pt; j--) {

                dy[j] = Math.max(dy[j], dy[j - arr.get(i).pt] + arr.get(i).ps);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) {
        TestMain T = new TestMain();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();

            arr.add(new Problem(a, b));
        }

        System.out.println(T.solution());
    }

}


