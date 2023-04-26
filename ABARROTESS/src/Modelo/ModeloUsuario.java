/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


import pckgWEB.WSBD;
import pckgweb.WSBD_Service;
/**
 *
 * @author lpzlu
 */


public class ModeloUsuario {
    
    private WSBD_Service obj1=new WSBD_Service();
    private WSBD obj2=obj1.getWSBDPort();
    String leyenda;
    
    public String alta (String tabla , String datos){
        String leyenda;
        leyenda = obj2.altas(tabla,datos);
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
        
        String leyenda;
        leyenda=obj2.consultar(tabla, datos,condicion);
        return leyenda;
    } 
    
      //GEARRDO
       public String AltasProductos (String tabla , String datos){
  
        leyenda=obj2.AltaProductos(tabla,datos);
       return leyenda;
    } 
    
    public String eliminarProductos (String tabla , String datos){
   
        leyenda=obj2.eliminarProductos(tabla, datos);
        return leyenda;
    }
    
     public String modificarProductos (String tabla , String datos, String condicion){
        
       leyenda=obj2.modificarProductos(tabla, datos,condicion);
        return leyenda;
    } 
     
     //METER EN UN ARRAY LA INFORMACIÓN
     
    
      public String ConsultarProductos (String tabla , String datos, String condicion){
        
        leyenda=obj2.consultarProductos(tabla, datos,condicion);
        return leyenda;
    } 

    public String editarProductos(String productos, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     
    
    
    public String AltasProveedores (String tabla , String datos){
  
        leyenda=obj2.altasProveedores(tabla,datos);
       return leyenda;
    } 
    
    public String eliminarProveedores (String tabla , String datos){
   
        leyenda=obj2.eliminarProveedores(tabla, datos);
        return leyenda;
    }
    
     public String modificarProveedores (String tabla , String datos, String condicion){
        
       leyenda=obj2.modificarProveedores(tabla, datos,condicion);
        return leyenda;
    } 
     
     //METER EN UN ARRAY LA INFORMACIÓN
     
    
      public String ConsultarProveedores (String tabla , String datos, String condicion){
        
        leyenda=obj2.consultarProveedores(tabla, datos,condicion);
        return leyenda;
    } 

    public String editarProveedores(String productos, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //CARLOS
    
    
    
    public String AltasCategoria (String tabla , String datos){
  
        leyenda=obj2.AltasCategorias(tabla,datos);
       return leyenda;
    } 
    
    public String eliminarCategoria  (String tabla , String datos){
   
        leyenda=obj2.eliminarProveedores(tabla, datos);
        return leyenda;
    }
    
     public String modificarCategoria  (String tabla , String datos, String condicion){
        
       leyenda=obj2.modificarProveedores(tabla, datos,condicion);
        return leyenda;
    } 
     
     //METER EN UN ARRAY LA INFORMACIÓN
     
    
      public String ConsultarCategoria  (String tabla , String datos, String condicion){
        
        leyenda=obj2.consultarProveedores(tabla, datos,condicion);
        return leyenda;
    } 

    public String editarCategoria (String productos, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    //REZENDIZ
    
    
    
    
    public String AltasTicket(String tabla , String datos){
  
        leyenda=obj2.altasProveedores(tabla,datos);
       return leyenda;
    } 
    
    public String eliminarTicket (String tabla , String datos){
   
        leyenda=obj2.eliminarProveedores(tabla, datos);
        return leyenda;
    }
    
     public String modificarTicket (String tabla , String datos, String condicion){
        
       leyenda=obj2.modificarProveedores(tabla, datos,condicion);
        return leyenda;
    } 
     
     //METER EN UN ARRAY LA INFORMACIÓN
     
    
      public String ConsultarTicket (String tabla , String datos, String condicion){
        
        leyenda=obj2.consultarProveedores(tabla, datos,condicion);
        return leyenda;
    } 

    public String editarTicket(String productos, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    } 
        

