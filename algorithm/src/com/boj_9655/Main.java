package com.boj_9655;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        if (n % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
