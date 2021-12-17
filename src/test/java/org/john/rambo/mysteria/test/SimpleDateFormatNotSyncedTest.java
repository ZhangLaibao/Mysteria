package org.john.rambo.mysteria.test;

import lombok.extern.slf4j.Slf4j;
import org.john.rambo.mysteria.service.SimpleDateFormatNotSynced;
import org.john.rambo.mysteria.service.impl.FormatVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootTest
public class SimpleDateFormatNotSyncedTest {

    private final ExecutorService executorService = Executors.newFixedThreadPool(100);

    @Resource
    private SimpleDateFormatNotSynced simpleDateFormatNotSynced;

    @Test
    public void testFormat() {
        for (int i = 0; i < 1000000; i++) {
            executorService.submit(() -> {
                FormatVO formatVO = simpleDateFormatNotSynced.formatError();

                SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
                String format = SIMPLE_DATE_FORMAT.format(formatVO.getDate());
                if (!format.equals(formatVO.getFormatted())) {
                    log.error("format error {}, should be {}", formatVO, format);
                }
            });
        }
    }
}
