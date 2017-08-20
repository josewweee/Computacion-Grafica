/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
/**
 *
 * @author cl18413
 */
public class Vector3 {
    
    public int n = 3;       
    public int[] data = {2,4,5};       
    public int[] data2 = {3,5,6};
    
    public Vector3(int n) {
        this.n = n;
        this.data = new int[n];
    }
    
     public Vector3(int[] data) {
        n = data.length;
        
        this.data = new int[n];
        for (int i = 0; i < n; i++){
            this.data[i] = data[i];
        }
    }
    
    public static Vector3 Cross_Product(Vector3 V1, Vector3 V2) {
       Vector3 Cross = new Vector3(V1.length());
       if(V1.length() == V2.length()){
            
        for(int i = 0; i == V1.length(); i++){
               Cross.data[i] = (V1.data[i+1] * V2.data[i+2]);
               System.out.println("Valor de V1 en posicion actual: " + Cross.data[i]);
        }
       }
       return Cross;
    }
    
    public static int Dot_Product(Vector3 V1, Vector3 V2) {
       int suma = 0;
       if(V1.length() == V2.length()){
            
        for(int i = 0; i == V1.length(); i++){
            System.out.println("Valor de V1 en posicion actual: " + V1.data[i]);
            suma = suma + (V1.data[i] * V2.data[i]);
        }
       }
       return suma;
    }
    
     public double Magnitude(Vector3 V1) {
       return Math.sqrt(Dot_Product(V1,V1));
    }
    
    public Vector3 Normalize(Vector3 V1) {
        
       return null;
    }
    
    public int length() {
        return n;
    }
}

