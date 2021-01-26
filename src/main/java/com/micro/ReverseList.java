package com.micro;

public class ReverseList {

    static Node newHead = null;

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static void insert(int data) {
        if (newHead == null) {
            newHead = new Node(data, null);
        } else {
            Node currNode = newHead;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new Node(data, null);
        }
    }

    static void recur(Node node) {
        if (node == null)
            return;
        recur(node.next);
        insert(node.data);
    }

    static Node recurMain(Node node) {

        if (node == null || node.next == null)
            return node;
        Node newNode = recurMain(node.next);

        node.next.next = node;
        node.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, null);
        Node head2 = new Node(2, null);
        Node head3 = new Node(3, null);
        head1.next = head2;
        head2.next = head3;
        recur(head1);
        Node currNode = newHead;
        while (currNode != null) {
            System.out.print(currNode.data + " ----> ");
            currNode = currNode.next;
        }
        System.out.println();
        currNode = recurMain(head1);
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

    }
}
