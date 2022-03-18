package com.boj_1912;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = kb.nextInt();
        }

        int max = board[0];
        for (int i = 1; i < n; i++) {
            board[i] = Math.max(board[i], board[i - 1] + board[i]);
            max = Math.max(max, board[i]);
        }
        System.out.println(max);
    }
}
