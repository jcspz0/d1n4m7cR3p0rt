package com.mis.proyectoreportemaven.nashorn;

import com.mis.proyectoreportemaven.negocio.PantallaComponente;
import java.awt.Label;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NashApp {

    private final ScriptEngineManager manejador;
    private final ScriptEngine motor;
    private String pathArchivo;
    private final String configuration;
    private final Invocable invocador;

    public NashApp() {
        manejador = new ScriptEngineManager();
        motor= manejador.getEngineByName("nashorn");
//        this.pathArchivo="src/main/java/com/mis/proyectoreportemaven/archivos/javaSwing.js";
        this.configuration="src/main/java/com/mis/proyectoreportemaven/archivos/configuration.js";
        invocador = (Invocable)motor;
        initConfiguration();
    }
    
    private void initConfiguration(){
        try {
            motor.put("pathArchivo", pathArchivo);
            motor.eval(new FileReader(configuration));
            this.pathArchivo = (String) motor.get("pathArchivo");
        } catch (ScriptException ex) {
            Logger.getLogger(NashApp.class.getName()).log(Level.SEVERE, null, ex);
        }catch (FileNotFoundException ex) {
            Logger.getLogger(NashApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llamarFunciones() throws ScriptException, FileNotFoundException, NoSuchMethodException{
        motor.eval("print ('Hola desde javascript')");
        motor.eval(new FileReader(pathArchivo));
        //double respuesta= (double) invocador.invokeFunction("sumarNumeros", "1","2");
        //System.out.println(respuesta);
    }
    public void implementarInterfaz() throws ScriptException, FileNotFoundException, NoSuchMethodException{
        PantallaComponente frame = new PantallaComponente("frame de swing");
        
        motor.put("frame", frame);
        
        motor.eval(new FileReader(pathArchivo));
        //double respuesta= (double) invocador.invokeFunction("sumarNumeros", "1","2");
        //System.out.println(respuesta);
    }
}
