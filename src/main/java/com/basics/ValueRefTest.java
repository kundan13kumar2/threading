package com.basics;

public class ValueRefTest {

    public static void increment(TestNumber a) {
        a.setAge(30);
    }

    public static void decrement(Integer num) {
        num--;
    }

    public static void main(String[] args) {

        TestNumber testNumber = new TestNumber();
        testNumber.setAge(20);
        testNumber.setName("Kundan");

        System.out.println("In Main : \n" + testNumber);

        increment(testNumber);

        System.out.println("After : " + testNumber);

        Integer a = 10;

        System.out.println("Before : " + a);

        decrement(a);

        System.out.println(a);
    }
}
