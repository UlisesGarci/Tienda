 
package Controlador;

import Modelo.ModeloUsuario;
import Vistas.Proveedores;

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
public class ControladorProveedores implements ActionListener {
    
    private Proveedores _proveed;
    private ModeloUsuario _modelproveed;
    public ControladorProveedores(Proveedores proveed, ModeloUsuario modelproveed)
    {
      this._proveed=proveed;
      this._modelproveed=modelproveed;
      
      this._proveed.btninsertarproveedores.addActionListener(this);
      this._proveed.btneliminarprovedor.addActionListener(this);
      this._proveed.btneditarprovedor.addActionListener(this);
      this._proveed.btnconsultarproveedores.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String leyenda="";
        
         if(e.getSource() == _proveed.btninsertarproveedores){
            leyenda = _modelproveed.AltasProveedores("proveedores","'" + _proveed.txtidproveedor.getText()+"','" + _proveed.txtnombreproveedor.getText() + "','" + _proveed.txtdireccionproveedores.getText() + "','" + _proveed.txtgmailprovedores.getText()+ "','" + _proveed.txttelefonoprovedores.getText()+"'");
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        }
         if(e.getSource() ==_proveed.btneliminarprovedor){
            leyenda = _modelproveed.eliminarProveedores("proveedores", "id_proveedor = " + _proveed.txtidproveedor.getText());
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        
         }          
               if(e.getSource() == _proveed.btneditarprovedor){
            leyenda = _modelproveed.modificarProveedores("proveedores", "id_proveedor = '" +                
                    _proveed.txtidproveedor.getText()+ "',  nombre = '"+
                    _proveed.txtnombreproveedor.getText() + "', direccion = '" +
                    _proveed.txtdireccionproveedores.getText() + "', email = '" + 
                    _proveed.txtgmailprovedores.getText() + "', telefono = '" + 
                    _proveed.txttelefonoprovedores.getText() + "'" ," id_proveedor= " + _proveed.txtidproveedor.getText());          
            JOptionPane.showMessageDialog(null, leyenda);
            
        }
               
               if(e.getSource()==_proveed.btnconsultarproveedores){
                   
                   List<String> datos = new ArrayList<>();
                   String consulta = _modelproveed.ConsultarProveedores("proveedores","id_proveedor,nombre,direccion,email,telefono","id_proveedor>=1");
                   datos.addAll(Arrays.asList(consulta.split(",")));
                   DefaultTableModel tabla = new DefaultTableModel();
                   tabla.addColumn("id_proveedor");
                   tabla.addColumn("nombre");
                   tabla.addColumn("direccion");
                   tabla.addColumn("email");
                   tabla.addColumn("telefono");
                   _proveed.TablaProveedoress.setModel(tabla);
                   for (int i = 0; i < datos.size(); i += 5) {
                       Object[] fila = new Object[5];
                       for (int j = 0; j < 5; j++) {
                           fila[j] = datos.get(i + j);
                       }
                       tabla.addRow(fila);
               }
        
               }
    }
    public void limpiar(){
        _proveed.txtidproveedor.setText(null);
        _proveed.txtnombreproveedor.setText(null);
        _proveed.txtdireccionproveedores.setText(null);
        _proveed.txtgmailprovedores.setText(null);
        _proveed.txttelefonoprovedores.setText(null);
}
}