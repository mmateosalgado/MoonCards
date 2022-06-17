package InterfacesGraficas;

import Control.Inicio;
import model.Carta;
import model.ColeccionCartas;
import model.ColeccionHeroe;
import model.Heroe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerCartas extends JFrame implements ListSelectionListener, ActionListener {
    private JSplitPane jsNombreImagenCarta;
    private JLabel jlImagenCarta;
    private JList<Carta> jsListCarta;

    private JButton salir;
    //TODO modo de seleccional para modificar

    public VerCartas(ColeccionCartas listaCartas){
        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin - Ver Cartas");

        setBounds(0,0,1280,720);
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TODO aplicar metodo de salida
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.

        crearGui(listaCartas);

        setVisible(true);
    }

    private void crearGui(ColeccionCartas listaCartas){

        Carta [] arregloCartas=listaCartas.devolverArregloCartas();
        jsListCarta = new JList<>(arregloCartas);
        JScrollPane jsList = new JScrollPane(jsListCarta);

        jsListCarta.addListSelectionListener(this::valueChanged);

        jlImagenCarta = new JLabel();
        JScrollPane jsImage = new JScrollPane(jlImagenCarta);

        jsNombreImagenCarta = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsList,jsImage);
        add(jsNombreImagenCarta);

        //salir=new JButton("Salir");
      //  salir.addActionListener(this);
       // salir.setBounds(490,600,300,100);
      //  add(salir);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Carta itemSeleccionado = jsListCarta.getSelectedValue();
        jlImagenCarta.setIcon(itemSeleccionado.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==salir){
            setVisible(false);
            SeleccionAdmin vuelta=new SeleccionAdmin();
        }
    }
}
