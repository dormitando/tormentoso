/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assets.entity;

/**
 *
 * @author dormitando
 */
public class TAnim {

    TItem iInicial, iFinal;
    float velocidad;
    TVelocidad tVel;

    public TItem getiInicial() {
        return iInicial;
    }

    public void setiInicial(TItem iInicial) {
        this.iInicial = iInicial;
    }

    public TItem getiFinal() {
        return iFinal;
    }

    public void setiFinal(TItem iFinal) throws Exception {
        if (iInicial!=null && iFinal.getType_item().equals(iInicial.getType_item())){
            throw tInicial_exception("asignados tipos diferentes a una animación");
        }
        this.iFinal = iFinal;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public TVelocidad gettVel() {
        return tVel;
    }

    public void settVel(TVelocidad tVel) {
        this.tVel = tVel;
    }

    private Exception tInicial_exception(String txt) {
        return new Exception(txt); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
