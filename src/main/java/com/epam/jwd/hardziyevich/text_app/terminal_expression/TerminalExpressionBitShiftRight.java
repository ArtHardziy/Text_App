package com.epam.jwd.hardziyevich.text_app.terminal_expression;

public class TerminalExpressionBitShiftRight extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        Integer rightValue = context.popValue();
        Integer leftValue = context.popValue();
        context.pushValue((leftValue >> rightValue));
    }
}
