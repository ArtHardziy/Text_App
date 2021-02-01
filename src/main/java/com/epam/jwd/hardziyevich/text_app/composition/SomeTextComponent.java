package com.epam.jwd.hardziyevich.text_app.composition;

import com.epam.jwd.hardziyevich.text_app.parsers.ConcreteTextSplitter;
import com.epam.jwd.hardziyevich.text_app.parsers.TextSplitter;

import java.util.ArrayList;
import java.util.List;

public abstract class SomeTextComponent implements TextComponent{

    protected String value;
    protected List<TextComponent> composite = new ArrayList<>();

    @Override
    public List<TextComponent> getComposite() {
        return composite;
    }

    @Override
    public void add(TextComponent textComponent) {
        TextSplitter textSplitter = ConcreteTextSplitter.PARAGRAPH
                .setNext(ConcreteTextSplitter.LEXEME);
        textSplitter.handle(textComponent, composite);
    }

    @Override
    public String build() {
        return null;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setEndSign(char endSing) {

    }
}
