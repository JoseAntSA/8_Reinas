/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocho_Reinas;

import java.util.*;

/**
 *
 * @author anton
 */
public class Individuo{
    
    public int tam;
    public Random random = new Random();
    public ArrayList<Integer> cromosoma; 

    Individuo(int tam){
        this.tam = tam;
    }
    
    public void init(){
        cromosoma = new ArrayList<>();
        for(int i=0 ; i<tam ; i++){
            cromosoma.add(random.nextInt(tam));
        }     
    }
    
    public Individuo[] cruza(Individuo mother){
        ArrayList<Integer> padre = this.cromosoma;
        ArrayList<Integer> madre = mother.cromosoma;
        ArrayList<Integer> hijo1 = new ArrayList<>();
        ArrayList<Integer> hijo2 = new ArrayList<>();
        
        int idx = tam/2;
        
        hijo1.addAll(padre.subList(0, idx));
        hijo1.addAll(madre.subList(idx, tam));
        
        hijo2.addAll(madre.subList(0, idx));
        hijo2.addAll(padre.subList(idx, tam));
        
        Individuo h1 = new Individuo(tam); 
        Individuo h2 = new Individuo(tam);
       
        h1.cromosoma = hijo1;
        h2.cromosoma = hijo2;
        
        Individuo[] arr = new Individuo[2];
        arr[0] = h1;
        arr[1] = h2;
        
        return arr;
        
        /*
        Reina tmp;
        int idReina;
        for(int i=0 ; i<idx ; i++){
            tmp = padre.get(i);
            idReina = hijo1.indexOf(tmp);
            System.out.println("--------");
            System.out.println(tmp);
            System.out.println(idReina);
            hijo1.set(idReina,hijo1.get(i));
            hijo1.set(i,tmp);
            
            tmp = madre.get(i);
            idReina = hijo2.indexOf(tmp);
            hijo2.set(idReina,hijo2.get(i));
            hijo2.set(i,tmp);
        }*/
    } 
    
    public void mutar(){
        this.cromosoma.set(random.nextInt(tam), random.nextInt(tam));
    }
    
    public String str(){ 
        return cromosoma.toString();
    }  
    
    
    
    
    
    
    
}
