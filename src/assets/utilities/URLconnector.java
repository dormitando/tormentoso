/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

/**
 *
 * @author jmd
 */
public class URLconnector {

    private Logger  log = Logger.getLogger(this.getClass().toString());

    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(result);
        return result;
    }

    public static void main(String args[]) {
        URLconnector connector = new URLconnector();
        connector.getHTML("http://localhost/html5/escena.json");

    }
}
