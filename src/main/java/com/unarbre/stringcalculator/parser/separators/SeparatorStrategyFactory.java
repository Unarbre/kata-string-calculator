package com.unarbre.stringcalculator.parser.separators;

import com.unarbre.stringcalculator.structures.Factory;

public class SeparatorStrategyFactory implements Factory<String, SeparatorStrategy> {

    @Override
    public SeparatorStrategy get(String source) {
        return switch (source) {
            case String s && s.startsWith("\\") -> new CustomSeparatorStrategy(
                    this.extractSeparator(source)
            );

            default -> new DefaultSeparatorStrategy();
        };
    }

    private String extractSeparator(String source) {
        var indexOf = source.indexOf("\n");
        if (indexOf == -1) {
            throw new SeparatorUnparsableException(source + " separator couldn't be parse. Please provide an \\n at the end");
        }
        return source.substring(1, source.indexOf("\n"));
    }
}
