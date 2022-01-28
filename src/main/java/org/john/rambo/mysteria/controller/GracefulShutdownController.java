package org.john.rambo.mysteria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/graceful")
public class GracefulShutdownController {

    @RequestMapping("/check")
    public Object isGraceful() {
        return new Date();
    }

}
