package com.bankinngApplication.Banking.Application.test;

public interface B {
    default void show() {
        System.out.println("from A");
    }
}
