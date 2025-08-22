import java.util.Date;
import javax.swing.*;
import java.awt.*;
import javafx.scene.text.Font;

import Modelo.Cancha;
import java.util.ArrayList;



public class Main {
    public static Controlador controlador= new Controlador();
    public static JFrame frame = new JFrame("Complejo Deportivo");
    public static void main(String[] args) {
        iniciarVentana();
        pedirDatosCanchas();
    }

    // Ventana principal
    public static void iniciarVentana(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Sistema de Reservaciones - Complejo Deportivo", SwingConstants.CENTER);
        frame.add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton btnAgregarCancha = new JButton("Agregar Cancha");
        JButton btnReservar = new JButton("Nueva Solicitud de Reserva");
        JButton btnVerCanchas = new JButton("Ver Canchas");
        JButton btnListaEspera = new JButton("Ver Lista de Espera");

        panelBotones.add(btnAgregarCancha);
        panelBotones.add(btnReservar);
        panelBotones.add(btnVerCanchas);
        panelBotones.add(btnListaEspera);

        frame.add(panelBotones, BorderLayout.CENTER);


        btnAgregarCancha.addActionListener(e->{
            agregarCancha();
        });
        btnReservar.addActionListener(e->{
            agregarReserva();
        });
        btnListaEspera.addActionListener(e->{
            verListaEspera();
        });
        btnVerCanchas.addActionListener(e -> {
            verCancha();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Ingresar datos iniciales
    public static void pedirDatosCanchas() {
        JOptionPane.showMessageDialog(null, "Ingrese los datos de 4 canchas");
        String[] tipos = new String[4];
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        int[] capacidades = new int[4];
        int[] costos = new int[4];

        for (int i = 1; i <= 4; i++) {
            JTextField tipoField = new JTextField();
            JTextField numeroField = new JTextField();
            JTextField capacidadField = new JTextField();
            JTextField costoField = new JTextField();

            JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
            panel.add(new JLabel("Tipo:"));
            panel.add(tipoField);
            panel.add(new JLabel("Número:"));
            panel.add(numeroField);
            panel.add(new JLabel("Capacidad:"));
            panel.add(capacidadField);
            panel.add(new JLabel("Costo:"));
            panel.add(costoField);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Cancha " + i, JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                try {
                    String tipo = tipoField.getText();
                    Integer numero = Integer.parseInt(numeroField.getText());
                    Integer capacidad = Integer.parseInt(capacidadField.getText());
                    Integer costo = Integer.parseInt(costoField.getText());
                    if(numeros.contains(numero)){
                        JOptionPane.showMessageDialog(null, "Error: ya existe una cancha con el número "+numero.toString());
                        i--;
                    }else{
                        tipos[i-1]=tipo;
                        numeros.add(numero);
                        capacidades[i-1]=capacidad;
                        costos[i-1]=costo;
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: ingrese valores numéricos válidos.");
                    i--; 
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes crear 4 canchas antes de poder realizar más acciones.");
                i--; 
            }
        }

        controlador.agregarCancha(tipos[0],numeros.get(0),capacidades[0],costos[0]);
        controlador.agregarCancha(tipos[1],numeros.get(1),capacidades[1],costos[1]);
        controlador.agregarCancha(tipos[2],numeros.get(2),capacidades[2],costos[2]);
        controlador.agregarCancha(tipos[3],numeros.get(3),capacidades[3],costos[3]);
    }

    public static void agregarCancha(){

    }

    public static void agregarReserva(){

    }

    public static String verCancha(){
        return null;
    }

    public static String verListaEspera(){
        return null;
    }
}