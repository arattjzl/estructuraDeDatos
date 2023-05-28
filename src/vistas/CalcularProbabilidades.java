package vistas;

import registros.probabilidad.ModeloOcultoMarkov;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcularProbabilidades {
    private JFrame ventana;
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JLabel etiquetaResultado;
    private String tipo;
    private ModeloOcultoMarkov mom;
    public CalcularProbabilidades(String tipo, ModeloOcultoMarkov mom) {
        this.tipo = tipo;
        this.mom = mom;
        initComponents();
    }
    public void initComponents(){
        ventana = new JFrame();

        if(tipo.toString().equalsIgnoreCase("actividad")){
            ventana.setTitle("Probabilidad de Cierta Accion");
        } else if(tipo.toString().equalsIgnoreCase("estado")){
            ventana.setTitle("Probabilidad de Cierto Estado");
        }else{
            ventana.setTitle("xd");
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setSize(200,100);

        JLabel etiqueta1 = new JLabel("Estado:");
        campoTexto1 = new JTextField();

        JLabel etiqueta2 = null;
        if(tipo.toString().equalsIgnoreCase("actividad")){
            etiqueta2 = new JLabel("Observacion:");
        } else if(tipo.toString().equalsIgnoreCase("estado")){
            etiqueta2 = new JLabel("Estado de transicion:");
        }else{
            etiqueta2 = new JLabel("xd");
        }

        campoTexto2 = new JTextField();

        JButton botonCalcular = new JButton("Calcular Probabilidad");

        etiquetaResultado = new JLabel("  _______  ");
        Font fuente = new Font("Arial", Font.BOLD, 18);
        etiquetaResultado.setFont(fuente);

        // Cambiar el color del texto
        etiquetaResultado.setForeground(Color.BLACK);

        // Cambiar el color de fondo
        Color colorFondo = new Color(240, 240, 240);
        etiquetaResultado.setOpaque(true);
        etiquetaResultado.setBackground(colorFondo);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tipo.equalsIgnoreCase("actividad")){
                    calcularAct();
               }else if(tipo.equalsIgnoreCase("estado")){
                    calcularEst();
                }
            }
        });


        panel.add(etiqueta1);
        panel.add(campoTexto1);
        panel.add(etiqueta2);
        panel.add(campoTexto2);
        panel.add(botonCalcular);
        panel.add(etiquetaResultado);

        ventana.add(panel);
        ventana.pack();
        ventana.setVisible(true);
    }

    private void calcularAct(){
        String variable1 = campoTexto1.getText();
        String variable2 = campoTexto2.getText();
        etiquetaResultado.setText(String.valueOf("    "+mom.probabilidadDeRealizarActividad(variable1, variable2)));
    }

    private void calcularEst(){
        String variable1 = campoTexto1.getText();
        String variable2 = campoTexto2.getText();
        etiquetaResultado.setText(String.valueOf("    "+ mom.probabilidadCiertoEstado(variable1, variable2)));
    }

}
