package leetHard;

import java.util.*;

public class SpellChecker {

    Node rootNode;

    class Node {
        char ch;
        Node[] children;
        boolean isEOW;

        Node() {
            children = new Node[256];
            for (int i = 0; i < 256; i++)
                children[i] = null;
            isEOW = false;
        }
    }

    void createTrie(String word) {
        if (rootNode == null)
            rootNode = new Node();
        Node currNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                currNode.children[ch - 'a'] = new Node();
                currNode = currNode.children[ch - 'a'];
            } else {
                currNode.children[ch - 'A'] = new Node();
                currNode = currNode.children[ch - 'A'];
            }
        }
        currNode.isEOW = true;
    }

    char checkCapitalizationMatch(char ch, Node node) {
        Node smallNode = null;
        Node capitalNode = null;
        if (ch >= 'a' && ch <= 'z') {
            smallNode = node.children[ch - 'a'];
            capitalNode = node.children[ch - 32 - 'A'];
            if (smallNode != null)
                return (char) (ch - 'a');
            else if (capitalNode != null) return (char) (ch - 32 - 'A');
            else return '\0';
        } else {
            smallNode = node.children[ch + 32 - 'a'];
            capitalNode = node.children[ch - 'A'];
            if (smallNode != null)
                return (char) (ch + 32 - 'a');
            else if (capitalNode != null) return (char) (ch - 'A');
            else return '\0';
        }
    }

    char checkVowel(char ch, Node node) {
        if (ch >= 'a' && ch <= 'z') {
            if (node.children[ch] != null) return ch;
            else if (node.children[ch - 32] != null) return (char) (ch - 32);
        } else {
            if (node.children[ch] != null) return ch;
            else if (node.children[ch + 32] != null) return (char) (ch + 32);
        }
        return '\0';
    }

    String findAndReturn(String str) {
        Node currNode = rootNode;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (checkCapitalizationMatch(ch, currNode) != '\0') {
                char cc = checkCapitalizationMatch(ch, currNode);
                sb.append(cc);
                if (cc >= 'a' && cc <= 'z')
                    currNode = currNode.children[cc - 'a'];
                else
                    currNode = currNode.children[cc - 'A'];
            } else if (checkVowel(ch, currNode) != '\0') {
                char cc = checkVowel(ch, currNode);
                sb.append(cc);
                if (cc >= 'a' && cc <= 'z')
                    currNode = currNode.children[cc - 'a'];
                else
                    currNode = currNode.children[cc - 'A'];
            } else return "";

        }
        if (currNode.isEOW)
            return sb.toString();
        else return "";
    }


    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> consonant = new HashMap<>();

        for (String str : wordlist) {
            exact.add(str);
            caseInsensitive.putIfAbsent(str.toLowerCase(), str);
            consonant.putIfAbsent(delVowel(str.toLowerCase()), str);
        }

        int i = 0;
        for (String str : queries) {
            if (exact.contains(str))
                result[i++] = str;
            else if (caseInsensitive.containsKey(str.toLowerCase()))
                result[i++] = caseInsensitive.get(str.toLowerCase());
            else if (consonant.containsKey(delVowel(str.toLowerCase())))
                result[i++] = consonant.get(delVowel(str.toLowerCase()));
            else result[i++] = "";
        }
        return result;

    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        return false;
    }

    public String delVowel(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(isVowel(str.charAt(i)) ? '*' : str.charAt(i));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();
        //   spellChecker.createTrie("yellow");
        System.out.println(Arrays.toString(spellChecker.spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"}, new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"})));
    }
}
