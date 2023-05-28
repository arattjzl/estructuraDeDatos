package vistas;

import registros.probabilidad.ModeloOcultoMarkov;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class VentanaPrincipal {

    private JPanel panel;
    private JLabel etiquetaImagen;
    private ModeloOcultoMarkov mom;

    public VentanaPrincipal(ModeloOcultoMarkov mom) {
        initComponents();
        this.mom = mom;
    }

    public void initComponents() {
        JFrame ventana = new JFrame("Ventana Principal");
        panel = new JPanel();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setContentPane(panel);

        JMenuBar menu = new JMenuBar();
        menu.setFont(new Font("Arial", Font.BOLD, 14));
        menu.setPreferredSize(new Dimension(100, 40));
        menu.setForeground(Color.WHITE);
        menu.setBackground(new Color(44,63,80));

        ventana.setJMenuBar(menu);

        JMenuItem btnImagen = new JMenuItem("Mostrar Grafo");
        btnImagen.setFont(new Font("Arial", Font.PLAIN, 12));
        btnImagen.setForeground(Color.WHITE);
        btnImagen.setBackground(new Color(52,73,94));
        btnImagen.setHorizontalAlignment(SwingConstants.CENTER);

        JMenuItem probEscIn = new JMenuItem("Probabiliadad Escenario Inicio");
        probEscIn.setFont(new Font("Arial", Font.PLAIN, 12));
        probEscIn.setForeground(Color.WHITE);
        probEscIn.setBackground(new Color(52,73,94));
        probEscIn.setHorizontalAlignment(SwingConstants.CENTER);

        JMenuItem probCierAct = new JMenuItem("Probabilidad de cierta Accion");
        probCierAct.setFont(new Font("Arial", Font.PLAIN, 12));
        probCierAct.setForeground(Color.WHITE);
        probCierAct.setBackground(new Color(52,73,94));
        probCierAct.setHorizontalAlignment(SwingConstants.CENTER);

        JMenuItem probCierEst = new JMenuItem("Probabilidad de cierto Estado");
        probCierEst.setFont(new Font("Arial", Font.PLAIN, 12));
        probCierEst.setForeground(Color.WHITE);
        probCierEst.setBackground(new Color(52,73,94));
        probCierEst.setHorizontalAlignment(SwingConstants.CENTER);

        JMenuItem probSec = new JMenuItem("Probabilidad de Secuencia");
        probSec.setFont(new Font("Arial", Font.PLAIN, 12));
        probSec.setForeground(Color.WHITE);
        probSec.setBackground(new Color(52,73,94));
        probSec.setHorizontalAlignment(SwingConstants.CENTER);

        menu.add(probEscIn);
        menu.add(probCierAct);
        menu.add(btnImagen);
        menu.add(probCierEst);
        menu.add(probSec);

        btnImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(etiquetaImagen == null) {
                    Image imagen = mostrarImagen();
                    etiquetaImagen = new JLabel(new ImageIcon(imagen));
                    panel.add(etiquetaImagen);
                }else{
                    panel.remove(etiquetaImagen);
                    etiquetaImagen = null;
                }
                panel.revalidate();
                panel.repaint();
            }
        });

        probCierAct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalcularProbabilidades calcProb = new CalcularProbabilidades("actividad",mom);
            }
        });

        probCierEst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalcularProbabilidades calcProb = new CalcularProbabilidades("estado",mom);
            }
        });

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public Image mostrarImagen() {
        BufferedImage imagenOriginal = null;
        try {
            imagenOriginal = ImageIO.read(new File("src/imagenes/mom.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image imagenRedi = imagenOriginal.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
        return imagenRedi;
    }
}
