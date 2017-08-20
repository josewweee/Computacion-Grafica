
package retoscomputaciongrafica3;

/**
 *
 * @author CRISTIAN
 */
public class vector2D {
    private int x,y;
    
    public vector2D(punto2D punto2D1, punto2D punto2D2){
        this.x = punto2D2.getX() - punto2D1.getX();
        this.y = punto2D2.getY() - punto2D1.getY();
    }

         //GET
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
            //SET
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
