/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoscomputaciongrafica3;

/**
 *
 * @author CRISTIAN
 */
public class ecuacionesParametricasSegmetoRecta2D {
    private int xa;
    private int yb;
    private int xc;
    private int yd;
    private int Vx;
    private int Vy;
    private int x;
    private int y;
    private int t1;
    
    public ecuacionesParametricasSegmetoRecta2D(int x1, int y1, int x2, int y2,int t){
        xa = x1;
        yb = y1;
        xc = x2;
        yd = y2;
        t1=t;
        Vx = xc - xa;
        Vy = yd - yb;

        x = xc + (t1*Vx);
        y = yd + (t1*Vy);
    }
    
    
            //GET
    public int getXa() {
        return xa;
    }

    public int getYb() {
        return yb;
    }

    public int getXc() {
        return xc;
    }

    public int getYd() {
        return yd;
    }

    public int getVx() {
        return Vx;
    }

    public int getVy() {
        return Vy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getT1() {
        return t1;
    }
    
    
            //SET

    public void setXa(int xa) {
        this.xa = xa;
    }

    public void setYb(int yb) {
        this.yb = yb;
    }

    public void setXc(int xc) {
        this.xc = xc;
    }

    public void setYd(int yd) {
        this.yd = yd;
    }

    public void setVx(int Vx) {
        this.Vx = Vx;
    }

    public void setVy(int Vy) {
        this.Vy = Vy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }
    
}
