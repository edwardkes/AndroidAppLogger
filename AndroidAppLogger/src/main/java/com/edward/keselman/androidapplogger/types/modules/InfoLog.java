package com.edward.keselman.androidapplogger.types.modules;

import androidx.annotation.NonNull;

import com.edward.keselman.androidapplogger.types.enums.LogLabel;
import com.edward.keselman.androidapplogger.types.enums.LogSeverity;

import java.util.Map;

public class InfoLog extends BaseLog {

    private String message;
    private Map<String, Object> functionParams;
    private Map<String, Object> additionalData;

    /**
     * Info log constructor
     * @param logLabel - label of the flow the log belongs to
     * @param severity - the severity of the log either info or error
     * @param fileName - the name of the file where this log comes from
     * @param functionName - the name of the function this log comes from
     */
    public InfoLog (LogLabel logLabel, LogSeverity severity, String fileName, String functionName )
    {
        super(logLabel, severity, fileName, functionName);
    }

    /**
     * Info log constructor
     * @param logLabel - label of the flow the log belongs to
     * @param severity - the severity of the log either info or error
     * @param fileName - the name of the file where this log comes from
     * @param functionName - the name of the function this log comes from
     * @param functionParams - arguments that this function receives
     */
    public InfoLog(LogLabel logLabel, LogSeverity severity, String fileName, String functionName, Map<String, Object> functionParams)
    {
        super(logLabel, severity, fileName, functionName);
        this.functionParams = functionParams;
    }

    /**
     * Info log constructor
     * @param logLabel - label of the flow the log belongs to
     * @param severity - the severity of the log either info or error
     * @param fileName - the name of the file where this log comes from
     * @param functionName - the name of the function this log comes from
     * @param message - additional information
     */
    public InfoLog (LogLabel logLabel, LogSeverity severity, String fileName, String functionName, String message)
    {
        super(logLabel, severity, fileName, functionName);
        this.message = message;
    }

    /**
     * Info log constructor
     * @param logLabel - label of the flow the log belongs to
     * @param severity - the severity of the log either info or error
     * @param fileName - the name of the file where this log comes from
     * @param functionName - the name of the function this log comes from
     * @param functionParams - arguments that this function receives
     * @param message - additional information
     */
    public InfoLog(LogLabel logLabel, LogSeverity severity, String fileName, String functionName, Map<String, Object> functionParams, String message)
    {
        super(logLabel, severity, fileName, functionName);
        this.functionParams = functionParams;
        this.message = message;
    }

    public InfoLog(LogLabel logLabel, LogSeverity severity, String fileName, String functionName, String message, Map<String, Object> additionalData) {
        super(logLabel, severity, fileName, functionName);
        this.message = message;
        this.additionalData = additionalData;
    }

    public InfoLog(
            LogLabel logLabel,
            LogSeverity severity,
            String fileName,
            String functionName,
            Map<String, Object> functionParams,
            String message,
            Map<String, Object> additionalData)
    {
        super(logLabel, severity, fileName, functionName);
        this.functionParams = functionParams;
        this.message = message;
        this.additionalData = additionalData;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + " | " + "params => " + functionParams + " | " + "message => " +  message + " | " + additionalData;
    }
}
