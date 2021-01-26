package com.micro;


public class MultiplyNumStr {

    public static void main(String[] args) {

        //Numbers are here after reversing the actual number 484 and 63
        StringBuilder str1 = new StringBuilder("284");
        StringBuilder str2 = new StringBuilder("36");

        int[] res = new int[str1.length() + str2.length()];

        for (int index = 0; index < str1.length(); index++) {
            int num = str1.charAt(index) - '0';
            int carry = 0;
            int t = index;
            for (int k = 0; k < str2.length(); k++) {
                int val = (num * (str2.charAt(k) - '0')) + carry + res[t];
                int rem = val % 10;
                carry = val / 10;
                res[t] = rem;
                t++;
            }
            res[t] = carry;
        }
        int t;
        for (t = (res.length - 1); t >= 0; t--) {
            if (res[t] != 0)
                break;
        }
        StringBuilder s = new StringBuilder();
        while (t >= 0) {
            s.append(res[t--]);
        }

        System.out.println(s);
    }
}
