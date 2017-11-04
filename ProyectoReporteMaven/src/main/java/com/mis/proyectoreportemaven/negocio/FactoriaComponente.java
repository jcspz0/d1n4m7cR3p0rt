/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.negocio;

import com.mis.proyectoreportemaven.Utils.Constantes;
import java.util.Map;

/**
 *
 * @author admin
 */
public class FactoriaComponente {
    
    public static Componente getComponente(String tipoComponent, Object valor, int tipo, String nombreBD, String operador){
        switch(tipoComponent){
            case "etiqueta" : return new MyEtiqueta(valor);
            case "boton" : return new MyBoton(valor,tipo);
//            case "botonComboText" : return new MyBoton(valor,tipo,(MyComboBox)obj1,(MyEtiqueta)obj2);
            case "texto" : return new MyTexto(valor,nombreBD,operador,tipo);
            case "combo" : return new MyComboBox(valor, tipo, nombreBD, operador);
            default:break;
        }
        return null;
    }
    
//    public static Componente getComponenteMap(Map<String,Object> datos){
//        switch((String)datos.get("tipoComponent")){
//            case "etiqueta" : return new MyEtiqueta((String)datos.get("valor"));
//            case "boton" : return new MyBoton((String)datos.get("valor"),(int)datos.get("tipo"));
//            case "texto" : return new MyTexto((String)datos.get("valor"),(String)datos.get("valor"),(String)datos.get("valor"),(int)datos.get("tipo"));
//            case "comboCabecera" : return new MyComboBox((String)datos.get("valor"), (int)datos.get("tipo"), (String)datos.get("nombreBD"), (String)datos.get("operador"));
//            default:break;
//        }
//        return null;
//    }
    
}
