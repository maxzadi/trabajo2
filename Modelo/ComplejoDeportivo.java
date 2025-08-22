package Modelo;
import java.util.ArrayList;

public class ComplejoDeportivo {
    ArrayList<Cancha> canchas;
    ListaEspera lista;

    public ComplejoDeportivo(){
        canchas = new ArrayList<Cancha>();
        lista = new ListaEspera();
    }

    public void agregar(String tipo, Integer numero, Integer capacidad, Integer costo){

    }

    public void reservar(Reserva reserva, Boolean espera){

    }

    public Boolean validarReserva(){
        return null;
    }

    public String verListaEspera(){
        return null;
    }

    public String verReservas(){
        return null;
    }
}
