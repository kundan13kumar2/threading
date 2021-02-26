package leetHard;

import java.util.*;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {

        String curr = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() + curr.length() <= maxWidth)
                curr += words[i] + " ";
            else {
                curr = curr.substring(0, curr.length() - 1);
                int currLength = curr.length();
                int rem = maxWidth - currLength;
                if (rem == 0)
                    list.add(curr);
                else {
                    String[] arr = curr.split("\\s");
                    int n = arr.length;
                    int uniSpace = 0;
                    int p = 0;
                    if (n > 1) {
                        uniSpace = rem / (n - 1);
                        p = rem % (n - 1);
                    } else uniSpace = maxWidth - currLength;
                    String s = new String("");
                    int t = 0;
                    int j = 0;
                    if (uniSpace == 0) {
                        for (; j < arr.length - 1; j++) {
                            if (t == rem) break;
                            s += arr[j] + "  ";
                            t++;
                        }
                    } else {
                        for (; j < arr.length - 1; j++) {
                            s += arr[j] + " ";
                            for (int k = 0; k < uniSpace; k++) {
                                s += " ";
                                if (p > 0) {
                                    s += " ";
                                    p--;
                                }
                            }
                        }
                    }
                    for (; j < arr.length - 1; j++)
                        s += arr[j] + " ";
                    s += arr[arr.length - 1];
                    if (arr.length == 1) {
                        for (int k = 0; k < uniSpace; k++)
                            s += " ";
                    }
                    list.add(s);
                }
                curr = words[i] + " ";

            }
        }
        if (curr.length() - 1 == maxWidth)
            list.add(curr.substring(0, curr.length() - 1));
        else {
            int rem = maxWidth - curr.length();
            for (int k = 0; k < rem; k++)
                curr += " ";
            list.add(curr);
        }
        return list;
    }

    public String reorderSpaces(String text) {

        int counter = 0;
        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) == ' ')
                counter++;
        String[] arr = text.trim().split("\\s+");
        int n = arr.length;
        if (n == 1) {
            String res = arr[0];
            for (int j = 0; j < counter; j++)
                res += " ";
            return res;
        } else {
            int spaces = counter / (n - 1);
            int extra = counter % (n - 1);
            String res = "";
            for (int i = 0; i < arr.length - 1; i++) {
                res += arr[i];
                for (int j = 0; j < spaces; j++)
                    res += " ";
            }
            res += arr[arr.length - 1];
            for (int j = 0; j < extra; j++)
                res += " ";
            return res;
        }

    }

    class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : arr) {
            int val = map.getOrDefault(k, 0);
            map.put(k, val + 1);
        }

        if (map.size() == 1) return 1;

        List<Pair> pairList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            pairList.add(new Pair(entry.getKey(), entry.getValue()));

        Collections.sort(pairList, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.freq - p2.freq;
            }
        });

        int j = pairList.size() - 1;
        int req = arr.length / 2;
        int res = 0;
        int tillSum = 0;
        while (j >= 0) {
            tillSum += pairList.get(j).freq;
            res++;
            if (tillSum >= req)
                return res;
            j--;

        }
        return res;
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        //String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        // String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        //String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        //String[] words = {"The", "important", "thing", "is", "not", "to", "stop", "questioning.", "Curiosity", "has", "its", "own", "reason", "for", "existing."};
        String[] words = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};

        int maxWidth = 16;
        //  System.out.println(textJustification.fullJustify(words, maxWidth));
        String str = "  this   is  a sentence ";
     //   System.out.println(textJustification.reorderSpaces(str));

        int[] arr = {9, 77, 63, 22, 92, 9, 14, 54, 8, 38, 18, 19, 38, 68, 58, 19};
        System.out.println(textJustification.minSetSize(arr));
    }


}
