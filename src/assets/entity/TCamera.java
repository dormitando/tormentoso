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
public class TCamera {
    private Vector3f position;
    private Vector3f orientation;

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getOrientation() {
        return orientation;
    }

    public void setOrientation(Vector3f orientation) {
        this.orientation = orientation;
    }
    
    
    
}
