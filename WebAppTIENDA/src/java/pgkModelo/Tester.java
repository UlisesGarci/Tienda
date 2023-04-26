package pgkModelo;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i,j;
		MDB administradorBD =  new MDB();
		List<ArrayList<String>> datosObtenidos= new ArrayList<ArrayList<String>>();
		ArrayList<String> renglonObtenido = new ArrayList<String>();
		String leyenda = "";
                
                //consulta
		/*datosObtenidos = administradorBD.consultarDatos("cliente", "id_cliente, nombre,apellido,email,telefono,direccion","id_cliente>=1");
                  System.out.println(leyenda);
                  for(i=0;i<datosObtenidos.size();j++)
                  {
                      renglonObtenido = datosObtenidos.get(i);
                      for(j=0;j<renglonObtenido.size();j++){
                          System.out.println(renglonObtenido.get(j)+"");
                      }
                      System.out.println();
                  }*/
                //insertar
                //leyenda= administradorBD.registrarAlta("cliente"," '2', 'uli', 'hgy', 'jfytdyt', '1256416', 'jgduyrdugv'");
		//System.out.println(leyenda);
                
                //modificar
	//leyenda = administradorBD.modificarRegistro("cliente", "nombre='ulises'" , "id_cliente = 2");
          // System.out.println(leyenda);
                
                //Borrar
           //leyenda = administradorBD.borrarRegistro("cliente", "id_cliente = 1");
              //System.out.println(leyenda);
		
        }
}
