package com.epam.jwd.hardziyevich.text_app.parsers;

import com.epam.jwd.hardziyevich.text_app.composition.TextComponent;

import java.util.List;

public interface TextSplitter {

    static final String PARAGRAPH_REGEX = ".+(\\n)?";
    static final String SENTENCE_REGEX = "[A-Z].*?[\\.\\!\\?]";
    static final String LEXEME_REGEX = "\\S+";

    TextSplitter setNext(TextSplitter textSplitter);
    void handle(TextComponent textComponent, List<TextComponent> composite);
}
