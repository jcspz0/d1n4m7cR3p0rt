/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

import com.mis.proyectoreportemaven.Utils.Constantes;
import static com.mis.proyectoreportemaven.negocio.MyBoton.observadores;

/**
 *
 * @author admin
 */
public class EventoBoton implements Subject{
    @Override
    public void attach(IMyBoton observador) {
        observadores.add(observador);
    }

    @Override
    public void dettach(IMyBoton observador) {
        observadores.remove(observador);
    }

    @Override
    public void notifyObservers(int tipo) {
        for (int i = 0; i < observadores.size(); i++) {
            observadores.get(i).presionado(tipo);
        }
    }
}
