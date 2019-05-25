package com.preparation.singletonEnum;

public class EnumTester {

    public static void main(String[] args) {
        SingletonEnum singletonEnum=SingletonEnum.INSTANCE;

        singletonEnum.setValue(5);
        System.out.println(singletonEnum.getValue());
    }
}
