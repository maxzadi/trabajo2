package Modelo;
import java.util.ArrayList;

public class ListaEspera {
    private ArrayList<Reserva> reservas;

    public ListaEspera(){
        this.reservas= new ArrayList<Reserva>();
    }

    public void agregar(Reserva reserva){
        reservas.add(reserva);
    }

    public void quitar(Integer posicion){
        if(posicion >=0 && posicion < reservas.size()){
                    reservas.remove((int)posicion);
        }
    }

    public ArrayList<Reserva> obtener(){
        return reservas;
    }
}
