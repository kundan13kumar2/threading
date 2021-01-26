package com.micro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKList {

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static class PQ {
        int val;
        Node currNode;

        public PQ(int val, Node currNode) {
            this.val = val;
            this.currNode = currNode;
        }
    }

    static void mergeK(List<List<Node>> kList) {
        List<Integer> output = new ArrayList<>();

        PriorityQueue<PQ> priorityQueue = new PriorityQueue<>(new Comparator<PQ>() {
            @Override
            public int compare(PQ o1, PQ o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < kList.size(); i++) {
            List<Node> tt = kList.get(i);
            PQ pq = new PQ(tt.get(0).val, tt.get(0).next);
            priorityQueue.add(pq);
        }

        while (!priorityQueue.isEmpty()) {
            PQ tt = priorityQueue.remove();
            output.add(tt.val);
            if (tt.currNode != null) {
                Node node = tt.currNode;
                priorityQueue.add(new PQ(node.val, node.next));
            }
        }
        for (Integer inte : output)
            System.out.println(inte);
    }

    public static void main(String[] args) {

        List<List<Node>> masterList = new ArrayList<>();

        Node head1 = new Node(1, null);
        Node m1 = new Node(3, null);
        Node m2 = new Node(5, null);
        Node m3 = new Node(7, null);
        List<Node> l1 = new ArrayList<>();
        head1.next = m1;
        m1.next = m2;
        m2.next = m3;
        l1.add(head1);
        l1.add(m1);
        l1.add(m2);
        l1.add(m3);

        Node head2 = new Node(2, null);
        Node n1 = new Node(4, null);
        Node n2 = new Node(6, null);
        Node n3 = new Node(8, null);
        head2.next = n1;
        n1.next = n2;
        n2.next = n3;
        List<Node> l2 = new ArrayList<>();
        l2.add(head2);
        l2.add(n1);
        l2.add(n2);
        l2.add(n3);

        Node head3 = new Node(8, null);
        Node p1 = new Node(9, null);
        Node p2 = new Node(10, null);
        Node p3 = new Node(11, null);
        head3.next = p1;
        p1.next = p2;
        p2.next = p3;
        List<Node> l3 = new ArrayList<>();
        l3.add(head3);
        l3.add(p1);
        l3.add(p2);
        l3.add(p3);

        masterList.add(l1);
        masterList.add(l2);
        masterList.add(l3);

        mergeK(masterList);


    }
}
