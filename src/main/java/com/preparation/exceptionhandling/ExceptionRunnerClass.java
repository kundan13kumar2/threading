package com.preparation.exceptionhandling;

import java.util.Date;

public class ExceptionRunnerClass {

    public static void main(String[] args) {

        Date dd = new Date(System.currentTimeMillis());

        Date dd1 = new Date(dd.getTime());

        try {
            throw new ExceptionImplement("Bhai error hai");
        } catch (ExceptionImplement e) {
            System.out.println("Exception pakra gaya");
            System.out.println(e.getMessage());
        }
    }
}
