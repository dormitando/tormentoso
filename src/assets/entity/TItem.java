/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import com.jme3.math.Vector3f;

/**
 *
 * @author jmd
 */
public class TItem {
    
    String name = "";
   
    Vector3f pos,rot,scale;
    String text;
    String type_item;

    public TItem(){
        pos = new Vector3f(0,0,0);
        rot = new Vector3f(0,0,0);
        scale = new Vector3f(1f,1f,1f);
        text = new String("");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPos(float x, float y, float z){
        pos = new Vector3f(x, y, z);
    }
    public void setScale(float x, float y, float z){
        this.scale = new Vector3f(x, y, z);
    }
    public void setRot(float x, float y, float z){
        this.rot = new Vector3f(x, y, z);
    }

    public float getPx() {
        return pos.x;
    }

    public float getPy() {
        return pos.y;
    }

    public float getPz() {
        return pos.z;
    }

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    public Vector3f getRot() {
        return rot;
    }

    public void setRot(Vector3f rot) {
        this.rot = rot;
    }

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

   
    
   
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType_item() {
        return type_item;
    }

    public void setType_item(String type_item) {
        this.type_item = type_item;
    }
    
    
}
