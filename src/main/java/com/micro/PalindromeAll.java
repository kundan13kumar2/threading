package com.micro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PalindromeAll {

    Set<String> orderSet = new HashSet<>();

    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public void recur(String str, char oddChar, int l, int r) {
        if (l == r) {
            orderSet.add(str + oddChar + new StringBuilder(str).reverse().toString());
            return;
        }
        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            recur(str, oddChar, l + 1, r);
            str = swap(str, l, i);
        }
    }

    public static void main(String[] args) {
        PalindromeAll palindromeAll = new PalindromeAll();
        String string = "aabbadad";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            int val = map.getOrDefault(string.charAt(i), 0);
            map.put(string.charAt(i), val + 1);
        }
        int oddCharCounter = 0;
        Character oddChar = '\0';
        for (Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() % 2 == 1) {
                oddCharCounter++;
                oddChar = mapEntry.getKey();
            }
        }
        if (oddCharCounter > 1) {
            System.out.println("Not Possible");
            return;
        }
        String tempString = "";
        for (Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
            for (int i = 1; i <= mapEntry.getValue() / 2; i++)
                tempString += mapEntry.getKey();
        }
        palindromeAll.recur(tempString, oddChar, 0, tempString.length() - 1);
        System.out.println(palindromeAll.orderSet);
    }

}
