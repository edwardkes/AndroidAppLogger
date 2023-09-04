package com.edward.keselman.androidapplogger;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.edward.keselman.androidapplogger.interfaces.CompletionHandler;
import com.edward.keselman.androidapplogger.types.modules.BaseLog;
import com.edward.keselman.androidapplogger.types.modules.ErrorLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppLogger {
    private static final String TAG = "AppLogger";
    private static final String LOG_FILE_NAME = "app_logs.log";
    private static String deviceUUID;
    private static String bugsnagUUID;
    private static final  String LOGGER_SHARED_PREFS = "Logger_Preferences";
    private static final String DEVICE_UUID = "deviceUUID";
    private static final String BUGSNAG_UUID = "bugsnagUUID";

    public static boolean deleteLogFile(Context context) {
        File fileToDelete = new File(getFilePath(context));

        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                return true; // File deleted successfully
            } else {
                return false; // Failed to delete the file
            }
        } else {
            return false; // File doesn't exist
        }
    }

    public static void clearLogFileContent(Context context) throws IOException {
        File file = new File(getFilePath(context));
        if(file.exists()) new FileOutputStream(file.getPath()).close();
    }

    private static String getFilePath(Context context) {
        return context.getApplicationContext().getFilesDir() + "/" + LOG_FILE_NAME;
    }

    private static void writeToLogFile(Context context, String message) throws IOException {
        File file = new File(getFilePath(context));
        if (!file.exists()) {
            boolean created = file.createNewFile();
            if (!created) return;
        }
        FileOutputStream writer = new FileOutputStream(file, true);
        String output = message + "\n";
        writer.write(output.getBytes());
        writer.close();
    }

    @Nullable
    public static byte[] getAppLogsFromFile(Context context) throws IOException {
        File file = new File(getFilePath(context));
        if(!file.exists()) {
            return null;
        } else {
            int size = (int) file.length();
            byte[] bytes = new byte[size];
            FileInputStream is = new FileInputStream(file);
            int readBytes = is.read(bytes);
            is.close();
            Log.e(TAG, "readFromFile:  read " + readBytes + " bytes" );
            return bytes;
        }
    }

    public static void info(final Context context, final @NonNull BaseLog info, CompletionHandler completionHandler) throws IOException {
        String message = addBugsnagUUID(context, addDeviceUUID(context, info.toString()));
        writeToLogFile(context, message);
        completionHandler.onComplete();
    }

    public static void error(Context context, @NonNull ErrorLog errorLog, CompletionHandler completionHandler) throws IOException {
        String message = addBugsnagUUID(context,addDeviceUUID(context, errorLog.toString()));
        writeToLogFile(context, message);
        completionHandler.onComplete();
    }

    private static String addDeviceUUID(Context context, String logMessage) {
        String uuid = getDeviceUUD(context);
        return logMessage + " | " + uuid;
    }

    private static String addBugsnagUUID(Context context, String logMessage) {
        String uuid = getBugsnagUUD(context);
        return logMessage + " | " + uuid;
    }

    public static void setDeviceUUID(Context context, String uuid) {
        SharedPreferences preferences = context.getSharedPreferences(LOGGER_SHARED_PREFS, Context.MODE_PRIVATE);
        preferences.edit().putString(DEVICE_UUID, uuid).apply();
        deviceUUID = uuid;
    }

    public static void setBugsnagUUID(Context context, String uuid) {
        SharedPreferences preferences = context.getSharedPreferences(LOGGER_SHARED_PREFS, Context.MODE_PRIVATE);
        preferences.edit().putString(BUGSNAG_UUID, uuid).apply();
        bugsnagUUID = uuid;
    }

    private static String getBugsnagUUD(Context context) {
        if (bugsnagUUID == null || bugsnagUUID.isEmpty()) {
            bugsnagUUID = context.getSharedPreferences(LOGGER_SHARED_PREFS, Context.MODE_PRIVATE)
                    .getString(BUGSNAG_UUID, "");
        }
        return bugsnagUUID;
    }

    private static String getDeviceUUD(Context context) {
        if (deviceUUID == null || deviceUUID.isEmpty()) {
            deviceUUID = context.getSharedPreferences(LOGGER_SHARED_PREFS, Context.MODE_PRIVATE)
                    .getString(DEVICE_UUID, "");
        }
        return deviceUUID;
    }
}
