package org.john.rambo.mysteria.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FormatVO {

    private String formatted;
    private Date date;

}
