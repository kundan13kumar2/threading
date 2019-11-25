
package com.basics;


public class Subtract {

    private static boolean foundFirstNonZero = false;
    private static boolean flag1 = false;

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void recur(Node node, int k) {

        if (node == null)
            return;

        recur(node.next, k);

        if (node.next == null) {
            if (node.val > k) {
                node.val -= k;
            } else {
                node.val = 10 + node.val - k;
                flag1 = true;
            }
        } else {
            if (flag1) {
                if (!foundFirstNonZero && node.val == 0) {
                    node.val = 9;
                } else if (!foundFirstNonZero) {
                    node.val -= 1;
                    foundFirstNonZero = true;
                }
            }
        }


    }


    public static void main(String[] args) {

        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(0);
        Node node4 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        recur(node1, 7);

        System.out.println(node1.val);
        System.out.println(node2.val);
        System.out.println(node3.val);
        System.out.println(node4.val);


    }
}