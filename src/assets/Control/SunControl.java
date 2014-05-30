/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.Control;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author jmd
 */
public class SunControl extends AbstractControl{

    private float speed = 1.0f;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    
    @Override
    protected void controlUpdate(float tpf) {
        spatial.rotate(0, 0, speed*tpf);
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
    
    public Control cloneForSpatial(Spatial spatial){
        SunControl control = new SunControl();
        control.setSpeed(speed);
        control.setSpatial(spatial);
        return control;
        
    }
    
    
}
