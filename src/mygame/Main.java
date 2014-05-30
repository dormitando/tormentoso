package mygame;

import assets.entity.Dictionary;
import assets.entity.TMap;
import assets.entity.TScene;
import assets.generator.AssetGeneratorImplements;
import assets.generator.AssetGeneratorInterface;
import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;
import java.util.ArrayList;
import test.PregeneratedMaps.MapsV1;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication  {

    ArrayList<Node> maps = new ArrayList<Node>();
    TScene scene = new TScene();
    Integer mapsIndex = new Integer(-1);
    Node rotating_scene = new Node("rotating_scene");
    private AnimChannel channel;
    private AnimControl control;

    public static void main(String[] args) {
        Main app = new Main();

        app.start();
    }

    @Override
    public void simpleInitApp() {

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
        ambient.setColor(ColorRGBA.White);
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
        viewPort.setBackgroundColor(ColorRGBA.Blue);
        selftest();

        rootNode.attachChild(rotating_scene);

        initKeys();
    }

    private void initKeys() {
        //deshabilitar movimiento de camara
//        flyCam.setEnabled(false);
        flyCam.setMoveSpeed(flyCam.getMoveSpeed() * 10);

        inputManager.addMapping(Dictionary.MAP_NEXT, new KeyTrigger(KeyInput.KEY_ADD));
        inputManager.addMapping(Dictionary.MAP_PREVIUS, new KeyTrigger(KeyInput.KEY_MINUS));
        inputManager.addListener(actionListener,
                new String[]{Dictionary.MAP_PREVIUS,
            Dictionary.MAP_NEXT});
//        System.out.println("keys iniciadas");
    }
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            Node node = rotating_scene;
//            System.out.println("iniciando key " + name + "key" + keyPressed);
            if (name.equals(Dictionary.MAP_NEXT) && keyPressed) {
                if (mapsIndex < maps.size() - 1) {
                    try {
                        node.detachChildNamed(maps.get(mapsIndex.intValue()).getName());
                    } catch (Exception e) {
                    }
                    mapsIndex = (mapsIndex + 1) % maps.size();
//                    System.out.println("mapsIndex " + mapsIndex);
                    node.attachChild(maps.get(mapsIndex));
                }
            }
            if (name.equals(Dictionary.MAP_PREVIUS) && keyPressed) {
                if (mapsIndex > 0) {
                    try {
                        node.detachChildNamed(maps.get(mapsIndex.intValue()).getName());
                    } catch (Exception e) {
                    }
                    mapsIndex = (mapsIndex - 1) % maps.size();
//                    System.out.println("mapsIndex " + mapsIndex);
                    node.attachChild(maps.get(mapsIndex));
                }
            }

        }
    };

    private void selftest() {
        AssetGeneratorInterface agen = new AssetGeneratorImplements() {
        };

        MapsV1 testMap = new MapsV1();

        rootNode.attachChild(agen.makeReference(assetManager));
        this.scene = testMap.genScene1();
        for (TMap scenemaps : this.scene.getMaps()) {
            maps.add(agen.makeMap(assetManager, scenemaps));
        }
    }

}
