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
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;

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

    public Node makeElevation(AssetManager assetManager, String name,
            String texture, String elevation) {
        Node node = new Node(name);
        Material mat_terrain;
        TerrainQuad terrain;
        /**
         * 1. Create terrain material and load four textures into it.
         */
        mat_terrain = new Material(assetManager,
                "Common/MatDefs/Terrain/Terrain.j3md");

        /**
         * 1.1) Add ALPHA map (for red-blue-green coded splat textures)
         */
        mat_terrain.setTexture("Alpha", assetManager.loadTexture(
                texture));

        /**
         * 1.2) Add GRASS texture into the red layer (Tex1).
         */
        Texture grass = assetManager.loadTexture(
                "Textures/Terrain/splat/grass.jpg");
        grass.setWrap(WrapMode.Repeat);
        mat_terrain.setTexture("Tex1", grass);
        mat_terrain.setFloat("Tex1Scale", 64f);

        /**
         * 1.3) Add DIRT texture into the green layer (Tex2)
         */
        Texture dirt = assetManager.loadTexture(
                "Textures/Terrain/splat/dirt.jpg");
        dirt.setWrap(WrapMode.Repeat);
        mat_terrain.setTexture("Tex2", dirt);
        mat_terrain.setFloat("Tex2Scale", 32f);

        /**
         * 1.4) Add ROAD texture into the blue layer (Tex3)
         */
        Texture rock = assetManager.loadTexture(
                "Textures/Terrain/splat/road.jpg");
        rock.setWrap(WrapMode.Repeat);
        mat_terrain.setTexture("Tex3", rock);
        mat_terrain.setFloat("Tex3Scale", 128f);

        /**
         * 2. Create the height map
         */
        AbstractHeightMap heightmap = null;
        Texture heightMapImage = assetManager.loadTexture(
                elevation);
        heightmap = new ImageBasedHeightMap(heightMapImage.getImage());
        heightmap.load();

        /**
         * 3. We have prepared material and heightmap. Now we create the actual
         * terrain: 3.1) Create a TerrainQuad and name it "my terrain". 3.2) A
         * good value for terrain tiles is 64x64 -- so we supply 64+1=65. 3.3)
         * We prepared a heightmap of size 512x512 -- so we supply 512+1=513.
         * 3.4) As LOD step scale we supply Vector3f(1,1,1). 3.5) We supply the
         * prepared heightmap itself.
         */
        int patchSize = 20;
        terrain = new TerrainQuad(name + "my terrain", patchSize, 513, heightmap.getHeightMap());

        /**
         * 4. We give the terrain its material, position & scale it, and attach
         * it.
         */
        terrain.setMaterial(mat_terrain);
        terrain.setLocalTranslation(0, -10, 0);
        terrain.setLocalScale(0.5f, 0.2f, 0.5f);
        node.attachChild(terrain);
//        TerrainLodControl control = new TerrainLodControl(terrain, cam);
//        terrain.addControl(control);
        return node;
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
            float rx, float ry, float rz) {
        // Load a model from test_data (OgreXML + material + texture)
        Spatial asset = assetManager.loadModel(fileName);
        asset.scale(sx, sy, sz);
        asset.setLocalTranslation(px, py, pz);
        asset.rotate(rx, ry, rz);

        return asset;
    }
}
