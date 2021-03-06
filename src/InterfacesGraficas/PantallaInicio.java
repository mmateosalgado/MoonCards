package InterfacesGraficas;

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
    private JLabel fondo;

    public PantallaInicio(){
        Font fuente=new Font("Belwe", Font.PLAIN,25);

        ImageIcon icono = new ImageIcon("src\\imagenes\\logo.png");
        setIconImage(icono.getImage());
        setBounds(0,0,1280,720);
        setTitle("MoonCards");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        getContentPane().setBackground(Color.LIGHT_GRAY);



        botonJugar=new JButton("Jugar");
        botonJugar.setBounds(444,304,443,101);
        botonJugar.setFont(fuente);
        add(botonJugar);
        botonJugar.addActionListener( this);

        botonAdmin=new JButton("Aceptar");
        botonAdmin.setBounds(900,575,200,40);
        botonAdmin.setFont(fuente);
        add(botonAdmin);
        botonAdmin.addActionListener( this);

        textAdmin=new JLabel("- Ingrese como administrador -");
        textAdmin.setBounds(800,485,400,40);
        textAdmin.setFont(fuente);
        textAdmin.setBackground(Color.LIGHT_GRAY);
        add(textAdmin);

        ingreseContrasena=new JLabel("Contraseña");
        ingreseContrasena.setBounds(30,250,90,20);
        add(ingreseContrasena);

        campoContrasena=new JPasswordField();
        campoContrasena.setBounds(800,530,200,25);
        add(campoContrasena);

        mostrarContrasena=new JCheckBox("Mostrar Contraseña");
        mostrarContrasena.setBounds(1020,530,200,25);
        add(mostrarContrasena);
        mostrarContrasena.addActionListener(this);

        ImageIcon fondoImg = new ImageIcon("src\\imagenes\\fondoPantallaInicio.png");
        fondo = new JLabel(fondoImg);
        fondo.setBounds(0,0,1280,720);
        add(fondo);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource().equals(botonJugar)){
            ReglasJuego reglitas = new ReglasJuego();
            this.setVisible(false);
        }else if(e.getSource().equals(botonAdmin)){
            String a= String.valueOf(campoContrasena.getPassword());
            if(a.equals("messi")) {//clave
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
