package co.utp.meter.Control.Fabrica;

public class Fabrica {
    public Conexion GetConexion(String estado){
                   
            if(estado.equalsIgnoreCase("agua")){
                return new Water();
            }
            
            else if(estado.equalsIgnoreCase("energy")){
               return new Energy();
            }
        return new EstadoVacio();
    }
}
