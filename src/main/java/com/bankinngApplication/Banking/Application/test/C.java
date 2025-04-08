package com.bankinngApplication.Banking.Application.test;

public class C implements A , B{

    public static void main(String[] args) {

        C obj = new C();

        obj.show();
    }

    @Override
    public void show() {
        A.super.show();
    }
}
