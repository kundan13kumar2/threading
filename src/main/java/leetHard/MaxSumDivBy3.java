package leetHard;

import java.util.Arrays;

public class MaxSumDivBy3 {

    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node reverse(Node head, int k) {
        if (head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        MaxSumDivBy3 llist = new MaxSumDivBy3();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
    /*public static void main(String[] args) {
        int[] arr = {3, 6, 5, 1, 8};
        int[] dp = new int[3];

        dp[arr[0] % 3] = arr[0];
        boolean[] updated = new boolean[3];
        Arrays.fill(updated, false);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = arr[i] + dp[j];
                if (updated[sum % 3]) {
                    dp[sum % 3] = Math.max(dp[sum % 3], sum);
                    updated[sum % 3] = true;
                }
            }
        }
        System.out.println(dp[0]);
    }*/
}
