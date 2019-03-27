package com.preparation.graph;

import java.util.LinkedList;

public class DFS {

    int V;
    LinkedList<Integer> nodes[];

    boolean visited[];

    DFS(int v) {
        V = v;
        nodes = new LinkedList[4];
        visited = new boolean[V];
        for (int i = 0; i < v; i++) {
            nodes[i] = new LinkedList<>();
            visited[i] = false;
        }
    }

    public void addEdge(int u, int v) {
        nodes[u].add(v);
    }

    public void recur(int u) {

        if (visited[u] == true)
            return;

        visited[u] = true;
        System.out.print(u + " -> ");

        for (Integer v : nodes[u])
            recur(v);

    }


    public static void main(String[] args) {

        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);

        g.recur(0);
    }


}
