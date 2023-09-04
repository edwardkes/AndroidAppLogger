package com.edward.keselman.androidapplogger.types.modules;

import androidx.annotation.NonNull;

import com.edward.keselman.androidapplogger.types.enums.LogLabel;
import com.edward.keselman.androidapplogger.types.enums.LogSeverity;

public class ErrorLog extends BaseLog {

    private final Exception exception;
    private final String message;

    public ErrorLog(LogLabel logLabel, String fileName, String functionName, String message, Exception e) {
        super(logLabel, LogSeverity.ERROR, fileName, functionName);
        this.exception = e;
        this.message = message;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + " | " + message + " | " +  "Exception has occurred => "
                + exception.getMessage() + exception;
    }
}