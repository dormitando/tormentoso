/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mygame.Main;

/**
 *
 * @author jmd
 */
public class PropertiesFile {

    Properties prop;
    public PropertiesFile(String filename) throws IOException {
             String result = "";
        this.prop = new Properties();
        String propFileName = filename;
 
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            this.prop.load(inputStream);
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
    }
    
    public String get(String key){
        return  prop.getProperty(key);
    }
    
    
    
}
