/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.geometries;

import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.asset.AssetManager;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.effect.shapes.EmitterBoxShape;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.VertexBuffer;
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
       
        Material terrain_mat = new Material(assetManager,
                "Common/MatDefs/Terrain/TerrainLighting.j3md");

        
    terrain_mat.setBoolean("useTriPlanarMapping", false);
    terrain_mat.setBoolean("WardIso", true);    
    terrain_mat.setTexture("AlphaMap", assetManager.loadTexture(
            "Textures/islands/balearesAlpha2.png"));
    
    Texture grass = assetManager.loadTexture(
            "Textures/Terrain/SeaWater/12_DIFFUSE.jpg");
    grass.setWrap(WrapMode.Repeat);
    terrain_mat.setTexture("DiffuseMap", grass);
    terrain_mat.setFloat("DiffuseMap_0_scale", 16);
    Texture normalMap0 = assetManager.loadTexture(
             "Textures/Terrain/SeaWater/12_NORMAL.jpg");
    normalMap0.setWrap(WrapMode.Repeat);
    terrain_mat.setTexture("NormalMap", normalMap0);
    
    Texture rock = assetManager.loadTexture(
            "Textures/Terrain/SeaWater/05_DIFFUSE.jpg");
    rock.setWrap(WrapMode.Repeat);
    terrain_mat.setTexture("DiffuseMap_1", rock);
    terrain_mat.setFloat("DiffuseMap_1_scale", 16);
    Texture normalMap1 = assetManager.loadTexture(
            "Textures/Terrain/SeaWater/05_NORMAL.jpg");
    normalMap1.setWrap(WrapMode.Repeat);
    terrain_mat.setTexture("NormalMap_1", normalMap1);
    
    Texture road = assetManager.loadTexture(
            "Textures/Terrain/Grass/06_DIFFUSE.jpg");
    road.setWrap(WrapMode.Repeat);
    terrain_mat.setTexture("DiffuseMap_2", road);
    terrain_mat.setFloat("DiffuseMap_2_scale", 32);
    Texture normalMap2 = assetManager.loadTexture(
             "Textures/Terrain/Grass/06_NORMAL.jpg");
    normalMap2.setWrap(WrapMode.Repeat);
    terrain_mat.setTexture("NormalMap_2", normalMap2);
        
    //texturas de las islas
//      terrain_mat.setTexture("AlphaMap", assetManager.loadTexture(
//            "Textures/islands/balearesAlpha2b.png"));
//      
//       Texture grass2 = assetManager.loadTexture(
//            "Textures/Terrain/Pavers/14_DIFFUSE.jpg");
//    grass2.setWrap(WrapMode.Repeat);
//    terrain_mat.setTexture("DiffuseMap_3", grass2);
//    terrain_mat.setFloat("DiffuseMap_3_scale", 16);
//    Texture normalMap02 = assetManager.loadTexture(
//             "Textures/Terrain/Pavers/14_NORMAL.jpg");
//    normalMap02.setWrap(WrapMode.Repeat);
//    terrain_mat.setTexture("NormalMap_3", normalMap02);
//    
//    Texture rock2 = assetManager.loadTexture(
//            "Textures/Terrain/SeaWater/05_DIFFUSE.jpg");
//    rock2.setWrap(WrapMode.Repeat);
//    terrain_mat.setTexture("DiffuseMap_4", rock2);
//    terrain_mat.setFloat("DiffuseMap_4_scale", 16);
//    Texture normalMap12 = assetManager.loadTexture(
//            "Textures/Terrain/SeaWater/05_NORMAL.jpg");
//    normalMap12.setWrap(WrapMode.Repeat);
//    terrain_mat.setTexture("NormalMap_4", normalMap12);
    
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
        terrain.setMaterial(terrain_mat);
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
        asset.setLocalTranslation(px, py, pz);
        asset.scale(sx, sy, sz);
        asset.rotate(rx, ry, rz);

        return asset;
    }

    public Node makeCloud(AssetManager assetManager, String name, ColorRGBA color,
            float px, float py, float pz) {
        Node node = new Node(name);
        node.setLocalTranslation(px, py, pz);

        ParticleEmitter fire =
                new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 20);
        node.attachChild(fire);
//        fire.setLocalTranslation(px,py, pz);
        Material mat_red = new Material(assetManager,
                "Common/MatDefs/Misc/Particle.j3md");
//        mat_red = assetManager.loadMaterial("Materials/Generated/clouds-Emitter_1.j3m");

//        mat_red.setTexture("Texture", assetManager.loadTexture(
//                "Effects/Smoke/Smoke.png"));
        mat_red.setTexture("Texture", assetManager.loadTexture(
                "Textures/clouds/nubes2grey.png"));
