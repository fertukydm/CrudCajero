
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.CajeroReg;
import vistas.RegistrodeCajero;

public class ctrlCajero {
     //1- Llamar a las otras capas(modelo, vista)
    private RegistrodeCajero vistas;
    private CajeroReg modelo;
    
    //2- Crear el constructor de la clase
    public ctrlCajero(RegistrodeCajero Vista, CajeroReg Modelo){
        this.vistas = Vista;
        this.modelo = Modelo;

        
        vistas.btnGuardar.addMouseListener(this); 
        
        //Para mostrar los datos
        vistas.jtbCajero.addMouseListener(this);
        modelo.Mostrar(vistas.jtbCajero);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        
      if(e.getSource() == vistas.btnGuardar){
          modelo.setNombre_Cajero(vistas.txtNombre.getText());
          modelo.setPrecio(Double.parseDouble( vistas.txtPrecio.getText()));
          modelo.setCategoria(vistas.txtCategoria.getText());
          
          modelo.Guardar();
          modelo.Mostrar(vistas.jtbCajero);
      }
    }



    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    

}
