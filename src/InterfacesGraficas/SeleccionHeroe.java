package InterfacesGraficas;


import Administrador.Administrador;
import Batalla.Partida;
import model.Coleccion;
import model.Heroe;
import model.Jugador;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionHeroe extends JFrame implements ListSelectionListener, ActionListener {

    private JPanel jPanelCentral, jPanelSouth, jPanelNorth;
    private JPanel jpanelCentralLeft,jpanelCentralRight;
    private JLabel jLabelNombreJugador,jLabelNombreJugador2;
    private JButton jButtonaceptar;
    private JSplitPane jsNombreImagenHeroe;
    private JLabel jlImagenHeroe;
    private JList<Heroe> jsListHeroe,jsListHeroe2;;
    private JSplitPane jsDescripcionHeroe;
    private JTextArea jtDescripcionHeroe;
    private static int value = 0;
    private static int cant;

    private Heroe heroeFinal;
    private Heroe heroeFinal2;
    private Jugador jugador1;
    private Jugador jugador2;
    private JLabel jlImagenHeroe2;
    private JSplitPane jsNombreImagenHeroe2;
    private JTextArea jtDescripcionHeroe2;
    private JSplitPane jsDescripcionHeroe2;

    static boolean flag1 = false;
    static boolean flag2 = false;

    public SeleccionHeroe(String nombrejugador1, String nombreJugador2){
        setBounds(0,0,1280,720);
        setTitle("Seleccionar Heroe y Mazo");
        ImageIcon icono = new ImageIcon("src\\imagenes\\logo.png");
        setIconImage(icono.getImage());
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        this.setLayout(new BorderLayout());

        value = value + cant;
        cant++;

        constructorNorth(nombrejugador1,nombreJugador2);
        crearGuiCentral();
        constructorSouth();

        add(jPanelNorth,BorderLayout.NORTH);
        add(jPanelCentral,BorderLayout.CENTER);
        add(jPanelSouth,BorderLayout.SOUTH);

        setVisible(true);
    }

    public void constructorNorth(String nombreJugador, String nombreJugador2){
        jPanelNorth = new JPanel();
        jPanelNorth.setPreferredSize(new Dimension(1280,100));
        jPanelNorth.setLayout(new BoxLayout(jPanelNorth,BoxLayout.X_AXIS));

        jLabelNombreJugador = new JLabel("Jugador "+value);
        if(!nombreJugador.isEmpty()){
            jLabelNombreJugador.setText(nombreJugador + "                                                                      ");
        }
        jLabelNombreJugador.setFont(TableroGrafico.fontBelweH2);
        jPanelNorth.add(jLabelNombreJugador);


        jLabelNombreJugador2= new JLabel("Jugador "+value);
        if(!nombreJugador2.isEmpty()){
            jLabelNombreJugador2.setText(" "+nombreJugador2);
        }
        jLabelNombreJugador2.setFont(TableroGrafico.fontBelweH2);
        jPanelNorth.add(jLabelNombreJugador2);

    }
    public void crearGuiCentral(){
        jPanelCentral = new JPanel();
        jPanelCentral.setLayout(new BoxLayout(jPanelCentral,BoxLayout.X_AXIS));
        crearGuiCentralLeft();
        jPanelCentral.add(jpanelCentralLeft);

        crearGuiCentralRight();
        jPanelCentral.add(jpanelCentralRight);
    }

    public void crearGuiCentralLeft(){

        jpanelCentralLeft = new JPanel();
        jpanelCentralLeft.setLayout(new BoxLayout(jpanelCentralLeft,BoxLayout.Y_AXIS));

        jsListHeroe = new JList<>(Administrador.cargarColeccionDeHeroes().devolverArregloHeroe());
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

        jpanelCentralLeft.add(jsDescripcionHeroe);

    }
    public void crearGuiCentralRight(){
        jpanelCentralRight = new JPanel();
        jpanelCentralRight.setLayout(new BoxLayout(jpanelCentralRight,BoxLayout.Y_AXIS));

        jsListHeroe2 = new JList<>(Administrador.cargarColeccionDeHeroes().devolverArregloHeroe());
        JScrollPane jsList2 = new JScrollPane(jsListHeroe2);

        jsListHeroe2.addListSelectionListener(this::valueChanged);

        jlImagenHeroe2 = new JLabel();
        JScrollPane jsImage2 = new JScrollPane(jlImagenHeroe2);

        jsNombreImagenHeroe2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsList2,jsImage2);

        jtDescripcionHeroe2 = new JTextArea();
        JScrollPane jsTextArea2 = new JScrollPane(jtDescripcionHeroe2);

        jsDescripcionHeroe2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jsNombreImagenHeroe2,jsTextArea2);
        jsDescripcionHeroe2.setOneTouchExpandable(true);
        jsDescripcionHeroe2.setDividerLocation(200);

        jpanelCentralRight.add(jsDescripcionHeroe2);

    }

    public void constructorSouth(){
        jPanelSouth = new JPanel();
        jPanelSouth.setPreferredSize(new Dimension(1280,100));
        jButtonaceptar = new JButton("Aceptar");
        jButtonaceptar.setEnabled(false);
        jButtonaceptar.setFont(TableroGrafico.fontBelweTextNormal);
        jButtonaceptar.addActionListener(this);
        jPanelSouth.add(jButtonaceptar);
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource().equals(jsListHeroe)){
            flag1 = true;
            Heroe itemSeleccionado = jsListHeroe.getSelectedValue();
            jtDescripcionHeroe.setText(itemSeleccionado.getDescripcion());
            jlImagenHeroe.setIcon(itemSeleccionado.getImage());
            jtDescripcionHeroe.setCaretPosition(0);
            heroeFinal = itemSeleccionado;
        }



        if(e.getSource().equals(jsListHeroe2)){
            flag2 = true;
            Heroe itemSeleccionado2 = jsListHeroe2.getSelectedValue();
            jtDescripcionHeroe2.setText(itemSeleccionado2.getDescripcion());
            jlImagenHeroe2.setIcon(itemSeleccionado2.getImage());
            jtDescripcionHeroe2.setCaretPosition(0);
            heroeFinal2 = itemSeleccionado2;

        }

        if(flag1 && flag2) {
            jButtonaceptar.setEnabled(true);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButtonaceptar){
            jugador1 = new Jugador(heroeFinal,jLabelNombreJugador.getText(),0);
            jugador2 = new Jugador(heroeFinal2,jLabelNombreJugador2.getText(),1);
            new TableroGrafico(new Partida(jugador1,jugador2));
            this.setVisible(false);
        }
    }
}


