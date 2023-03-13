package Ocho_Reinas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anton
 */
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Plano{

    private JPanel pnl;
    private ArrayList<Integer> reinas;
    private int w, h, tam;

    //Constructor
    public Plano(JPanel pnl){
        this.pnl = pnl;
        w = pnl.getWidth();
        h = pnl.getHeight();
    }
    
    //Metodos
    public void setCromosoma(ArrayList<Integer> reinas){
        this.reinas = reinas;
        this.tam = reinas.size();
    }
    
    public void dibujarCartesiano(){
        Graphics2D g = (Graphics2D) pnl.getGraphics();
        g.setFont(new Font( "sans-serif", 0, 12 )); 
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        
        g.setColor(new Color(150,150,150));
        int sepW = w/tam;
        int sepH = h/tam;
            
        for(int i=sepW; i<=w-sepW ; i+=sepW){
            g.drawLine(i, 3, i, h-4);
        }
        for(int i=sepH; i<=h-sepH ; i+=sepH){
            g.drawLine(3, i, w-4, i);
        }
        
        int tamW = w/(tam+2);
        int tamH = h/(tam+2);
        
        ImageIcon Img = new ImageIcon(getClass().getResource("/Ocho_Reinas/Corona_Reina.png")); 
 
        for(int i=0 ; i<tam ; i++){
            g.drawImage(Img.getImage(), ((sepW-tamW)/2)+(sepW*i),(sepH-tamH)/2+(sepH*reinas.get(i)), tamW, tamH, null);
        }
        
    }
}	

