/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocho_Reinas;

/**
 *
 * @author anton
 */
public class Reina {
    
    private int posX, posY;
    
    Reina(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public boolean equals(Reina reinaA){
        return reinaA.getPosX()==posX && reinaA.getPosY()==posY;
    }
    
    @Override
    public String toString(){
        return "[" + String.valueOf(posX) + "," + String.valueOf(posY) + "]";
    }
}
