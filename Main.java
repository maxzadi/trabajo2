import java.util.Date;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Controlador controlador= new Controlador();
        iniciarVentana();
    }

    public static void iniciarVentana(){
        JFrame frame =new JFrame("Complejo Deportivo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.add(new JLabel("Complejo Deportivo"));


        frame.setVisible(true);
    }

    public void crearCanchas(){

    }

    public void agregarCancha(){

    }

    public void agregarReserva(){

    }

    public String verCancha(){
        return null;
    }

    public String verListaEspera(){
        return null;
    }
}