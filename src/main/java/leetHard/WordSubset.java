package leetHard;

import java.util.*;

public class WordSubset {

    public boolean isSubset(int[] temp, int[] bFreq) {

        for (int i = 0; i < 26; i++)
            if (temp[i] < bFreq[i]) return false;
        return true;
    }

    public List<String> wordSubsets(String[] A, String[] B) {

        List<String> result = new ArrayList<>();

        int[] bFreq = new int[26];
        for (String str : B) {
            int[] temp = new int[26];
            for (char ch : str.toCharArray()) {
                temp[ch - 'a']++;
                bFreq[ch - 'a'] = Math.max(bFreq[ch - 'a'], temp[ch - 'a']);
            }
        }

        for (String str : A) {
            int[] temp = new int[26];
            for (char ch : str.toCharArray())
                temp[ch - 'a']++;
            if (isSubset(temp, bFreq))
                result.add(str);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"e","oo"};

        WordSubset ws = new WordSubset();
        System.out.println(ws.wordSubsets(A, B));

    }
}
