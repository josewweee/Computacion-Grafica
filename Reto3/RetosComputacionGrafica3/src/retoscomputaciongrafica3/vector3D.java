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
public class vector3D {
    private int x,y,z;
    
    public vector3D(punto3D punto3D1, punto3D punto3D2){
        this.x = punto3D2.getX() - punto3D1.getX();
        this.y = punto3D2.getY() - punto3D1.getY();
        this.z = punto3D2.getZ() - punto3D2.getZ();
    }

            //GET
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
