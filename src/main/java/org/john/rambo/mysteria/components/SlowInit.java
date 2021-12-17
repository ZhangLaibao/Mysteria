package org.john.rambo.mysteria.components;

import java.util.concurrent.TimeUnit;

public class SlowInit {

    private boolean inited;

    /**
     * assume that it will take 1 second for this class to initialize
     */
    public void init() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setInited(true);
    }

    // ------------------------

    public boolean isInited() {
        return inited;
    }

    public void setInited(boolean inited) {
        this.inited = inited;
    }
}
