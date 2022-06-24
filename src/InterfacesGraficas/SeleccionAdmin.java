package InterfacesGraficas;

import Administrador.Administrador;
import Json.JsonControladora;
import Razas.Humano;
import Razas.Orco;
import model.Carta;
import model.Coleccion;
import model.Heroe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionAdmin extends JFrame implements ActionListener {

    private JButton a1,a2,a3,b1,b2,b3,salir;
    //ESQUEMA DE UBICACION
    /*
            A1     A2      A3
            B1     B2      B3
                  SALIR
     */

    public SeleccionAdmin(){
        Font fuente=new Font("Belwe", Font.PLAIN,25);

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
        a1.setFont(fuente);
        add(a1);
        a1.addActionListener(this);

        a2=new JButton("Modificar Cartas");
        a2.setBounds(380,50,300,100);
        a2.setFont(fuente);
        add(a2);
        a2.addActionListener(this);

        a3=new JButton("Agregar Cartas");
        a3.setBounds(710,50,300,100);
        a3.setFont(fuente);
        add(a3);
        a3.addActionListener(this);

        b1=new JButton("Ver Heroes");
        b1.setBounds(50,170,300,100);
        b1.setFont(fuente);
        add(b1);
        b1.addActionListener(this);

        b2=new JButton("Generar JSON");
        b2.setBounds(380,170,300,100);
        b2.setFont(fuente);
        add(b2);
        b2.addActionListener(this);

        b3=new JButton("Agregar Heroes");
        b3.setBounds(710,170,300,100);
        b3.setFont(fuente);
        add(b3);
        b3.addActionListener(this);

        salir=new JButton("Salir");
        salir.setBounds(380,550,300,100);
        salir.setFont(fuente);
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
            setVisible(false);
            Administrador admin = new Administrador();
            VerColeccion test=new VerColeccion(Administrador.cargarColeccionDeCartas(),false);
        }else if(e.getSource()==a2) {//MODIFICAR CARTAS
            setVisible(false);
            Administrador admin = new Administrador();
            VerColeccion test=new VerColeccion(Administrador.cargarColeccionDeCartas(),true);
        }else if(e.getSource()==a3) {//AGREGAR CARTAS
            setVisible(false);
            SeleccionCartaACrear ida=new SeleccionCartaACrear();
        }else if(e.getSource()==b1) {//VER HEROES
            setVisible(false);
            Administrador admin=new Administrador();
            VerColeccion test=new VerColeccion(admin.cargarColeccionDeHeroes(),false);
        }else if(e.getSource()==b2) {//GENERA JSON
            Administrador admin=new Administrador();
            JsonControladora.grabarEnJsonCartas(Administrador.cargarColeccionDeCartas().getLista());
            JsonControladora.grabarEnJsonHeroes(admin.cargarColeccionDeHeroes().getLista());
            JOptionPane.showMessageDialog(null,"Se a actualizado los archivos JSON del proyecto!");
        }else if(e.getSource()==b3) {//AGREGAR HEROES
            setVisible(false);
            CrearHeroe ida=new CrearHeroe();
        }
    }
}
