package com.epam.jwd.hardziyevich.text_app.terminal_expression;

public class TerminalExpressionOr extends AbstractMathExpression{
    @Override
    public void interpret(Context context) {
        context.pushValue((context.popValue() | context.popValue()));
    }
}
