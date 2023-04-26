/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuario;
import Vistas.Cliente;
import Vistas.Productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ulesg
 */
public class ControladorCliente implements ActionListener {
    
    private Cliente _client;
    private ModeloUsuario _model;
    public ControladorCliente(Cliente client, ModeloUsuario model)
    {
      this._client=client;
      this._model=model;
      
      this._client.btninsertarclientes.addActionListener(this);
      this._client.btneliminarclientes.addActionListener(this);
      this._client.btneditarclientes.addActionListener(this);
      this._client.btnconsultarclientes.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String leyenda="";
        
         if(e.getSource() == _client.btninsertarclientes){
            leyenda = _model.alta("cliente","'" + _client.txtidcliente.getText()+"','" + _client.txtnombrecliente.getText() + "','" + _client.txtapellidocliente.getText() + "','" + _client.txtemailcliente.getText() + "', '" + _client.txttelefonocliente.getText() + "','" + _client.txtdireccioncliente.getText()+ "'");
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        }
         if(e.getSource() ==_client.btneliminarclientes ){
            leyenda = _model.eliminar("cliente", "id_cliente = " + _client.txtidcliente.getText());
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        
         }          
               if(e.getSource() == _client.btneditarclientes){
            leyenda = _model.modificar("cliente", "id_cliente = '" +                
                    _client.txtidcliente.getText()+ "',  Nombre = '"+
                    _client.txtnombrecliente.getText() + "', Apellido = '" +
                    _client.txtapellidocliente.getText() + "', Telefono = '" + 
                    _client.txttelefonocliente.getText() + "', Email= '" + 
                    _client.txtemailcliente.getText() + "', Direccion = '" +
                    _client.txtdireccioncliente.getText() + "'" ," id_cliente = " + _client.txtidcliente.getText());          
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        }
               
               if(e.getSource()==_client.btnconsultarclientes){
                   
                   List<String> datos = new ArrayList<>();
                   String consulta = _model.Consultar("cliente","id_cliente,nombre,apellido,telefono,email,direccion","id_cliente>=1");
                   datos.addAll(Arrays.asList(consulta.split(",")));
                   DefaultTableModel tabla = new DefaultTableModel();
                   tabla.addColumn("id_cliente");
                   tabla.addColumn("nombre");
                   tabla.addColumn("apellido");
                   tabla.addColumn("telefono");
                   tabla.addColumn("email");
                   tabla.addColumn("direccion");
                   _client.tabla_cliente.setModel(tabla);
                   for (int i = 0; i < datos.size(); i += 6) {
                       Object[] fila = new Object[6];
                       for (int j = 0; j < 6; j++) {
                           fila[j] = datos.get(i + j);
                       }
                       tabla.addRow(fila);
               }
        
               }
    }
    public void limpiar(){
        _client.txtidcliente.setText(null);
        _client.txtnombrecliente.setText(null);
        _client.txtapellidocliente.setText(null);
        _client.txttelefonocliente.setText(null);
        _client.txtemailcliente.setText(null);
        _client.txtdireccioncliente.setText(null);
}
}