/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import assets.utilities.Tools;
import assets.utilities.URLconnector;
import com.jme3.math.Vector3f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author jmd
 */
public class THarvester {

    private Logger log = Logger.getLogger(this.getClass().toString());
    private JSONObject json;

    /**
     * retorna un JSONObject amb les dades del escenari
     */
    public void loadScene(String url) {
        URLconnector urlcon = new URLconnector();
        String jsonString = urlcon.getHTML("http://localhost/html5/escena.json");
        this.json = new JSONObject(jsonString);
        log.info("importado " + Dictionary.CAMPS_ESCENA.get("nom"));

    }

    public static void main(String args[]) {
        THarvester harvester = new THarvester();
        harvester.loadScene("http://localhost/html5/escena.json");
//        System.out.println("listo calisto " + json.getString("autor"));
    }

    public String getField(String field) {
        try {
            return json.getString(Dictionary.CAMPS_ESCENA.get(field));
        } catch (Exception e) {
            return "";
        }
    }

    public Iterator<?> listMaps() {
        JSONObject localjson = this.json.getJSONObject("mapa");
        return localjson.keys();
    }

    public TMap loadMap(String mapName) {
        TMap mapa1 = new TMap();
        mapa1.setName(mapName);
        JSONObject contentMap = this.json.getJSONObject("mapa").getJSONObject(mapName);
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        ArrayList<TCamera> camaras = new ArrayList<>();
//        TCamera[] camaras = null;
        Iterator<?> keys = contentMap.getJSONObject(
                Dictionary.CAMPS_ESCENA.get("element")).keys();
        String nomMapa = contentMap.getString(Dictionary.CAMPS_ESCENA.get("nom"));

        String background = contentMap.getString(Dictionary.CAMPS_ESCENA.get("background"));
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName(nomMapa);
        aItems.get(aItems.size() - 1).setPos(0f, 0f, 0f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CAMPS_ESCENA.get(background));
        //afegim la càmara inicial
        TCamera cam = new TCamera(new Vector3f(0, 115.320496f, 12.418017f));
        cam.setLookAt(new Vector3f(0, 0, -30f));
        camaras.add(cam);
        while (keys.hasNext()) {
            String key = (String) keys.next();
            log.info("key " + key);
            //TMap map = harvester.loadMap(key);
            JSONObject item = contentMap.getJSONObject(
                    Dictionary.CAMPS_ESCENA.get("element")).getJSONObject(key);
            JSONObject position = item.getJSONObject(
                    Dictionary.CAMPS_ESCENA.get("posicio"));
            String typeElement = item.getString(
                    Dictionary.CAMPS_ESCENA.get("tipus_element"));
            String texte;
            try {
                texte = item.getString(
                        Dictionary.CAMPS_ESCENA.get(Dictionary.TEXTE));
            } catch (Exception e) {
                texte = null;
            }
            Float px, pz;
            Tools tool = new Tools();
            Integer pos;


            switch (typeElement) {
                case Dictionary.TIPUS_CAMERA:
                    log.fine("carregant camera");
                    px = new Float(position.getDouble(Dictionary.CAMPS_ESCENA.get("px")));
                    pz = new Float(position.getDouble(Dictionary.CAMPS_ESCENA.get("pz")));
                    try {
                        pos = new Integer(texte);
                    } catch (Exception e) {
                        pos = camaras.size();
                    }
                    cam = new TCamera(tool.normalize(new Vector3f(px + 60f, 30f, pz)));
                    cam.setLookAt(tool.normalize(new Vector3f(px, 0f, pz)));

//                    camaras.add
                    if (pos<camaras.size()){
                        camaras.add(pos.intValue(), cam);
                    }else{
                        camaras.add(cam);
                    }
                    break;
                default:
                    aItems.add(new TItem());
                    aItems.get(aItems.size() - 1).setName(key);
                    aItems.get(aItems.size() - 1).setType_item(Dictionary.CAMPS_ESCENA.get(typeElement));
                    px = new Float(position.getDouble(Dictionary.CAMPS_ESCENA.get("px")));
                    pz = new Float(position.getDouble(Dictionary.CAMPS_ESCENA.get("pz")));
                    aItems.get(aItems.size() - 1).setPos(tool.normalize(new Vector3f(px.floatValue(), 10f, pz.floatValue())));
//                    aItems.get(aItems.size() -1).setPos(tool.normalize(px.floatValue(), 10f, pz.floatValue()));
                    break;
            }
        }
        mapa1.setItem(aItems);
        mapa1.setCam(camaras);
        return mapa1;
    }
}