//        mat_red.setTexture("Texture", assetManager.loadTexture(
//                "Effects/Smoke/Smoke.png"));
//        mat_red.setTexture("NormalMap", 
//                        assetManager.loadTexture("Textures/clouds/nubes2grey.png"));
        fire.setShape(new EmitterBoxShape(new Vector3f(-2f, -1f, -2f),
                new Vector3f(2f, 1f, 2f)));
        fire.setMaterial(mat_red);
        fire.setImagesX(4);
        fire.setImagesY(4); // 2x2 texture animation

//        fire.setImagesX(1);
//        fire.setImagesY(15); // 2x2 texture animation

//        ColorRGBA mycolor = ColorRGBA.Green;
//        mycolor = new ColorRGBA(0.5f, 0.5f, 0.5f, 0.8f);
//        fire.setEndColor(mycolor);   // red
//        fire.setStartColor(mycolor); // yellow

//        fire.setEndColor(new ColorRGBA(1f, 0f, 0f, 1f));   // red
//        fire.setStartColor(new ColorRGBA(1f, 1f, 0f, 0.5f)); // yellow

//        fire.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
        fire.setStartSize(2.5f);
        fire.setEndSize(2.5f);
        fire.setGravity(0, 0, 0);
        fire.setLowLife(3600f);
        fire.setHighLife(3600f);
        fire.setParticlesPerSec(80);
//        fire.getParticleInfluencer().setVelocityVariation(0.3f);
        fire.setSelectRandomImage(true);
        fire.setRandomAngle(true);
        fire.killAllParticles();
        fire.emitAllParticles();

        return node;
    }

    public Node makeLightingBolt(AssetManager assetManager, String name, ColorRGBA color,
            float px, float py, float pz, float length) {
        Node node = new Node(name);
        node.setLocalTranslation(px, py - length, pz);
        float velCaida = 10f;
        ParticleEmitter fire =
                new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 2);
        node.attachChild(fire);
//        fire.setLocalTranslation(px,py, pz);
        Material mat_red = new Material(assetManager,
                "Common/MatDefs/Misc/Particle.j3md");
        mat_red.setTexture("Texture", assetManager.loadTexture(
                "Textures/bolt/rayo3_2.png"));
        fire.setShape(new EmitterBoxShape(new Vector3f(-1f, py - length / 2, -1f),
                new Vector3f(1f, py - length / 2, 1f)));
        fire.setMaterial(mat_red);
        fire.setImagesX(3);
        fire.setImagesY(3); // 2x2 texture animation
        color = new ColorRGBA(0.8f, 0.8f, 0.8f, 1f);
//        color = ColorRGBA.White;
        fire.setEndColor(color);   // red
        fire.setStartColor(color); // yellow
        fire.setParticlesPerSec(8);
//        fire.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
        float size = 5f;
        fire.setStartSize(size);
        fire.setEndSize(size);
        fire.setSelectRandomImage(true);
//        fire.setGravity(0, velCaida, 0);
        float tiempo = 0.1f;
//        System.out.println(this.getClass() + " tiempo " + tiempo + " = 2*" + length + "/" + velCaida);
        fire.setLowLife(tiempo);
        fire.setHighLife(tiempo);
//        fire.getParticleInfluencer().setVelocityVariation(0.3f);
        fire.setRandomAngle(false);
//        fire.killAllParticles();
//        fire.emitAllParticles();

        return node;
    }

    public Node makeRain(AssetManager assetManager, String name, ColorRGBA color,
            float px, float py, float pz, float length) {
        Node node = new Node(name);
        node.setLocalTranslation(px, py, pz);
        float velCaida = 10f;
        ParticleEmitter fire =
                new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 300);
        node.attachChild(fire);
//        fire.setLocalTranslation(px,py, pz);
        Material mat_red = new Material(assetManager,
                "Common/MatDefs/Misc/Particle.j3md");
        mat_red.setTexture("Texture", assetManager.loadTexture(
                "Textures/rain/rain.png"));
        fire.setShape(new EmitterBoxShape(new Vector3f(-1.5f, -1f, -1.5f),
                new Vector3f(1.5f, 0f, 1.5f)));
        fire.setMaterial(mat_red);
        fire.setImagesX(4);
        fire.setImagesY(4); // 2x2 texture animation
        fire.setEndColor(color);   // red
        fire.setStartColor(color); // yellow
//        fire.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
        fire.setStartSize(0.5f);
        fire.setEndSize(0.5f);
        fire.setGravity(0, velCaida, 0);
        float tiempo = new Double(Math.sqrt(2 * length / velCaida)).floatValue();
        System.out.println(this.getClass() + " tiempo " + tiempo + " = 2*" + length + "/" + velCaida);
        fire.setLowLife(tiempo);
        fire.setHighLife(tiempo);
        fire.getParticleInfluencer().setVelocityVariation(0.3f);
        fire.setRandomAngle(false);
//        fire.killAllParticles();
//        fire.emitAllParticles();

        return node;
    }
}
