/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocho_Reinas;

import java.awt.*;
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
public class Frame extends JFrame{
	
    //Atributos
    private JFrame frame;
    private JPanel pnl;
    private JLabel etqTitle1, etqTitle2, etqSubtitle, etqSubtitle2, etqReinas, etqPoblacion, etqGeneracion;
    private JLabel etqSep1, etqSep2, etqSep3, etqSepTitle, etqFondo;
    private ImageIcon imgFondo;
    private JTextField txtReinas, txtPoblacion, txtGeneracion;
    private JButton btnCalcular;
    
    //Constructor
    public Frame(){
        frame = this;
        setTitle("Algoritmo Genetico - Problema de la 8 Reinas");
        setSize(800,450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        initComponets();
        setVisible(true);
    }


    public void initComponets(){

        //CODIGO ATRIBUTOS
        Font fuenteTitle = new Font( "Calibri", 0, 32 );
        Font fuenteSubtitle = new Font( "Calibri", 0, 28 );        
        Font fuenteSubtitle2 = new Font( "Calibri", 0, 22 );
        Font fuenteContenido = new Font( "Calibri", 1, 18 );
        Font fuenteOptionPane = new Font( "Calibri", 1, 16 );
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
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextField.background", colorGris);
        UIManager.put("TextField.border", BorderFactory.createLineBorder(colorGris));
        UIManager.put("TextField.caretForeground", Color.WHITE);

        //CODIGO PANEL
        pnl = new JPanel();
        this.getContentPane().add(pnl);
        pnl.setLayout(null);
        
        //CODIGO TITULO
        etqTitle1 = new JLabel("Algoritmo");
        etqTitle1.setBounds(60,30,130,27);
        etqTitle1.setForeground(Color.WHITE);
        etqTitle1.setFont( fuenteTitle );
        pnl.add(etqTitle1);
        
        etqTitle2 = new JLabel("Genético");
        etqTitle2.setBounds(200,30,120,27);
        etqTitle2.setForeground(colorAzul);
        etqTitle2.setFont( fuenteTitle );
        pnl.add(etqTitle2);
        
        //CODIGO SUBTITULO
        etqSepTitle = new JLabel();
        etqSepTitle.setBounds(50,65,280,3);
        etqSepTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
        pnl.add(etqSepTitle);
        
        etqSubtitle = new JLabel("Sistemas Expertos", SwingConstants.CENTER);
        etqSubtitle.setBounds(50,80,280,25);
        etqSubtitle.setForeground(Color.WHITE);
        etqSubtitle.setFont( fuenteSubtitle );
        pnl.add(etqSubtitle);
        
        //CODIGO SUBTITULO_2
        etqSubtitle2 = new JLabel("Problema de las 8 Reinas", SwingConstants.CENTER);
        etqSubtitle2.setBounds(50,130,280,25);
        etqSubtitle2.setForeground(Color.WHITE);
        etqSubtitle2.setFont( fuenteSubtitle2 );
        etqSubtitle2.setOpaque(true);
        etqSubtitle2.setBackground(colorAzul);
        pnl.add(etqSubtitle2);
        
        //CODIGO PALABRA
        etqReinas = new JLabel("No. Reinas:");
        etqReinas.setBounds(70,190,90,25);
        etqReinas.setForeground(colorAzul);
        etqReinas.setFont( fuenteContenido );
        pnl.add(etqReinas);
        
        txtReinas = new JTextField("4");
        txtReinas.setHorizontalAlignment(SwingConstants.CENTER);
        txtReinas.setBounds(175,190,135,20);
        txtReinas.setFont( fuenteContenido );
        txtReinas.addActionListener( new EventoTxtField());
        pnl.add(txtReinas);
        
        etqSep1 = new JLabel();
        etqSep1.setBounds(175,210,135,3);
        etqSep1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul));
        pnl.add(etqSep1);
        
        //CODIGO POBLACION
        etqPoblacion = new JLabel("Población:");
        etqPoblacion.setBounds(70,220,90,25);
        etqPoblacion.setForeground(colorAzul);
        etqPoblacion.setFont( fuenteContenido );
        pnl.add(etqPoblacion);
        
