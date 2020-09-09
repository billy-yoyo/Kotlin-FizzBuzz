package com.example.fizzbuzz;

fun main() {
    for (i in 1..100) {
        val s = ArrayList<String>();
        val isBong = i % 11 == 0;

        if(!isBong && i % 3 == 0) {
            s.add("Fizz");
        }

        if(i % 13 == 0) {
            s.add("Fezz");
        }

        if (!isBong && i % 5 == 0) {
            s.add("Buzz");
        }

        if (!isBong && i % 7 == 0) {
            s.add("Bang");
        }

        if (isBong) {
            s.add("Bong");
        }

        if (i % 17 == 0) {
            s.reverse();
        }

        if (s.isEmpty()) {
            println(i);
        } else {
            println(s.joinToString(separator = ""));
        }
    }
}