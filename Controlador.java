import java.util.Date;
import java.util.ArrayList;

import Modelo.ComplejoDeportivo;
import Modelo.Cancha;
import Modelo.Reserva;
import Modelo.ListaEspera;

public class Controlador {
    public ComplejoDeportivo complejo;

    public Controlador(){
        complejo = new ComplejoDeportivo();
    }

    public void agregarCancha(String tipo, Integer numero, Integer capacidad, Integer costo){
        complejo.agregar(tipo, numero, capacidad, costo);
    }

    public void agregarReserva(String responsable, String nombre, String tipo, Date fechaInicio, Date fechaFin){

    }

    public String verCancha(String tipo){
        return complejo.verCanchasPorTipo(tipo);
    }

    public String verListaEspera(){
        return null;
    }
    
}