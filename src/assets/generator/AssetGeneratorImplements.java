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
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;

/**
 *
 * @author jmd
 */
public abstract class AssetGeneratorImplements implements AssetGeneratorInterface {

    @Override
    public Node makeReference(AssetManager assetManager) {
        Node node = new Node("reference_map");
        BasicGeometry bg = new BasicGeometry();
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
    public Node makeMap(AssetManager assetManager, TMap mapa) {
        Node n = new Node(mapa.getName());
        TItem item = mapa.firstItem();

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
                    n.attachChild(this.makeGreyCloud(assetManager, item.getName(),
                            item.getPx(), item.getPy(), item.getPz()));
                    break;
            }
            item = mapa.nextItem();
        }
        return n;
    }

    @Override
    public Spatial makeGreyCloud(AssetManager assetManager, String name, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeAsset(assetManager, "Models/clouds/clouds.j3o",
                x, y, z, 1, 1, 1, 0, 0, 0);
    }

    @Override
    public Spatial makeCloud(AssetManager assetManager,
            float rx, float ry, float rz,
            float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeAsset(assetManager, "Models/Suzanne.mesh.j3o",
                x, y, z, 1, 1, 1, rx, ry, rz);
    }

    @Override
    public ArrayList<Node> generateScene(AssetManager assetManager, TScene scene) {
        ArrayList<Node> node = new ArrayList<Node>();
        for (TMap map : scene.getMaps()) {
            node.add(makeMap(assetManager, map));
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
    public Spatial makeAgumon(AssetManager assetManager, String name, float x, float y, float z) {
        BasicGeometry geom = new BasicGeometry();
        return geom.makeAsset(assetManager, "Models/agumon_skin/agumon_skin.j3o",
                x, y, z, //position
                1, 1, 1, //scale
                0, 0, 0);//rotate
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
        return geom.makeAsset(assetManager, "Models/volcano/volcano.j3o",
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
}