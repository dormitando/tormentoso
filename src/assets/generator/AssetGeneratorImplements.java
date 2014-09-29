/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.generator;

import assets.entity.Dictionary;
import assets.entity.TItem;
import assets.entity.TMap;
import assets.entity.TScene;
import assets.geometries.BasicGeometry;
import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;
import java.util.logging.Logger;
import sun.org.mozilla.javascript.internal.ast.SwitchCase;

/**
 *
 * @author jmd
 */
public abstract class AssetGeneratorImplements implements AssetGeneratorInterface {

    @Override
    public Node makeReference(AssetManager assetManager) {
        Node node = new Node("reference_map");
        BasicGeometry bg = new BasicGeometry();
        for (int y = 0; y < 10; y++) {
            node.attachChild(bg.makeSphere(assetManager,
                    "ref_" + (new Integer(y)).toString() + "i_" + (new Integer(y)).toString() + "j",
                    4, 4, 0.5f, 22f, y, -20f, ColorRGBA.Black));
        }
        for (int i = -10; i < 10; i++) {
            for (int j = -10; j < 10; j++) {
                if (j == 0 && i == 0) {
                    node.attachChild(bg.makeSphere(assetManager,
                            "ref_" + (new Integer(i)).toString() + "i_" + (new Integer(j)).toString() + "j",
                            4, 4, 0.5f, i * 10f, 0, j * 10f, ColorRGBA.Black));

                } else if (i == 0) {
                    node.attachChild(bg.makeSphere(assetManager,
                            "ref_" + (new Integer(i)).toString() + "i_" + (new Integer(j)).toString() + "j",
                            4, 4, 0.5f, i * 10f, 0, j * 10f, ColorRGBA.Red));

                } else if (j == 0) {
                    node.attachChild(bg.makeSphere(assetManager,
                            "ref_" + (new Integer(i)).toString() + "i_" + (new Integer(j)).toString() + "j",
                            4, 4, 0.5f, i * 10f, 0, j * 10f, ColorRGBA.Green));

                } else if (i % 3 == 0 && j % 3 == 0) {
                    node.attachChild(bg.makeSphere(assetManager,
                            "ref_" + (new Integer(i)).toString() + "i_" + (new Integer(j)).toString() + "j",
                            4, 4, 0.5f, i * 10f, 0, j * 10f, ColorRGBA.Black));

                } else {
                    if (j % 3 == 0) {
                        node.attachChild(bg.makeSphere(assetManager,
                                "ref_" + (new Integer(i)).toString() + "i_" + (new Integer(j)).toString() + "j",
                                4, 4, 0.5f, i * 10f, 0, j * 10f, ColorRGBA.Gray));

                    } else {
                        node.attachChild(bg.makeSphere(assetManager,
                                "ref_" + (new Integer(i)).toString() + "i_" + (new Integer(j)).toString() + "j",
                                4, 4, 0.5f, i * 10f, 0, j * 10f, ColorRGBA.White));

                    }
                }
            }
        }
        return node;
    }

    @Override
    public Geometry makeSun(AssetManager assetManager,
            String name,
            float x, float y, float z) {
        BasicGeometry miniSun = new BasicGeometry();
        return miniSun.makeSphere(assetManager, name,
                30, 30, 1f, x, y, z, ColorRGBA.Yellow);
    }

    @Override
    public Geometry makeFloor(AssetManager assetManager, String name, float sx, float sy, float sz, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeCube(assetManager,
                name,
                sx, sy, sz,
                x, y, z,
                ColorRGBA.DarkGray);
    }

    @Override
    public Geometry makeSimpleBox(AssetManager assetManager, String name, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeCube(assetManager,
                name,
                1, 1, 1,
                x, y, z,
                ColorRGBA.DarkGray);
    }

