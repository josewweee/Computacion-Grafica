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
public class ecuacionesParametricasSegmentoRecta3D {
    private int xa;
    private int yb;
    private int zc;
    private int xd;
    private int ye;
    private int zf;
    private int a;
    private int b;
    private int c;
    private int t1;
    private int x;
    private int y;
    private int z;

    
    public ecuacionesParametricasSegmentoRecta3D(int x1, int y1, int z1, int x2, int y2, int z2, int t){
        xa = x1;
        yb = y1;
        zc = z1;
        xd = x2;
        ye = y2;
        zf = z2;
        t1=t;

        a = xd - xa;
        b = ye - yb;
        c = zf - zc;


        x=xa+(a*t1);
        y=yb+(b*t1);
        z=zc+(c*t1);
    }

    
                //GET

    public int getXa() {
        return xa;
    }

    public int getYb() {
        return yb;
    }

    public int getZc() {
        return zc;
    }

    public int getXd() {
        return xd;
    }

    public int getYe() {
        return ye;
    }

    public int getZf() {
        return zf;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getT1() {
        return t1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    
    
                //SET

    public void setXa(int xa) {
        this.xa = xa;
    }

    public void setYb(int yb) {
        this.yb = yb;
    }

    public void setZc(int zc) {
        this.zc = zc;
    }

    public void setXd(int xd) {
        this.xd = xd;
    }

    public void setYe(int ye) {
        this.ye = ye;
    }

    public void setZf(int zf) {
        this.zf = zf;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    
    
}
