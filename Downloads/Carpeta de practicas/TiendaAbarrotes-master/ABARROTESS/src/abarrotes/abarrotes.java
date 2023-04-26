package ABARROTES;

import Controlador.ControladorCategoria;
import Controlador.ControladorUsuarioContrasena;
import Modelo.ModeloUsuario;
import Modelo.ModeloUsuarioContrasena;
import Vistas.Categoria;
import Vistas.UsuarioContrasena;


public class abarrotes{

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Categoria categor = new Categoria();
        ModeloUsuario  model = new ModeloUsuario ();
        categor.setVisible(true);
        ControladorCategoria objCa = new ControladorCategoria(categor, model);
        
        //UsuarioContrasena usua = new UsuarioContrasena();
        //ModeloUsuarioContrasena mdu = new ModeloUsuarioContrasena();
        //usua.setVisible(true);
        //ControladorUsuarioContrasena ogb6 = new ControladorUsuarioContrasena(usua, mdu);
    }
    
}
