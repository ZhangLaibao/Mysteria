package org.john.rambo.mysteria.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@Slf4j
public class DoubleNotPreciseTest {

    @Test
    public void testEqualsOperator() {
        Double d1 = 0.1;
        Double d2 = 0.2;
        Double d3 = 0.3;
        Assertions.assertFalse(d3 == d1 + d2);
    }

    @Test
    public void testEqualsMethod() {
        Double d1 = 0.1;
        Double d2 = 0.2;
        Double d3 = 0.3;
        Assertions.assertFalse(d3.equals(d1 + d2));
    }

    @Test
    public void testCompareDoubleUseDecimal() {
        Double d1 = 0.1;
        Double d2 = 0.2;
        Double d3 = 0.3;
        Assertions.assertNotEquals(0, new BigDecimal(d3).compareTo(new BigDecimal(d1 + d2)));
    }
}
