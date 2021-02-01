package com.epam.jwd.hardziyevich.text_app.TextStorage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TextStorage {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextStorage.class);

    public static String initText(String filePath) {
        File file = new File(filePath);
        byte[] data = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(data);
        } catch (IOException e) {
            LOGGER.error("Error in read file");
        }
        return new String(data, StandardCharsets.UTF_8);
    }
}
