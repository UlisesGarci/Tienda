package Modelo;


import pckgweb.WSBD;
import pckgweb.WSBD_Service;

/**
 *
 * @author lpzlu
 */


public class ModeloCategoria {
    
    private WSBD_Service obj1=new WSBD_Service();
    private WSBD obj2=obj1.getWSBDPort();
    String leyenda;
    
    public String altas (String tabla , String datos){
  
        leyenda=obj2.altas (tabla,datos);
        return leyenda;
    } 
    
    public String eliminar (String tabla , String datos){
   
        leyenda=obj2.eliminar(tabla, datos);
        return leyenda;
    }
    
     public String modificar (String tabla , String datos, String condicion){
        
       // leyenda=obj2.modificar(tabla, datos,condicion);
        return leyenda;
    } 
     
     //METER EN UN ARRAY LA INFORMACIÓN
     
    
      public String Consultar (String tabla , String datos, String condicion){
        
        leyenda=obj2.consultar(tabla, datos,condicion);
        return leyenda;
    } 

 
    
    
    } 
