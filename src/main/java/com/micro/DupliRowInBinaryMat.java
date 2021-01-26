package com.micro;

public class DupliRowInBinaryMat {

    class Node {
        Node[] children = new Node[2];
        boolean isLeaf;
    }

    Node getNewTrie() {
        Node node = new Node();
        node.children[0] = null;
        node.children[1] = null;
        node.isLeaf = false;
        return node;
    }


    boolean insert(int[] arr, Node head) {
        Node curr = head;

        for (int i = 0; i < arr.length; i++) {
            if (curr.children[arr[i]] == null)
                curr.children[arr[i]] = getNewTrie();
            curr = curr.children[arr[i]];
        }
        if (curr.isLeaf)
            return false;
        return curr.isLeaf = true;
    }

    void printDuplicateRow(int[][] mat) {

        Node head = getNewTrie();

        for (int i = 0; i < mat.length; i++) {
            if (insert(mat[i], head))
                System.out.println("Rown " + (i + 1));
        }
    }

    public static void main(String[] args) {
        DupliRowInBinaryMat dupliRowInBinaryMat = new DupliRowInBinaryMat();
        int[][] mat = {
                {1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 1},
        };
        dupliRowInBinaryMat.printDuplicateRow(mat);
    }

}
