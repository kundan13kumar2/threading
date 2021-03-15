package com.adobePrep;

import java.util.StringTokenizer;

public class StringTokenTest {
    public static void main(String[] args) {
        String str = "I,am,a,boy,";

        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        System.out.println(tokenizer.countTokens());

    }
}
