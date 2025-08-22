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

    public String info(){
        return "";
    }
}
