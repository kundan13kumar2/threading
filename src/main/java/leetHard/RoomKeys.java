package leetHard;

import java.util.*;

public class RoomKeys {

    boolean[] visited;
    int n;

    void recur(int u, Map<Integer, List<Integer>> graph) {
        if (!visited[u])
            visited[u] = true;
        else return;

        List<Integer> adjNode = graph.get(u);
        if (adjNode != null) {
            for (Integer v : adjNode) {
                if (!visited[v])
                    recur(v, graph);
            }
        }
    }

    int numberOfIsland(Map<Integer, List<Integer>> graph) {
        visited = new boolean[n];
        Arrays.fill(visited, false);
        int counter = 0;
        for (Map.Entry<Integer, List<Integer>> nodes : graph.entrySet()) {
            int u = nodes.getKey();
            if (!visited[u]) {
                recur(u, graph);
                counter++;
            }
        }
        return counter;
    }

    Map<Integer, List<Integer>> createGraph(List<List<Integer>> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> nodes = edges.get(i);
            set.add(i);
            set.addAll(nodes);
            graph.put(i, nodes);
        }
        n = set.size();
        return graph;
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(0);
        l2.add(1);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);

        List<Integer> l4 = new ArrayList<>();
        l4.add(0);

        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        RoomKeys roomKeys = new RoomKeys();

        Map<Integer, List<Integer>> graph = roomKeys.createGraph(lists);
        int counter = roomKeys.numberOfIsland(graph);
        System.out.println(counter);
    }
}
