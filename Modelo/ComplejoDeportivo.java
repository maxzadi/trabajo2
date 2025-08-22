package Modelo;
import java.util.ArrayList;

public class ComplejoDeportivo {
    public static ArrayList<Cancha> canchasFut;
    public static ArrayList<Cancha> canchasBasket;
    public static ArrayList<Cancha> canchasTenis;
    public ListaEspera lista;

    public ComplejoDeportivo(){
        canchasFut = new ArrayList<Cancha>();
        canchasBasket = new ArrayList<Cancha>();
        canchasTenis = new ArrayList<Cancha>();
        lista = new ListaEspera();
    }

    public void agregar(String tipo, Integer numero, Integer capacidad, Integer costo){
        Cancha cancha = new Cancha(tipo, numero, capacidad, costo);
        switch (tipo) {
        case "Fútbol":
            canchasFut.add(cancha);
            break;
        case "Baloncesto":
            canchasBasket.add(cancha);
            break;
        case "Tenis":
            canchasTenis.add(cancha);
            break;
    }
    }

    public void reservar(Reserva reserva, Boolean espera){

    }

    public Boolean validarReserva(){
        return null;
    }

    public String verListaEspera(){
        return null;
    }

    public static ArrayList<Cancha> getCanchaTipo(String tipo){
        switch (tipo) {
        case "Fútbol":
            return canchasFut;
        case "Baloncesto":
            return canchasBasket;
        case "Tenis":
            return canchasTenis;
        }
        return new ArrayList<Cancha>();
    }

    public String verCanchasPorTipo(String tipo) {
        ArrayList<Cancha> lista = getCanchaTipo(tipo);
        StringBuilder sb = new StringBuilder();

        sb.append("============ ").append(tipo).append(" ============\n\n");

        if (lista.isEmpty()) {
            sb.append("No hay canchas registradas de este tipo.\n");
            return sb.toString();
        }

        for (Cancha cancha : lista) {
            String[] datos = cancha.info();
            sb.append("-------------------- Cancha ").append(datos[1]).append(" --------------------\n");
            sb.append("Tipo: ").append(datos[0]).append("\n");
            sb.append("Capacidad: ").append(datos[2]).append("\n");
            sb.append("Costo: ").append(datos[3]).append("\n");
            sb.append("---------------------------------------------------\n");

            if (cancha.obtenerReservas().isEmpty()) {
                sb.append("No hay reservas registradas.\n\n");
            } else {
                int i = 1;
                for (Reserva r : cancha.obtenerReservas()) {
                    String[] datosReserva = r.info();
                    sb.append("Reserva ").append(i++).append("\n");
                    sb.append("Encargado: ").append(datosReserva[0]).append("\n");
                    sb.append("Nombre: ").append(datosReserva[1]).append("\n");
                    sb.append("Tipo: ").append(datosReserva[2]).append("\n");
                    sb.append("Fecha inicio: ").append(datosReserva[3]).append("\n");
                    sb.append("Fecha fin: ").append(datosReserva[4]).append("\n");
                    sb.append("---------------------------------------------------\n");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}