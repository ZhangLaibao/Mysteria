package org.john.rambo.mysteria.test;

import lombok.extern.slf4j.Slf4j;
import org.john.rambo.mysteria.components.SingletonSlowInitHolder;
import org.john.rambo.mysteria.components.SlowInit;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PengXianglong
 * @date 2021-12-17 15:28
 */
@Slf4j
public class DoubleCheckNotSyncedTest {

    private final ExecutorService executorService = Executors.newFixedThreadPool(100);

    @Test
    public void testNotInited() {
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 1000000; i++) {
            executorService.submit(() -> {
                final SlowInit slowInit = SingletonSlowInitHolder.getSlowInit();
                if (!slowInit.isInited()) {
                    count.incrementAndGet();
                }
            });
        }
        log.error("not inited count {}", count.get());
    }

}
