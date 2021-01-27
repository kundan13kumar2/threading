package leetHard;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class AlienDictionary {

    Map<Character, List<Character>> graph = new HashMap<>();
    boolean[] visited = new boolean[26];
    Set<Character> charAvailable = new HashSet<>();
    Stack<Character> stack = new Stack<>();


    public void createGraph(Character u, Character v) {
        List<Character> tempList = graph.getOrDefault(u, new ArrayList<>());
        tempList.add(v);
        graph.put(u, tempList);
        charAvailable.add(u);
    }

    public void dfs(Character u) {
        visited[u - 'a'] = true;
        List<Character> tempList = graph.get(u);
        if (tempList != null) {
            for (Character ch : tempList) {
                if (!visited[ch - 'a'])
                    dfs(ch);
            }
        }
        stack.push(u);

    }

    public void topologicalSort() {
        for (Character character : charAvailable) {
            if (!visited[character - 'a'])
                dfs(character);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void alienLang(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            String word1 = strings[i];
            String word2 = strings[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    createGraph(word1.charAt(j), word2.charAt(j));
                    break;
                }
            }
        }
        topologicalSort();
    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        AlienDictionary alienDictionary = new AlienDictionary();
        alienDictionary.alienLang(words);
    }


}
