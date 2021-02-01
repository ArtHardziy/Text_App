package com.epam.jwd.hardziyevich.text_app.service;

import com.epam.jwd.hardziyevich.text_app.composition.TextComponent;

import java.util.Comparator;

public class LexemeComparator implements Comparator<TextComponent> {
    private char symbol;

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        if(count(o1.build()) > 0 && count(o2.build()) == 0){
            return -1;
        } else if (count(o1.build()) == 0 && count(o2.build()) > 0){
            return 1;
        }
        if (count(o1.build()) > count(o2.build())) {
            return 1;
        } else if (count(o1.build()) < count(o2.build())) {
            return -1;
        } else {
            if (o1.build().compareTo(o2.build()) > 0) {
                return 1;
            } else if (o1.build().compareTo(o2.build()) < 0) {
                return -1;
            }
            return 0;
        }
    }

    private long count(String string){
        return string.chars().filter(num -> num == symbol).count();
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }
}
