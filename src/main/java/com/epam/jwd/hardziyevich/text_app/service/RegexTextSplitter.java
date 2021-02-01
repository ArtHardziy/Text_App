package com.epam.jwd.hardziyevich.text_app.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTextSplitter {

    public static final String PARAGRAPH_REGEX = "\\s{4}[A-Z].*(\\.|!|\\?|\\.\\.\\.)";
    public static final String SENTENCE_REGEX = ".*?(\\.|!|\\?|\\.\\.\\.)";
    public static final String LEXEME_REGEX = " ";
    public static final String WORD_REGEX = "";

}
