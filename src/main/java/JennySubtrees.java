import java.util.*;

public class JennySubtrees {
    static void dfs(Map<Integer, List<Integer>> graph, int u, List<Integer> list, int r, boolean[] visited) {
        visited[u] = true;
        list.add(u);
        if (list.size() == r) return;
        List<Integer> adjacentNode = graph.get(u);

        for (Integer node : adjacentNode) {
            if (!visited[node])
                dfs(graph, node, list, r, visited);
        }
    }

    static Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];

            List<Integer> l1 = graph.getOrDefault(n1, new ArrayList<>());
            l1.add(n2);
            graph.put(n1, l1);

            List<Integer> l2 = graph.getOrDefault(n2, new ArrayList<>());
            l2.add(n1);
            graph.put(n2, l2);
        }

        return graph;
    }

    static int jennysSubtrees(int n, int r, int[][] edges) {
        /*
         * Write your code here.
         */
        Map<Integer, List<Integer>> graph = createGraph(edges);
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[30001];
        List<Integer> list = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>(graph.keySet());
        for (Integer node : nodes) {
            list = new ArrayList<>();
            Arrays.fill(visited, false);
            dfs(graph, node, list, r+1, visited);
            set.add(list.size());
        }
        return set.size();
    }


    public static void main(String[] args) {
        int[][] edges = {{1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {2, 6},
                {2, 7}};
        System.out.println(jennysSubtrees(7, 1, edges));
    }
}
