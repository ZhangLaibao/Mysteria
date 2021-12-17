package org.john.rambo.mysteria.components;

/**
 * Singleton holder for something expensive to initialize
 */
public class SingletonSlowInitHolder {

    private static volatile SlowInit SLOW_INIT;

    /**
     * IT'S FAILURE
     */
    public static SlowInit getSlowInit() {
        if (null == SLOW_INIT) {
            synchronized (SlowInit.class) {
                if (null == SLOW_INIT) {
                    SLOW_INIT = new SlowInit();
                    SLOW_INIT.init();
                }
            }
        }
        return SLOW_INIT;
    }

    /**
     * IT'S OK
     */
//    public static SlowInit getSlowInit() {
//        if (null == SLOW_INIT) {
//            synchronized (SlowInit.class) {
//                if (null == SLOW_INIT) {
//                    SlowInit tmp = new SlowInit();
//                    tmp.init();
//                    SLOW_INIT = tmp;
//                }
//            }
//        }
//        return SLOW_INIT;
//    }
}
