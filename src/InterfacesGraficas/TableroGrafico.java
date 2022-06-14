package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class TableroGrafico extends JFrame {

    JPanel jpPrincipalDerecha, jpPrincipalIzquierda;
    JPanel jpArriba,jp2;
    JPanel jpAbajo,jp2A;
    JButton botonDerecha;

    JButton button[] = new JButton[10];



    public TableroGrafico(){
        setBounds(0,0,1280,720);
        setTitle("Seleccionar Heroe y Mazo");
        //setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        setLayout(new BorderLayout());

        jpPrincipalDerecha = new JPanel();
        jpPrincipalDerecha.setBackground(Color.BLUE);
        jpPrincipalDerecha.setLayout(new BorderLayout());

        jpArriba = new JPanel();
        jpArriba.setBackground(Color.RED);

        jpPrincipalDerecha.add(jpArriba,BorderLayout.NORTH);

        jpAbajo = new JPanel();
        jpAbajo.setBackground(Color.GREEN);

        botonDerecha = new JButton("Hola soy un boton y estoy probando algo");

        jpAbajo.add(botonDerecha,BorderLayout.CENTER);

        jpPrincipalDerecha.add(jpAbajo,BorderLayout.SOUTH);


        add(jpPrincipalDerecha,BorderLayout.CENTER);

        jpPrincipalIzquierda= new JPanel();
        jpPrincipalIzquierda.setBackground(Color.RED);
        jpPrincipalIzquierda.setLayout(new BorderLayout());

        jp2 = new JPanel();
        jp2.setBackground(Color.BLUE);

        jpPrincipalIzquierda.add(jp2,BorderLayout.NORTH);

        jp2A = new JPanel();
        jp2A.setBackground(Color.GREEN);
        jpPrincipalIzquierda.add(jp2A,BorderLayout.SOUTH);

        add(jpPrincipalIzquierda,BorderLayout.EAST);

        setVisible(true);


    }


}
