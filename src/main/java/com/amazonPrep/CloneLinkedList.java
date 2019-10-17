/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.amazonPrep;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kundan Kumar
 * @version $Id: CloneLinkedList.java, v 0.1 2019-10-16 9:27 PM Kundan Kumar Exp $$
 */
public class CloneLinkedList {

    public static class Node {
        int val;
        Node random;
        Node next;

        Node(int val, Node random, Node next) {
            this.val = val;
            this.random = random;
            this.next = next;
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.random != null)
                System.out.println(" : " + node.random.val);
            else System.out.println(" : -1");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, node5);
        Node node3 = new Node(3, node5, node4);
        Node node2 = new Node(2, node4, node3);
        Node node1 = new Node(1, node3, node2);
        node5.random = node2;


        Node head = node1;
        Node newHead = new Node(node1.val, null, null);

        printList(head);


        Map<Node, Node> mappingNode = new HashMap<>();
        Node p = head;
        Node q = newHead;

        mappingNode.put(p, q);
        p = p.next;
        while (p != null) {
            Node temp = new Node(p.val, p.random, p.next);
            mappingNode.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }

        p = head;
        q = newHead;

        while (p != null) {

            if (p.random != null)
                q.random = mappingNode.get(p.random);
            else q.random = null;

            p = p.next;
            q = q.next;
        }

        printList(newHead);

    }

}