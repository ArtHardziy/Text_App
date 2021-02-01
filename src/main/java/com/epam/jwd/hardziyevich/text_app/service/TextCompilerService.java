package com.epam.jwd.hardziyevich.text_app.service;

import com.epam.jwd.hardziyevich.text_app.terminal_expression.BitLogicalExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCompilerService implements TextCompiler{

    private static final String EXPRESSION_REGEX = "(((<{2}|>{2})|[&~^)(|])|(\\\\d+))+";

    @Override
    public String compile(String text) {
        Pattern pattern =  Pattern.compile(EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(text);
        String retrievedText = null;
        if(matcher.find()){
            retrievedText = matcher.group();
        }
        if(retrievedText.length() > 1 && !retrievedText.equals("()")){
            return  text.replaceFirst(EXPRESSION_REGEX, new BitLogicalExpression(retrievedText).calculate().toString());
        }
        return text;
    }
}
