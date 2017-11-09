/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.Utils;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author JC
 */
public class DatosBD {
    
    private static String nombre;
    private static LinkedHashMap<String,String> columnas;
    private static String titulo;

    public DatosBD() {
        if(columnas==null){
            columnas = new LinkedHashMap<>();
        }
    }

    public DatosBD(String nombre) {
        this.nombre = nombre;
        if(columnas==null){
            columnas = new LinkedHashMap<>();
        }
    }
    
    public void agregarCabecera(String cabeceraBD, String cabeceraReporte){
        columnas.put(cabeceraBD, cabeceraReporte);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, String> getColumnas() {
        return columnas;
    }

    public void setColumnas(LinkedHashMap<String, String> columnas) {
        this.columnas = columnas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
