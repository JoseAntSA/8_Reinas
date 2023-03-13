/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocho_Reinas;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anton
 */

class global{
    public static int time=1500;
}

public class Frame_Tablero extends JDialog {
	
    //Atributos
    private JPanel pnl, pnl2;
    private JLabel etqFondo;
    private JTextArea txtArea, txtAreaTitle, txtArea2, txtAreaTitle2, txtArea3, txtAreaTitle3;
    private JScrollPane scroll, scroll2, scroll3;
    private JButton btnTerminar;
    private ImageIcon imgFondo;
    private StringBuilder cad;
    private int noReinas;
    private int noPob;
    private int noGen;
    
    //Constructor
    public Frame_Tablero(JFrame padre, int noReinas, int noPob, int noGen){
        super(padre, true);
        this.noReinas = noReinas;
        this.noPob = noPob;
        this.noGen = noGen;
  
        setTitle("Algoritmo Genetico - Problema de la 8 Reinas");
        setSize(1300, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        initComponets();
        this.addWindowListener(new MyWindowListener());
        setVisible(true);
    }
    
    public void initComponets(){

        //CODIGO ATRIBUTOS
        Font fuenteTitle = new Font( "Calibri", 0, 32 );
        Font fuenteSubtitle = new Font( "Calibri", 0, 28 );        
        Font fuenteSubtitle2 = new Font( "Calibri", 0, 22 );
        Font fuenteContenido = new Font( "Calibri", 1, 18 );
        Font fuenteOptionPane = new Font( "Calibri", 1, 16 );
        Font fuenteTexto = new Font( "Consolas", 0, 14 );
        Color colorGris = new Color(26,26,26);
        Color colorAzul = new Color(0,120,121);
        Color colorAzul2 = new Color(0,101,113);
        UIManager.put("OptionPane.messageFont", fuenteOptionPane);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.background", colorGris);
        UIManager.put("OptionPane.buttonFont", fuenteOptionPane);
        UIManager.put("Button.border", BorderFactory.createMatteBorder(5, 5, 5, 5, colorAzul));
        UIManager.put("Panel.background", colorGris);
        UIManager.put("Button.font", fuenteContenido);
        UIManager.put("Button.background", colorAzul);
        UIManager.put("Button.focus", colorAzul2);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.select", colorAzul2);

        //CODIGO PANEL
        pnl = new JPanel();
        this.getContentPane().add(pnl);
        pnl.setLayout(null);
        
        //CODIGO GRAFICA
        pnl2 = new JPanel();
        pnl2.setBackground(Color.WHITE);
        pnl2.setLayout(null);
        pnl2.setBounds(25,50,550,500);
        pnl2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, colorGris));
        pnl.add(pnl2);
        
        //CODIGO CAJA DE TEXTO
        txtAreaTitle = new JTextArea();
        txtAreaTitle.setBounds(600,53,670,50);
        txtAreaTitle.setLineWrap(true);
        txtAreaTitle.setWrapStyleWord(true);
        txtAreaTitle.setBackground(Color.WHITE);
        txtAreaTitle.setFont(fuenteTexto);
        txtAreaTitle.setBorder(BorderFactory.createEmptyBorder());
        txtAreaTitle.setEditable(false);
        txtAreaTitle.append("\n  Gen.  Score   Individuo\n");
        txtAreaTitle.append("  --------------------------------------------------------------------------------");
        pnl.add(txtAreaTitle);
        
        txtArea = new JTextArea();
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setBackground(Color.WHITE);
        txtArea.setFont(fuenteTexto);
        txtArea.setBorder(BorderFactory.createEmptyBorder());
        txtArea.setEditable(false);
        scroll = new JScrollPane(txtArea);
        scroll.setBounds(600,103,670,165);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        pnl.add(scroll);
        
