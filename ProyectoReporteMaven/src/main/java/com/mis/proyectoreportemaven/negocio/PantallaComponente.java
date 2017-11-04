/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

import com.mis.proyectoreportemaven.Utils.Constantes;
import com.mis.proyectoreportemaven.entity.Cliente;
import com.mis.proyectoreportemaven.entity.ClienteJpaController;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 *
 * @author admin
 */
public class PantallaComponente extends JFrame implements IMyBoton{

    List<Componente> listaComponente;
    Box box;
    EventoBoton eventoBoton;
    
    public PantallaComponente(String frame_de_swing_con_factory) {
        super(frame_de_swing_con_factory);
        listaComponente = new ArrayList<>();
//        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(600, 600);
//        setLayout(null);
        box = Box.createVerticalBox();
        
        //Esto es para registrar el escuchador
        EventoBoton eventoBoton = new EventoBoton();
        eventoBoton.attach(this);
    }

    @Override
    public Component add(Component comp) {
        if (comp instanceof Componente) {
//            Object object = (Object) comp;
            listaComponente.add((Componente) comp);
        }else{
            
        }
        Component c = super.add(comp);
        validate();
        return  c;//To change body of generated methods, choose Tools | Templates.
    }
    
    public void adicionar(Component comp){
        box.add(comp);
        box.add(Box.createHorizontalGlue());
        listaComponente.add((Componente) comp);
    }
    
    public void mostrar(){
        getContentPane().add(box);
        setVisible(true);
        validate();
    }
    
    public void listarComponentes(){
        for (Iterator<Componente> iterator = listaComponente.iterator(); iterator.hasNext();) {
            Componente next = iterator.next();
            System.out.println("nombre en la BD="+next.getNombreBD()+", valor= "+next.getValor()+", operador= "+next.getOperadorBD());
        }
    }

    @Override
    public void presionado(int tipo) {
        if(tipo==Constantes.BOTON_REPORTE){
            System.out.println("Se presiono un boton de tipo reporte");
        }
        if(tipo==Constantes.BOTON_AGREGAR_CABECERA){
            System.out.println("Se presiono un boton de agregado de cabeceras");
            
        }
        consulta(crearQuery());
    }
    
    private void consulta(String query){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prueba");
        EntityManager manager = factory.createEntityManager();
        Query q = manager.createNativeQuery(query, Cliente.class);
        List<Cliente> clientes = q.getResultList();
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente next = iterator.next();
            System.out.println(next.getNombre());
        }
        manager.close();
        factory.close();
    }

    private String crearQuery(){
        return "";
    }
}
