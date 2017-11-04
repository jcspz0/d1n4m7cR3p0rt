/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

import com.mis.proyectoreportemaven.Utils.Constantes;
import java.awt.Dimension;
import java.awt.Insets;
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
    
    public static ArrayList<IMyBoton> observadores = new ArrayList<>();
    
    public MyBoton() {
        super();
    }
    
    public MyBoton(String valor) {
        super(valor);
        
    }
    
    public MyBoton(String texto,String nombreBD, String operador) {
        super(texto);
        this.nombreBD=nombreBD;
        this.operadorBD=operador;
        setSize(100, 100);
        validate();
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

    
    
    
    
}
