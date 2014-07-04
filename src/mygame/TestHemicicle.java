/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import assets.entity.Hemiciclo;
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import java.util.Vector;
import java.util.logging.Logger;
 
/** Sample 4 - how to trigger repeating actions from the main update loop.
 * In this example, we make the player character rotate. */
public class TestHemicicle extends SimpleApplication {
 
    public static void main(String[] args){
        TestHemicicle app = new TestHemicicle();
        app.start();
    }
 
    protected Vector<Geometry> player = new Vector();
    protected Hemiciclo hemiciclo = new Hemiciclo("senado");
    protected BitmapText hudText;
    protected float time = 0.0f;
    private static final Logger LOG = Logger.getLogger(TestHemicicle.class.getName());
    
    
    @Override
    public void simpleInitApp() {
 
       setUpHUD();
       LOG.info("***** inicando hemiciclo");
       hemiciclo.afegirResultatPartit(ColorRGBA.Blue, 5, "Peso1");
       LOG.info(hemiciclo.toString());
       hemiciclo.afegirResultatPartit(ColorRGBA.Red, 15, "Peso2");
       hemiciclo.afegirResultatPartit(ColorRGBA.Green, 70, "Peso3");
       hemiciclo.afegirResultatPartit(ColorRGBA.Orange, 50, "Peso4");
       hemiciclo.afegirResultatPartit(ColorRGBA.Brown, 80, "Peso5");
       hemiciclo.afegirResultatPartit(ColorRGBA.Magenta, 10, "Peso6");
       hemiciclo.insertMesh(assetManager, rootNode);
       LOG.info(hemiciclo.toString());
       
       afegirLlum();
       setCam();
       flyCam.setEnabled(false);
       LOG.info("fin de preparacion de elementos");
//        rootNode.attachChild(player.elementAt(2));
        
         // Display a line of text with a default font
//        guiNode.detachAllChildren();
//        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
//        helloText = new BitmapText(guiFont, false);
//        helloText.setSize(guiFont.getCharSet().getRenderedSize());
//        helloText.setText("");
//        helloText.setLocalTranslation(300, helloText.getLineHeight(), 0);
//        guiNode.attachChild(helloText);
        
        

    }
   private void setUpHUD() {
        hudText = new BitmapText(guiFont, false);
        hudText.setSize(guiFont.getCharSet().getRenderedSize());      // font size
        hudText.setColor(ColorRGBA.Blue);                             // font color
        hudText.setText("Holita vecino");             // the text
        hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
        guiNode.attachChild(hudText);
    }
    /* This is the update loop */
    @Override
    public void simpleUpdate(float tpf) {
        hudText.setText(new Float(tpf).toString());
        LOG.fine("animando " + tpf);
        hemiciclo.animSegments(tpf);
//        time +=tpf;
//        // make the player rotate
//        player.elementAt(0).rotate(0, 2*tpf, 0); 
//        player.elementAt(1).rotate(0, 0, 2*2*tpf); 
//        float oscilation = new Double(Math.sin(
//                    (new Float(time)).doubleValue())).floatValue();
//        float move = 3.0f;
//        player.elementAt(1).setLocalTranslation(oscilation*move, 2.0f, 0);
//        helloText.setText((new Float(player.elementAt(1).getWorldTranslation().x)).toString());
//        System.out.println(oscilation*move);
//        System.out.flush();
    }

    private void afegirLlum() {
      
          // You must add a light to make the model visible
        AmbientLight general_light = new AmbientLight();
        general_light.setColor(ColorRGBA.White);
        rootNode.addLight(general_light);
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
//        rootNode.addLight(sun);

        /**
         * A white ambient light source.
         */
        Node be_endesa = new Node("luces");
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(new ColorRGBA(0.2f, 0.2f, 0.2f, 0.5f));

        be_endesa.addLight(ambient);
        /**
         * A white, directional light source
         */
        DirectionalLight sunny = new DirectionalLight();
        sunny.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sunny.setColor(ColorRGBA.White);
        rootNode.addLight(sunny);
        be_endesa.addLight(sunny);

        rootNode.attachChild(be_endesa);
        viewPort.setBackgroundColor(new ColorRGBA(0.98f, 0.98f, 0.98f, 1f));
    }

    private void setCam() {
       cam.setLocation(new Vector3f(2.7359283f, 10.253212f, 13.442588f));
       cam.setRotation(new Quaternion(-0.02497584f, 0.9614363f, -0.25753158f, -0.09324159f));
    }
}