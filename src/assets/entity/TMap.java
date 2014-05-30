/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import java.util.ArrayList;

/**
 *
 * @author jmd
 */
public class TMap {
    private String name;
    private int position = 0;
    ArrayList <TItem> item;
    
    void TMap(){
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

    
    
}
