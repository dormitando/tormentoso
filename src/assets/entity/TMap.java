/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import com.jme3.cinematic.MotionPath;
import java.util.ArrayList;

/**
 *
 * @author jmd
 */
public class TMap {
    private String name;
    private int position = 0;
    ArrayList <TItem> item;
    private ArrayList <TCamera> cam; //posiciones y orientaciones de la camara
    private MotionPath path = new MotionPath();
    
    void TMap(){
        path.setCycle(true);
        path.setCurveTension(0.83f);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TItem getItem(int pos) {
        this.position = pos;
        try {
            return item.get(pos);
        } catch (Exception e) {
            return null;
        }
    }
    public TItem firstItem(){
        this.position = 0;
        return getItem(this.position);
    }
    public TItem nextItem(){
        this.position++;
        if (this.position>= item.size()){
            return null;
        }
        return this.getItem(this.position);
    }

    public void setItem(ArrayList<TItem> item) {
        this.item = item;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ArrayList<TCamera> getCam() {
        
        return cam;
    }

    public void setCam(ArrayList<TCamera> cam) {
        this.cam = cam;
        for (TCamera c: cam){
            path.addWayPoint(c.getPosition());
        }
    }
    public MotionPath getMotionpath(){
        return this.path;
    }

    
    
}
