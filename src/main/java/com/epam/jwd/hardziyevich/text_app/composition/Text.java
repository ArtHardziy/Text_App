package com.epam.jwd.hardziyevich.text_app.composition;

public class Text extends SomeTextComponent{

    @Override
    public String build() {
        StringBuilder text = new StringBuilder();
        composite.forEach(x ->
            text.append("    ").append(x.build())
                    .append(System.lineSeparator()));
        return text.toString();

    }
}
