package com.epam.jwd.hardziyevich.text_app.terminal_expression;

public class TerminalExpressionNot extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue((~context.popValue()));
    }
}