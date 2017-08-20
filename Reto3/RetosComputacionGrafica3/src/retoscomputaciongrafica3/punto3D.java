
package retoscomputaciongrafica3;

/**
 *
 * @author CRISTIAN
 */
public class punto3D {
    private int x,y,z;
    
    /*
    *   PUNTO 3D
    */
    public punto3D(int x1, int y1, int z1){
        x = x1;
        y = y1;
        z = z1;
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
