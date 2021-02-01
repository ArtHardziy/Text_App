package com.epam.jwd.hardziyevich.text_app.composition;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Sentence extends SomeTextComponent {

    private char endSign;

    @Override
    public String build() {
        StringBuilder text = new StringBuilder();
        composite.forEach(x -> {
            text.append(x.build());
            text.append(" ");
        });
        text.deleteCharAt(text.length()-1);
        text.append(endSign);
        return text.substring(0 ,1).toUpperCase()
                + text.substring(1);
    }

    @Override
    public void setEndSign(char endSing) {
        this.endSign = endSign;
    }
}
