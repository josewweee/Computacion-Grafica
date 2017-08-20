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
public class Operaciones {
    
    //Multiplicación puntos homogéneos x matrices, representan transformaciones
    
    /**
     * TRANFORMACIÓN EN 2D
     * 
     * @param punto2D
     * @param matriz
     * @return 
     */
    public puntoHomogeneo2D transformacion2D(puntoHomogeneo2D punto2D,
            matriz2D matriz){ 
        int[][] m = matriz.getMatriz();
        
        punto2D.setX(punto2D.getX()*m[0][0] + punto2D.getY()*m[0][1] 
                + punto2D.getW()*m[0][2]);
        punto2D.setY(punto2D.getX()*m[1][0] + punto2D.getY()*m[1][1] 
                + punto2D.getW()*m[1][2]);
        punto2D.setW(punto2D.getX()*m[2][0] + punto2D.getY()*m[2][1] 
                + punto2D.getW()*m[2][2]);
        
        return punto2D;
    }
    
    /**
     * TRANSFORMACIÓN EN 3D
     * 
     * @param punto3D
     * @param matriz
     * @return 
     */
    public puntoHomogeneo3D transformacion3D(puntoHomogeneo3D punto3D,matriz3D matriz){
        
        int[][] m = matriz.getMatriz();
        
        punto3D.setX(punto3D.getX()*m[0][0] + punto3D.getY()*m[0][1] 
                + punto3D.getZ()*m[0][2] + punto3D.getW()*m[0][3]);
        punto3D.setY(punto3D.getX()*m[1][0] + punto3D.getY()*m[1][1] 
                + punto3D.getZ()*m[1][2] + punto3D.getW()*m[1][3]);
        punto3D.setZ(punto3D.getX()*m[2][0] + punto3D.getY()*m[2][1] 
                + punto3D.getZ()*m[2][2] + punto3D.getW()*m[2][3]);
        punto3D.setW(punto3D.getX()*m[3][0] + punto3D.getY()*m[3][1] 
                + punto3D.getZ()*m[3][2] + punto3D.getW()*m[3][3]);
        
        return punto3D;
    }
    
    
                         //Suma de vectores 
    
    /**
     * SUMA VECTOR 2D
     * 
     * @param v1
     * @param v2
     * @return 
     */
    public vector2D suma(vector2D v1, vector2D v2){
        v1.setX(v1.getX() + v2.getX());
        v1.setY(v1.getY() + v2.getY());
        
        return v1;
    }
    
    /**
     * SUMA DE VECTOR 3D
     * 
     * @param v1
     * @param v2
     * @return 
     */
    public vector3D suma(vector3D v1, vector3D v2){
        v1.setX(v1.getX() + v2.getX());
        v1.setY(v1.getY() + v2.getY());
        v1.setZ(v1.getZ() + v2.getZ());
        
        return v1;
    }
    





            //Producto punto de vectores
    /**
     * PRODUCTO PUNTO DE VECTORES 2D
     * 
     * @param v1
     * @param v2
     * @return 
     */
    public int productoPunto2D(vector2D v1,vector2D v2){
        System.out.println("Ejecución de producto punto2D");
        return (v1.getX()*v2.getX() + v1.getY()*v2.getY());
    }
    
    /**
     * PRODUCTO PUNTO DE VECTORES 3D
     * 
     * @param v1
     * @param v2
     * @return 
     */
    public int productoPunto3D(vector3D v1, vector3D v2){
        System.out.println("Ejecución producto punto3D");
        return (v1.getX()*v2.getX() + v1.getY()*v2.getY() + v1.getZ()*v2.getZ());
    }
    
    
                       //Producto cruz de vectores 3D.
    /**
     * PRODUCTO CRUZ DE VECTORES 3D
     * 
     * @param v1
     * @param v2
     * @return 
     */
    public vector3D productoCruzVector3D(vector3D v1, vector3D v2){
        System.out.println("Ejecución producto cruz vector3D");
        v1.setX(v1.getY()*v2.getZ()-v1.getZ()*v2.getY());
        v1.setY(-1*(v1.getX()*v2.getZ()-v1.getZ()*v2.getX()));
        v1.setZ(v1.getX()*v2.getY()-v1.getY()*v2.getX());
        
        return v1;
    }
    
    
                //Multiplicación de vectores por escalares.
    /**
     * MULTIPLICACIÓN DE VECTORE 2D POR ESCALARE
     * 
     * @param v1
     * @param e
     * @return 
     */
    public vector2D multiplicacionVectorEscalar2D(vector2D v1,int e){
        System.out.println("Ejecución de multiplicación de vector escalar2D");
        v1.setX(v1.getX()*e);
        v1.setY(v1.getY()*e);
        
        return v1;
    }
    
    /**
     * MULTIPLICACIÓN DE VECTOR 3D POR ESCALAR
     * 
     * @param v1
     * @param e
     * @return 
     */
    public vector3D multiplicacionVectorEscalar3D(vector3D v1,int e){
        System.out.println("Ejecución de multiplicacion vector escalar3D");
        v1.setX(v1.getX()*e);
        v1.setY(v1.getY()*e);
        v1.setZ(v1.getZ()*e);
        
        return v1;
    }
    
    
    
    
    
            //Multiplicación de matrices que  representan transformaciones.
    /**
     * MULTIPLICACIÓN DE MATRICES 2D
     * 
     * @param matriz1
     * @param matriz2
     * @return 
     */
    public int[][] multiplicacionMatriz2D(matriz2D matriz1,matriz2D matriz2){
        System.out.println("Ejecución de multiplicación de matriz2D");
        int[][]matrizProcesada = new int[3][3];
        
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                for(int k = 0;k<3;k++){
                    matrizProcesada[i][j] += 
                            matriz2.getMatriz()[i][k]*matriz1.getMatriz()[k][j];
                }
            }
        }
        
        return matrizProcesada;
    }
    
    /**
     * MULTIPLICACIÓN DE MATRICES 3D
     * 
     * @param matriz1
     * @param matriz2
     * @return 
     */
    public int[][] multiplicacionMatriz3D(matriz3D matriz1, matriz3D matriz2){
        System.out.println("Ejecución de multiplicación de matriz 3D");
        int[][]matrizProcesada = new int[4][4];
        
        for(int i = 0;i<4;i++){
            
            for(int j = 0;j<4;j++){
                
                for(int k = 0;k<4;k++){
                    matrizProcesada[i][j] += matriz2.getMatriz()[i][k]*matriz1.getMatriz()[k][j];
                }
            }
        }
        
        return matrizProcesada;
    }
    
    
    
}
