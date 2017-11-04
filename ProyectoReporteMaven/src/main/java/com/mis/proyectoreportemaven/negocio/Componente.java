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
public interface Componente {
    String getNombreBD();
    void setNombreBD(String nombre);
    Object getValor();
    void setValor(Object valor);
    String getOperadorBD();
    void setOperadorBD(String operador);
}
