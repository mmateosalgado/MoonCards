package InterfacesGraficas;

import Batalla.Tablero;
import model.Carta;
import model.Coleccion;
import model.Heroe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerColeccion extends JFrame implements ListSelectionListener, ActionListener {
    private JSplitPane jsNombreImagenT;
    private JLabel jlImagenT;
    private JList jsListT;
    private JPanel espacio;

    private JButton salirBoton;
    private JButton modificarBoton;

    public VerColeccion(Coleccion lista, boolean modificar){
        ImageIcon icono = new ImageIcon("src\\imagenes\\iconoTest.png");
        setIconImage(icono.getImage());
        setTitle("MoonCards Admin");

        setBounds(0,0,1280,720);
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.

        crearGui(lista,modificar);

        setVisible(true);
    }

    private void crearGui(Coleccion lista,boolean modificar){

        if(lista.getTipo() instanceof Carta){
            jsListT = new JList(lista.devolverArregloCarta());
        }else if(lista.getTipo() instanceof Heroe){
            jsListT = new JList(lista.devolverArregloHeroe());
        }

        JScrollPane jsList = new JScrollPane(jsListT);

        jsListT.addListSelectionListener(this::valueChanged);

        jlImagenT = new JLabel();
        JScrollPane jsImage = new JScrollPane(jlImagenT);

        jsNombreImagenT = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsList,jsImage);
        add(jsNombreImagenT);

        espacio=new JPanel();
        espacio.setLayout(new BoxLayout(espacio,BoxLayout.Y_AXIS));
        espacio.setBackground(new Color(150,48,40));
        espacio.add(jsNombreImagenT);


        salirBoton=new JButton("Salir");
        salirBoton.addActionListener(this);
        salirBoton.setBounds(490,600,300,100);
        espacio.add(salirBoton);


        modificarBoton=new JButton("Modificar");
        modificarBoton.addActionListener(this);
        modificarBoton.setBounds(800,600,300,100);
        modificarBoton.setVisible(false);
        modificarBoton.setEnabled(false);

        if(modificar) {
            modificarBoton.setVisible(true);
            espacio.add(modificarBoton);
        }

        add(espacio);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(jsListT.getSelectedValue() instanceof Carta){
            Carta itemSeleccionado = (Carta) jsListT.getSelectedValue();
            jlImagenT.setIcon(itemSeleccionado.getImagen());
        }else if((jsListT.getSelectedValue() instanceof Heroe)){
            Heroe itemSeleccionado = (Heroe) jsListT.getSelectedValue();
            jlImagenT.setIcon(itemSeleccionado.getImage());
        }
        modificarBoton.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==salirBoton){
            setVisible(false);
            SeleccionAdmin vuelta=new SeleccionAdmin();
        }else if(e.getSource()==modificarBoton){
            setVisible(false);
            SeleccionMoficarCarta ida=new SeleccionMoficarCarta((Carta) jsListT.getSelectedValue());
        }
    }
}
