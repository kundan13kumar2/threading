package leetHard;


import java.util.*;

public class CourseSchedule2 {

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Set<Integer> availableNum = new HashSet<>();
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited;
    static boolean[] recPath;
    static List<Integer> res = new ArrayList<>();


    public static boolean isCycleUtil(int u) {
        if (recPath[u])
            return true;
        if (visited[u])
            return false;
        recPath[u] = true;
        visited[u] = true;
        List<Integer> temp = graph.get(u);
        if (temp != null) {
            for (int k : temp)
                if (isCycleUtil(k))
                    return true;
        }
        recPath[u] = false;
        return false;
    }

    public static boolean isCycle() {
        for (Integer k : availableNum)
            if (isCycleUtil(k))
                return true;
        return false;
    }

    public static void createGraph(int u, int v) {
        List<Integer> list = graph.getOrDefault(u, new ArrayList<>());
        list.add(v);
        graph.put(u, list);
        availableNum.add(u);
        availableNum.add(v);
    }

    public static void dfs(int u) {
        visited[u] = true;
        List<Integer> list = graph.get(u);
        if (list != null) {
            for (Integer v : list) {
                if (!visited[v])
                    dfs(v);
            }
        }
        stack.push(u);

    }

    public static void topologicalSort() {
        for (Integer u : availableNum) {
            if (!visited[u])
                dfs(u);
        }
        while (!stack.isEmpty())
            res.add(stack.pop());

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        recPath = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++)
            createGraph(prerequisites[i][0], prerequisites[i][1]);
        if (isCycle()) {
            return new int[0];
        }

        visited = new boolean[numCourses];

        topologicalSort();
        if (res.size() < numCourses) {
            int p = res.size();
            for (int i = 0; i < numCourses; i++)
                if (!availableNum.contains(i))
                    res.add(i);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{3, 0},{0,1}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));


    }
}
