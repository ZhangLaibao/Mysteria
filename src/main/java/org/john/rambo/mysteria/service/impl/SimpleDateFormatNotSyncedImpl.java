package org.john.rambo.mysteria.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.john.rambo.mysteria.service.SimpleDateFormatNotSynced;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class SimpleDateFormatNotSyncedImpl implements SimpleDateFormatNotSynced {

    // error 1
    //    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
    // error 2
    //    private SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

    @Override
    public FormatVO formatError() {
        // it's OK
        SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

        Date date = new Date();
        String dateString = SIMPLE_DATE_FORMAT.format(date);

        return new FormatVO(dateString, date);
    }

}
