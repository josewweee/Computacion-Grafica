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
public class RetosComputacionGrafica3 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Operaciones operaciones = new Operaciones();
        int x = 2;
        int y = 3;
        int z = 4;
        int w = 3;
        punto2D punto2D = new punto2D(x,y);
        punto2D punto2D2 = new punto2D(x+3,y+3);
        
        punto3D punto3D = new punto3D(x,y,z);
        punto3D punto3D2 = new punto3D(x+3,y+3,z+3);
        
        puntoHomogeneo2D puntoHomogeneo2D = new puntoHomogeneo2D(x,y,w);
        puntoHomogeneo3D puntoHomogeneo3D = new puntoHomogeneo3D(x,y,z,w);
        
        
        matriz2D matriz2D = new matriz2D();
        matriz2D matriz2D2 = new matriz2D();
        
        matriz3D matriz3D = new matriz3D();
        matriz3D matriz3D2 = new matriz3D();
        
        vector2D vector2D = new vector2D(punto2D,punto2D2);
        vector2D vector2D2 = new vector2D(punto2D,punto2D2);
        
        vector3D vector3D = new vector3D(punto3D,punto3D2);
        vector3D vector3D2 = new vector3D(punto3D,punto3D2);
        
        
        operaciones.transformacion2D(puntoHomogeneo2D, matriz2D);
        operaciones.transformacion3D(puntoHomogeneo3D, matriz3D);
        
        operaciones.suma(vector2D, vector2D2);
        operaciones.suma(vector3D, vector3D2);
        
        operaciones.productoPunto2D(vector2D, vector2D2);
        operaciones.productoPunto3D(vector3D, vector3D2);
        
        operaciones.productoCruzVector3D(vector3D, vector3D2);
        
        operaciones.multiplicacionVectorEscalar2D(vector2D, w);
        operaciones.multiplicacionVectorEscalar3D(vector3D, w);
        
        operaciones.multiplicacionMatriz2D(matriz2D, matriz2D2);
        operaciones.multiplicacionMatriz3D(matriz3D, matriz3D2);
        
    }
    
}


