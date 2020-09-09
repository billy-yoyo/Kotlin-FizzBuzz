package com.example.fizzbuzz

class Machine(private val rules: Array<Rule>) {
    fun feed(number: Int) {
        val state = State(number);
        this.rules.forEach { state.processRule(it) }
        println(state.build());
    }
}