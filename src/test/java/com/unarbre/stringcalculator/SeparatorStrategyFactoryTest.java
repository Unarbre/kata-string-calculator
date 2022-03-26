package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.separators.CustomSeparatorStrategy;
import com.unarbre.stringcalculator.parser.separators.DefaultSeparatorStrategy;
import com.unarbre.stringcalculator.parser.separators.SeparatorStrategyFactory;
import com.unarbre.stringcalculator.parser.separators.SeparatorUnparsableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeparatorStrategyFactoryTest {


    private final SeparatorStrategyFactory separatorStrategyFactory = new SeparatorStrategyFactory();

    @Test
    public void should_return_default_on_no_specified_separator() {
        Assertions.assertEquals(new DefaultSeparatorStrategy(), this.separatorStrategyFactory.get("123"));
    }

    @Test
    public void should_return_custom_on_specified_separator() {
        Assertions.assertEquals(new CustomSeparatorStrategy("dog"), this.separatorStrategyFactory.get("\\dog\n5dog3"));
    }

    @Test
    public void should_return_custom_with_empty_separator() {
        Assertions.assertEquals(new CustomSeparatorStrategy(""), this.separatorStrategyFactory.get("\\\n35"));
    }

    @Test
    public void should_handle_number_separator() {
        Assertions.assertEquals(new CustomSeparatorStrategy("5"), this.separatorStrategyFactory.get("\\5\n35"));
    }
}
