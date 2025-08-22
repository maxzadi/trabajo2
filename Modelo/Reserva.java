package Modelo;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Reserva {
    private String responsable;
    private String nombre;
    private String tipo;
    public Date fechaInicio;
    public Date fechaFin;

    public Reserva(String responsable, String nombre, String tipo, Date fechaInicio, Date fechaFin){
        this.responsable = responsable;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String[] info(){
        String[] datos= new String[5];
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        datos[0] = responsable;
        datos[1] = nombre;
        datos[2] = tipo;
        datos[3] = formato.format(fechaInicio);
        datos[4] = formato.format(fechaFin);

        return datos;
    }
}