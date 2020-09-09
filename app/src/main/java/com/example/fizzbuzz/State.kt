package com.example.fizzbuzz

class State {
    private val number: Int;
    private val buffer: ArrayList<String>;
    private val groupVisbility: HashMap<String, Boolean>;

    constructor(number: Int) {
        this.number = number;
        this.buffer = ArrayList();
        this.groupVisbility = HashMap();

        groupVisbility.put("default", true);
        groupVisbility.put("*", true);
    }

    fun groupIsVisible(group: String): Boolean {
        return this.groupVisbility.containsKey(group) && this.groupVisbility.getValue(group);
    }

    fun ruleIsVisible(rule: Rule): Boolean {
        return rule.getGroups().any { this.groupIsVisible(it) };
    }

    fun getBuffer(): ArrayList<String> {
        return this.buffer;
    }

    fun setGroupVisibility(group: String, visibility: Boolean) {
        this.groupVisbility.put(group, visibility);
    }

    fun processRule(rule: Rule) {
        if (this.number % rule.getNumber() == 0 && this.ruleIsVisible(rule)) {
            rule.commitActions(this);
        }
    }

    fun build(): String {
        if (this.buffer.isEmpty()) {
            return this.number.toString();
        } else {
            return this.buffer.joinToString(separator = "");
        }
    }
}