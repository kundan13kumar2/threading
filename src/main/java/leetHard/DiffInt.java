package leetHard;

import java.util.*;

public class DiffInt {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                char lastChar = '\0';
                if (sb.length() == 1)
                    lastChar = sb.charAt(0);
                if (lastChar == '0')
                    sb = new StringBuilder();
                sb.append(ch);
            } else if (sb.length() != 0) {
                set.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() != 0)
            set.add(sb.toString());

        return set.size();
    }

    public String evaluate(String s, List<List<String>> knowledge) {

        StringBuilder result = new StringBuilder();

        Map<String, String> dictionary = new HashMap<>();
        for (List<String> stringList : knowledge)
            dictionary.put(stringList.get(0), stringList.get(1));

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                flag = true;
                continue;
            } else if (ch == ')') {
                if (sb.length() > 0 && dictionary.containsKey(sb.toString()))
                    result.append(dictionary.get(sb.toString()));
                else result.append("?");
                sb = new StringBuilder();
                flag = false;
            } else if (!flag) result.append(ch);
            if (flag) sb.append(ch);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        DiffInt diffInt = new DiffInt();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");

        List<String> l2 = new ArrayList<>();
        l2.add("b");
        l2.add("a");

        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);


        //System.out.println(diffInt.numDifferentIntegers("101a02bb000"));

        System.out.println(diffInt.evaluate("(a)(b)", list));
    }
}
