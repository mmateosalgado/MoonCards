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

        ImageIcon icono = new ImageIcon("src\\imagenes\\logo.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin");
        setBounds(0,0,1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);



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

        ImageIcon imagen=new ImageIcon("src\\imagenes\\reglas.png");
        reglas=new JLabel(imagen);
        reglas.setBounds(0,0,1280,720);
        add(reglas);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(aceptar)){
            setVisible(false);
            final ImageIcon icon = new ImageIcon("src\\imagenes\\logo.png");
            Image image2 = icon.getImage().getScaledInstance(200,200,0);
            String nombreJugador1 = JOptionPane.showInputDialog(null,"Ingrese el nombre del Jugador 1 ","MoonCards Jugar",JOptionPane.PLAIN_MESSAGE, new ImageIcon(image2),null," ").toString();
            String nombreJugador2 = JOptionPane.showInputDialog(null,"Ingrese el nombre del Jugador 2 ","MoonCards Jugar",JOptionPane.PLAIN_MESSAGE, new ImageIcon(image2),null," ").toString();
            SeleccionHeroe seleccionHeroe1 = new SeleccionHeroe(nombreJugador1,nombreJugador2);

            setVisible(false);

        }else if(e.getSource().equals(salir)){
            setVisible(false);
            new PantallaInicio();

        }else{
            setVisible(false);
            new PantallaInicio();
        }
    }
}