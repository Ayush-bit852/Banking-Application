package com.bankinngApplication.Banking.Application.test;

public interface A {

    default void show() {
        System.out.println("from A");
    }
}
