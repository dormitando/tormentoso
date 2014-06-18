/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;

/**
 *
 * @author jmd
 */
public class TCamera {
    private Vector3f position;
    private Quaternion orientation;
    private Vector3f lookAt;

    public TCamera(Vector3f position, Quaternion orientation) {
        this.position = position;
        this.orientation = orientation;
    }
    public TCamera(Vector3f position) {
        this.position = position;
    }

    
    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Quaternion getOrientation() {
        return orientation;
    }

    public void setOrientation(Quaternion orientation) {
        this.orientation = orientation;
    }

    public Vector3f getLookAt() {
        return lookAt;
    }

    public void setLookAt(Vector3f lookAt) {
        this.lookAt = lookAt;
    }
    
    
    
}
