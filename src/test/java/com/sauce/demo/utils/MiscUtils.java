package com.sauce.demo.utils;

import org.apache.commons.lang.CharEncoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MiscUtils {

    /**
     * This method replaces single whitespaces in a string with multiple ones. The purpose of this method is to take an
     * existing entity name, add whitespaces and then pass it to a fillUp method.
     *
     * @param targetString
     *         the initial string value that needs the number of whitespaces increased.
     *
     * @return returns the modified string which has more spaces.
     */
    public static String addWhitespacesToString(String targetString) {
        return String.format(targetString).replace(" ", "   ");
    }

    public static String getDriverPID(String driverPort) {
        String PID = null;
        try {
            String line;
            Process process = Runtime.getRuntime().exec("netstat -aon");
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while((line = bufferedReader.readLine()) != null) {
                if(line.contains(driverPort)) {
                    line = line.replaceAll("( )+", " ");
                    PID = line.split(" ")[5];
                    break;
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch(Exception err) {
            err.printStackTrace();
        }

        return PID;
    }

    public static String getBrowserPID(String driverPID) {
        String PID = null;
        try {
            String line;
            Process process = Runtime.getRuntime().exec("wmic process where (ParentProcessId=" + driverPID +
                                                        ") get Caption,ProcessId");
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while((line = bufferedReader.readLine()) != null) {
                if(line.contains("iexplore")) {
                    line = line.replaceAll("( )+", " ");
                    PID = line.split(" ")[1];
                    break;
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch(Exception err) {
            err.printStackTrace();
        }

        return PID;
    }

    public static void killProcessById(String processIdentifier) {
        try {
            Runtime.getRuntime().exec("TASKKILL /F /T /PID " + processIdentifier);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String encodeStirngForURL(String string) {
        String encodedString = null;
        try {
            encodedString = URLEncoder.encode(string, CharEncoding.UTF_8);
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedString;
    }

    public static String getFailedMethodName() {
        String methodName = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        for(int i = 1; i < stackTraceElements.length; ++i) {
            StackTraceElement stackTraceElement = stackTraceElements[i];
            if(stackTraceElement.getMethodName().equals("invoke0")) {
                stackTraceElement = stackTraceElements[i - 1];
                methodName =
                        stackTraceElement.getClassName() + "/" + stackTraceElement.getMethodName() + "/line number: " +
                        stackTraceElement.getLineNumber();
            }
        }

        return methodName;
    }

    static String getCleanPath(String path) {
        return path.replace("!", "");
    }

}
