package com.epam.jwd.hardziyevich.text_app.terminal_expression;

public class NonterminalExpressionNumber extends AbstractMathExpression {

    private final int number;

    public NonterminalExpressionNumber(int number){
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
