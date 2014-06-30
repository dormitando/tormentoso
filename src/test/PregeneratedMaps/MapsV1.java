/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.PregeneratedMaps;

import assets.entity.Dictionary;
import assets.entity.TCamera;
import assets.entity.TItem;
import assets.entity.TMap;
import assets.entity.TScene;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import java.util.ArrayList;

/**
 *
 * @author jmd
 */
public class MapsV1 {

    public TMap genMap1() {
        TMap mapa1 = new TMap();
        mapa1.setName("m1");
        ArrayList<TItem> aItems = new ArrayList<TItem>();

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("isla");
        aItems.get(aItems.size() - 1).setPos(2f, 0f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.BASIC_ELEVATION);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("isla");
        aItems.get(aItems.size() - 1).setPos(2f, 0f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.BASIC_ELEVATION);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo1");
        aItems.get(aItems.size() - 1).setPos(2f, 0f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo2");
        aItems.get(aItems.size() - 1).setPos(2f, 3f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN_MODEL);


        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo3");
        aItems.get(aItems.size() - 1).setPos(2f, 5f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);

        mapa1.setItem(aItems);

        return mapa1;
    }

    public TMap genMapNubes() {
        TMap mapa1 = new TMap();
        mapa1.setName("nubes");
        ArrayList<TItem> aItems = new ArrayList<TItem>();

//        aItems.add(new TItem());
//        aItems.get(aItems.size() - 1).setName("isla");
//        aItems.get(aItems.size() - 1).setPos(2f, 0f, -20f);
//        aItems.get(aItems.size() - 1).setType_item(Dictionary.BASIC_ELEVATION);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo1");
        aItems.get(aItems.size() - 1).setPos(2f, 10f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN_MODEL);
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo1");
        aItems.get(aItems.size() - 1).setPos(12f, 10f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_BOLT);
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo1");
        aItems.get(aItems.size() - 1).setPos(22f, 10f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_RAIN);
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo1");
        aItems.get(aItems.size() - 1).setPos(32f, 10f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo2");
        aItems.get(aItems.size() - 1).setPos(2f, 10f, -30f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_DARK);
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo2");
        aItems.get(aItems.size() - 1).setPos(12f, 10f, -30f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_DARK);
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo2");
        aItems.get(aItems.size() - 1).setPos(22f, 10f, -30f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_DARK);
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo2");
        aItems.get(aItems.size() - 1).setPos(32f, 10f, -30f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_DARK);

        mapa1.setItem(aItems);

        return mapa1;
    }

    public TMap genMap2() {
        TMap mapa1 = new TMap();
        mapa1.setName("m2");
        ArrayList<TItem> aItems = new ArrayList<TItem>();

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("miniSol");
        aItems.get(aItems.size() - 1).setPos(-2f, 8f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("sun001");
        aItems.get(aItems.size() - 1).setPos(-2f, 0f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo2");
        aItems.get(aItems.size() - 1).setPos(-2f, 3f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.BOX);


        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cubo2");
        aItems.get(aItems.size() - 1).setPos(-2f, 5f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN_MODEL);

        mapa1.setItem(aItems);

        return mapa1;
    }

    public TMap genMap3() {
        TMap mapa1 = new TMap();
        mapa1.setName("m3");
        ArrayList<TItem> aItems = new ArrayList<TItem>();

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("miniSol");
        aItems.get(aItems.size() - 1).setPos(0f, 8f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("cl1");
        aItems.get(aItems.size() - 1).setPos(0f, 4f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("miniSol");
        aItems.get(aItems.size() - 1).setPos(0f, 2f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("miniSol");
        aItems.get(aItems.size() - 1).setPos(0f, 0f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);

        mapa1.setItem(aItems);

        return mapa1;
    }

    public TMap genReference() {
        TMap mapa1 = new TMap();
        mapa1.setName("m3");
        ArrayList<TItem> aItems = new ArrayList<TItem>();

        for (int i = -10; i < 10; i++) {
            for (int j = -10; j < 10; j++) {
                aItems.add(new TItem());
                aItems.get(aItems.size() - 1).setName("miniSol");
                aItems.get(aItems.size() - 1).setPos(i * 10f, 0f, j * 10f);
                aItems.get(aItems.size() - 1).setType_item(Dictionary.SPHERE);
            }
        }

        mapa1.setItem(aItems);

        return mapa1;
    }

    public TMap genAgumon() {
        TMap mapa1 = new TMap();
        mapa1.setName("agumon");
        ArrayList<TItem> aItems = new ArrayList<TItem>();

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("agumon");
        aItems.get(aItems.size() - 1).setPos(0f, 8f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.AGUMON);

        mapa1.setItem(aItems);

        return mapa1;
    }

    public TMap genBaleares() {
        TMap mapa1 = new TMap();
        mapa1.setName("Baleares");
        ArrayList<TItem> aItems = new ArrayList<TItem>();

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("baleares");
        aItems.get(aItems.size() - 1).setPos(0f, 0f, 0f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.MAPA_BALEARES);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("bolt ibiza");
        aItems.get(aItems.size() - 1).setPos(-40f, 10f, -10f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_BOLT);
        mapa1.setItem(aItems);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("nube3");
        aItems.get(aItems.size() - 1).setPos(-30f, 10f, -40f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_RAIN);
        mapa1.setItem(aItems);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("nube solitaria");
        aItems.get(aItems.size() - 1).setPos(-10f, 10f, -40f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD_RAIN);
        mapa1.setItem(aItems);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("sun");
        aItems.get(aItems.size() - 1).setPos(-30f, 12f, -40f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);
        mapa1.setItem(aItems);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("sun");
        aItems.get(aItems.size() - 1).setPos(10f, 12f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);
        mapa1.setItem(aItems);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("sun");
        aItems.get(aItems.size() - 1).setPos(30f, 12f, -50f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.SUN);
        mapa1.setItem(aItems);

        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("nube4");
        aItems.get(aItems.size() - 1).setPos(20f, 12f, 40f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.CLOUD);
        mapa1.setItem(aItems);

        TCamera[] camaras = {new TCamera(new Vector3f(3.121f, 78.341f, 16.758f)),
            new TCamera(new Vector3f(-29.549942f, 21.233969f, 19.374535f)),
            new TCamera(new Vector3f(3.063681f, 37.992195f, 0.3624136f)),
            new TCamera(new Vector3f(38.067627f, 26.996294f, -33.66666f)),};
        camaras[0].setLookAt(new Vector3f(-10f, 0, -40f));
        camaras[1].setLookAt(new Vector3f(-40f, 0, -10f));
        camaras[2].setLookAt(new Vector3f(0f, 0, -40f));
        camaras[3].setLookAt(new Vector3f(35f, 0, -60f));
        mapa1.setCam(camaras);
        return mapa1;
    }

    public TMap genVolcano() {
        TMap mapa1 = new TMap();
        mapa1.setName("m3");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        System.out.println("setting volcano");
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("volcano");
        aItems.get(aItems.size() - 1).setPos(0f, 8f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.VOLCANO);

        mapa1.setItem(aItems);

        return mapa1;
    }

    public TMap genOcean() {
        TMap mapa1 = new TMap();
        mapa1.setName("ocean");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        System.out.println("setting ocean");
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("ISLA_CALAVERA");
        aItems.get(aItems.size() - 1).setPos(0f, -1f, -20f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.ISLA_CALAVERA);

        mapa1.setItem(aItems);

        return mapa1;
    }    
    public TMap genSenado() {
        TMap mapa1 = new TMap();
        mapa1.setName("senado");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        System.out.println("setting senado");
        aItems.add(new TItem());
        aItems.get(aItems.size() - 1).setName("ISLA_CALAVERA");
        aItems.get(aItems.size() - 1).setPos(0f, 0f, 0f);
        aItems.get(aItems.size() - 1).setType_item(Dictionary.ELEC_SENADO);

        mapa1.setItem(aItems);
        
         TCamera[] camaras = {new TCamera(new Vector3f(0,0,-20))};
        camaras[0].setLookAt(new Vector3f(0f, 0, 0f));
        mapa1.setCam(camaras);

        return mapa1;
    }

    public TScene genScene1() {
        TScene scene = new TScene();
        scene.setName("Test1");
        scene.addTMap(genBaleares());
        scene.addTMap(genMapNubes());
//        scene.addTMap(genMap3());
//        scene.addTMap(genOcean());
//        scene.addTMap(genMap1());
        scene.addTMap(genVolcano());
        scene.addTMap(genAgumon());
//        scene.addTMap(genMap2());
        return scene;
    }

    public TScene genScene2() {
        TScene scene = new TScene();
        scene.setName("Test2");
        scene.addTMap(genBaleares());
        scene.addTMap(genMapNubes());
        scene.addTMap(genPedestales());
        scene.addTMap(genSenado());

        return scene;
    }

    private TMap genPedestales() {
        TMap mapa1 = new TMap();
        mapa1.setName("pedestales");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        for (int i = 0; i < 10; i++) {
            aItems.add(new TItem());
            aItems.get(aItems.size() - 1).setName("pedestal_"+i);
            aItems.get(aItems.size() - 1).setPos(i*3f, 0f, 0f);
            aItems.get(aItems.size() - 1).setType_item(Dictionary.EL_PEDESTAL);

            TCamera[] camaras = {new TCamera(new Vector3f(3.121f, 78.341f, 16.758f)),
            new TCamera(new Vector3f( 9.618516f, 7.1798444f, 29.095222f))
//                    ,
//            new TCamera(new Vector3f(3.063681f, 37.992195f, 0.3624136f)),
//            new TCamera(new Vector3f(38.067627f, 26.996294f, -33.66666f)),
            };
        camaras[0].setLookAt(new Vector3f(-0f, 0, -20f));
        camaras[0].setOrientation(new Quaternion(3.5894738E-4f, 0.99699795f, -0.071879365f, 0.028780898f));
//        camaras[1].setLookAt(new Vector3f(-40f, 0, -10f));
//        camaras[2].setLookAt(new Vector3f(0f, 0, -40f));
//        camaras[3].setLookAt(new Vector3f(35f, 0, -60f));
//            9.618516            , 7.1798444, 29.095222
            mapa1.setItem(aItems);
        }

        return mapa1;
    }
}
