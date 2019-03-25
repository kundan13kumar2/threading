package com.preparation;

import java.util.Stack;

public class WaysToBalanceParanthesis {


    public static int count(String str) {

        Stack<Character> stringStack = new Stack<>();

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == '}' && !stringStack.empty() && stringStack.peek() == '{') {
                stringStack.pop();
            } else
                stringStack.push(charArray[i]);
        }

        int counter1 = 0, counter2 = 0;

        while (!stringStack.empty()) {
            if (stringStack.peek() == '{')
                counter1++;
            else
                counter2++;

            stringStack.pop();
        }


        return Math.getExponent(Math.ceil(counter1 / 2.0) + Math.ceil(counter2 / 2.0));
    }


    public static void main(String[] args) {


        System.out.println(count("{{{{"));
    }


}
