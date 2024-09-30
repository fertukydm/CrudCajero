
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CajeroReg {
     //1- Parametros
    String UUID_Cajero;
    String Nombre_Cajero;
    int Edad_Cajero;
    Number Peso_Cajero;
    String Correo_Cajero;
    
      public String getUUID_Cajero() {
        return UUID_Cajero;
    }

    public void setUUID_Cajero(String UUID_Cajero) {
        this.UUID_Cajero = UUID_Cajero;
    }

    public String getNombre_Cajero() {
        return Nombre_Cajero;
    }

    public void setNombre_Cajero(String Nombre_Cajero) {
        this.Nombre_Cajero = Nombre_Cajero;
    }

    public double getEdad_Cajero() {
        return Edad_Cajero;
    }

    public void setEdad_Cajero(int Edad_Cajero) {
        this.Edad_Cajero = Edad_Cajero;
    }

    public Number getPeso_Cajero() {
        return Peso_Cajero;
    }

    public void setPeso_Cajero(Number Peso_Cajero) {
        this.Peso_Cajero = Peso_Cajero;
    }
    public String getCorreo_Cajero(){
        return Correo_Cajero;
    }
    public void setCorreo_Cajero(String Correo_Cajero){
        this.Correo_Cajero = Correo_Cajero;
    }
    
    //3- Funciones (Guardar, mostrar, eliminar, actualizar)
   
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO tbCajero (UUID_Cajero, Nombre_Cajero, Edad_Cajero, Peso_Cajero, Correo_Cajero) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, UUID.randomUUID().toString());
            addProducto.setString(2, getNombre_Cajero());
            addProducto.setint(3, getEdad_Cajero());
            addProducto.setNumber(4, getPeso_Cajero());
            addProducto.setString(5, getCorreo_Cajero());
 
            //Ejecutar la consulta
            addProducto.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
    public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloPinulito = new DefaultTableModel();
        modeloPinulito.setColumnIdentifiers(new Object[]{"UUID_producto", "Nombre", "Precio", "Categoria"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbProductos");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloPinulito.addRow(new Object[]{rs.getString("UUID_producto"), 
                    rs.getString("nombre"), 
                    rs.getInt("precio"), 
                    rs.getString("categoria")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloPinulito);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
}
