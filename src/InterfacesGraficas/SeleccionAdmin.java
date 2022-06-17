package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionAdmin extends JFrame implements ActionListener {

    private JButton a1,a2,a3,b1,b2,b3,salir;

    public SeleccionAdmin(){
        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin");
        setBounds(0,0,1075,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        a1=new JButton("Ver Cartas");
        a1.setBounds(50,50,300,100);
        add(a1);
        a1.addActionListener(this);

        a2=new JButton("Modificar Cartas");
        a2.setBounds(380,50,300,100);
        add(a2);
        a2.addActionListener(this);

        a3=new JButton("Agregar Cartas");
        a3.setBounds(710,50,300,100);
        add(a3);
        a3.addActionListener(this);

        b1=new JButton("Ver Heroes");
        b1.setBounds(50,170,300,100);
        add(b1);
        b1.addActionListener(this);

        b2=new JButton("Modificar Mazos");
        b2.setBounds(380,170,300,100);
        add(b2);
        b2.addActionListener(this);

        b3=new JButton("Agregar Heroes");
        b3.setBounds(710,170,300,100);
        add(b3);
        b3.addActionListener(this);

        salir=new JButton("Salir");
        salir.setBounds(380,500,300,100);
        add(salir);
        salir.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==salir){
            setVisible(false);
            PantallaInicio inicio=new PantallaInicio();
        }else if(e.getSource()==a1) {//VER CARTAS
            //LANZA VER CARTAS
        }else if(e.getSource()==a2) {//MODIFICAR CARTAS
            //LANZA AGREGAR CARTAS
        }else if(e.getSource()==a3) {//AGREGAR CARTAS
            //LANZA AGREGAR CARTAS
        }else if(e.getSource()==b1) {//VER HEROES
            //LANZA VER HEROES
        }else if(e.getSource()==b2) {//MODIFICAR CARTAS
            //LANZA MODIFICAR CARTAS
        }else if(e.getSource()==b3) {//AGREGAR HEROES
            //LANZA AGREGAR HEROES
        }
    }
}
