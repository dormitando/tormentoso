/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

import assets.geometries.BasicGeometry;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.Vector;
import java.util.logging.Logger;

/**
 *
 * @author jmd
 */
public class Hemiciclo {

    Vector<Partido> partidos = new Vector();
    final static private Integer TOTAL_ESCANOS = 266;
    final public float TIEMPO_TOTAL = 1f;
    private float tiempo = 0f;
    private Float tiempo_inicial = null;
    String name;
    Logger log = Logger.getLogger(this.getClass().toString());
    Vector<Spatial> meshSenado = new Vector<>();
    Node node;
    private boolean animarElementos = false;

//    = geom.makeAsset(assetManager, "Models/1de266/1de266.j3o",
//                    0, 0, 0, //position
//                    1, 0.5f, 1, //scale
//                    0, 0, 0);
    public Hemiciclo(String name) {
        this.node = new Node(name);
    }

    public void afegirResultatPartit(ColorRGBA color,
            Integer cantidad, String partido) {
        Partido p = new Partido();
        p.setCantidad(cantidad);
        p.setColor(color);
        p.setNombrePartido(partido);
        if (partidos.isEmpty()) {
            partidos.add(p);
        } else {
            if (TOTAL_ESCANOS >= sumaAsientos() + cantidad) {
                for (int i = 0; i < partidos.size(); i++) {
                    if (partidos.get(i).cantidad < cantidad) {
                        partidos.add(i, p);
                        break;
                    } else {
                    }
                }
            } else {
                log.severe("mas asientos de los " + TOTAL_ESCANOS + " definidos");
            }
        }


    }

    @Override
    public String toString() {
        String txt = "";
        for (Partido p : partidos) {
            txt = txt.concat(p.nombrePartido + ":" + p.cantidad.toString() + "("
                    + p.color + "); ");
        }
        return txt;
    }

    private Integer sumaAsientos() {
        Integer totalActual = 0;
        for (Partido p : partidos) {
            totalActual += p.cantidad;
        }
        return totalActual;
    }

    public void insertMesh(AssetManager assetManager, Node root) {
        regenerarMesh(assetManager);
//        if (root.getChild(this.name) != null) {
//            root.detachChildNamed(this.name);
//        }
        root.attachChild(node);
        for (int i = 0; i < this.meshSenado.size(); i++) {
            root.attachChild(this.meshSenado.get(i));
        }
        this.animarElementos = true;

    }

    public void animSegments(float tpf) {
        float scale = 0;
        if (!this.animarElementos) {
            return;
        }
        if (this.tiempo_inicial == null) {
            this.tiempo_inicial = new Float(tpf);
        }
        tiempo += tpf;// - this.tiempo_inicial;
        log.info(this.meshSenado.elementAt(0).getLocalScale().toString());
//        if (tiempo > this.TIEMPO_TOTAL) {
//            scale = 1f;
//            this.animarElementos = false;
//            this.tiempo_inicial = null;
//        } else {
//            scale = (tiempo / this.TIEMPO_TOTAL);
//        }
//        for (int i = 0; i < this.meshSenado.size(); i++) {
//            this.meshSenado.elementAt(i).setLocalScale(scale,scale,scale);
//        }
        
        for (int i = 0; i<this.meshSenado.size(); i++){
            float t_parcial = tiempo - 
                    (this.TIEMPO_TOTAL/new Float(Hemiciclo.TOTAL_ESCANOS))*new Float(i);
            scale = (t_parcial / this.TIEMPO_TOTAL);
            if (scale<0) scale = 0;
            if (scale>1f)scale = 1f;
            this.meshSenado.elementAt(i).setLocalScale(1f,scale,scale);
        }
    }

    private void regenerarMesh(AssetManager assetManager) {
        if (!this.meshSenado.isEmpty()) {
            this.meshSenado.clear();
        }
        BasicGeometry geom = new BasicGeometry();
        Integer acumulado = 0;
        for (Partido p : this.partidos) {
            for (int i = 0; i < p.cantidad; i++) {
                Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                mat.setBoolean("UseMaterialColors", true);
                mat.setColor("Specular", p.getColor());
                mat.setColor("Ambient", p.getColor());
                mat.setColor("Diffuse", p.getColor());

                Spatial baseSenado = geom.makeAsset(assetManager, "Models/1de266/1de266.j3o",
                        0, 0, 0, //position
                        1, 0f, 1, //scale
                        0, 0, 0);
                baseSenado.setMaterial(mat);
                baseSenado.rotate(
                        0, new Float(acumulado).floatValue() * 0.6766917293233083f * -1
                        * new Float(Math.PI).floatValue() / 180f, 0);
                acumulado++;
                this.meshSenado.add(baseSenado);
                //afegir el nom del partit a la meitat del resultat
            }
        }
        //omplir fins al final amb resultat d'ALTRES
        for (int i = acumulado; i < Hemiciclo.TOTAL_ESCANOS; i++) {
            Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
            mat.setBoolean("UseMaterialColors", true);
            mat.setColor("Specular", ColorRGBA.Black);
            mat.setColor("Ambient", ColorRGBA.Black);
            mat.setColor("Diffuse", ColorRGBA.Black);
            Spatial baseSenado = geom.makeAsset(assetManager, "Models/1de266/1de266.j3o",
                    0, 0, 0, //position
                    1, 0.5f, 1, //scale
                    0, 0, 0);
            baseSenado.setMaterial(mat);
            baseSenado.rotate(
                    0, new Float(acumulado).floatValue() * 0.6766917293233083f * -1
                    * new Float(Math.PI).floatValue() / 180f, 0);
            this.meshSenado.add(baseSenado);
        }
    }

    private static class Partido {

        public ColorRGBA color;
        public Integer cantidad;
        public String nombrePartido;

        public Partido() {
        }

        public ColorRGBA getColor() {
            return color;
        }

        public void setColor(ColorRGBA color) {
            this.color = color;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

        public String getNombrePartido() {
            return nombrePartido;
        }

        public void setNombrePartido(String nombrePartido) {
            this.nombrePartido = nombrePartido;
        }
        private static final Logger LOG = Logger.getLogger(Partido.class.getName());
    }
}