    @Override
    public Node makeMap(AssetManager assetManager, TMap mapa, BitmapText hud) {
        Node n = new Node(mapa.getName());
        TItem item = mapa.firstItem();
        hud.setText(mapa.getName());

        while (item != null) {
            switch (item.getType_item()) {
                case Dictionary.SUN:
                    n.attachChild(this.makeSun(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.BOX:
                    n.attachChild(this.makeSimpleBox(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.SUN_MODEL:
                    n.attachChild(this.makeSun2(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.AGUMON:
                    n.attachChild(this.makeAgumon(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.VOLCANO:
                    n.attachChild(this.makeVolcano(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.OCEAN:
                    n.attachChild(this.makeOcean(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.SPHERE:
                    n.attachChild(this.makeSphere(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz(), 0.2f, ColorRGBA.White));
                    break;
                case Dictionary.CLOUD:
                    n.attachChild(this.makeCloud(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.CLOUD_DARK:
                    n.attachChild(this.makeCloudGrey(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.CLOUD_RAIN:
                    n.attachChild(this.makeCloudRain(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz(), item.getPy()));
                    break;
                case Dictionary.CLOUD_BOLT:
                    n.attachChild(this.makeCloudBolt(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz(), item.getPy()));
                    break;
                case Dictionary.BASIC_ELEVATION:
                    n.attachChild(this.makeBaseElevation(assetManager));
                    break;
                case Dictionary.ISLA_CALAVERA:
                    n.attachChild(this.makeIslaCalavera(assetManager));
                    break;
                case Dictionary.MAPA_BALEARES:
                    n.attachChild(this.makeIslaBaleares(assetManager));
                    break;
                case Dictionary.EL_PEDESTAL:
                    n.attachChild(this.makeElPedestal(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
                case Dictionary.ELEC_SENADO:
                    n.attachChild(this.makeSenado(assetManager));
                    break;
            }
            item = mapa.nextItem();
        }
//         n.attachChild(this.makeReference(assetManager));
        return n;
    }

    @Override
    public Spatial makeCloudGrey(AssetManager assetManager, String name, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        Node node = new Node();
        node.attachChild(geom.makeCloud(assetManager, name,
                new ColorRGBA(0.7f, 0.7f, 0.7f, 0.8f), x, y, z));

        return node;
    }

    @Override
    public Node makeCloud(AssetManager assetManager,
            String name,
            float x, float y, float z) {
        Node node = new Node();
        BasicGeometry geom = new BasicGeometry();
        node.attachChild(geom.makeCloud(assetManager, name,
                new ColorRGBA(0.7f, 0.7f, 0.7f, 0.8f), x, y, z));



        return node;
    }

    @Override
    public Node makeCloudRain(AssetManager assetManager,
            String name,
            float x, float y, float z, float dist) {
        Node node = new Node();
        BasicGeometry geom = new BasicGeometry();
        node.attachChild(geom.makeCloud(assetManager, name,
                new ColorRGBA(1f, 0.7f, 0.7f, 0.8f), x, y, z));

        geom = new BasicGeometry();
        node.attachChild(geom.makeRain(assetManager, name,
                new ColorRGBA(0.7f, 0.7f, 0.7f, 0.8f),
                x, y, z,
                dist));


        return node;
    }

    @Override
    public Spatial makeCloudBolt(AssetManager assetManager, String name, float x, float y, float z, float dist) {
        Node node = new Node();
        BasicGeometry geom = new BasicGeometry();
        node.attachChild(geom.makeCloud(assetManager, name,
                new ColorRGBA(1f, 0.7f, 0.7f, 0.8f), x, y, z));

        geom = new BasicGeometry();
        node.attachChild(geom.makeLightingBolt(assetManager, name,
                ColorRGBA.White,
                x, y, z,
                dist));
        return node;
    }

    @Override
    public ArrayList<Node> generateScene(AssetManager assetManager,
            TScene scene,
            BitmapText hud) {
        ArrayList<Node> node = new ArrayList<Node>();
        for (TMap map : scene.getMaps()) {
            node.add(makeMap(assetManager, map, hud));
        }
        return node;
    }

    @Override
    public Spatial makeSun2(AssetManager assetManager, String name, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeAsset(assetManager, "Models/sunTextured/sunTextured.j3o",
                x, y, z, //position
                1, 1, 1, //scale
                0, 0, 0);//rotate
    }

    @Override
    public Spatial makeSky(AssetManager assetManager, String name) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeAsset(assetManager, "Models/background/sky_blue.j3o",
                0, 0, 0, //position
                1, 1, 1, //scale
                0, 0, 0);//rotate   
    }

    @Override
    public Spatial makeAgumon(AssetManager assetManager, String name, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeAsset(assetManager, "Models/sw2/sw2.j3o",
                x, y, z, //position
                1, 1, 1, //scale
                0, 0, 0);//rotate
    }

    @Override
    public Node makeElPedestal(AssetManager assetManager, String name, float x, float y, float z) {
        Node node = new Node("pedestal_" + name);
        BasicGeometry geom = new BasicGeometry();
        Spatial pedestal = geom.makeAsset(assetManager, "Models/pedestal/pedestal.j3o",
                x, y, z, //position
                1, 1, 1, //scale
                0, 0, 0);//rotate
        node.attachChild(pedestal);
        return node;
    }

    @Override
    public Spatial makeOcean(AssetManager assetManager, String name, float x, float y, float z) {
        Node node = new Node();
        BasicGeometry geom = new BasicGeometry();
        node.attachChild(geom.makeAsset(assetManager, "Models/ocean/ocean.j3o",
                x, y, z, //position
                1, 1, 1, //scale
                new Float(-Math.PI / 2).floatValue(), 0, 0));//rotate
        node.attachChild(geom.makeSphere(assetManager, name + "sphere", 4, 4, 1, x, y, z, ColorRGBA.Pink));
        return node;
    }

    @Override
    public Spatial makeVolcano(AssetManager assetManager, String name, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        /**
         * Load a model. Uses model and texture from jme3-test-data library!
         */
//        Spatial teapot = assetManager.loadModel("Models/Teapot/Teapot.obj");
//        Material defaultMat = new Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");
//        teapot.setMaterial(defaultMat);
//        return teapot;
        return geom.makeAsset(assetManager, "Models/test/sketchup/test.j3o",
                x, y, z, //position
                1, 1, 1, //scale
                0, 0, 0);//rotate
    }

    @Override
    public Geometry makeSphere(AssetManager assetManager,
            String name, float x, float y, float z, float radius, ColorRGBA color) {
        BasicGeometry miniSun = new BasicGeometry();
        return miniSun.makeSphere(assetManager, name,
                30, 30, radius, x, y, z, color);
    }

    @Override
    public Node makeBaseElevation(AssetManager assetMaster) {
        BasicGeometry miniSun = new BasicGeometry();
        return miniSun.makeElevation(assetMaster, "isla base",
                "Textures/Terrain/splat/alphamap.png",
                "Textures/islands/mimapa.png");
//                makeSphere(assetManager, name,
//                30, 30, radius, x, y, z, color);
    }

    @Override
    public Node makeIslaCalavera(AssetManager assetMaster) {
        BasicGeometry miniSun = new BasicGeometry();
        return miniSun.makeElevation(assetMaster, "isla base",
                "Textures/Terrain/splat/alphamap.png",
                "Textures/islands/mallorcaElev.png");
//                makeSphere(assetManager, name,
//                30, 30, radius, x, y, z, color);
    }

    @Override
    public Node makeIslaBaleares(AssetManager assetManager) {
//        Node node = new Node();
//        BasicGeometry geom = new BasicGeometry();
//        geom.makeAsset(assetManager, "Models/mapas/baleares.j3o",
//                0, 0, 0, //position
//                1, 1, 1, //scale
//                0, 0, 0);//rotate  
//        node.attachChild(geom);
        BasicGeometry miniSun = new BasicGeometry();
        Node node = miniSun.makeElevation(assetManager, "isla base",
                "Textures/islands/balearesTextura.png",
                "Textures/islands/balearesElevation.png");
//               makeSphere(assetManager, name,
//                30, 30, radius, x, y, z, color);
//        return node;
        node.setLocalScale(0.7f, 0.1f, 0.7f);
        node.setLocalTranslation(0, 0.5f, 0);
        return node;
    }

    @Override
    public Node makeSenado(AssetManager assetManager) {
        Logger log = Logger.getLogger(this.getClass().toString());
        Node node = new Node(Dictionary.SENADO);
        BasicGeometry geom = new BasicGeometry();
        Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat.setColor("Specular", ColorRGBA.Cyan);
        mat.setBoolean("UseMaterialColors", true);
        mat.setColor("Ambient", new ColorRGBA(0.8f, 0.8f, 0.8f, 0.2f));
        ColorRGBA colorSector = new ColorRGBA();
        for (int i = 0; i < 266; i++) {
            Spatial baseSenado = geom.makeAsset(assetManager, "Models/1de266/1de266.j3o",
                    0, 0, 0, //position
                    1, 0.5f, 1, //scale
                    0, 0, 0);
            baseSenado.setName("senado");
            baseSenado.rotate(
                    0, new Float(i).floatValue() * 0.6766917293233083f * -1
                    * new Float(Math.PI).floatValue() / 180f, 0);
//            baseSenado.scale(0);
            switch (i) {
                case 0: {
                    colorSector = new ColorRGBA(0.8f, 0.1f, 0.1f, 0.2f);
                    break;
                }
                case 51: {
                    colorSector = new ColorRGBA(0.1f, 0.8f, 0.1f, 0.2f);
                    break;
                }
                case 90: {
                    colorSector = new ColorRGBA(0.1f, 0.1f, 0.8f, 0.2f);
                    break;
                }
                case 158: {
                    colorSector = new ColorRGBA(0.1f, 0.8f, 0.8f, 0.2f);
                    break;
                }
                case 198: {
                    colorSector = new ColorRGBA(0.8f, 0.1f, 0.8f, 0.2f);
                    break;
                }
                case 220: {
                    colorSector = new ColorRGBA(0.8f, 0.8f, 0.1f, 0.2f);
                    break;
                }
                case 240: {
                    colorSector = new ColorRGBA(0.5f, 0.8f, 0.5f, 0.2f);
                    break;
                }
                case 258: {
                    colorSector = new ColorRGBA(0.1f, 0.1f, 0.1f, 0.2f);
                    break;
                }
            }
            mat.setColor("Ambient", colorSector);
            mat.setColor("Diffuse", colorSector);
            mat.setColor("Specular", colorSector);

            Material triar_material = mat.clone();
            baseSenado.setMaterial(triar_material);
            node.attachChild(baseSenado.clone());//rotate
        }

        node.rotate(0, new Float(Math.PI).floatValue(), 0);
        return node;
    }
}
