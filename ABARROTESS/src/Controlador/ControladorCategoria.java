/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloUsuario;
import Vistas.Categoria;
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
public class ControladorCategoria implements ActionListener {
    
    private Categoria _categor;
    private ModeloUsuario _modelcate;
    public ControladorCategoria(Categoria client, ModeloUsuario modelcate)
    {
      this._categor=client;
      this._modelcate=modelcate;
      
      this._categor.btnagregarcategoria.addActionListener(this);
      this._categor.btneliminarcategoria.addActionListener(this);
      this._categor.btneditarcategoria.addActionListener(this);
      this._categor.btnconsultarcategoria.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String leyenda="";
        
         if(e.getSource() == _categor.btnagregarcategoria){
            leyenda = _modelcate.AltasCategoria("categoria","'" + _categor.txtidcategoria.getText()+"','" + _categor.txtnombrecategoria.getText() + "','" + _categor.txtdescripcioncategoria.getText() + "'");
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        }
         if(e.getSource() ==_categor.btneliminarcategoria ){
            leyenda = _modelcate.eliminarCategoria("categoria", "id_categoria = " + _categor.txtidcategoria.getText());
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        
         }          
               if(e.getSource() == _categor.btneditarcategoria){
            leyenda = _modelcate.modificarCategoria("categoria", "id_categoria = '" +                
                    _categor.txtidcategoria.getText()+ "',  nombre = '"+
                    _categor.txtnombrecategoria.getText() + "', descripcion = '" +
                    _categor.txtdescripcioncategoria.getText() +  "'" ," id_categoria = " + _categor.txtidcategoria.getText());          
            JOptionPane.showMessageDialog(null, leyenda);
            
        }
               
               if(e.getSource()==_categor.btnconsultarcategoria){
                   
                   List<String> datos = new ArrayList<>();
                   String consulta = _modelcate.ConsultarCategoria("categoria","id_categoria,nombre,descripcion","id_categoria>=1");
                   datos.addAll(Arrays.asList(consulta.split(",")));
                   DefaultTableModel tabla = new DefaultTableModel();
                   tabla.addColumn("id_categoria");
                   tabla.addColumn("nombre");
                   tabla.addColumn("descripcion");
                   _categor.Tabla_Categoria.setModel(tabla);
                   for (int i = 0; i < datos.size(); i += 3) {
                       Object[] fila = new Object[3];
                       for (int j = 0; j < 3; j++) {
                           fila[j] = datos.get(i + j);
                       }
                       tabla.addRow(fila);
               }
        
               }
    }
    public void limpiar(){
        _categor.txtidcategoria.setText(null);
        _categor.txtnombrecategoria.setText(null);
        _categor.txtdescripcioncategoria.setText(null);
}
}