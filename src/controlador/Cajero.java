
package controlador;

public class Cajero {
    
    String UUID_Cajero;
    String Nombre_Cajero;
    int Edad_Cajero;
    double Peso_Cajero;
    String Correo_Cajero;
    
    //Constructor
    public Cajero(String nombreQuePido, int edadQuePido){
        this.Nombre_Cajero = nombreQuePido;
        this.Edad_Cajero = edadQuePido;
    }
    
      public Cajero(String peso){
        this.Peso_Cajero = Peso_Cajero;
    }
}
