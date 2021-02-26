public class CCLL {
    static class Node {

        int val;
        Node next;
        public Node() {
        }
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    static Node CreateCircularLL(int numberOfPeople) {

        Node head = null;
        Node prev = null;
        for (int i = 1; i <= numberOfPeople; i++) {
            Node nn = new Node(i);
            if (head == null)
                head = nn;
            if (prev == null)
                nn.next = nn;
            else {
                prev.next = nn;
                nn.next = head;
            }
            prev = nn;
        }
        return head;

    }
    //O(N)

    static void solution(int numberOfPeople) {

        Node head = CreateCircularLL(numberOfPeople);
        Node temp = new Node();
        Node curr = head;
        while (curr.next != curr) {
            temp = curr;
            curr = curr.next;
            temp.next = curr.next;
            temp = temp.next;
            curr = temp;
        }
       // N N/2 N/4 N/8 N/16 ....1
        // N + N/2+ N/4 + N/8
        System.out.println(temp.val);
    }

    public static void main(String[] args) {
        solution(3);
    }
}
