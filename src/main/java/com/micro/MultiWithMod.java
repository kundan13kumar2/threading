package com.micro;

public class MultiWithMod {

    //Wrong Implementation
    public static void main(String[] args) {
        int a = 17, b = 14;
        int res = 0;
        while (b > 0) {
            if (b % 2 == 0) {
                res = (2 * a * b / 2) % 6;
                b = b / 2;
            } else {
                res = (a + a * (b - 1)) % 6;
                b--;
            }
        }
        System.out.println(res);
    }
}
