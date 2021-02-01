package com.epam.jwd.hardziyevich.text_app.composition;

import com.epam.jwd.hardziyevich.text_app.service.TextCompiler;
import com.epam.jwd.hardziyevich.text_app.service.TextCompilerService;


public class Lexeme extends SomeTextComponent{

    private final TextCompiler compiler = new TextCompilerService();

    @Override
    public String build() {
        return compiler.compile(getValue());
    }
}
