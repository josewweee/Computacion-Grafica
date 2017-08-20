/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoscomputaciongrafica3;

import java.util.Scanner;

/**
 *
 * @author CRISTIAN
 */
public class puntoHomogeneo3D {
    private int x,y,z,w;

    /*
    **  CONSTRUCTOR PUNTO HOMOGENEO 2D (CONDICIONADO w != 0)
    */
    public puntoHomogeneo3D(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        if(w != 0){
            this.w = w;
        }else{
            System.out.println("Usted a ingresado w = 0,");
            System.out.println("Ingresar valor diferente de 0 = ");
            String entradaTeclado = "";
            //Creación de un objeto Scanner
            Scanner entradaEscaner = new Scanner (System.in); 
            //Invocamos un método sobre un objeto Scanner
            entradaTeclado = entradaEscaner.nextLine (); 
            this.w = Integer.parseInt(entradaTeclado);
        }
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

    public int getW() {
        return w;
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

    public void setW(int w) {
        this.w = w;
    }
    
}
