/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

/**
 *
 * @author jmd
 */
public class TItem {
    
    String name = "";
    float px = 0f, py = 0f, pz = 0f;
    String text;
    String type_item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPx() {
        return px;
    }

    public void setPx(float px) {
        this.px = px;
    }

    public float getPy() {
        return py;
    }

    public void setPy(float py) {
        this.py = py;
    }

    public float getPz() {
        return pz;
    }

    public void setPz(float pz) {
        this.pz = pz;
    }
    
    public void setPos(float px,float  py,float  pz){
        this.px = px;
        this.py = py;
        this.pz = pz;
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
