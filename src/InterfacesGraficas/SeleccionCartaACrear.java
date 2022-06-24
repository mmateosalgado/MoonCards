package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionCartaACrear extends JFrame implements ActionListener {
    private JLabel texto;
    private JButton seleccionHechizo,seleccionPersonaje,volver;

    public SeleccionCartaACrear(){
        Font fuente=new Font("Belwe", Font.PLAIN,25);
        ImageIcon icono = new ImageIcon("src\\imagenes\\logo.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin");
        setBounds(0,0,500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        seleccionHechizo=new JButton("Hechizo");
        seleccionHechizo.setBounds(25,200,200,50);
        seleccionHechizo.setFont(fuente);
        add(seleccionHechizo);
        seleccionHechizo.addActionListener(this);

        seleccionPersonaje=new JButton("Personaje");
        seleccionPersonaje.setBounds(250,200,200,50);
        seleccionPersonaje.setFont(fuente);
        add(seleccionPersonaje);
        seleccionPersonaje.addActionListener(this);

        volver=new JButton("Salir");
        volver.setBounds(150,300,180,50);
        volver.setFont(fuente);
        add(volver);
        volver.addActionListener(this);

        texto=new JLabel(" Seleccion el tipo de carta a crear! ");
        texto.setBounds(30,100,440,50);
        texto.setFont(fuente);
        add(texto);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        if(e.getSource().equals(seleccionHechizo)){
            CargaNuevaCarta idaHechizo=new CargaNuevaCarta(false);
        }else if(e.getSource().equals(seleccionPersonaje)){
            CargaNuevaCarta idaPersonaje=new CargaNuevaCarta(true);
        } else if(e.getSource().equals(volver)){
            SeleccionAdmin vuelta=new SeleccionAdmin();
        }
    }
}
