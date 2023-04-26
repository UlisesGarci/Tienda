/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuario;
import Modelo.ModeloUsuarioContrasena;
import Vistas.UsuarioContrasena;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ControladorUsuarioContrasena implements ActionListener{
    private UsuarioContrasena _usua;
    private ModeloUsuarioContrasena _model;
    public ControladorUsuarioContrasena(UsuarioContrasena usua, ModeloUsuarioContrasena model)
    {
      this._usua=usua;
      this._model=model;
      
      this._usua.txtUsuario.addActionListener(this);
      this._usua.txtContrasena.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String leyenda="";
        
         if(e.getSource() == _usua.btnIngresar){
            leyenda = _model.alta("sesion", "idUsuario,'" +_usua.txtUsuario.getText() + "','" + _usua.txtContrasena.getText() + "'");
            JOptionPane.showMessageDialog(null, leyenda);
     limpiar();//se limpian las cajas de texto
     //agregar otros botones si se necesitan implementar
        
     }
         
      }    
    public void iniciar(){
        _usua.setTitle("MVC_Visual");
    }
    
    public void limpiar(){
        _usua.txtUsuario.setText(null);
        _usua.txtContrasena.setText(null);
       }
    
}
