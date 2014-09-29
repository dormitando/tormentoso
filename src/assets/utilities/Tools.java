/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.utilities;

import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author jmd
 */
public class Tools {
    
    private CollisionResult collide(Vector3f pos, Vector3f dir, Node collidable){
         CollisionResults results = new CollisionResults();
        // 2. Aim the ray from cam loc to cam direction.
        Ray ray = new Ray(pos, dir);
        // 3. Collect intersections between Ray and Shootables in results list.
        collidable.collideWith(ray, results);
        // 4. Print the results
//        System.out.println("----- Collisions? " + results.size() + "-----");
//        for (int i = 0; i < results.size(); i++) {
//          // For each hit, we know distance, impact point, name of geometry.
//          float dist = results.getCollision(i).getDistance();
//          Vector3f pt = results.getCollision(i).getContactPoint();
//          String hit = results.getCollision(i).getGeometry().getName();
////          System.out.println("* Collision #" + i);
////          System.out.println("  You shot " + hit + " at " + pt + ", " + dist + " wu away.");
//        }
        // 5. Use the results (we mark the hit object)
        if (results.size() > 0) {
          // The closest collision point is what was truly hit:
          CollisionResult closest = results.getClosestCollision();
          // Let's interact - we mark the hit with a red dot.
//          mark.setLocalTranslation(closest.getContactPoint());
//          rootNode.attachChild(mark);
          return closest;
        } else {
          // No hits? Then remove the red mark.
          return null;
        }
    }
    public float collideFloor(Vector3f pos, Node floorGroup){
        return collide(pos, new Vector3f(0, -1, 0), floorGroup).getDistance();
    }

    public Vector3f normalize(Vector3f vector3f) {
        Vector3f v3n = vector3f.clone();
        v3n.x = vector3f.z *200/800f -95;
        v3n.z = vector3f.x *(200/1.77777777f)/450f -90;
        return v3n;
    }
    
}
