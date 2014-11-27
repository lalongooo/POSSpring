package com.puntodeventa.global.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 *
 * @author USER
 */
public class LogHelper {

    private String className;
    private BufferedWriter bw;

    public LogHelper(String className) {
        this.className = className;
    }

    public void Log(String message) {
        try {

            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            String stackMsg = new String();
            
            bw = new BufferedWriter(new FileWriter("rossy.log", true));
            
            Date date = new Date();
            bw.newLine();
            bw.write("Class name: " + this.className);
            bw.newLine();
//            bw.write("Stacktrace : " + stackMsg);
//            bw.newLine();
//            
//            for (StackTraceElement elm : stack) {
//                stackMsg += elm.getFileName() + " --  ";
//                stackMsg += elm.getClassName() + " --  "; 
//                stackMsg += elm.getMethodName();
//                bw.write(stackMsg);
//                bw.newLine();
//            }
            
            bw.write("Message: " + message);
            bw.newLine();
            bw.write("Date: " + date.toString());
            bw.newLine();
            bw.write("--------------------------------------------");

            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(LogHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}