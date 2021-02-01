package com.epam.jwd.hardziyevich.text_app.composition;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends SomeTextComponent{

    @Override
    public String build() {
        StringBuilder text = new StringBuilder();
        composite.forEach(x -> {
            text.append(x.build());
            text.append(" ");
        });
        return text.toString().trim();
    }
}
