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
public class matriz3D {
    private int[][] matriz;
    
    public matriz3D(){
        matriz = new int[4][4];
    }

            //GET
    public int[][] getMatriz() {
        return matriz;
    }

    
            //SET
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    
}
