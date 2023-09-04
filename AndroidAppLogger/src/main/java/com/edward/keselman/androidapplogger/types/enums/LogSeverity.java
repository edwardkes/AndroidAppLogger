package com.edward.keselman.androidapplogger.types.enums;

import com.edward.keselman.androidapplogger.Constants;

public enum LogSeverity {
    INFO(Constants.LOG_SEVERITY_INFO),
    ERROR(Constants.LOG_SEVERITY_ERROR);
    public final String label;
    LogSeverity(String label) {
        this.label = label;
    }
}
