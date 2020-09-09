package com.example.fizzbuzz;

import com.example.fizzbuzz.actions.AppendAction
import com.example.fizzbuzz.actions.GroupVisibilityAction
import com.example.fizzbuzz.actions.ReverseAction
import com.example.fizzbuzz.dataclass.MachineData
import com.example.fizzbuzz.dataclass.RuleData
import com.google.gson.Gson;

fun actionFromMap(map: Map<String, Any>): Action {
    val name = map.getValue("action");

    if (name.equals("append")) {
        return AppendAction(map.getValue("content") as String);
    } else if (name.equals("group")) {
        return GroupVisibilityAction(map.getValue("group") as String, map.getValue("visible") as Boolean);
    } else if (name.equals("reverse")) {
        return ReverseAction();
    } else {
        throw ClassNotFoundException("No matching action for name $name");
    }
}

fun ruleFromData(ruleData: RuleData): Rule {
    return Rule(
        ruleData.number,
        ruleData.groups.toTypedArray(),
        ruleData.actions.map { actionFromMap(it) }.toTypedArray()
    );
}

fun machineFromJson(content: String): Machine {
    val gson = Gson();
    val machineData = gson.fromJson(content, MachineData::class.java);
    val rules = machineData.rules.map { ruleFromData(it) };
    return Machine(rules.toTypedArray());
}

val rules = """
{
  "rules": [
    { "number": 11,
      "groups": ["default"],
      "actions": [ { "action": "group", "group": "default", "visible": false },
        { "action": "group", "group": "bong", "visible": true } ] },
    { "number": 3,
      "groups": ["default"],
      "actions": [ { "action": "append", "content": "Fizz" } ] },
    { "number": 13,
      "groups": ["default", "bong"],
      "actions": [ { "action": "append", "content": "Fezz" } ] },
    { "number": 5,
      "groups": ["default"],
      "actions": [ { "action": "append", "content": "Buzz" } ] },
    { "number": 7,
      "groups": ["default"],
      "actions": [ { "action": "append", "content": "Bang" } ] },
    { "number": 11,
      "groups": ["bong"],
      "actions": [ { "action": "append", "content": "Bong"} ] },
    { "number": 17,
      "groups": ["*"],
      "actions": [ { "action": "reverse" } ] }
  ]
}
""".trimIndent();

fun main() {
    val machine = machineFromJson(rules);

    for (i in 1..100) {
        machine.feed(i);
    }
}