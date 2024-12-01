package com.jaydenroeper.adventOfCode2024.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
    public static String readFileToString(String source) {
        StringBuilder result = new StringBuilder();

        try (InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(source)) {
            if (inputStream == null) {
                throw new FileNotFoundException(source);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line).append(System.lineSeparator());
                }

                return result.toString();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load file: " + source, e);
        }
    }
}
