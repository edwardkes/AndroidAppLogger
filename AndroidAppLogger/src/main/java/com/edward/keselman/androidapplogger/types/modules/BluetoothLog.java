package com.edward.keselman.androidapplogger.types.modules;

import androidx.annotation.NonNull;

import com.edward.keselman.androidapplogger.types.enums.LogLabel;
import com.edward.keselman.androidapplogger.types.enums.LogSeverity;

public class BluetoothLog extends BaseLog{

    String bluetoothState; // TODO: need to change to enum
    String bluetoothName;
    String bluetoothId;

    public BluetoothLog(LogLabel logLabel, LogSeverity severity, String fileName,
                        String functionName, String bluetoothState, String bluetoothName,
                        String bluetoothId) {
        super(logLabel, severity, fileName, functionName);
        this.bluetoothState = bluetoothState;
        this.bluetoothName = bluetoothName;
        this.bluetoothId = bluetoothId;
    }

    @Override
    @NonNull
    public String toString() {
        return super.toString() + " | " + bluetoothState + " | " + bluetoothName
                + " | " + bluetoothId + " | " + bluetoothId;
    }
}
