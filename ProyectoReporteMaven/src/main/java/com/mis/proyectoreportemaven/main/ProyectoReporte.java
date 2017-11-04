package com.mis.proyectoreportemaven.main;

import com.mis.proyectoreportemaven.Utils.Constantes;
import com.mis.proyectoreportemaven.entity.Cliente;
import com.mis.proyectoreportemaven.entity.ClienteJpaController;
import com.mis.proyectoreportemaven.nashorn.NashApp;
import com.mis.proyectoreportemaven.negocio.Componente;
import com.mis.proyectoreportemaven.negocio.EventoBoton;
import com.mis.proyectoreportemaven.negocio.FactoriaComponente;
import static com.mis.proyectoreportemaven.negocio.FactoriaComponente.getComponente;
import com.mis.proyectoreportemaven.negocio.MyBoton;
import com.mis.proyectoreportemaven.negocio.PantallaComponente;
import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ProyectoReporte {

    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {
//        NashApp app = new NashApp();
//        app.implementarInterfaz();
//        obtenerDatos();

        PantallaComponente frame = new PantallaComponente("frame de swing con factory");
        
        EventoBoton eventoBoton = new EventoBoton();
        
        frame.adicionar((Component) FactoriaComponente.getComponente("etiqueta", "valor1",null,null));
        frame.adicionar((Component) FactoriaComponente.getComponente("boton", "boton", null,null));
        frame.adicionar((Component) FactoriaComponente.getComponente("texto", "", "NOMBRE EN BD",Constantes.OPERADOR_IGUAL));
        Component boton = (Button) FactoriaComponente.getComponente("boton", "mostrar", null,null);
        frame.adicionar((Component) FactoriaComponente.getComponente("boton", "mostrar", null,null));
        frame.adicionar((Component) FactoriaComponente.getComponente("texto", "", "NOMBRE EN BD",Constantes.OPERADOR_IGUAL));
        
        
        
        frame.mostrar();
//        frame.listarComponentes();
    }
    
    public static void obtenerDatos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prueba");
        EntityManager manager = factory.createEntityManager();
        ClienteJpaController clientJPA = new ClienteJpaController(factory);
        List<Cliente> clientes = clientJPA.findClienteEntities();
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente next = iterator.next();
            System.out.println(next.getNombre());
        }
        manager.close();
        factory.close();
    }

}
