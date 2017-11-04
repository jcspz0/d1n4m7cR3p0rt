frame.setSize(600, 600);
frame.adicionar( FactoriaComponente.getComponente("texto", "*", Constantes.TEXTO_CABECERA,"",""));
frame.adicionar( FactoriaComponente.getComponente("texto", "Juan", Constantes.TEXTO_CADENA,"NOMBRE",Constantes.OPERADOR_IGUAL));
combo = new DefaultComboBoxModel();
combo.addElement("M");
combo.addElement("F");
frame.adicionar( FactoriaComponente.getComponente("combo", combo, Constantes.COMBO_RELLENADO,"SEXO",Constantes.OPERADOR_IGUAL));
frame.adicionar(FactoriaComponente.getComponente("boton", "Mostrar Reporte", Constantes.BOTON_REPORTE,null,null));
frame.mostrar();

