/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;


import com.mis.proyectoreportemaven.Utils.Constantes;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class MyComboBox extends JComboBox<Object> implements Componente {

    private String nombreBD;
    private String operadorBD;
    private int tipo;
    
    public MyComboBox(DefaultComboBoxModel<Object> valor) {
        super();
    }

    public MyComboBox(String valor,int tipo,String nombreBD, String operador) {
        super();
        setModel(generarValores(valor));
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
        return getModel();
    }

    @Override
    public void setValor(Object valor) {
        setModel((ComboBoxModel<Object>)valor);
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
    
    private DefaultComboBoxModel<Object> generarValores(String tipo){
        DefaultComboBoxModel<Object> model =new DefaultComboBoxModel<>();
        switch(tipo){
            case Constantes.COMBO_CLIENTE:
                model.addElement("ID");
                model.addElement("NOMBRE");
                break;
        }
        return model;
    }
    
}