        txtPoblacion = new JTextField("100");
        txtPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
        txtPoblacion.setBounds(170,220,140,20);
        txtPoblacion.setFont( fuenteContenido );
        txtPoblacion.addActionListener( new EventoTxtField());
        pnl.add(txtPoblacion);
        
        etqSep2 = new JLabel();
        etqSep2.setBounds(170,240,140,3);
        etqSep2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul));
        pnl.add(etqSep2);
        
        //CODIGO GENERACION
        etqGeneracion = new JLabel("Generaciones:");
        etqGeneracion.setBounds(70,250,120,25);
        etqGeneracion.setForeground(colorAzul);
        etqGeneracion.setFont( fuenteContenido );
        pnl.add(etqGeneracion);
        
        txtGeneracion = new JTextField("50");
        txtGeneracion.setHorizontalAlignment(SwingConstants.CENTER);
        txtGeneracion.setBounds(200,250,110,20);
        txtGeneracion.setFont( fuenteContenido );
        txtGeneracion.addActionListener( new EventoTxtField());
        pnl.add(txtGeneracion);
        
        etqSep3 = new JLabel();
        etqSep3.setBounds(200,270,110,3);
        etqSep3.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul));
        pnl.add(etqSep3);
        
        //CODIGO BOTON DATOS
        btnCalcular = new JButton("Calcular");
        btnCalcular.setVerticalAlignment(SwingConstants.CENTER);
        btnCalcular.setBounds(130,310,120,35);
        btnCalcular.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, colorAzul2));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setCursor(new Cursor(HAND_CURSOR));
        btnCalcular.addActionListener(new EventoBoton());
        pnl.add(btnCalcular);
        
        //CODIGO FONDO
        imgFondo = new ImageIcon("src/Ocho_Reinas/Img_Frame.png");
        etqFondo = new JLabel();
        etqFondo.setBounds(0, 0, 800, 423);
        etqFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(etqFondo.getWidth(), etqFondo.getHeight(), Image.SCALE_SMOOTH)));
        pnl.add(etqFondo);
        
    }
    
    //CODIGO EVENTO ACTION
    public class EventoBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            int noReinas = Integer.parseInt(txtReinas.getText());
            int noPob = Integer.parseInt(txtPoblacion.getText());
            int noGen = Integer.parseInt(txtGeneracion.getText());
            if (noReinas<=3)
                JOptionPane.showMessageDialog(null, "El numero de reinas debe ser mayor a 3.","Valores incorrectos",JOptionPane.WARNING_MESSAGE);
            else if (noPob<=0 || noGen<=0)
                JOptionPane.showMessageDialog(null, "La Poblacion y las Generaciones deben ser mayores que 0.","Valores incorrectos",JOptionPane.WARNING_MESSAGE);
            else{
                Frame_Tablero tablero = new Frame_Tablero(frame, noReinas, noPob, noGen);
            }
        }//evento
    }//clase interna
    
    //CODIGO EVENTO TEXT FIELD (PASAR A OTRO CAMPO CON INTRO)
    public class EventoTxtField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            if (txtReinas.getText().length()==0 || txtPoblacion.getText().length()==0 || txtGeneracion.getText().length()==0)
                ((JComponent) ev.getSource()).transferFocus();
            else{
                if (Integer.parseInt(txtReinas.getText())<=3)
                    JOptionPane.showMessageDialog(null, "El numero de reinas debe ser mayor a 3.","Valores incorrectos",JOptionPane.WARNING_MESSAGE);
                else if (Integer.parseInt(txtPoblacion.getText())<=0 || Integer.parseInt(txtGeneracion.getText())<=0)
                    JOptionPane.showMessageDialog(null, "La Poblacion y las Generaciones deben ser mayores que 0.","Valores incorrectos",JOptionPane.WARNING_MESSAGE);
                else
                    btnCalcular.doClick();
            }
        }
    }
}
