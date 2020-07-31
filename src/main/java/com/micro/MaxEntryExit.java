/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.micro;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kundan Kumar
 * @version $Id: MaxEntryExit.java, v 0.1 2020-07-31 5:19 PM Kundan Kumar Exp $$
 */
public class MaxEntryExit {
    public static class Person {
        int entry;
        int counter;

        public Person(int entry, int counter) {
            this.entry = entry;
            this.counter = counter;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "entry=" + entry +
                    ", counter=" + counter +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] entry = {1, 2, 10, 12, 14};
        int[] exit = {3, 4};

        Arrays.sort(entry);
        Arrays.sort(exit);

        Stack<Person> stack = new Stack<>();
        if (entry[0] > exit[0]) {
            System.out.println("Invalid records");
            return;
        }
        Person maxObject = new Person(entry[0], 1);
        stack.push(maxObject);
        int counter = 1;
        int i = 1, j = 0;
        while (i < entry.length && j < exit.length) {
            if (entry[i] < exit[j]) {
                Person currentObj = new Person(entry[i], ++counter);
                stack.push(currentObj);
                if (currentObj.counter > maxObject.counter)
                    maxObject = currentObj;
                i++;
            } else if (entry[i] > exit[j]) {
                --counter;
                j++;
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                i++;
                j++;
            }
        }
        while (i < entry.length) {
            Person currentObj = new Person(entry[i], ++counter);
            if (currentObj.counter > maxObject.counter)
                maxObject = currentObj;
            i++;
        }
        System.out.println("Maximum number of count at a time: " + maxObject);
    }
}