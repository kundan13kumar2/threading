package com.preparation;

import java.util.LinkedList;
import java.util.Queue;

public class StepToConvert {

    public static class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", step=" + step +
                    '}';
        }
    }


    public static int countSteps(int a, int b, int k) {


        Queue<Node> calculationQueue = new LinkedList<>();

        Node node = null;


        if (a * k == b)
            return 1;
        else if (a * k < b) {
            node = new Node(a * k, 1);
            calculationQueue.add(node);
        }

        if (a - 1 == b)
            return 1;
        else if (a - 1 > 0) {
            node = new Node(a - 1, 1);
            calculationQueue.add(node);
        }


        if (a - 2 == b)
            return 1;
        else if (a - 2 > 0) {
            node = new Node(a - 2, 1);
            calculationQueue.add(node);
        }


        while (!calculationQueue.isEmpty()) {

            Node queueNode = calculationQueue.poll();

            int mul = queueNode.val * k;
            int diff1 = queueNode.val - 1;
            int diff2 = queueNode.val - 2;

            if (mul == b || diff1 == b || diff2 == b)
                return queueNode.step + 1;

            if (mul > 1)
                calculationQueue.add(new Node(mul, queueNode.step + 1));

            if (diff1 > 0)
                calculationQueue.add(new Node(diff1, queueNode.step + 1));

            if (diff2 > 0)
                calculationQueue.add(new Node(diff2, queueNode.step + 1));

        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(countSteps(11, 6, 2));
    }


}
