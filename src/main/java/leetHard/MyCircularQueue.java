package leetHard;

class MyCircularQueue {

    public int size;
    ListNode head;
    int currCount;

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public MyCircularQueue(int k) {
        this.size = k;
        head = null;
        currCount = 0;
    }

    public boolean enQueue(int value) {
        if (head == null) {
            head = new ListNode(value);
            head.next = head;
            currCount++;
        } else {
            if (size != currCount) {
                ListNode temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                ListNode node = new ListNode(value);
                temp.next = node;
                node.next = head;
                currCount++;
            } else
                return false;
        }
        return true;
    }

    public boolean deQueue() {
        if (head == null) return false;
        if (head.next == head) {
            currCount--;
            head = null;
            return true;
        }
        ListNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        ListNode dummy = head;
        head = dummy.next;
        temp.next = head;
        dummy = null;
        currCount--;
        return true;

    }

    public int Front() {
        if (head == null)
            return -1;
        return head.val;

    }

    public int Rear() {
        if (head == null) return -1;
        ListNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        return temp.val;

    }

    public boolean isEmpty() {
        return currCount == 0;
    }

    public boolean isFull() {
        return size == currCount;
    }


    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(8);
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(9));
        System.out.println(queue.enQueue(5));
        System.out.println(queue.enQueue(0));
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isEmpty());
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        System.out.println(queue.deQueue());

    }
}
