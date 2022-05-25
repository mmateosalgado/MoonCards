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

    public PantallaInicio(){
        setLayout(null);
        setTitle("MoonCards");

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
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==botonJugar){
            System.exit(0);
        }else if(e.getSource()==botonAdmin){
            String ingresado= String.valueOf(campoContrasena.getPassword());
            if(ingresado.equals("MoonMaster")){

            }
        }
    }


}
