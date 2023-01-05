package com.money.fimsystem;

public class StringTest {

    public static void main(String[] args) {
            String pattern = "^[A-Za-z0-9-\u4e00-\u9fa5\\s]+$";
            String str = "你好啊asda213张文仔2---";
            System.out.println(str.matches(pattern));
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
