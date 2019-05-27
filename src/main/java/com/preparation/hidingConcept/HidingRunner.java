package com.preparation.hidingConcept;

public class HidingRunner {

    public static void main(String[] args) {

        Animal.foo();
        Cat.foo();

        Animal a = new Animal();
        Animal a1 = new Cat();

        Cat c = new Cat();

        a.foo();
        a1.foo();
        c.foo();

    }
}
