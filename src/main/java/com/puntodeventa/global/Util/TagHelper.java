package com.puntodeventa.global.Util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Jorge Hernandez
 */
public class TagHelper {
    
    private static final LogHelper objLog = new LogHelper("TagHelper");
    private static final Properties prop = new Properties();

    public static String getTag(String tagName) {

        
        String returnValue = "";
        
        try {
            prop.load(TagHelper.class.getResourceAsStream("/tags.properties"));
            returnValue =  prop.getProperty(tagName).toString();

        } catch (IOException ex) {
            objLog.Log("Possible cause: Tag " + tagName + " not found."  + ex.getMessage());
        }
        
        return returnValue;
    }
}
