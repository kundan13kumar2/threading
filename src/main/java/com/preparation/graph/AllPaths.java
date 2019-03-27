package com.preparation.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPaths {

    int V;
    LinkedList<Integer> nodes[];

    AllPaths(int v) {

        V = v;
        ;
        nodes = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            nodes[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        nodes[u].add(v);
    }


    public void recur(int u, int d, List<Integer> paths, boolean visited[]) {

        if (visited[u])
            return;

        visited[u] = true;

        if (u == d) {
            System.out.println(paths);
            visited[u] = false;
            return;
        }


        for (Integer v : nodes[u]) {

            paths.add(v);
            recur(v, d, paths, visited);
            paths.remove(v);

        }

        visited[u] = false;

    }


    public static void main(String[] args) {

        AllPaths g = new AllPaths(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);

        boolean visited[] = new boolean[4];

        List<Integer> paths = new ArrayList<>();
        paths.add(2);
        g.recur(2, 3, paths, visited);
    }

}
