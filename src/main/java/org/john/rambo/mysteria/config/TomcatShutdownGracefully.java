package org.john.rambo.mysteria.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * work for kill -15
 * can't survive from kill -9
 */
@Slf4j
@Component
public class TomcatShutdownGracefully implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {

    private static final Integer SHUTDOWN_GRACEFULLY_TIME = 5;
    private volatile Connector connector;

    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        connector.pause();

        final Executor executor = connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            try {
                final ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) executor;
                poolExecutor.shutdown();
                if (!poolExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                    log.warn("Tomcat thread pool did not shut down gracefully within " +
                            SHUTDOWN_GRACEFULLY_TIME + " seconds. Proceeding with forceful shutdown");
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
    }
}