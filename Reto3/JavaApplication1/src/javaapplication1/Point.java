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
public class Point {
    int x;
    int y;
    int w;

    public Point(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + "w=" + w + '}';
    }
    
}