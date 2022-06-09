package InterfacesGraficas;

import Control.Inicio;
import model.ColeccionHeroe;
import model.Heroe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame implements ActionListener {

    private JPasswordField campoContrasena;
    private JButton botonJugar,botonAdmin;
    private JLabel ingreseContrasena;
    private JLabel textAdmin;

    public PantallaInicio(){
        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setIconImage(icono.getImage());
        setBounds(0,0,1280,720);
        setTitle("MoonCards");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        getContentPane().setBackground(Color.LIGHT_GRAY);

        botonJugar=new JButton("Jugar");
        botonJugar.setBounds(100,50,300,100);
        add(botonJugar);
        botonJugar.addActionListener( this);

        botonAdmin=new JButton("Aceptar");
        botonAdmin.setBounds(360,250,80,20);
        add(botonAdmin);
        botonAdmin.addActionListener( this);

        textAdmin=new JLabel("Ingrese como administrador");
        textAdmin.setBounds(60,220,300,20);
        add(textAdmin);

        ingreseContrasena=new JLabel("CONTRASEÑA");
        ingreseContrasena.setBounds(60,250,80,20);
        add(ingreseContrasena);

        campoContrasena=new JPasswordField();
        campoContrasena.setBounds(150,250,200,20);
        add(campoContrasena);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==botonJugar){
            String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1");
            String nombreJugador2 = JOptionPane.showInputDialog("Ingrese le nombre del jugador 2");

            Inicio inicio = new Inicio(nombreJugador1,nombreJugador2); // en el constructor de la clase seleccion mazo debe
            // recibir un objeto de tipo Inicio.



            System.exit(0);
        }else if(e.getSource()==botonAdmin){
            String ingresado= String.valueOf(campoContrasena.getPassword());
            if(ingresado.equals("MoonMaster")){
                //lanza admin
            }
        }
    }
}
