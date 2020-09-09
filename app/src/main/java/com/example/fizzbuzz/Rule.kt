package com.example.fizzbuzz

class Rule {
    private val number: Int;
    private val groups: Array<String>;
    private val actions: Array<Action>;

    constructor(number: Int, groups: Array<String>, actions: Array<Action>) {
        this.number = number;
        this.groups = groups;
        this.actions = actions;
    }

    fun getNumber(): Int {
        return this.number;
    }

    fun getGroups(): Array<String> {
        return this.groups;
    }

    fun commitActions(state: State) {
        actions.forEach { it.commit(state) }
    }
}