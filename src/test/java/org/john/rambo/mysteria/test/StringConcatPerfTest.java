package org.john.rambo.mysteria.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author PengXianglong
 * @date 2021-12-17 15:28
 */
@Slf4j
public class StringConcatPerfTest {

    private static final Integer TOTAL = 10000000;
    private static final Integer TOTAL_STR = 100;

    @Test
    public void testStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        long l = System.currentTimeMillis();
        for (int i = 0; i < TOTAL; i++) {
            stringBuffer.append(i);
        }
        log.info("StringBuffer concat cost: {}", System.currentTimeMillis() - l);

        l = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_STR; i++) {
            stringBuffer.toString();
        }
        log.info("StringBuffer toString cost: {}", System.currentTimeMillis() - l);
    }

    @Test
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        long l = System.currentTimeMillis();
        for (int i = 0; i < TOTAL; i++) {
            stringBuilder.append(i);
        }
        log.info("StringBuilder concat cost: {}", System.currentTimeMillis() - l);

        l = System.currentTimeMillis();
        for (int i = 0; i < TOTAL_STR; i++) {
            stringBuilder.toString();
        }
        log.info("StringBuffer toString cost: {}", System.currentTimeMillis() - l);
    }

}
