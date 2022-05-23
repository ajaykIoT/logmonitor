package com.akumar1.logmonitor.service;

import com.akumar1.logmonitor.conf.ApplicationData;
import com.akumar1.logmonitor.controller.LogMonitorController;
import com.akumar1.logmonitor.model.Context;
import com.akumar1.logmonitor.validator.LogMonitorValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogMonitorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogMonitorService.class);

    @Autowired
    private LogMonitorValidator validator;

    @Autowired
    private LogMonitorController manager;

    @Autowired
    private ApplicationData applicationData;

    public void execute(String... args) {
        Context context = Context.getInstance();
        validator.validateInput(context, args);
        manager.parseAndPersistEvents(context);
    }

}
