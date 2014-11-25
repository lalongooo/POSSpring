/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.settings;

import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.ParamHelper;
import com.puntodeventa.global.Util.TagHelper;
import java.io.File;

/**
 * @author USER
 */
public class Init {

    private static LogHelper objLog = new LogHelper("jfrmSplash");

    public static void onInit() {

        //Add runtime before exit event
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                String fileName = ParamHelper.getParam("usr_srlzd_fl_nm").toString();
                File file = new File(fileName);
                file.delete();

                fileName = ParamHelper.getParam("ssn_srlzd_fl_nm").toString();                
                file = new File(fileName);
                file.delete();
            }
        }));

        //Set the look and feel configurations
        initialLookAndFeelSettings();
    }

    private static void initialLookAndFeelSettings() {

        String lookAndFeelName = ParamHelper.getParam("system.lookAndFeelName").toString();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (lookAndFeelName.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.put("OptionPane.cancelButtonText", TagHelper.getTag("OptionPane.cancelButtonText"));
                    javax.swing.UIManager.put("OptionPane.noButtonText", TagHelper.getTag("OptionPane.noButtonText"));
                    javax.swing.UIManager.put("OptionPane.okButtonText", TagHelper.getTag("OptionPane.okButtonText"));
                    javax.swing.UIManager.put("OptionPane.yesButtonText", TagHelper.getTag("OptionPane.yesButtonText"));
                    javax.swing.UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            objLog.Log(ex.getMessage());
        }
    }
}
