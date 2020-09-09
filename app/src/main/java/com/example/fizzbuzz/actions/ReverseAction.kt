package com.example.fizzbuzz.actions

import com.example.fizzbuzz.Action
import com.example.fizzbuzz.State

class ReverseAction : Action {

    override fun commit(state: State) {
        state.getBuffer().reverse();
    }

}