package InterfacesGraficas;


import model.ColeccionHeroe;
import model.Heroe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Control.*;
import java.awt.*;

public class SeleccionHeroe extends JFrame implements ListSelectionListener {

    private JSplitPane jsNombreImagenHeroe;
    private JLabel jlImagenHeroe;
    private JList<Heroe> jsListHeroe;

    private JSplitPane jsDescripcionHeroe;
    private JTextArea jtDescripcionHeroe;


    public SeleccionHeroe(Inicio inicio,ColeccionHeroe listaHeroes){

        setBounds(0,0,1280,720);
        setTitle("Seleccionar Heroe y Mazo");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.

        crearGui(listaHeroes);



        setVisible(true);
    }

    private void crearGui(ColeccionHeroe listaHeroes){

       jsListHeroe = new JList<>(listaHeroes.devolverArregloHeroes());
        JScrollPane jsList = new JScrollPane(jsListHeroe);

        jsListHeroe.addListSelectionListener(this::valueChanged);


        jlImagenHeroe = new JLabel();
        JScrollPane jsImage = new JScrollPane(jlImagenHeroe);

        jsNombreImagenHeroe = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsList,jsImage);

        jtDescripcionHeroe = new JTextArea();
        JScrollPane jsTextArea = new JScrollPane(jtDescripcionHeroe);

        jsDescripcionHeroe = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jsNombreImagenHeroe,jsTextArea);
        jsDescripcionHeroe.setOneTouchExpandable(true);
        jsDescripcionHeroe.setDividerLocation(200);


        add(jsDescripcionHeroe);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Heroe itemSeleccionado = jsListHeroe.getSelectedValue();
        jtDescripcionHeroe.setText(itemSeleccionado.getDescripcion());
        jlImagenHeroe.setIcon(itemSeleccionado.getImage());
        jtDescripcionHeroe.setCaretPosition(0);

    }
}
