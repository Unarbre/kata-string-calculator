package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.separators.CustomSeparatorStrategy;
import com.unarbre.stringcalculator.parser.separators.DefaultSeparatorStrategy;
import com.unarbre.stringcalculator.parser.separators.SeparatorStrategyFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeparatorStrategyFactoryTest {


    private final SeparatorStrategyFactory separatorStrategyFactory = new SeparatorStrategyFactory();

    @Test
    public void should_return_default_on_no_specified_separator() {
        Assertions.assertEquals(new DefaultSeparatorStrategy(),
                this.separatorStrategyFactory.get(new UserInput("123")));
    }

    @Test
    public void should_return_custom_on_specified_separator() {
        Assertions.assertEquals(new CustomSeparatorStrategy("dog"),
                this.separatorStrategyFactory.get(new UserInput("\\dog\n5dog3")));
    }

    @Test
    public void should_return_custom_with_empty_separator() {
        Assertions.assertEquals(new CustomSeparatorStrategy(""),
                this.separatorStrategyFactory.get(new UserInput("\\\n35")));
    }

    @Test
    public void should_handle_number_separator() {
        Assertions.assertEquals(new CustomSeparatorStrategy("5"),
                this.separatorStrategyFactory.get(new UserInput("\\5\n35")));
    }
}
