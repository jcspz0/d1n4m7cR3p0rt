frame.setSize(600, 600);
frame.adicionar(FactoriaComponente.getComponente("etiqueta", "valor1",null,null));
frame.adicionar(FactoriaComponente.getComponente("texto", "Juan", "NOMBRE",Constantes.OPERADOR_IGUAL));
frame.adicionar(FactoriaComponente.getComponente("boton", "mostrar", null,null));
frame.mostrar();

