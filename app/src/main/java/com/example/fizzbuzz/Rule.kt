package com.example.fizzbuzz

class Rule(
    private val number: Int,
    private val groups: Array<String>,
    private val actions: Array<Action>
) {
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