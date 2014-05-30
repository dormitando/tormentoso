/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import com.jme3.scene.Node;
import java.util.ArrayList;

/**
 *
 * @author jmd
 */
public class TScene {
    String name = "";
    String descrition = "";
    ArrayList<TMap> maps = new ArrayList<TMap>();;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public ArrayList<TMap> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<TMap> maps) {
        this.maps = maps;
    }
    
    public void addTMap(TMap map){
        maps.add(map);
    }
}
