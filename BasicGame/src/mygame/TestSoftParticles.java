/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.effect.shapes.EmitterBoxShape;
import com.jme3.effect.shapes.EmitterSphereShape;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.FogFilter;
import com.jme3.post.filters.TranslucentBucketFilter;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;

/**
 *
 * @author Nehon
 */
public class TestSoftParticles extends SimpleApplication {

    private boolean softParticles = true;
    private FilterPostProcessor fpp;
    private TranslucentBucketFilter tbf;
    private Node particleNode;

    public static void main(String[] args) {
        TestSoftParticles app = new TestSoftParticles();
        app.start();
    }

    @Override
    public void simpleInitApp() {

        cam.setLocation(new Vector3f(-7.2221026f, 4.1183004f, 7.759811f));
        cam.setRotation(new Quaternion(0.06152846f, 0.91236454f, -0.1492115f, 0.37621948f));

        flyCam.setMoveSpeed(10);


        // -------- floor
        Box b = new Box(Vector3f.ZERO, 10, 0.1f, 10);
        Geometry geom = new Geometry("Box", b);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Gray);
        mat.setTexture("ColorMap", assetManager.loadTexture("Interface/Logo/Monkey.jpg"));
        geom.setMaterial(mat);
        rootNode.attachChild(geom);

        Box b2 = new Box(Vector3f.ZERO, 1, 1, 1);
        Geometry geom2 = new Geometry("Box", b2);
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.DarkGray);
        geom2.setMaterial(mat2);
        rootNode.attachChild(geom2);
        geom2.setLocalScale(0.1f, 0.2f, 1);

        fpp = new FilterPostProcessor(assetManager);        
        tbf = new TranslucentBucketFilter(true);
        fpp.addFilter(tbf);
        viewPort.addProcessor(fpp);

        particleNode = new Node("particleNode");
        rootNode.attachChild(particleNode);
        
        createParticles();

        
        inputManager.addListener(new ActionListener() {

            public void onAction(String name, boolean isPressed, float tpf) {
                if(isPressed && name.equals("toggle")){
               //     tbf.setEnabled(!tbf.isEnabled());     
                    softParticles = !softParticles;
                    if(softParticles){
                        viewPort.addProcessor(fpp);
                    }else{
                        viewPort.removeProcessor(fpp);
                    }
                }
            }
        }, "toggle");
        inputManager.addMapping("toggle", new KeyTrigger(KeyInput.KEY_SPACE));
        
        // emit again
        inputManager.addListener(new ActionListener() {
            public void onAction(String name, boolean isPressed, float tpf) {
                if(isPressed && name.equals("refire")) {
                    //fpp.removeFilter(tbf); // <-- add back in to fix
                    particleNode.detachAllChildren();
                    createParticles();
                    //fpp.addFilter(tbf);
                }
            }
        }, "refire");
        inputManager.addMapping("refire", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
    }

    private void createParticles() {
        
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
        material.setTexture("Texture", assetManager.loadTexture("Effects/Explosion/flame.png"));
        material.setFloat("Softness", 3f); // 
        
        //Fire
        ParticleEmitter fire = new ParticleEmitter("Fire", ParticleMesh.Type.Triangle, 30);
        fire.setMaterial(material);
        fire.setShape(new EmitterSphereShape(Vector3f.ZERO, 0.1f));
        fire.setImagesX(2);
        fire.setImagesY(2); // 2x2 texture animation
        fire.setEndColor(new ColorRGBA(1f, 0f, 0f, 1f)); // red
        fire.setStartColor(new ColorRGBA(1f, 1f, 0f, 0.5f)); // yellow
        fire.setStartSize(0.6f);
        fire.setEndSize(0.01f);
        fire.setGravity(0, -0.3f, 0);
        fire.setLowLife(0.5f);
        fire.setHighLife(3f);
        fire.setLocalTranslation(0, 0.2f, 0);

        particleNode.attachChild(fire);
        
         Material material2 = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
        //material2.setTexture("Texture", assetManager.loadTexture("Textures/b3CloudTexture.jpg"));
        material2.setTexture("Texture", assetManager.loadTexture("Effects/Explosion/flame.png"));
        ParticleEmitter smoke = new ParticleEmitter("Smoke",
                ParticleMesh.Type.Triangle, 80);
        smoke.setMaterial(material2);
        smoke.setShape(new EmitterSphereShape(Vector3f.ZERO, 1));
//        smoke.setShape(new EmitterBoxShape(new Vector3f(3.5f,0.5f,0.52f), new Vector3f( 5f,1.5f,2f)));
        smoke.setImagesX(2);
        smoke.setImagesY(2); // 2x2 texture animation
        smoke.setStartColor(new ColorRGBA(0.1f, 0.1f, 0.1f,1f)); // dark gray
        smoke.setEndColor(new ColorRGBA(0.5f, 0.5f, 0.5f, 0.3f)); // gray      
        smoke.setStartSize(0.35f);
        smoke.setEndSize(0.5f);
        smoke.setGravity(0, -0.0001f, 0);
        smoke.setLowLife(50f);
        smoke.setHighLife(70f);
        smoke.setLocalTranslation(0, 0.1f, 0);   
        smoke.setRandomAngle(true);
        smoke.emitAllParticles();
        
        Node smokeNode = new Node("clouds");
        smokeNode.setLocalTranslation(0.0f, 5f, 0f);
        particleNode.attachChild(smokeNode);
        
        smokeNode.attachChild(smoke);
//       particleNode.attachChild(smoke);
       

    }
    
    
}