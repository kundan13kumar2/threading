package leetHard;

import java.util.*;

public class GroupReverseLL {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverse(ListNode head, ListNode dummy) {
        ListNode prev = dummy;
        ListNode next = head;
        while (next != null && next != dummy) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int i = 0;
        ListNode newHead = null;
        ListNode result = null;
        ListNode temp = head;
        ListNode ph = null;
        while (head != null && i < k) {
            head = head.next;
            i++;
        }
        result = reverse(temp, head);

        while (head != null) {
            i = 0;
            temp = head;
            while (head != null && i < k) {
                head = head.next;
                i++;
            }
            if (head == null && i < k)
                break;
            if (ph == null)
                ph = result;
            else
                ph = newHead;
            i = 0;
            while (ph != null && i < k - 1) {
                ph = ph.next;
                i++;
            }
            newHead = reverse(temp, head);
            assert ph != null;
            ph.next = newHead;

        }
        return result;

    }


    public static void main(String[] args) {
        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(3);
        ListNode ll4 = new ListNode(4);
        ListNode ll5 = new ListNode(5);
        ll1.next = ll2;

        int[] nums1 = {45, 86, 75, 27, 10, 44, 27, 13, 100, 17, 7, 50, 54, 90, 17, 59, 54, 26, 85, 89, 81, 6, 65, 43, 14, 4, 24, 58, 51, 49, 40, 24, 56, 59, 32, 93, 17, 63, 62, 24, 76, 27, 86, 11, 77, 33, 45, 87, 64, 27, 47, 13, 15, 93, 78, 44, 94, 26, 40, 69, 13, 100, 65, 38, 85, 95, 98, 59, 67, 90, 12, 24, 67, 86, 11, 56, 94, 16, 35, 27, 13, 39, 31, 69, 52, 32, 72, 82, 56, 73, 94, 28, 45, 35, 68, 76, 100, 52, 27, 85};
        int[] nums2 = {37, 53, 98, 10, 39, 26, 19, 66, 84, 6, 31, 78, 29, 84, 7, 63, 14, 87, 11, 13, 61, 42, 6, 3, 35, 67, 62, 49, 38, 7, 74, 12, 65, 37, 2, 58, 50, 55, 86, 7, 75, 88, 35, 56, 90, 77, 5, 28, 5, 59, 79, 70, 31, 22, 70, 37, 69, 49, 62, 85, 9, 87, 100, 7, 79, 92, 91, 20, 95, 51, 83, 58, 8, 82, 100, 18, 48, 60, 7, 80, 89, 66, 64, 11, 22, 69, 59, 70, 76, 10, 48, 12, 86, 31, 15, 16, 38, 59, 41, 82};

        int[] diff = new int[nums1.length];

        int max = Integer.MIN_VALUE;
        int num = 0;
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            if (diff[i] > max) {
                max = diff[i];
                num = nums2[i];
            }
            sum = (sum + diff[i]) % 1000000007;
        }
        if (sum == 0) {
            System.out.println(sum);
            return;
        }

        int next = 0;
        int prev = 0;
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] >= num) {
                next = nums1[i];
                if (i != 0)
                    prev = nums1[i - 1];
                break;
            }
        }
        sum = sum + (Math.min(Math.abs(num - next), Math.abs(num - prev)) - max) % 1000000007;
        System.out.println(sum);


        GroupReverseLL reverseLL = new GroupReverseLL();
        // ListNode k = reverseLL.reverseKGroup(ll1, 2);
        // System.out.println(k.val);

    }
}
