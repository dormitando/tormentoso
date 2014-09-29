package mygame;

import assets.entity.Dictionary;
import assets.entity.TCamera;
import assets.entity.TMap;
import assets.entity.TScene;
import assets.generator.AssetGeneratorImplements;
import assets.generator.AssetGeneratorInterface;
import assets.generator.SceneGeneratorImplements;
import assets.generator.SceneGeneratorInterface;
import assets.utilities.PropertiesFile;
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
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Quad;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;
import com.jme3.water.SimpleWaterProcessor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
    private Logger log = Logger.getLogger(this.getClass().toString());
    private TCamera[] cams = {null, null};
    private TCamera camActual = null;
    private float camSpeed = 10f;
    private Integer camOrder = 0;
    private boolean camMove = false;
    private boolean animSenado = false;
    private Spatial animScale;
    private float tiempoTotal = 0;
    private Node senado;
    final static Frame viewer = new Frame("Viewer");

    public static void main(String[] args) {

//        Main app = new Main();


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GraphicsDevice[] lDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
                int i = 1;
                GraphicsDevice device = lDevice[2];

                AppSettings settings = new AppSettings(true);
                settings.setSettingsDialogImage("Interface/splashScreen/Mosca_positiu_1.jpg");

                Main canvasApplication = new Main();
                canvasApplication.setPauseOnLostFocus(false);
                canvasApplication.setSettings(settings);
                canvasApplication.createCanvas(); // create canvas!
                JmeCanvasContext ctx = (JmeCanvasContext) canvasApplication.getContext();
//                ctx.setAutoFlushFrames(true);
//                ctx.
                ctx.setSystemListener(canvasApplication);
                Dimension dim = new Dimension(1920, 1080);
                ctx.getCanvas().setPreferredSize(dim);

                JFrame window = new JFrame("Swing Application");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel(new FlowLayout()); // a panel
//// add all your Swing components ...
//                panel.add(new JButton("Some Swing Component"));
// add the JME canvas
                panel.add(ctx.getCanvas());
                panel.setBorder(new EmptyBorder(1, 1, 1, 1));
//                panel.set

                settings.setWidth(1920);
                settings.setHeight(1080);
                settings.setTitle("Temps");
//                window.setUndecorated(true);

//                device.setFullScreenWindow(window);
//                device.setDisplayMode(new java.awt.DisplayMode(1024, 768, 32, 60));
                

                ctx.setSettings(settings);

                window.setLocation(1920, 0);
                window.add(panel);
                window.pack();
                window.setVisible(true);



//                canvasApplication.startCanvas();
                canvasApplication.paused = false;
                canvasApplication.startCanvas(false);
            }
        });


//        settings = settings.


//
//        app.createCanvas();
//        settings.setRenderer(AppSettings.LWJGL_OPENGL1);


//        final JmeCanvasContext context = (JmeCanvasContext) app.getContext();
//
// instantiate the viewer frame to provide fake fullscreen

//        viewer.add(context.getCanvas());
//        viewer.setUndecorated(true);
//        viewer.setVisible(true);
//        viewer.setSize(1920, 1080);
////        viewer.setLocation(1920, 0);
////        viewer.setAlwaysOnTop(true);
//        viewer.setVisible(true);

//        device.setDisplayMode(device.getDisplayMode());
//        app.setSettings(settings);
//        app.start();

