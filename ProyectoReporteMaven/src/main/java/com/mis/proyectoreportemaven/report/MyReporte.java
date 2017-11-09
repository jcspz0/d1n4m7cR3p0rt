/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.report;

import com.mis.proyectoreportemaven.Utils.Constantes;
import com.mis.proyectoreportemaven.Utils.DatosBD;
import com.mis.proyectoreportemaven.negocio.Componente;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

/**
 *
 * @author JC
 */
public class MyReporte {
    
    List<Componente> listaComponente;
    private DatosBD db;
    private String cabeceraQuery="";

    public MyReporte(List<Componente> listaComponente) {
        this.listaComponente = listaComponente;
        db = new DatosBD();
    }

    public List<Componente> getListaComponente() {
        return listaComponente;
    }

    public void setListaComponente(List<Componente> listaComponente) {
        this.listaComponente = listaComponente;
    }
    
    private String[] getCabeceras(){
        for (Iterator<Componente> iterator = listaComponente.iterator(); iterator.hasNext();) {
            Componente next = iterator.next();
                switch(next.getTipo()){
                    case Constantes.TEXTO_CABECERA:
                        return next.getValor().toString().split(",");
                }
        }
        return null;
    }
    
    private String crearQuery(){
        String sql="SELECT ";
        String queryWhere ="WHERE ";
        for (Iterator<Componente> iterator = listaComponente.iterator(); iterator.hasNext();) {
            Componente next = iterator.next();
            if(!"".equalsIgnoreCase(next.getValor().toString())){
                switch(next.getTipo()){
//                    case Constantes.TEXTO_CABECERA:
//                        if(existeCabecera((String)next.getValor())!=null){
//                            cabecera=(String)next.getValor();
//                        }
//                        break;
                    case Constantes.TEXTO_CADENA:
                        if(existeCabecera(next.getNombreBD())!=null)
                        queryWhere = queryWhere + next.getNombreBD() +" "+next.getOperadorBD()+" '"+(String)next.getValor()+"' and ";
                        break;
                    case Constantes.TEXTO_NUMERO:
                        if(existeCabecera(next.getNombreBD())!=null)
                        queryWhere = queryWhere + next.getNombreBD() +" "+next.getOperadorBD()+" "+(String)next.getValor()+" and ";
                        break;
                    case Constantes.COMBO_RELLENADO:
                        if(existeCabecera(next.getNombreBD())!=null)
                        queryWhere = queryWhere + next.getNombreBD() +" "+next.getOperadorBD()+" '"+(String)next.getValor()+"' and ";
                        break;
                    default:break;
                }
            }
        }
        if(!queryWhere.equalsIgnoreCase(" ")){
                queryWhere=queryWhere.substring(0, queryWhere.length()-4);
            }
        sql = sql + cabeceraQuery +" FROM "+db.getNombre()+" "+queryWhere;
        System.out.println(sql);
        return sql;
    }
    
    public void generarReporte(){
        Connection connection = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cliente?zeroDateTimeBehavior=convertToNull","root", "root");
	} catch (SQLException e) {
		e.printStackTrace();
		return;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
	}
        
	JasperReportBuilder report = DynamicReports.report();//a new report
	
        
        cargarCabecerasReporte(report);
//        System.out.println("asd "+cabeceras[0]);
        
        
        report.title(//title of the report
	      Components.text(db.getTitulo())
		  .setHorizontalAlignment(HorizontalAlignment.CENTER))
		  .pageFooter(Components.pageXofY())//show page number on the page footer
		  .setDataSource(crearQuery(),
                                  connection);

	try {
                //show the report
		report.show();

                //export the report to a pdf file
		report.toPdf(new FileOutputStream("d:/report.pdf"));
	} catch (DRException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
    }

    private void cargarCabecerasReporte(JasperReportBuilder report) {
//        report.columns(Columns.column("ID", "id", DataTypes.integerType()).setHorizontalAlignment(HorizontalAlignment.LEFT),
//	      Columns.column("Nombre", "nombre", DataTypes.stringType())).addColumn(Columns.column("SEXO", "sexo", DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT));
        String[] cabeceras = getCabeceras();
        if(cabeceras==null || cabeceras.length<=0 || cabeceras[0].equalsIgnoreCase("*")|| cabeceras[0].equalsIgnoreCase("")){
            for (Map.Entry<String, String> entrySet : db.getColumnas().entrySet()) {
            report.columns(Columns.column(entrySet.getValue(), entrySet.getKey(), DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT));
            cabeceraQuery = cabeceraQuery + entrySet.getKey()+",";
            System.out.println("value="+entrySet.getValue()+", key="+entrySet.getKey());
        }
        }else{
            for (int i = 0; i < cabeceras.length; i++) {
                Map.Entry<String, String> cab = existeCabecera(cabeceras[i]);
                if(cab!=null){
                    report.columns(Columns.column(cab.getValue(), cab.getKey(), DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT));
                    cabeceraQuery = cabeceraQuery + cab.getKey()+",";
                }
//                report.columns(Columns.column(cabeceras[i], cabeceras[i], DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT));
            }
        }
        if(cabeceraQuery.substring(cabeceraQuery.length() - 1).equalsIgnoreCase(",")){
            cabeceraQuery=cabeceraQuery.substring(0, cabeceraQuery.length()-1);
        }
        
        
    }
    
    private Map.Entry<String, String> existeCabecera(String cabeceraBD){
        for (Map.Entry<String, String> entrySet : db.getColumnas().entrySet()) {
            if(cabeceraBD.equalsIgnoreCase(entrySet.getKey())){
                return entrySet;
            }
        }
        return null;
    }

    
}