        //CODIGO BOTON DATOS
        btnTerminar = new JButton("Terminar");
        btnTerminar.setVerticalAlignment(SwingConstants.CENTER);
        btnTerminar.setBounds(1150,280,120,35);
        btnTerminar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, colorAzul2));
        btnTerminar.setFocusPainted(false);
        btnTerminar.setCursor(new Cursor(HAND_CURSOR));
        btnTerminar.addActionListener(new EventoBoton());
        pnl.add(btnTerminar);
        
        //CODIGO CAJA DE TEXTO 2
        txtAreaTitle2 = new JTextArea();
        txtAreaTitle2.setBounds(600,335,335,85);
        txtAreaTitle2.setLineWrap(true);
        txtAreaTitle2.setWrapStyleWord(true);
        txtAreaTitle2.setBackground(Color.WHITE);
        txtAreaTitle2.setFont(fuenteTexto);
        txtAreaTitle2.setBorder(BorderFactory.createEmptyBorder());
        txtAreaTitle2.setEditable(false);
        txtAreaTitle2.append("\n  Primera generación\n");
        txtAreaTitle2.append("\n  Ind.  Score   Individuo\n");
        txtAreaTitle2.append("  -------------------------------------");
        pnl.add(txtAreaTitle2);
        
        txtArea2 = new JTextArea();
        txtArea2.setLineWrap(true);
        txtArea2.setWrapStyleWord(true);
        txtArea2.setBackground(Color.WHITE);
        txtArea2.setFont(fuenteTexto);
        txtArea2.setBorder(BorderFactory.createEmptyBorder());
        txtArea2.setEditable(false);
        scroll2 = new JScrollPane(txtArea2);
        scroll2.setBounds(600,420,335,126);
        scroll2.setBorder(BorderFactory.createEmptyBorder());
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        pnl.add(scroll2);
        
        //CODIGO CAJA DE TEXTO 3
        txtAreaTitle3 = new JTextArea();
        txtAreaTitle3.setBounds(925,335,345,85);
        txtAreaTitle3.setLineWrap(true);
        txtAreaTitle3.setWrapStyleWord(true);
        txtAreaTitle3.setBackground(Color.WHITE);
        txtAreaTitle3.setFont(fuenteTexto);
        txtAreaTitle3.setBorder(BorderFactory.createEmptyBorder());
        txtAreaTitle3.setEditable(false);
        txtAreaTitle3.append("\n  Ultima generación\n");
        txtAreaTitle3.append("\n  Ind.  Score   Individuo\n");
        txtAreaTitle3.append("  -------------------------------------");
        pnl.add(txtAreaTitle3);
        
        txtArea3 = new JTextArea();
        txtArea3.setLineWrap(true);
        txtArea3.setWrapStyleWord(true);
        txtArea3.setBackground(Color.WHITE);
        txtArea3.setFont(fuenteTexto);
        txtArea3.setBorder(BorderFactory.createEmptyBorder());
        txtArea3.setEditable(false);
        scroll3 = new JScrollPane(txtArea3);
        scroll3.setBounds(925,420,345,126);
        scroll3.setBorder(BorderFactory.createEmptyBorder());
        scroll3.getVerticalScrollBar().addAdjustmentListener(new MyScrollListener());
        pnl.add(scroll3);
                
        //CODIGO FONDO
        imgFondo = new ImageIcon("src/Ocho_Reinas/Img_Frame_Plano.png");
        etqFondo = new JLabel();
        etqFondo.setBounds(0, 0, 600, 600);
        etqFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(etqFondo.getWidth(), etqFondo.getHeight(), Image.SCALE_SMOOTH)));
        pnl.add(etqFondo);
    
        
    }
    
    public class MyWindowListener implements WindowListener {

        // Se dispara cuando se abre el formulario
        @Override
        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(Frame_Tablero.this, "Iniciara el algoritmo genetico");       
            Thread t = new Thread(new TextArea(pnl2, txtArea, txtArea2, txtArea3, noReinas, noPob, noGen));
            t.start();          
        }

        // Se activa cuando el formulario está a punto de cerrarse
        @Override
        public void windowClosing(WindowEvent e) {
            //Codigo
        }

        // Se dispara cuando se cierra el formulario
        @Override
        public void windowClosed(WindowEvent e) {
            //Codigo
        }

        // Se activa cuando la ventana está minimizada
        @Override
        public void windowIconified(WindowEvent e) {
            //Codigo
        }

        // Se activa cuando la ventana vuelve al tamaño normal
        @Override
        public void windowDeiconified(WindowEvent e) {
            //Codigo
        }

        // Se activa cuando el formulario está activado
        @Override
        public void windowActivated(WindowEvent e) {
            //Codigo
        }

        // Se activa cuando la ventana ya no está activa
        @Override
        public void windowDeactivated(WindowEvent e) {
            //Codigo
        }
    }
     
    //CODIGO EVENTO ACTION
    public class EventoBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            global.time = 0; 
        }//evento
    }//clase interna
    
    public class MyScrollListener implements AdjustmentListener{
       
        @Override
        public void adjustmentValueChanged(AdjustmentEvent ae) {
            scroll2.getVerticalScrollBar().setValue(scroll3.getVerticalScrollBar().getValue());
        }//evento
    }//clase interna
}

