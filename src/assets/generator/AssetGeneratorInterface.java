/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.generator;

import assets.entity.TMap;
import assets.entity.TScene;
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
    public Spatial makeGreyCloud(AssetManager assetManager,
                                 String name,  
                                 float x, float y, float z);
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
    public Spatial makeCloud(AssetManager assetManager,
                                 float rx, float ry, float rz,
                                 float x, float y, float z);
    public Geometry makeSimpleBox(AssetManager assetManager,
                                 String name,  
                                 float x, float y, float z);
   
    public Node makeMap(AssetManager assetManager,TMap mapa);
    
    public ArrayList<Node> generateScene( AssetManager assetManager, TScene scene);

    public Node makeReference(AssetManager assetManager);
    
}
