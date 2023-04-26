/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgWEB;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pgkModelo.MDB;

/**
 *
 * @author gerar
 */
@WebService(serviceName = "WSBD")
public class WSBD {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Altas")
    public String Altas(@WebParam(name = "tabla") String tabla, @WebParam(name = "datos")String datos) {
        MDB administradoBD = new MDB();
        String leyenda;
        leyenda= administradoBD.registrarAlta("cliente", datos);
        System.out.println(leyenda);
        return leyenda;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public String eliminar(@WebParam(name = "tablas") final String tablas, @WebParam(name = "datos") final String datos) {
        //TODO write your implementation code here:
        MDB administradoBD = new MDB();
        String leyenda;
        leyenda = administradoBD.borrarRegistro(tablas, datos);
        return leyenda;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultar")
    public String consultar(@WebParam(name = "tablas") final String tablas, @WebParam(name = "datos") final String datos, @WebParam(name = "condicion") final String condicion) {
        MDB administradoBD = new MDB();
        String[] extraer = new String[100];
        String info ="";
         int i,j;
        List<ArrayList<String>> datosObtenidos= new ArrayList<ArrayList<String>>();
        ArrayList<String> infoReclutada = new ArrayList<String>();
        datosObtenidos = administradoBD.consultarDatos(tablas, datos, condicion);
        
                for(i=0;i<datosObtenidos.size();i++){
                    infoReclutada = datosObtenidos.get(i);
                    for(j=0;j<infoReclutada.size();j++){
                        info = info + infoReclutada.get(j)+",";
                    }
                    
                    extraer[i] = info;
                
                }
        
        return info;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editar")
    public String editar(@WebParam(name = "tablas") final String tablas, @WebParam(name = "datos") final String datos, @WebParam(name = "condicion") final String condicion) {
        MDB administradoBD = new MDB();
        String leyenda;
        leyenda = administradoBD.modificarRegistro(tablas, datos , condicion);
        return leyenda;
    }


}
