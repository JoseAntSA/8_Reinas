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
public class FitnessFunction {
    
    public int evaluate(Individuo ind){
        ArrayList<Integer> reinas = ind.cromosoma; 
        int reina_tmp;
        int ctr = 0;
        
        
        for(int i=0 ; i<ind.tam ; i++){
            reina_tmp = reinas.get(i);
            for(int j=0 ; j<ind.tam ; j++){
                if(j!=i){
                    if(  reina_tmp == reinas.get(j))
                        ctr++;
                    if( (reina_tmp+i == reinas.get(j)+j) || (i-j == reina_tmp-reinas.get(j)) )
                        ctr++;
                }
            }
        }     
        return ctr;
            
    }
}
