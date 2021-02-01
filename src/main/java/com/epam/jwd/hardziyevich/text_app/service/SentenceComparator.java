package com.epam.jwd.hardziyevich.text_app.service;

import com.epam.jwd.hardziyevich.text_app.composition.TextComponent;

import java.util.Comparator;

public class SentenceComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        if (o1.build().length() > o2.build().length()) {
            return 1;
        } else if (o1.build().length() < o2.build().length()) {
            return -1;
        }
        return 0;
    }
}