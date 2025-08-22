package Modelo;
import java.util.Date;


public class Reserva {
    private String responsable;
    private String nombre;
    private String tipo;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva(String responsable, String nombre, String tipo, Date fechaInicio, Date fechaFin){
        this.responsable = responsable;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String info(){
        return "";
    }
}