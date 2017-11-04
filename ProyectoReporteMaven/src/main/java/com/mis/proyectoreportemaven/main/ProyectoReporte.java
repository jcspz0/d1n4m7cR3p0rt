package com.mis.proyectoreportemaven.main;

import com.mis.proyectoreportemaven.Utils.Constantes;
import com.mis.proyectoreportemaven.Utils.comboValue;
import com.mis.proyectoreportemaven.entity.Cliente;
import com.mis.proyectoreportemaven.entity.ClienteJpaController;
import com.mis.proyectoreportemaven.nashorn.NashApp;
import com.mis.proyectoreportemaven.negocio.Componente;
import com.mis.proyectoreportemaven.negocio.EventoBoton;
import com.mis.proyectoreportemaven.negocio.FactoriaComponente;
import static com.mis.proyectoreportemaven.negocio.FactoriaComponente.getComponente;
import com.mis.proyectoreportemaven.negocio.IMyBoton;
import com.mis.proyectoreportemaven.negocio.MyBoton;
import com.mis.proyectoreportemaven.negocio.PantallaComponente;
import java.awt.Button;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.script.ScriptException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ProyectoReporte {

    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {
//        NashApp app = new NashApp();
//        app.implementarInterfaz();
        realizarConsulta();

        PantallaComponente frame = new PantallaComponente("frame de swing con factory");
        
        
        
        frame.adicionar((Component) FactoriaComponente.getComponente("texto", "*", Constantes.TEXTO_CABECERA,"",""));
        
        frame.adicionar((Component) FactoriaComponente.getComponente("texto", "Juan", Constantes.TEXTO_CADENA,"NOMBRE",Constantes.OPERADOR_IGUAL));
        
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        combo.addElement("M");
        combo.addElement("F");
        
        
        frame.adicionar((Component) FactoriaComponente.getComponente("combo", (DefaultComboBoxModel)combo, Constantes.COMBO_RELLENADO,"SEXO",Constantes.OPERADOR_IGUAL));
        
        frame.adicionar((Component)FactoriaComponente.getComponente("boton", "mostrar", Constantes.BOTON_REPORTE,null,null));
        
        frame.mostrar();
        frame.listarComponentes();
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
    
    public static void realizarConsulta(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prueba");
        EntityManager manager = factory.createEntityManager();
        Query q = manager.createNativeQuery("select * from CLIENTE where nombre='Juan'", Cliente.class);
        List<Cliente> clientes = q.getResultList();
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente next = iterator.next();
            System.out.println(next.getNombre());
        }
        manager.close();
        factory.close();
    }

}
