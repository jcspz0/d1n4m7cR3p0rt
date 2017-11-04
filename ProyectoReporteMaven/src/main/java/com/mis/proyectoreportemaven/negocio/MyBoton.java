/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

import com.mis.proyectoreportemaven.Utils.Constantes;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author admin
 */
public class MyBoton extends JButton implements Componente {

    private String nombreBD;
    private String operadorBD;
    private int tipo;
    private MyComboBox comboBox;
    private MyEtiqueta etiqueta;
    
    public static ArrayList<IMyBoton> observadores = new ArrayList<>();
    
    public MyBoton() {
        super();
    }
    
    public MyBoton(String valor,int tipo) {
        super(valor);
//        if (tipo==Constantes.BOTON_REPORTE) {
            addActionListener(new ActionListener() {
                EventoBoton eventoBoton = new EventoBoton();
                @Override
                public void actionPerformed(ActionEvent e) {
                     eventoBoton.notifyObservers();
                }
            });
//        }
    }
    
    public MyBoton(String texto,int tipo,MyComboBox comboBox,MyEtiqueta etiqueta) {
        super(texto);
        this.tipo=tipo;
        this.comboBox=comboBox;
        this.etiqueta=etiqueta;
//        if (tipo==Constantes.BOTON_REPORTE) {
            addActionListener(new ActionListener() {
                EventoBoton eventoBoton = new EventoBoton();
                @Override
                public void actionPerformed(ActionEvent e) {
                     eventoBoton.notifyObservers();
                }
            });
//        }
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    @Override
    public Object getValor() {
        return getText();
    }

    @Override
    public void setValor(Object valor) {
        setText((String) valor);
    }

    @Override
    public String getOperadorBD() {
        return operadorBD;
    }

    @Override
    public void setOperadorBD(String operador) {
        this.operadorBD=operador;
    }

    @Override
    public void addActionListener(ActionListener l) {
        super.addActionListener(l); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(int tipo) {
        this.tipo=tipo;
    }

}
