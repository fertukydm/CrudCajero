
package controlador;

public class Cajero {
    
    String nombre;
    String colorPiel;
    int edad;
    double salario;
    String tipoSangre;
    
    //Constructor
    public Cajero(String nombreQuePido, int edadQuePido){
        this.nombre = nombreQuePido;
        this.edad = edadQuePido;
    }
    
      public Cajero(String color){
        this.colorPiel = color;
    }
}
