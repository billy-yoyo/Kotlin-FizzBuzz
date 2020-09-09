package com.example.fizzbuzz.actions

import com.example.fizzbuzz.Action
import com.example.fizzbuzz.State

class GroupVisibilityAction : Action {

    private val group: String;
    private val visibility: Boolean;

    constructor(group: String, visibility: Boolean) {
        this.group = group;
        this.visibility = visibility
    }

    override fun commit(state: State) {
        state.setGroupVisibility(this.group, this.visibility);
    }

}