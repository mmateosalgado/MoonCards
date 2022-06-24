package InterfacesGraficas;

import Batalla.Partida;
import model.Heroe;
import model.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReglasJuego extends JFrame implements ActionListener {
    private JButton aceptar,salir;
    private JLabel reglas;
    private Partida partida;

    public ReglasJuego(){
        Font fuente=new Font("Belwe", Font.PLAIN,25);

        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin");
        setBounds(0,0,1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        ImageIcon imagen=new ImageIcon("src\\imagenes\\reglas.png");
        reglas=new JLabel(imagen);
        reglas.setBounds(0,0,1280,720);
        add(reglas);

        aceptar=new JButton("Aceptar");
        aceptar.setBounds(900,550,140,50);
        aceptar.setFont(fuente);
        add(aceptar);
        aceptar.addActionListener(this);

        salir=new JButton("Salir");
        salir.setBounds(750,550,100,50);
        salir.setFont(fuente);
        add(salir);
        salir.addActionListener(this);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(aceptar)){
            setVisible(false);
            String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1");
            String nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1");
           // SeleccionHeroe seleccionHeroe1 = new SeleccionHeroe(nombreJugador1,nombreJugador2);


            setVisible(false);

        }else if(e.getSource().equals(salir)){
            setVisible(false);
            new PantallaInicio();

        }
    }
}