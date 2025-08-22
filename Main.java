import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

import javafx.scene.text.Font;

import Modelo.Cancha;
import Modelo.Reserva;

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
            JRadioButton futBtn = new JRadioButton("Fútbol");
            JRadioButton basquetBtn = new JRadioButton("Baloncesto");
            JRadioButton tenisBtn = new JRadioButton("Tenis");

            ButtonGroup grupoTipo = new ButtonGroup();
            grupoTipo.add(futBtn);
            grupoTipo.add(basquetBtn);
            grupoTipo.add(tenisBtn);

            futBtn.setSelected(true);

            JTextField numeroField = new JTextField();
            JTextField capacidadField = new JTextField();
            JTextField costoField = new JTextField();

            JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
            panel.add(new JLabel("Tipo:"));

            JPanel tipoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            tipoPanel.add(futBtn);
            tipoPanel.add(basquetBtn);
            tipoPanel.add(tenisBtn);

            panel.add(tipoPanel);
            panel.add(new JLabel("Número:"));
            panel.add(numeroField);
            panel.add(new JLabel("Capacidad:"));
            panel.add(capacidadField);
            panel.add(new JLabel("Costo:"));
            panel.add(costoField);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Cancha ", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                try {
                    String tipo = "";
                    if (futBtn.isSelected()) tipo = "Fútbol";
                    else if (basquetBtn.isSelected()) tipo = "Baloncesto";
                    else if (tenisBtn.isSelected()) tipo = "Tenis";
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
        while(true){
        JRadioButton futBtn = new JRadioButton("Fútbol");
        JRadioButton basquetBtn = new JRadioButton("Baloncesto");
        JRadioButton tenisBtn = new JRadioButton("Tenis");

        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(futBtn);
        grupoTipo.add(basquetBtn);
        grupoTipo.add(tenisBtn);

        futBtn.setSelected(true);

        JTextField numeroField = new JTextField();
        JTextField capacidadField = new JTextField();
        JTextField costoField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.add(new JLabel("Tipo:"));

        JPanel tipoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tipoPanel.add(futBtn);
        tipoPanel.add(basquetBtn);
        tipoPanel.add(tenisBtn);

        panel.add(tipoPanel);

        panel.add(new JLabel("Número:"));
        panel.add(numeroField);
        panel.add(new JLabel("Capacidad:"));
        panel.add(capacidadField);
        panel.add(new JLabel("Costo:"));
        panel.add(costoField);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Agregar Cancha", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String tipo = "";
                if (futBtn.isSelected()) tipo = "Fútbol";
                else if (basquetBtn.isSelected()) tipo = "Baloncesto";
                else if (tenisBtn.isSelected()) tipo = "Tenis";

                Integer numero = Integer.parseInt(numeroField.getText());
                Integer capacidad = Integer.parseInt(capacidadField.getText());
                Integer costo = Integer.parseInt(costoField.getText());

                controlador.agregarCancha(tipo, numero, capacidad, costo);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: ingrese valores numéricos válidos.");
            }
        } else{
            break;
        }}
    }

    public static void agregarReserva() {
    JTextField responsableField = new JTextField();
    JTextField nombreField = new JTextField();
    JRadioButton entrenamientoBtn = new JRadioButton("Entrenamiento");
    JRadioButton campeonatoBtn = new JRadioButton("Campeonato");
    JRadioButton amistosoBtn = new JRadioButton("Amistoso");
    ButtonGroup tipoEventoGroup = new ButtonGroup();
    tipoEventoGroup.add(entrenamientoBtn);
    tipoEventoGroup.add(campeonatoBtn);
    tipoEventoGroup.add(amistosoBtn);
    entrenamientoBtn.setSelected(true);

    JTextField fechaInicioField = new JTextField("dd/MM/yyyy HH:mm");
    JTextField fechaFinField = new JTextField("dd/MM/yyyy HH:mm");
    JTextField participantesField = new JTextField();
    JTextField depositoField = new JTextField();

    JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
    panel.add(new JLabel("Responsable:"));
    panel.add(responsableField);
    panel.add(new JLabel("Nombre del evento:"));
    panel.add(nombreField);
    panel.add(new JLabel("Tipo de evento:"));
    JPanel tipoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    tipoPanel.add(entrenamientoBtn);
    tipoPanel.add(campeonatoBtn);
    tipoPanel.add(amistosoBtn);
    panel.add(tipoPanel);
    panel.add(new JLabel("Fecha inicio (dd/MM/yyyy HH:mm):"));
    panel.add(fechaInicioField);
    panel.add(new JLabel("Fecha fin (dd/MM/yyyy HH:mm):"));
    panel.add(fechaFinField);
    panel.add(new JLabel("Cantidad participantes:"));
    panel.add(participantesField);
    panel.add(new JLabel("Depósito:"));
    panel.add(depositoField);

    int result = JOptionPane.showConfirmDialog(frame, panel, "Nueva Reserva", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
        try {
            String responsable = responsableField.getText();
            String nombre = nombreField.getText();
            String tipoEvento = entrenamientoBtn.isSelected() ? "Entrenamiento" :
                                campeonatoBtn.isSelected() ? "Campeonato" : "Amistoso";

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date fechaInicio = formato.parse(fechaInicioField.getText());
            Date fechaFin = formato.parse(fechaFinField.getText());

            int participantes = Integer.parseInt(participantesField.getText());
            double deposito = Double.parseDouble(depositoField.getText());

            // Validaciones
            if (!controlador.validarHorario(fechaInicio, fechaFin)) {
                JOptionPane.showMessageDialog(frame, "Horario no permitido. Debe estar entre 6:00 y 22:00.");
                return;
            }
            if (deposito <= 0) {
                JOptionPane.showMessageDialog(frame, "Depósito insuficiente.");
                return;
            }

            boolean asignada = controlador.agregarReserva(responsable, nombre, tipoEvento, fechaInicio, fechaFin, participantes, deposito);
            if (!asignada) {
                JOptionPane.showMessageDialog(frame, "No hay cancha disponible. Se ha agregado a la lista de espera.");
            } else {
                JOptionPane.showMessageDialog(frame, "Reserva realizada con éxito.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error en los datos ingresados: " + e.getMessage());
        }
    }
}

    public static String verCancha(){
        StringBuilder sb = new StringBuilder();
        sb.append(controlador.verCancha("Fútbol")).append("\n");
        sb.append(controlador.verCancha("Tenis")).append("\n");
        sb.append(controlador.verCancha("Baloncesto")).append("\n");

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        JOptionPane.showMessageDialog(frame, scrollPane, "Todas las Canchas y Reservas", JOptionPane.INFORMATION_MESSAGE);

        return sb.toString();
    }

    public static void verListaEspera(){
        String texto = controlador.verListaEspera();
        JTextArea textArea = new JTextArea(texto);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(frame, scrollPane, "Lista de Espera", JOptionPane.INFORMATION_MESSAGE);
    }
}