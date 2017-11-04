load("nashorn:mozilla_compat.js");
//importacion de librerias
importPackage(java.awt); //paquete en concreto-(*)
importClass(java.awt.Frame); //clase de un paquete en concreto
importPackage(com.mis.proyectoreportemaven.negocio);
importPackage(com.mis.proyectoreportemaven.entity);
importClass(com.mis.proyectoreportemaven.negocio.FactoriaComponente);
//importacion de Objetos
var ArrayList = Java.type("java.util.ArrayList");
var pathArchivo = "src/main/java/com/mis/proyectoreportemaven/archivos/javaSwing.js"
