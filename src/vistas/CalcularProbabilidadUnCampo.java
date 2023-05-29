package vistas;

import registros.probabilidad.ModeloOcultoMarkov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcularProbabilidadUnCampo {
    private JFrame ventana;
    private JTextField campoTexto1;
    private JLabel etiquetaResultado;
    private String tipo;
    private ModeloOcultoMarkov mom;
    private JLabel etiqueta1, etiqueta2;

    public CalcularProbabilidadUnCampo(String tipo, ModeloOcultoMarkov mom){
        this.tipo = tipo;
        this.mom = mom;
        initComponents();
    }

    public void initComponents(){
        if(tipo.equalsIgnoreCase("inicial")){
            ventana = new JFrame("Probabilidad inicial");
            etiqueta1 = new JLabel("Estado:");
        } else if(tipo.equalsIgnoreCase("secuencia")){
            ventana = new JFrame("Probabilidad de Secuencia");
            etiqueta1 = new JLabel("Secuencia:");
            etiqueta2 = new JLabel("Ingrese los estados separados por coma y sin espacio");
        }else{
            ventana.setTitle("xd");
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setSize(200,100);

        campoTexto1 = new JTextField();


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
                if(tipo.equalsIgnoreCase("inicial")){
                    calcularProbabilidadInicial();
                }else if(tipo.equalsIgnoreCase("secuencia")){
                    calcularProbabilidadSecuencia();
                }
            }
        });


        panel.add(etiqueta1);
        panel.add(campoTexto1);
        if(tipo.equalsIgnoreCase("secuencia")){
            panel.add(etiqueta2);
        }
        panel.add(botonCalcular);
        panel.add(etiquetaResultado);

        ventana.add(panel);
        ventana.pack();
        ventana.setVisible(true);
    }

    private void calcularProbabilidadInicial(){
        etiquetaResultado.setText("    "+mom.inicioEstado(campoTexto1.getText()));
    }
    private void calcularProbabilidadSecuencia(){
        etiquetaResultado.setText("    "+mom.pobabilidadDeSecuenciaDeEstados(campoTexto1.getText()));
    }
}
