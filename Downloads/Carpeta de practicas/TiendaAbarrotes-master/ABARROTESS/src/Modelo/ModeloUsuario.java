/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


import pckgweb.WSBD;
import pckgweb.WSBD_Service;

/**
 *
 * @author lpzlu
 */


public class ModeloUsuario {
    
    private WSBD_Service obj1=new WSBD_Service();
    private WSBD obj2=obj1.getWSBDPort();
    String leyenda;
    
    public String altas (String tabla , String datos){
        String leyenda;
        leyenda=obj2.altas(tabla,datos);
       return leyenda;
    } 
    
    public String eliminar (String tabla , String datos){
        String leyenda;
        leyenda=obj2.eliminar(tabla, datos);
        return leyenda;
    }
    
     public String modificar (String tabla , String datos, String condicion){
       String leyenda;
       leyenda=obj2.editar(tabla, datos,condicion);
        return leyenda;
    } 
     
     //METER EN UN ARRAY LA INFORMACIÓN
     
    
      public String Consultar (String tabla , String datos, String condicion){
        
        leyenda=obj2.consultar(tabla, datos,condicion);
        return leyenda;
    } 

    public String editar(String productos, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    }
        

