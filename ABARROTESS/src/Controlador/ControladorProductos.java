
package Controlador;

import Modelo.ModeloUsuario;
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
public class ControladorProductos implements ActionListener {
    
    private Productos _product;
    private ModeloUsuario _modelproduct;
    public ControladorProductos(Productos product, ModeloUsuario modelproduct)
    {
      this._product=product;
      this._modelproduct=modelproduct;
      
      this._product.btninsertarproductos.addActionListener(this);
      this._product.btneliminarproductos.addActionListener(this);
      this._product.btneditarproductos.addActionListener(this);
      this._product.btnconsultarproductos.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String leyenda="";
        
         if(e.getSource() == _product.btninsertarproductos){
            leyenda = _modelproduct.AltasProductos("productos","'" + _product.txtidproductos.getText()+"','" + _product.txtnombreproducto.getText() + "','" + _product.txtdescripcionproducto.getText() + "','" + _product.txtprecioproducto.getText()+ "'");
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        }
         if(e.getSource() ==_product.btneliminarproductos ){
            leyenda = _modelproduct.eliminarProductos("productos", "id_producto = " + _product.txtidproductos.getText());
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        
         }          
               if(e.getSource() == _product.btneditarproductos){
            leyenda = _modelproduct.modificarProductos("productos", "id_producto = '" +                
                    _product.txtidproductos.getText()+ "',  nombre = '"+
                    _product.txtnombreproducto.getText() + "', descripcion = '" +
                    _product.txtdescripcionproducto.getText() + "', precio = '" + 
                    _product.txtprecioproducto.getText() + "'" ," id_producto= " + _product.txtidproductos.getText());          
            JOptionPane.showMessageDialog(null, leyenda);
            
        }
               
               if(e.getSource()==_product.btnconsultarproductos){
                   
                   List<String> datos = new ArrayList<>();
                   String consulta = _modelproduct.ConsultarProductos("productos","id_producto,nombre,descripcion,precio","id_producto>=1");
                   datos.addAll(Arrays.asList(consulta.split(",")));
                   DefaultTableModel tabla = new DefaultTableModel();
                   tabla.addColumn("id_producto");
                   tabla.addColumn("nombre");
                   tabla.addColumn("descripcion");
                   tabla.addColumn("precio");
                   _product.TablaProductos.setModel(tabla);
                   for (int i = 0; i < datos.size(); i += 4) {
                       Object[] fila = new Object[4];
                       for (int j = 0; j < 4; j++) {
                           fila[j] = datos.get(i + j);
                       }
                       tabla.addRow(fila);
               }
        
               }
    }
    public void limpiar(){
        _product.txtidproductos.setText(null);
        _product.txtnombreproducto.setText(null);
        _product.txtdescripcionproducto.setText(null);
        _product.txtprecioproducto.setText(null);
}
}