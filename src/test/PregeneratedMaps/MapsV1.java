/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.PregeneratedMaps;

import assets.entity.Dictionary;
import assets.entity.TItem;
import assets.entity.TMap;
import assets.entity.TScene;
import java.util.ArrayList;

/**
 *
 * @author jmd
 */
public class MapsV1 {
    
    public TMap genMap1(){
        TMap mapa1 = new TMap();
        mapa1.setName("m1");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("miniSol");
        aItems.get(aItems.size()-1).setPos(2f, 8f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.SUN);
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("cubo1");
        aItems.get(aItems.size()-1).setPos(2f, 0f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.CLOUD);
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("cubo2");
        aItems.get(aItems.size()-1).setPos(2f, 3f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.SUN_MODEL);
        
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("cubo3");
        aItems.get(aItems.size()-1).setPos(2f, 5f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.BOX);
        
        mapa1.setItem(aItems);
        
        return mapa1;
    }
    
    public TMap genMap2(){
        TMap mapa1 = new TMap();
        mapa1.setName("m2");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("miniSol");
        aItems.get(aItems.size()-1).setPos(-2f, 8f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.SUN);
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("sun001");
        aItems.get(aItems.size()-1).setPos(-2f, 0f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.CLOUD);
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("cubo2");
        aItems.get(aItems.size()-1).setPos(-2f, 3f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.BOX);
        
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("cubo2");
        aItems.get(aItems.size()-1).setPos(-2f, 5f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.SUN_MODEL);
        
        mapa1.setItem(aItems);
        
        return mapa1;
    }
    
    public TMap genMap3(){
        TMap mapa1 = new TMap();
        mapa1.setName("m3");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("miniSol");
        aItems.get(aItems.size()-1).setPos(0f, 8f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.SUN);
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("cl1");
        aItems.get(aItems.size()-1).setPos(0f, 4f,-20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.CLOUD);
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("miniSol");
        aItems.get(aItems.size()-1).setPos(0f, 2f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.SUN);
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("miniSol");
        aItems.get(aItems.size()-1).setPos(0f, 0f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.SUN);
        
        mapa1.setItem(aItems);
        
        return mapa1;
    }
    public TMap genReference(){
        TMap mapa1 = new TMap();
        mapa1.setName("m3");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        
        for (int i = -10; i < 10; i++) {
            for (int j = -10; j < 10; j++) {
                 aItems.add(new TItem());
                aItems.get(aItems.size()-1).setName("miniSol");
                aItems.get(aItems.size()-1).setPos(i*10f, 0f, j*10f);
                aItems.get(aItems.size()-1).setType_item(Dictionary.SPHERE);
            }
        }
        
        mapa1.setItem(aItems);
        
        return mapa1;
    }
    
    public TMap genAgumon(){
        TMap mapa1 = new TMap();
        mapa1.setName("agumon");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("agumon");
        aItems.get(aItems.size()-1).setPos(0f, 8f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.AGUMON);
        
        mapa1.setItem(aItems);
        
        return mapa1;
    }
    
    public TMap genVolcano(){
        TMap mapa1 = new TMap();
        mapa1.setName("m3");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        System.out.println("setting volcano");
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("volcano");
        aItems.get(aItems.size()-1).setPos(0f, 8f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.VOLCANO);
        
        mapa1.setItem(aItems);
        
        return mapa1;
    }
    public TMap genOcean(){
        TMap mapa1 = new TMap();
        mapa1.setName("ocean");
        ArrayList<TItem> aItems = new ArrayList<TItem>();
        System.out.println("setting ocean");
        aItems.add(new TItem());
        aItems.get(aItems.size()-1).setName("ocean");
        aItems.get(aItems.size()-1).setPos(0f, -1f, -20f);
        aItems.get(aItems.size()-1).setType_item(Dictionary.OCEAN);
        
        mapa1.setItem(aItems);
        
        return mapa1;
    }
    
    public TScene genScene1(){
        TScene scene = new TScene();
        scene.setName("Test1");
        scene.addTMap(genOcean());
        scene.addTMap(genMap1());
        scene.addTMap(genVolcano());
        scene.addTMap(genAgumon());
        scene.addTMap(genMap2());
        scene.addTMap(genMap3());
        return scene;
    }
    
}