package com.unarbre.stringcalculator.infrastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader implements InputReader {

    @Override
    public String read() throws UnreadableException {
        Path fileName = Path.of("./input.txt");
        try {
            return Files.readString(fileName)
                    .replace("\r\n", "\n");
        } catch (IOException e) {
            throw new UnreadableException(e.toString());
        }
    }
}
