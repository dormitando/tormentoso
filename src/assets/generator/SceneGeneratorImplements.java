/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.generator;

import assets.entity.Dictionary;
import assets.entity.THarvester;
import assets.entity.TMap;
import assets.entity.TScene;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 *
 * @author jmd
 */
public class SceneGeneratorImplements implements SceneGeneratorInterface {

    private Logger log = Logger.getLogger(this.getClass().toString());

    @Override
    public TScene loadSceneURL(String url) {
         
        
        
        TScene escena = new TScene();
        THarvester harvester = new THarvester();
        harvester.loadScene(url);//"http://localhost/html5/escena.json");
        escena.setName(harvester.getField(Dictionary.CAMPS_ESCENA.get("nom")));
       
        escena.setDescrition(harvester.getField(Dictionary.CAMPS_ESCENA.get("descripcio")));
        log.info("diccionar.camps escena.mapa " + Dictionary.CAMPS_ESCENA.get("mapa"));
         Iterator<?> keys = harvester.listMaps();
         while( keys.hasNext() ){
            String key = (String)keys.next();
            log.info("key " + key);
             TMap map = harvester.loadMap(key);
             escena.addTMap(map);
        }
        log.info("Escena preparada");
        return escena;

    }

    public static void main(String args[]) {
        SceneGeneratorInterface sceneGen = new SceneGeneratorImplements();
        TScene escena;
        escena = sceneGen.loadSceneURL("http://localhost/html5/escena.json");
    }
}
