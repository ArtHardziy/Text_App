package com.epam.jwd.hardziyevich.text_app.terminal_expression;

import java.util.ArrayDeque;

public class Context {

    private final ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value){
        contextValues.push(value);
    }
}
