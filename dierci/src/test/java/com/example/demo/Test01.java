package com.example.demo;

public class Test01 {

    public static void main(String[] args) {

        try {

        } catch (Exception e) {
        } finally {

        }
        try {

        } catch (Exception e) {
        } finally {

        }

        for (int i = 0; i < 100; i++) {
            int v = (int) Math.ceil(Math.random() * 5);
            int[] a = new int[3];
            a[v] = 1;
            System.out.println(v);
            try {

            } catch (Exception e) {
            } finally {

            }

        }
    }
}
