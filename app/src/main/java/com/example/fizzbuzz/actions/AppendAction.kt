package com.example.fizzbuzz.actions

import com.example.fizzbuzz.Action
import com.example.fizzbuzz.State

class AppendAction : Action {
    private val content: String;

    constructor(content: String) {
        this.content = content;
    }

    override fun commit(state: State) {
        state.getBuffer().add(this.content);
    }
}