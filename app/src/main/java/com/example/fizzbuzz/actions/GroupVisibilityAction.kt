package com.example.fizzbuzz.actions

import com.example.fizzbuzz.Action
import com.example.fizzbuzz.State

class GroupVisibilityAction(private val group: String, private val visibility: Boolean) : Action {

    override fun commit(state: State) {
        state.setGroupVisibility(this.group, this.visibility);
    }

}