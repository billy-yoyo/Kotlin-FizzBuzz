package com.example.fizzbuzz.actions

import com.example.fizzbuzz.Action
import com.example.fizzbuzz.State

class AppendAction(private val content: String) : Action {

    override fun commit(state: State) {
        state.getBuffer().add(this.content);
    }
}