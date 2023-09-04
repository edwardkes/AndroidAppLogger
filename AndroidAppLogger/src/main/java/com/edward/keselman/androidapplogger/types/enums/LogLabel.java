package com.edward.keselman.androidapplogger.types.enums;


import com.edward.keselman.androidapplogger.Constants;

public enum LogLabel {
    GENERAL(Constants.LOG_LABEL_GENERAL),
    FLOOW_SETUP(Constants.LOG_LABEL_FLOW_SETUP),
    FLOOW_LOGGING(Constants.LOG_LABEL_FLOOW_LOGGING),
    BLUETOOTH(Constants.LOG_LABEL_BLUETOOTH);

    public final String label;
    LogLabel(String label) {
        this.label = label;
    }
}
