/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class MyEtiqueta extends JLabel implements Componente {

    private String nombreBD;
    private String operadorBD;
    private int tipo;
    
    public MyEtiqueta() {
        super();
    }
    
    public MyEtiqueta(String valor) {
        super(valor);
//        setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
    }
    
    public MyEtiqueta(String texto,String nombreBD, String operador) {
        super(texto);
        this.nombreBD=nombreBD;
        this.operadorBD=operador;
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
