
package Controlador;

import Modelo.ModeloUsuario;
import Vistas.Ticket;

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
public class ControladorTicket implements ActionListener {
    
    private Ticket _tick;
    private ModeloUsuario _modelticket;
    public ControladorTicket(Ticket tick, ModeloUsuario modelticket)
    {
      this._tick=tick;
      this._modelticket=modelticket;
      
      this._tick.btnGuardarTicket.addActionListener(this);
      this._tick.btneliminarticket.addActionListener(this);
      this._tick.btneditarticket.addActionListener(this);
      this._tick.btnvisualizararticulos.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String leyenda="";
        
         if(e.getSource() == _tick.btnGuardarTicket){
            leyenda = _modelticket.AltasTicket("ticket","'" + _tick.txtidticket.getText()+"','" + _tick.txtfechafactura.getText() + "','" + _tick.txtvalortotal.getText() + "','" + _tick.txtefectivotickee.getText() + "','" + _tick.txtcambioticket.getText()+ "'");
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        }
         if(e.getSource() ==_tick.btneliminarticket ){
            leyenda = _modelticket.eliminarTicket("ticket", "id_ticket = " + _tick.txtidticket.getText());
            JOptionPane.showMessageDialog(null, leyenda);
            
            limpiar();
        
         }          
               if(e.getSource() == _tick.btneditarticket){
            leyenda = _modelticket.modificarTicket("ticket", "id_ticket = '" +                
                    _tick.txtidticket.getText()+ "',  fecha = '"+
                    _tick.txtfechafactura.getText() + "', total = '" +
                    _tick.txtvalortotal.getText() + "', efectivo = '" + 
                    _tick.txtefectivotickee.getText() + "', cambio = '" +
                    _tick.txtcambioticket.getText() + "'" ," id_ticket= " + _tick.txtidticket.getText());          
            JOptionPane.showMessageDialog(null, leyenda);
            
        }
               
               if(e.getSource()==_tick.btnvisualizararticulos){
                   
                   List<String> datos = new ArrayList<>();
                   String consulta = _modelticket.ConsultarTicket("ticket","id_ticket,fecha,total,efectivo,cambio","id_ticket>=1");
                   datos.addAll(Arrays.asList(consulta.split(",")));
                   DefaultTableModel tabla = new DefaultTableModel();
                   tabla.addColumn("id_ticket");
                   tabla.addColumn("fecha");
                   tabla.addColumn("total");
                   tabla.addColumn("efectivo");
                   tabla.addColumn("cambio");
                   _tick.TablaTickett.setModel(tabla);
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
        _tick.txtidticket.setText(null);
        _tick.txtfechafactura.setText(null);
        _tick.txtvalortotal.setText(null);
        _tick.txtefectivotickee.setText(null);
        _tick.txtcambioticket.setText(null);
}
}