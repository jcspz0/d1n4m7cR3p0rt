/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

/**
 *
 * @author admin
 */
public class FactoriaComponente {
    
    public static Componente getComponente(String tipo, String valor, String nombreBD, String operador){
        switch(tipo){
            case "etiqueta" : return new MyEtiqueta(valor);
            case "boton" : return new MyBoton(valor);
            case "texto" : return new MyTexto(valor,nombreBD,operador);
            default:break;
        }
        return null;
    }
    
}
