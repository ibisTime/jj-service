package com.cdkj.service.core;

public class RandomGenerater {
    public static String generate4() {
        int random = (int) ((Math.random() * 9 + 1) * 1000);
        return String.valueOf(random);
    }

    public static String generate6() {
        int random = (int) ((Math.random() * 9 + 1) * 100000);
        return String.valueOf(random);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println(generate6());
        }
    }
}
