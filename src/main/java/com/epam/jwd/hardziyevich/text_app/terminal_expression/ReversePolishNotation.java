package com.epam.jwd.hardziyevich.text_app.terminal_expression;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReversePolishNotation {
    private static final String EXPRESSION_LEXEME_REGEX = "((<{2}|>{2})|[&~^)(|])|(\\d+)";
    private static final String NUMBER_REGEX = "\\d+";
    private static final String OPERATOR_REGEX = "(<{2}|>{2})|[&~^)(|]";

    private final Stack<String> reversePolishNotation = new Stack<>();
    private final Stack<String> operators = new Stack<>();

    public String convert(String expression) {
        Pattern pattern = Pattern.compile(EXPRESSION_LEXEME_REGEX);
        Matcher matcher = pattern.matcher(expression);
        while(matcher.find()) {
            String lexeme = matcher.group();
            if (lexeme.matches(NUMBER_REGEX)) {
                reversePolishNotation.push(lexeme);
            } else if (lexeme.matches(OPERATOR_REGEX)) {
                switch (lexeme) {
                    case "(": {
                        operators.push(lexeme);
                    }
                    break;
                    case ")": {
                        while(!operators.peek().equals("(")) {
                            reversePolishNotation.push(operators.pop());
                        }
                        operators.pop();
                    }
                    break;
                    default: {
                        if (!operators.empty() && !operators.peek().equals("(")) {
                            if (operatorPrecedence(operators.peek()) > operatorPrecedence(lexeme)) {
                                while (!operators.empty()) {
                                    reversePolishNotation.push(operators.pop());
                                    if (!operators.empty() && operators.peek().equals("(")) break;
                                }
                            }
                        }
                        operators.push(lexeme);
                    }
                }
            }
        }
        while (!operators.empty()) {
            reversePolishNotation.push(operators.pop());
        }

        StringBuilder result = new StringBuilder();
        operators.clear();
        while(!reversePolishNotation.empty()) {
            operators.push(reversePolishNotation.pop());
        }
        while (!operators.empty()) {
            result.append(operators.pop());
            result.append(" ");
        }
        return result.toString().trim();
    }

    private int operatorPrecedence(String operator) {
        switch (operator) {
            case "|": return 0;
            case "^": return 1;
            case "&": return 2;
            case "<<":
            case ">>": return 3;
            case "~": return 4;
            default: return -1;
        }
    }
}