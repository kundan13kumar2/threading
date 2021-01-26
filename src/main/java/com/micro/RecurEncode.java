package com.micro;

import java.util.Stack;

public class RecurEncode {

    static void encodeString(String str) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int i = 0;
        while (true) {
            Character ch = '\0';
            while (true) {
                ch = str.charAt(i++);
                if (ch == '[') continue;
                if (ch == ']') break;
                stack1.push(ch);
            }
            ch = stack1.pop();
            while (!(ch >= '0' && ch <= '9')) {
                stack2.push(ch);
                ch = stack1.pop();
            }
            String s = "";
            while (!stack2.isEmpty()) {
                s += stack2.pop();
            }
            int j = 0;
            StringBuilder sb = new StringBuilder("");
            while (j < (ch - '0')) {
                sb.append(s);
                j++;
            }
            if (stack1.isEmpty()) {
                System.out.println(sb.toString());
                return;
            }
            for (int k = 0; k < sb.length(); k++) {
                stack1.push(sb.charAt(k));
            }

        }

    }

    public static void main(String[] args) {
        String str = "3[b2[ca]3[d]]";
        encodeString(str);
    }
}
