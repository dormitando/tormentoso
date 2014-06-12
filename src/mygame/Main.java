package mygame;

import assets.entity.Dictionary;
import assets.entity.TMap;
import assets.entity.TScene;
import assets.generator.AssetGeneratorImplements;
import assets.generator.AssetGeneratorInterface;
import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Plane;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.FogFilter;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Quad;
import com.jme3.water.SimpleWaterProcessor;
import java.util.ArrayList;
import test.PregeneratedMaps.MapsV1;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private ArrayList<Node> maps = new ArrayList<Node>();
    private TScene scene = new TScene();
    private Integer mapsIndex = new Integer(-1);
    private Node rotating_scene = new Node("rotating_scene");
    private Node reflexing_water = new Node("reflexing water");
    private BitmapText hudText;
    private AnimChannel channel;
    private AnimControl control;
    private FilterPostProcessor fpp;
    private FogFilter fog;

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
        addBackground();
        rootNode.attachChild(reflexing_water);
        reflexing_water.attachChild(rotating_scene);

        initKeys();
        setUpHUD();
        addWater();

        selftest();
    }

     /* This is the update loop */
    @Override
    public void simpleUpdate(float tpf) {
        Vector3f v = cam.getLocation();
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
    private void initKeys() {
        //deshabilitar movimiento de camara
//        flyCam.setEnabled(false);
        cam.setLocation(new Vector3f(3.121f, 78.341f, 16.758f));
        cam.setRotation(new Quaternion(-0.0356f, 0.8491f, -0.5244f, -0.05438f));
        flyCam.setMoveSpeed(flyCam.getMoveSpeed() * 10);
        setDisplayStatView(false);
        inputManager.addMapping(Dictionary.MAP_NEXT, new KeyTrigger(KeyInput.KEY_ADD));
        inputManager.addMapping(Dictionary.MAP_PREVIUS, new KeyTrigger(KeyInput.KEY_MINUS));
        inputManager.addMapping("cam_info", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(actionListener,
                new String[]{Dictionary.MAP_PREVIUS,
            Dictionary.MAP_NEXT, "cam_info"});
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
            System.out.println("onAction " + name);
            if (name.equals("cam_info") && keyPressed) {
                hudText.setText(cam.getRotation().toString());
            }
//            hudText.setText(maps.get(mapsIndex).getName());

        }
    };

    private void selftest() {
        AssetGeneratorInterface agen = new AssetGeneratorImplements() {
        };

        MapsV1 testMap = new MapsV1();

//        rootNode.attachChild(agen.makeReference(assetManager));
        this.scene = testMap.genScene1();
        for (TMap scenemaps : this.scene.getMaps()) {
            maps.add(agen.makeMap(assetManager, scenemaps, hudText));
        }
    }

    private void addWater() {
// we create a water processor
        SimpleWaterProcessor waterProcessor = new SimpleWaterProcessor(assetManager);
        waterProcessor.setReflectionScene(reflexing_water);

// we set the water plane
        Vector3f waterLocation = new Vector3f(0, 0, 0);
        waterProcessor.setPlane(new Plane(Vector3f.UNIT_Y, waterLocation.dot(Vector3f.UNIT_Y)));
        viewPort.addProcessor(waterProcessor);

// we set wave properties
        waterProcessor.setWaterDepth(40);         // transparency of water
        waterProcessor.setDistortionScale(0.05f); // strength of waves
        waterProcessor.setWaveSpeed(0.05f);       // speed of waves

// we define the wave size by setting the size of the texture coordinates
        Quad quad = new Quad(400, 400);
        quad.scaleTextureCoordinates(new Vector2f(6f, 6f));

// we create the water geometry from the quad
        Geometry water = new Geometry("water", quad);
        water.setLocalRotation(new Quaternion().fromAngleAxis(-FastMath.HALF_PI, Vector3f.UNIT_X));
        water.setLocalTranslation(-200, 0, 250);
        water.setShadowMode(ShadowMode.Receive);
        water.setMaterial(waterProcessor.getMaterial());
        rootNode.attachChild(water);
    }

    private void addBackground() {
        AssetGeneratorInterface agen = new AssetGeneratorImplements() {
        };
        reflexing_water.attachChild(agen.makeSky(assetManager, "reflex_sky"));

//        fpp = new FilterPostProcessor(assetManager);
//        fog = new FogFilter();
//        fog.setFogColor(new ColorRGBA(0.9f, 0.9f, 0.9f, 0.8f));
//        fog.setFogDistance(800);
//        
//        fog.setFogDensity(1.5f);
//        fpp.addFilter(fog);
//        viewPort.addProcessor(fpp);
        // Excluding sky bucket
//        fog.setExcludeSky(true);
    }

    private void setUpHUD() {
        hudText = new BitmapText(guiFont, false);
        hudText.setSize(guiFont.getCharSet().getRenderedSize());      // font size
        hudText.setColor(ColorRGBA.Blue);                             // font color
        hudText.setText("Holita vecino");             // the text
        hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
        guiNode.attachChild(hudText);
    }
}
