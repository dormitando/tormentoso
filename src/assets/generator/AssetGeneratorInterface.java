/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.generator;

import assets.entity.TMap;
import assets.entity.TScene;
import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.ArrayList;

/**
 *
 * @author jmd
 */
public interface AssetGeneratorInterface {

    public Geometry makeSphere(AssetManager assetManager,
            String name,
            float x, float y, float z,
            float radius, ColorRGBA color);

    public Geometry makeSun(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Spatial makeSun2(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Spatial makeSky(AssetManager assetManager,
            String name);

    public Spatial makeCloudGrey(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Spatial makeCloudRain(AssetManager assetManager,
            String name,
            float x, float y, float z, float dist);
    public Spatial makeCloudBolt(AssetManager assetManager,
            String name,
            float x, float y, float z, float dist);

    public Spatial makeAgumon(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Spatial makeOcean(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Spatial makeVolcano(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Geometry makeFloor(AssetManager assetManager,
            String name,
            float sx, float sy, float sz,
            float x, float y, float z);

    public Node makeCloud(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Geometry makeSimpleBox(AssetManager assetManager,
            String name,
            float x, float y, float z);

    public Node makeMap(AssetManager assetManager, TMap mapa, BitmapText hud);

    public Node makeBaseElevation(AssetManager assetMaster);

    public Node makeIslaCalavera(AssetManager assetMaster);

    public ArrayList<Node> generateScene(AssetManager assetManager,
            TScene scene,
            BitmapText hud);

    public Node makeReference(AssetManager assetManager);
}
