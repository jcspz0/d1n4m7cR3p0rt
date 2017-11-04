/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;


import com.mis.proyectoreportemaven.Utils.Constantes;
import com.mis.proyectoreportemaven.Utils.comboValue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class MyComboBox extends JComboBox<Object> implements Componente,ItemListener  {

    private String nombreBD;
    private String operadorBD;
    private int tipo;
    private Object valor;
    
    public MyComboBox(DefaultComboBoxModel<Object> valor) {
        super();
    }

    public MyComboBox(Object valor,int tipo,String nombreBD, String operador) {
        super();
        setModel((DefaultComboBoxModel<Object>)valor);
        this.nombreBD=nombreBD;
        this.operadorBD=operador;
        this.tipo=tipo;
        this.valor=getModel().getElementAt(0);
        addItemListener(this);
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    @Override
    public Object getValor() {
        return valor;
    }

    @Override
    public void setValor(Object valor) {
        this.valor=valor;
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println("dentro"+e.getItem().toString());
            valor=e.getItem().toString();
        }
        
    }

    

    
    
}