//        device.setFullScreenWindow(viewer);
//
//        device.setDisplayMode(new java.awt.DisplayMode(1920, 1080, 32, 60));


    }

    @Override
    public void simpleInitApp() {

        flyCam.setDragToRotate(true);
        // You must add a light to make the model visible
        AmbientLight general_light = new AmbientLight();
        general_light.setColor(ColorRGBA.White);
        rootNode.addLight(general_light);
//        DirectionalLight sun = new DirectionalLight();
//        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
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

        viewPort.setBackgroundColor(ColorRGBA.Blue);
        addBackground();
        rootNode.attachChild(reflexing_water);
        reflexing_water.attachChild(rotating_scene);

        initKeys();
        setUpHUD();
//        addWater();
        SceneGeneratorInterface sceneGen = new SceneGeneratorImplements();
        TScene escena;
        try {
            PropertiesFile prop = new PropertiesFile("cnf/properties.txt");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        escena = sceneGen.loadSceneURL("http://localhost/html5/escena.json");
        this.scene = escena;
        loadScene(escena);
//        AssetGeneratorInterface agen = new AssetGeneratorImplements() {
//        };
//        for (TMap scenemaps : this.scene.getMaps()) {
//            maps.add(agen.makeMap(assetManager, scenemaps, hudText));
//        }
//        hudText.setText(this.scene.getName());
    }

    /* This is the update loop */
    @Override
    public void simpleUpdate(float tpf) {
        Vector3f v = null;
        if (camMove) {
            if (cams[0] != null && cams[1] != null) {
                Vector3f posActual = camActual.getPosition();
                Vector3f posFinal = cams[1].getPosition();
                float distInicial = camActual.getPosition().distance(posFinal);
                float lookInicial = camActual.getLookAt().distance(cams[1].getLookAt());
//                log.info("camActual " + camActual.getPosition());
                camActual.setPosition(animaVector(tpf,
                        cams[0].getPosition(),
                        cams[1].getPosition(),
                        camActual.getPosition(),
                        camSpeed));
//                log.info("camActual modificado" + camActual.getPosition());
                camActual.setLookAt(animaVector(tpf,
                        cams[0].getLookAt(),
                        cams[1].getLookAt(),
                        camActual.getLookAt(),
                        camSpeed * 2));
                float distFinal = camActual.getPosition().distance(posFinal);
                float lookfinal = camActual.getLookAt().distance(cams[1].getLookAt());

//                log.info("dist antes" + distInicial + " dist despues " + distFinal);
                if (distFinal > distInicial) {
                    camMove = false;
                    camActual = cams[1];
                }
                log.info("lookfinal /" + lookfinal + "/ > lookInicial /" + lookInicial + "/?");
                if (lookfinal > lookInicial) {
                    camActual.setLookAt(cams[1].getLookAt());
                }
                log.info("moviendo");
                if (camActual.getPosition().equals(cams[1].getPosition())) {
//                    hemos llegado a destino
                    camMove = false;
//                    camActual.setLookAt(cams[1].getPosition());
                }

                cam.setLocation(camActual.getPosition());

                cam.lookAt(camActual.getLookAt(), new Vector3f(0, 1f, 0));
            }
        }
        if (animSenado) {
            tiempoTotal = tiempoTotal + tpf;
            float animTotal = 2f;
            String mapName = maps.get(mapsIndex).getName();
            Node node = rotating_scene;
            if (mapName.equalsIgnoreCase(Dictionary.SENADO)) {
//                        animScale = rootNode.getChild(Dictionary.SENADO);
//                int i = 0;
                if (senado == null || senado.descendantMatches(Dictionary.SENADO).isEmpty()) {
                    senado = (Node) node.getChild(Dictionary.SENADO);
                    rotating_scene.attachChild(senado);
                }
                float numSeg = senado.descendantMatches("senado").size();
                if (numSeg == 0) {
                    animSenado = false;
                    senado.detachAllChildren();
                    log.log(Level.SEVERE, "no hay segmentos para animar");
                } else {
                    float animSeg = animTotal / numSeg;

//                    for (int i=0; i<()
// hacer bucle de animación de los segmentos)

                    log.info("encontrado elemento "
                            + " animacion " + tiempoTotal);
                    for (int i = 0; i < senado.descendantMatches("senado").size(); i++) {
                        float animaScaleY = 0;
                        if (tiempoTotal >= animTotal) {
                            animSenado = false;
                            animaScaleY = 1f;
                        } else {
                            animaScaleY = tiempoTotal / animTotal;
                        }
                        senado.descendantMatches("senado").get(i)
                                .scale(1f, animaScaleY, 1f);

                    }
                }
            }
        } else {
            tiempoTotal = 0;
            animSenado = false;
            if (senado != null) {
                senado.detachAllChildren();
            }
//        if (animScale != null)
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
    }

    private Vector3f animaVector(float tpf,
            Vector3f posInicial,
            Vector3f posFinal,
            Vector3f posActual,
            float speedMovement) {
        Vector3f v;

        v = posFinal.subtract(posInicial);
        v = v.normalize();
        v = v.mult(tpf * speedMovement);
        posActual = posActual.add(v);


        return posActual;
    }

    private void initKeys() {
        //deshabilitar movimiento de camara
        flyCam.setEnabled(false);

        cam.setLocation(new Vector3f(-0.78524536f, 115.320496f, 12.418017f));
        cam.setRotation(new Quaternion(0.0025935215f, 0.8088461f, -0.5879789f, 0.006482597f));
//        cam.
        flyCam.setMoveSpeed(flyCam.getMoveSpeed() * 10);
        setDisplayStatView(false);
        inputManager.addMapping(Dictionary.MAP_NEXT, new KeyTrigger(KeyInput.KEY_PGDN));
        inputManager.addMapping(Dictionary.ANIMATE_SCENE, new KeyTrigger(KeyInput.KEY_TAB));
        inputManager.addMapping(Dictionary.MAP_PREVIUS, new KeyTrigger(KeyInput.KEY_PGUP));
        inputManager.addMapping("cam_info", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(actionListener,
                new String[]{Dictionary.ANIMATE_SCENE, Dictionary.MAP_PREVIUS,
            Dictionary.MAP_NEXT, "cam_info"});
//        System.out.println("keys iniciadas");
    }
    private ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            Node node = rotating_scene;
//            System.out.println("iniciando key " + name + "key" + keyPressed);
            if (name.equals(Dictionary.MAP_NEXT) && keyPressed) {
//                if (mapsIndex < maps.size() - 1) {
                try {
//                        node.detachChildNamed(maps.get(mapsIndex.intValue()).getName());
                    node.detachAllChildren();
                } catch (Exception e) {
                    log.severe("error " + e.getMessage());
                }
                log.info("maps size ");
                mapsIndex = (mapsIndex + 1) % maps.size();
//                    System.out.println("mapsIndex " + mapsIndex);
                node.attachChild(maps.get(mapsIndex));

                ArrayList<TCamera> camsLocal = scene.getMaps().get(mapsIndex).getCam();
                if (camsLocal != null && !camsLocal.isEmpty()) {
                    cam.setLocation(camsLocal.get(0).getPosition());
                    if (camsLocal.get(0).getOrientation() != null) {
                        cam.setRotation(camsLocal.get(0).getOrientation());
                    }
                    if (camsLocal.get(0).getLookAt() != null) {
                        cam.lookAt(camsLocal.get(0).getLookAt(), new Vector3f(0f, 1f, 0));
                    }
                }
                camOrder = 0;
                hudText.setText(maps.get(mapsIndex).getName());
                System.out.println(maps.get(mapsIndex).getName());
//                }
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
                    ArrayList<TCamera> camsLocal = scene.getMaps().get(mapsIndex).getCam();
                    if (camsLocal != null && !camsLocal.isEmpty()) {
                        cam.setLocation(camsLocal.get(0).getPosition());
                        if (camsLocal.get(0).getOrientation() != null) {
                            cam.setRotation(camsLocal.get(0).getOrientation());
                        }
                        if (camsLocal.get(0).getLookAt() != null) {
                            cam.lookAt(camsLocal.get(0).getLookAt(), new Vector3f(0, 1f, 0));
                        }
                    }
                    hudText.setText(maps.get(mapsIndex).getName());
                    camOrder = 0;
                }
            }
            //Inicia animació d'escena
            if (name.equals(Dictionary.ANIMATE_SCENE) && keyPressed && mapsIndex >= 0) {
                String mapName = maps.get(mapsIndex).getName();
                log.warning("nom de mapa " + mapName);
                animSenado = true;
            }

            if (name.equals("cam_info") && keyPressed) {
                ArrayList<TCamera> camsLocal = scene.getMaps().get(mapsIndex).getCam();
                if (camsLocal != null && !camsLocal.isEmpty()) {
                    switch (camsLocal.size()) {
                        case 1:
                            cam.setLocation(camsLocal.get(0).getPosition());
                            if (camsLocal.get(0).getOrientation() != null) {
                                cam.setRotation(camsLocal.get(0).getOrientation());
                            }
                            break;
                        default:
                            if (camActual == null) {
                                camActual = new TCamera(cam.getLocation());
                                camActual.setLookAt(cam.getLocation().add(cam.getDirection()));
                            }
                            camOrder = (camOrder + 1) % camsLocal.size();
                            ;
                            cams[0] = new TCamera(camActual.getPosition());
                            cams[0].setLookAt(camActual.getLookAt());
                            cams[1] = scene.getMaps().get(mapsIndex).getCam().get(camOrder);
                            cams[1].setLookAt(scene.getMaps().get(mapsIndex).getCam().get(camOrder).getLookAt());

                            camMove = true;
                    }
                }
                hudText.setText(cam.getRotation().toString());
            }
//            hudText.setText(maps.get(mapsIndex).getName());

        }
    };

    private void loadScene(TScene escena) {
        AssetGeneratorInterface agen = new AssetGeneratorImplements() {
        };

        MapsV1 testMap = new MapsV1();

//        rootNode.attachChild(agen.makeReference(assetManager));
        if (scene == null) {
            this.scene = testMap.genScene2();
        } else {
            this.scene = escena;
        }
        for (TMap scenemaps : this.scene.getMaps()) {
            Node mymap = agen.makeMap(assetManager, scenemaps, hudText);
            maps.add(mymap);
        }
        hudText.setText(this.scene.getName());
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
