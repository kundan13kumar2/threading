package com.preparation;

import java.util.Scanner;
import java.util.Stack;

public class CHEFCH {


    public static int count(String str) {

        char[] charArray = str.toCharArray();

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (Character ch : charArray) {


            if (ch == '-' && !st1.empty() && st1.peek() == '+')
                st1.pop();
            else
                st1.push(ch);


            if (ch == '+' && !st2.empty() && st2.peek() == '-')
                st2.pop();
            else
                st2.push(ch);

        }

        int ap = 0, am = 0, bp = 0, bm = 0;

        while (!st1.empty()) {
            if (st1.peek() == '+')
                ap++;
            else
                am++;
            st1.pop();
        }

        while (!st2.empty()) {
            if (st2.peek() == '+')
                bp++;
            else
                bm++;
            st2.pop();
        }

        return Math.max(ap / 2 + am / 2, bp / 2 + bm / 2);
    }


    public static int otherCounter(String str) {
        int plus = 0, minus = 0;


        char[] charArray = str.toCharArray();
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {

            char ch = charArray[i];
            if (i % 2 == 0)
                result = ch == '-' ? ++minus : ++plus;
            else
                result = ch == '-' ? ++plus : ++minus;
        }

        return Math.min(plus, minus);

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.next());

        while (t > 0) {
            String string = scanner.next();
            System.out.println(otherCounter(string));
            t--;
        }

    }

}
