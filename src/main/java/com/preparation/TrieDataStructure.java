package com.preparation;

public class TrieDataStructure {


    public static class Node {
        Node[] children = new Node[26];
        boolean isEOW;

        public Node() {
            isEOW = false;
            for (int i = 0; i < 26; i++)
                this.children[i] = null;
        }
    }

    public static Node root;

    public static void insert(String str) {

        char charArr[] = str.toCharArray();

        Node node = root;

        for (char ch : charArr) {

            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new Node();

            node = node.children[ch - 'a'];

        }

        node.isEOW = true;

    }

    public static boolean search(String str) {

        char[] charArray = str.toCharArray();

        Node node = root;
        for (char ch : charArray) {

            if (node.children[ch - 'a'] == null)
                return false;

            node = node.children[ch - 'a'];

        }
        if (node.isEOW)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        root = new Node();

        insert("apple");
        insert("apps");
        insert("apes");
        insert("ball");

        System.out.println(search("apes"));
        System.out.println(search("apps"));
        System.out.println(search("apple"));

    }

}
