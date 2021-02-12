package com.micro;

import java.util.Arrays;

public class LongSubKUnique {

    public static boolean isValid(int[] count, int k) {
        int val = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0)
                val++;
        }
        return k >= val;
    }

    public static void main(String[] args) {
        String str = "aabbcc";
        int k = 2;
        int[] count = new int[26];
        int u = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'a'] == 0) {
                u++;
            }
            count[str.charAt(i) - 'a']++;
        }
        if (u < k) {
            System.out.println("No Possible");
            return;
        }
        int start = 0;
        int end = 0;
        Arrays.fill(count, 0);
        count[str.charAt(0) - 'a']++;
        int maxStart = 0;
        int maxLength = 0;
        for (int i = 1; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
            end++;
            while (!isValid(count, k)) {
                count[str.charAt(start) - 'a']--;
                start++;
            }

            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }
        System.out.println(str.substring(maxStart, maxLength));

    }
}
