/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.proyectoreportemaven.report;

import com.mis.proyectoreportemaven.Utils.Constantes;
import com.mis.proyectoreportemaven.negocio.Componente;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
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

    public MyReporte(List<Componente> listaComponente) {
        this.listaComponente = listaComponente;
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
        String cabecera = "*";
        String queryWhere ="WHERE ";
        for (Iterator<Componente> iterator = listaComponente.iterator(); iterator.hasNext();) {
            Componente next = iterator.next();
            if(!"".equalsIgnoreCase(next.getValor().toString())){
                switch(next.getTipo()){
                    case Constantes.TEXTO_CABECERA:
                        cabecera=(String)next.getValor();
                        break;
                    case Constantes.TEXTO_CADENA:
                        queryWhere = queryWhere + next.getNombreBD() +" "+next.getOperadorBD()+" '"+(String)next.getValor()+"' and ";
                        break;
                    case Constantes.TEXTO_NUMERO:
                        queryWhere = queryWhere + next.getNombreBD() +" "+next.getOperadorBD()+" "+(String)next.getValor()+" and ";
                        break;
                    case Constantes.COMBO_RELLENADO:
                        queryWhere = queryWhere + next.getNombreBD() +" "+next.getOperadorBD()+" '"+(String)next.getValor()+"' and ";
                        break;
                }
            }
        }
        if(!queryWhere.equalsIgnoreCase(" ")){
                queryWhere=queryWhere.substring(0, queryWhere.length()-4);
            }
        sql = sql + cabecera +" FROM CLIENTE "+queryWhere;
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
	
        String[] cabeceras = getCabeceras();
        if(cabeceras.length<=0 || cabeceras[0].equalsIgnoreCase("*")){
            report.columns(Columns.column("ID", "id", DataTypes.integerType()).setHorizontalAlignment(HorizontalAlignment.LEFT),
	      Columns.column("Nombre", "nombre", DataTypes.stringType())).addColumn(Columns.column("SEXO", "sexo", DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT));
        }else{
            for (int i = 0; i < cabeceras.length; i++) {
                report.columns(Columns.column(cabeceras[i], cabeceras[i], DataTypes.stringType()).setHorizontalAlignment(HorizontalAlignment.LEFT));
            }
        }
        
        report.title(//title of the report
	      Components.text("Reporte")
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
}
