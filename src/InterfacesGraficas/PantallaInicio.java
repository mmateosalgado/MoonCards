package InterfacesGraficas;

import Control.Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicio extends JFrame implements ActionListener {

    private JPasswordField campoContrasena;
    private JButton botonJugar,botonAdmin;
    private JLabel ingreseContrasena;
    private JLabel textAdmin;
    private JCheckBox mostrarContrasena;

    public PantallaInicio(){
        Font h1=new Font("Belwe", Font.PLAIN,25);

        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setIconImage(icono.getImage());
        setBounds(0,0,500,400);
        setTitle("MoonCards");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        getContentPane().setBackground(Color.LIGHT_GRAY);

        botonJugar=new JButton("Jugar");
        botonJugar.setBounds(100,50,300,100);
        botonJugar.setFont(h1);
        add(botonJugar);
        botonJugar.addActionListener( this);

        botonAdmin=new JButton("Aceptar");
        botonAdmin.setBounds(125,290,200,40);
        botonAdmin.setFont(h1);
        add(botonAdmin);
        botonAdmin.addActionListener( this);

        textAdmin=new JLabel("- Ingrese como administrador -");
        textAdmin.setBounds(30,220,300,20);
        add(textAdmin);

        ingreseContrasena=new JLabel("Contraseña");
        ingreseContrasena.setBounds(30,250,90,20);
        add(ingreseContrasena);

        campoContrasena=new JPasswordField();
        campoContrasena.setBounds(125,250,200,25);
        add(campoContrasena);

        mostrarContrasena=new JCheckBox("Mostrar Contraseña");
        mostrarContrasena.setBounds(330,250,200,25);
        add(mostrarContrasena);
        mostrarContrasena.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource().equals(botonJugar)){
            String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del Jugador 1");
            String nombreJugador2 = JOptionPane.showInputDialog("Ingrese le nombre del jugador 2");

            Inicio inicio = new Inicio(nombreJugador1,nombreJugador2); // en el constructor de la clase seleccion mazo debe
            // recibir un objeto de tipo Inicio.
            //setVisible(false);

        }else if(e.getSource().equals(botonAdmin)){
            String a= String.valueOf(campoContrasena.getPassword());
            if(a.equals("messi")) {
                setVisible(false);
                SeleccionAdmin test = new SeleccionAdmin();
            }else{
                JOptionPane.showMessageDialog(null,"Contraseña Invalida!");
            }
        }

        if(mostrarContrasena.isSelected()){
            campoContrasena.setEchoChar((char)0);
        }else{
            campoContrasena.setEchoChar('*');
        }
    }
}
