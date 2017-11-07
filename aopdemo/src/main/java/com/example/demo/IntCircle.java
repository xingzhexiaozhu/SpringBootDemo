package com.example.demo;

public class IntCircle {
    public static void main(String[] args){
        int n = 2147483647;
        System.out.println(n);
        System.out.println(n&(n+1));
        System.out.println((n+1)&(n+2));
    }
}
