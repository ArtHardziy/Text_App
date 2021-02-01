package com.epam.jwd.hardziyevich.text_app.service;

import com.epam.jwd.hardziyevich.text_app.composition.TextComponent;

import java.util.Comparator;

public class TextSortService implements TextSort{
    private final Comparator<TextComponent> PARAGRAPH_COMPARATOR = new ParagraphComparator();
    private final Comparator<TextComponent> SENTENCE_COMPARATOR = new SentenceComparator();
    private final LexemeComparator lexemeComparator = new LexemeComparator();

    @Override
    public void sortParagraphsBySentences(TextComponent entireText) {
        entireText.getComposite().sort(PARAGRAPH_COMPARATOR);
    }

    @Override
    public void sortSentencesByLexemes(TextComponent entireText) {
        entireText.getComposite().forEach(paragraph -> {
            paragraph.getComposite().sort(SENTENCE_COMPARATOR);
        });
    }

    @Override
    public void sortLexemesBySymbolEntrance(TextComponent entireText, char symbol) {
        lexemeComparator.setSymbol(symbol);
        entireText.getComposite().forEach(paragraph -> {
            paragraph.getComposite().forEach(sentence -> {
                sentence.getComposite().sort(lexemeComparator);
            });
        });
    }
}
