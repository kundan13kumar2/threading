/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.*;

/**
 * @author Kundan Kumar
 * @version $Id: DesignNestedStructure.java, v 0.1 2020-07-07 7:01 PM Kundan Kumar Exp $$
 */


class TrieNode
{
    // each node stores a map to its child nodes
    Map<Character, TrieNode> map = new HashMap<>();

    // true when node is a leaf node
    boolean isLeaf = false;

    // collection to store complete list of words in the leaf node
    Set<String> word = new HashSet<>();
};
public class DesignNestedStructure {

    // Function to insert a String in trie
    public static TrieNode insert(TrieNode head, String word)
    {
        if (head == null) {
            head = new TrieNode();
        }

        // start from head node
        TrieNode curr = head;
        for (char c: word.toCharArray())
        {
            // insert only uppercase characters
            if (Character.isUpperCase(c))
            {
                // create a new node if path doesn't exists
                curr.map.putIfAbsent(c, new TrieNode());

                // go to next node
                curr = curr.map.get(c);
            }
        }

        // mark current node as leaf
        curr.isLeaf = true;

        // push current word into the set associated with leaf node
        (curr.word).add(word);

        return head;
    }

    // Function to print all children of given trie node
    public static void printAllWords(TrieNode root)
    {
        // base case
        if (root == null) {
            return;
        }

        // if current node is leaf, print all words associated with it
        if (root.isLeaf) {
            System.out.println(root.word);
        }

        // recur for all children of the root node
        for (Map.Entry<Character,TrieNode> pair: root.map.entrySet())
        {
            TrieNode child = pair.getValue();
            printAllWords(child);
        }
    }

    // Function to print all words in the CamelCase dictionary which
    // matches with the given pattern
    public static void findAllWords(List<String> dictionary, String pattern)
    {
        // Trie head node
        TrieNode head = null;

        // construct trie from the given dictionary
        for (String s: dictionary) {
            head = insert(head, s);
        }

        // search for the given pattern in trie
        TrieNode curr = head;
        for (char c: pattern.toCharArray())
        {
            // move to the child node
            curr = curr.map.get(c);

            // if the given pattern is not found (reached end of path in trie)
            if (curr == null) {
                return;
            }
        }

        // print all words matching given pattern
        printAllWords(curr);
    }

    public static void main(String[] args)
    {
        List<String> dictionary = null;
        dictionary = Arrays.asList("Hi", "HiTech","HiTechCity");

        String pattern = "HT";
        findAllWords(dictionary, pattern);
    }
}