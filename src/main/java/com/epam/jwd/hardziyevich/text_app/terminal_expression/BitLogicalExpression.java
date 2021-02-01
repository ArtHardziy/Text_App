package com.epam.jwd.hardziyevich.text_app.terminal_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BitLogicalExpression {

    private static final String EXPRESSION_REGEX = "\\p{Blank}+";
    private final List<AbstractMathExpression> listExpression = new ArrayList<>();

    public BitLogicalExpression(String expression){
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        parse(reversePolishNotation.convert(expression));
    }

    private void parse(String expression){
        for (String lexeme : expression.split(EXPRESSION_REGEX)){
            if (lexeme.isEmpty()){
                continue;
            }

            switch(lexeme){
                case "<<": listExpression.add(new TerminalExpressionBitShiftLeft());
                    break;
                case ">>": listExpression.add(new TerminalExpressionBitShiftRight());
                    break;
                case "~": listExpression.add(new TerminalExpressionNot());
                    break;
                case "&": listExpression.add(new TerminalExpressionAnd());
                    break;
                case "|": listExpression.add(new TerminalExpressionOr());
                    break;
                case "^": listExpression.add(new TerminalExpressionXor());
                    break;
                default: {
                    try(Scanner scan = new Scanner(lexeme)) {
                        if (scan.hasNextInt()) {
                            listExpression.add(new NonterminalExpressionNumber(scan.nextInt()));
                        }
                    }
                }
            }
        }
    }

    public Number calculate() {
        Context context = new Context();
        listExpression.forEach(terminal -> terminal.interpret(context));
        return context.popValue();
    }
}