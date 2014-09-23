/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jmd
 */
public class Dictionary {

    public static final String SPHERE = "sphere";
    public static final String EL_PEDESTAL = "pedestal";
    public static final String SUN = "sun";
    public static final String SUN_MODEL = "sun001";
    public static final String FLOOR = "floor";
    public static final String BOX = "box";
    public static final String MAP_NEXT = "next map";
    public static final String MAP_PREVIUS = "previus map";
    public static final String AGUMON = "previus map";
    public static final String VOLCANO = "volcano";
    public static final String OCEAN = "ocean";
    public static final String CLOUD = "cloud";
    public static final String CLOUD_DARK = "dark cloud";
    public static final String CLOUD_RAIN = "rain cloud";
    public static final String CLOUD_BOLT = "bolt cloud";
    public static final String BASIC_ELEVATION = "basic elevation";
    public static final String ISLA_CALAVERA = "ISLA_CALAVERA";
    public static final String MAPA_BALEARES = "islas baleares";
    public static final String ELEC_SENADO = "SENADO";
    public static final String ANIMATE_SCENE = "Animar escena";
    public static final String SENADO = "senado";
    
    public static final String NOM = "nom";
    public static final String DESCRIPCIO = "descripcio";
    public static final String ELEMENT = "element";
    public static final String MAPA = "mapa";
    public static final String TIPUS_ELEMENT = "tipus_element";
    public static final String TIPUS_CAMERA = "camera";
    
    public static Map<String, String> CAMPS_ESCENA = new HashMap();
    static{
        Map map = new HashMap();
        map.put("nom", "nom");
        map.put("descripcio", "descripcio");
        map.put("element", "element");
        map.put("mapa", "mapa");
        map.put("tipus_element", "tipus_element");
        
        map.put("posicio", "posicio");
        map.put("px", "top");
        map.put("pz", "left");
        map.put("rotacio", "rotacio");
        map.put("valor", "valor");
        map.put("texte", "texte");
        map.put("background_balears", Dictionary.MAPA_BALEARES);
        map.put("background_balearsx3", Dictionary.ISLA_CALAVERA);
        map.put("background_maritim", Dictionary.MAPA_BALEARES);
        map.put("background_peninsula", Dictionary.MAPA_BALEARES);
        map.put("background", "background");
        
        map.put("sol", Dictionary.SUN);
        map.put("nuvol", Dictionary.CLOUD);
        map.put("rajos", Dictionary.CLOUD_BOLT);
        map.put("neu", Dictionary.SPHERE);
        map.put("pluja", Dictionary.CLOUD_RAIN);
        
        CAMPS_ESCENA = Collections.unmodifiableMap(map);
    }
}

