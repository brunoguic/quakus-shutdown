package com.brunoguic;

import io.quarkus.runtime.Shutdown;
import io.quarkus.runtime.ShutdownDelayInitiated;
import io.quarkus.runtime.ShutdownDelayInitiatedEvent;
import io.quarkus.runtime.ShutdownEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.logging.Logger;

@ApplicationScoped
class Observers {
    private static final Logger LOG = Logger.getLogger(Observers.class.getName());

    void onPreShutdown(@Observes ShutdownDelayInitiatedEvent event) {
        LOG.info("ShutdownDelayInitiatedEvent");
    }

    @ShutdownDelayInitiated
    void preShutdown() throws InterruptedException {
        LOG.info("ShutdownDelayInitiated started");
//        Thread.sleep(15 * 1000);
        LOG.info("ShutdownDelayInitiated finished");
    }

    void onShutdown(@Observes ShutdownEvent event) {
        LOG.info("ShutdownEvent");
    }

    @Shutdown
    void shutdown() throws InterruptedException {
        LOG.info("Shutdown started");
        Thread.sleep(10 * 1000);
        LOG.info("Shutdown finished");
    }
}