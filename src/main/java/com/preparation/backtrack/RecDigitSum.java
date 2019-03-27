package com.preparation.backtrack;

import java.util.Scanner;

public class RecDigitSum {


    public static Long sumDigit(Long n) {
        Long sum = Long.valueOf(0);
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int k = scanner.nextInt();
        char[] ca = n.toCharArray();
        Long sum = Long.valueOf(0);
        for (Character character : ca) {
            sum +=  character - 48;
        }
        sum = sum * k;
        while (sum > 10) {
            sum = sumDigit(sum);
        }
        System.out.println(sum.intValue());
    }
}
