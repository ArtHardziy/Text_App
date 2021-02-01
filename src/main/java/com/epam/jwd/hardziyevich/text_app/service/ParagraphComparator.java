package com.epam.jwd.hardziyevich.text_app.service;

import com.epam.jwd.hardziyevich.text_app.composition.TextComponent;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        if (o1.getComposite().size() > o2.getComposite().size()) {
            return 1;
        }else if (o1.getComposite().size() < o2.getComposite().size()) {
            return -1;
        } return 0;
    }
}