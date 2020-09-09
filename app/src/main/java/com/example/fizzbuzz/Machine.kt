package com.example.fizzbuzz

class Machine {
    private val rules: Array<Rule>;
    constructor(rules: Array<Rule>) {
        this.rules = rules;
    }

    fun feed(number: Int) {
        val state = State(number);
        this.rules.forEach { state.processRule(it) }
        println(state.build());
    }
}