package com.edward.keselman.androidapplogger.types.modules;

import androidx.annotation.NonNull;

import com.edward.keselman.androidapplogger.types.enums.LogLabel;
import com.edward.keselman.androidapplogger.types.enums.LogSeverity;

import java.time.Instant;

public abstract class BaseLog {
    protected String date;
    protected LogLabel logLabel;
    protected LogSeverity severity;
    protected String fileName;
    protected String functionName;

    public  BaseLog(LogLabel logLabel, LogSeverity severity, String fileName, String functionName) {
        this.date = Instant.now().toString();
        this.logLabel = logLabel;
        this.severity = severity;
        this.fileName = fileName;
        this.functionName = functionName;
    }

    @NonNull
    @Override
    public String toString() {
        return date + " | " + logLabel + " | " + severity + " | " + fileName + " | " + functionName;
    }
}