class TextArea implements Runnable{

    private JTextArea txtArea, txtArea2, txtArea3;
    private JPanel pnl;
    private int noReinas, noPob, noGen;
    
    public TextArea(JPanel pnl, JTextArea txtArea, JTextArea txtArea2, JTextArea txtArea3, int noReinas, int noPob, int noGen){
        this.pnl = pnl;
        this.txtArea = txtArea;
        this.txtArea2 = txtArea2;
        this.txtArea3 = txtArea3;
        this.noReinas = noReinas;
        this.noPob = noPob;
        this.noGen = noGen;
    }
        
    @Override
    public void run() {
        
        Plano plano = new Plano(pnl);
        Individuo ind = new Individuo(4);
        ArrayList<Individuo> pobI = new ArrayList<>();
        ArrayList<Individuo> pobF = new ArrayList<>();
        FitnessFunction ff = new FitnessFunction();
        AlgoritmoEvolutivo algEv = new AlgoritmoEvolutivo(noPob,noReinas);
        algEv.init();
        int score;
        StringBuilder cad = new StringBuilder("");

        pobI = (ArrayList<Individuo>) algEv.pob.poblacion.clone();
        for( int i=1 ; i<=noGen ; i++){
            
            try {
                Thread.sleep(global.time);
            }catch(InterruptedException ex) {
                Logger.getLogger(TextArea.class.getName()).log(Level.SEVERE, null, ex);
            }
            algEv.evolucion();

            ind = algEv.mejorInd();
            score = ff.evaluate(ind);
            pobF = (ArrayList<Individuo>) algEv.pob.poblacion.clone();

            plano.setCromosoma(ind.cromosoma);
            plano.dibujarCartesiano();
            txtArea.append("  " + i + "\t"+ score + "\t" + ind.cromosoma.toString() + "\n");
                
            if (score==0){
                cad.append("Se llego a la mejor solucion en la generacion " + String.valueOf(i));
                break;
            }else if (i==noGen)
                cad.append("Se llego a la mejor solucion posible");
        }
        
        for( int i=0 ; i<noPob ; i++){

            score = ff.evaluate(pobI.get(i));
            txtArea2.append("  " + i + "\t");
            txtArea2.append(score + "\t");
            txtArea2.append(pobI.get(i).cromosoma.toString() + "\n");

            score = ff.evaluate(pobF.get(i));
            txtArea3.append("  " + i + "\t");
            txtArea3.append(score + "\t");
            txtArea3.append(pobF.get(i).cromosoma.toString() + "\n");

        }
        JOptionPane.showMessageDialog(null,cad);
        global.time = 1500;
    }
}