package com.akumar1.logmonitor;

import com.akumar1.logmonitor.service.LogMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class LogMonitor implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogMonitor.class);

    @Autowired
    private LogMonitorService service;

    public static void main(String... args) {
        SpringApplication logMonitorApp = new SpringApplication(LogMonitor.class);
        logMonitorApp.run(args);
    }

    @Override
    public void run(String... args) {
        Instant start = Instant.now();
        service.execute(args);
        Instant end = Instant.now();
        LOGGER.info("Total time: {}ms", Duration.between(start, end).toMillis());
    }
}
