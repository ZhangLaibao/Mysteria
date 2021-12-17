package org.john.rambo.mysteria.components;

import java.util.concurrent.TimeUnit;

/**
 * @author PengXianglong
 * @date 2021-12-17 15:04
 */
public class SlowInit {

    private boolean inited;

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
