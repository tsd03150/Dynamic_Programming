package com.boj_17070;

import java.util.Scanner;

class Main {
    static int n;
    static int[][] board;
    static int answer = 0;

    public void DFS(int x, int y, int dir) {
        if (x == n - 1 && y == n - 1 && board[x][y] == 0) {
            answer++;
            return;
        }

        // 오른쪽
        if (dir == 0) {
            // 오른쪽 -> 오른쪽
            if (y + 1 < n && board[x][y + 1] == 0) {
                DFS(x, y + 1, 0);
            }
            // 오른쪽 -> 대가선
            if (x + 1 < n && y + 1 < n && board[x][y + 1] == 0 && board[x + 1][y] == 0 && board[x + 1][y + 1] == 0) {
                DFS(x + 1, y + 1, 2);
            }
        }

        // 아래
        if (dir == 1) {
            // 아래 -> 아래
            if (x + 1 < n && board[x + 1][y] == 0) {
                DFS(x + 1, y, 1);
            }
            // 아래 -> 대가선
            if (x + 1 < n && y + 1 < n && board[x][y + 1] == 0 && board[x + 1][y] == 0 && board[x + 1][y + 1] == 0) {
                DFS(x + 1, y + 1, 2);
            }
        }

        // 대각선
        if (dir == 2) {
            // 대각선 -> 오른쪽
            if (y + 1 < n && board[x][y + 1] == 0) {
                DFS(x, y + 1, 0);
            }
            // 대각선 -> 아래
            if (x + 1 < n && board[x + 1][y] == 0) {
                DFS(x + 1, y, 1);
            }
            // 대각선 -> 대각선
            if (x + 1 < n && y + 1 < n && board[x][y + 1] == 0 && board[x + 1][y] == 0 && board[x + 1][y + 1] == 0) {
                DFS(x + 1, y + 1, 2);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        T.DFS(0, 1, 0);
        System.out.println(answer);
    }
}