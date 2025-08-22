import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

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

    public boolean validarHorario(Date inicio, Date fin) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inicio);
        int horaInicio = cal.get(Calendar.HOUR_OF_DAY);
        cal.setTime(fin);
        int horaFin = cal.get(Calendar.HOUR_OF_DAY);
        return horaInicio >= 6 && horaFin <= 22;
    }

    public boolean agregarReserva(String responsable, String nombre, String tipoEvento, Date inicio, Date fin, int participantes, double deposito){
    Reserva reserva = new Reserva(responsable, nombre, tipoEvento, inicio, fin);
    return complejo.reservar(reserva, deposito, participantes);
}

    public String verListaEspera(){
        return complejo.verListaEspera();
    }

    public String verCancha(String tipo){
        return complejo.verCanchasPorTipo(tipo);
    }
    
}