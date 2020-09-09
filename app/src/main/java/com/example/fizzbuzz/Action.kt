package com.example.fizzbuzz

interface Action {
    fun commit(state: State);
}