package com.epam.jwd.hardziyevich.text_app.service;


import com.epam.jwd.hardziyevich.text_app.composition.TextComponent;

public interface TextSort {
    void sortParagraphsBySentences(TextComponent entireText);
    void sortSentencesByLexemes(TextComponent paragraph);
    void sortLexemesBySymbolEntrance(TextComponent sentence, char symbol);
}
