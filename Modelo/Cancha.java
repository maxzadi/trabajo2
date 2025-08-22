package Modelo;
import java.util.ArrayList;

public class Cancha {
    private String tipo;
    private Integer numero;
    private Integer capacidad;
    private Integer costo;
    private ArrayList<Reserva> reservas;

    public Cancha(String tipo, Integer numero, Integer capacidad, Integer costo){
        this.tipo = tipo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.costo = costo;
        reservas=new ArrayList<Reserva>();
    }

    public void reservar(Reserva reserva){

    }

    public String[] info(){
        String[] datos= new String[4];
        datos[0] = tipo;
        datos[1] = numero.toString();
        datos[2] = capacidad.toString();
        datos[3] = costo.toString();
        return datos;
    }
    
    public ArrayList<Reserva> obtenerReservas(){
        return reservas;
    }
}
