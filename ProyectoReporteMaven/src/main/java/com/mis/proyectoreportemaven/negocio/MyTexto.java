/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class MyTexto extends JTextField implements Componente {

    private String nombreBD;
    private String operadorBD;
    private int tipo;
    
    public MyTexto() {
        super();
    }
    
    public MyTexto(Object texto,String nombreBD, String operador, int tipo) {
        super((String)texto);
        this.nombreBD=nombreBD;
        this.operadorBD=operador;
        this.tipo=tipo;
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
    public int getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(int tipo) {
        this.tipo=tipo;
    }
    
    
    
}
