/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.geometries;

import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.asset.AssetManager;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;

/**
 *
 * @author jmd
 */
public class BasicGeometry extends Geometry {

    public Geometry makeCube(AssetManager assetManager,
            String name,
            float sx, float sy, float sz,
            float x, float y, float z,
            ColorRGBA color) {
        Box box = new Box(sx, sy, sz);
        Geometry cube = new Geometry(name, box);
        cube.setLocalTranslation(x, y, z);
        Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", color);
        cube.setMaterial(mat1);
        return cube;
    }

    public Geometry makeSphere(AssetManager assetManager,
            String name,
            int zSamples, int rSamples, float radius,
            float x, float y, float z,
            ColorRGBA color) {
        System.out.println("zSam " + zSamples + " rSam " + rSamples + " r " + radius);
        Sphere sphere = new Sphere(zSamples, rSamples, radius);
        Geometry mark = new Geometry(name, sphere);
        mark.setLocalTranslation(x, y, z);
        Material mark_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mark_mat.setColor("Color", color);
        mark.setMaterial(mark_mat);
        return mark;
    } 
//    public Geometry makeSphere(AssetManager assetManager,
//            String name,
//            int zSamples, int rSamples, float radius,
//            float x, float y, float z,
//            ColorRGBA color) {
//        System.out.println("zSam " + zSamples + " rSam " + rSamples + " r " + radius);
//        Sphere sphere = new Sphere(zSamples, rSamples, radius);
//        Geometry mark = new Geometry(name, sphere);
//        mark.setLocalTranslation(x, y, z);
//        Material mark_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mark_mat.setColor("Color", color);
//        mark.setMaterial(mark_mat);
//        return mark;
//    }
    public Spatial makeAsset(AssetManager assetManager,
            String fileName,
            float px, float py, float pz,
            float sx, float sy, float sz,
            float rx, float ry, float rz){
           // Load a model from test_data (OgreXML + material + texture)
        Spatial asset = assetManager.loadModel(fileName);
        asset.scale(sx, sy, sz);
        asset.setLocalTranslation(px, py, pz);
        asset.rotate(rx, ry, rz);
        
        return asset;
    }
}
