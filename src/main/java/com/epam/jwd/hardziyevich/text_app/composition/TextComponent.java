package com.epam.jwd.hardziyevich.text_app.composition;

import java.util.List;

public interface TextComponent {
    List<TextComponent> getComposite();

    void add(TextComponent textComponent);
    String build();
    String getValue();
    void setValue(String value);
    void setEndSign(char endSing);
}
