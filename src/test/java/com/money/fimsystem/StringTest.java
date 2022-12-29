package com.money.fimsystem;

public class StringTest {

    public static void main(String[] args) {
        int i = test();
        System.out.println(i);
    }

    public static int test(){
        int i =10 ;
        try {
            return i;
        } finally {
            i=20;
        }
    }
}
