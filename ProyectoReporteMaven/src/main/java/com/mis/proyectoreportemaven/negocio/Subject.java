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
public interface Subject {
    public void attach(IMyBoton observador);
    public void dettach(IMyBoton observador);
    public void notifyObservers(int tipo);
}
