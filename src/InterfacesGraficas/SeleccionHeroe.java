/*package InterfacesGraficas;


import Administrador.Administrador;
import Batalla.Partida;
import model.Coleccion;
import model.Heroe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionHeroe extends JFrame implements ListSelectionListener, ActionListener {

    private JPanel jPanelCentral, jPanelSouth, jPanelNorth;
    private JPanel jpanelCentralLeft,getJpanelCentralRight;

    private JLabel jLabelNombreJugador;
    private JButton jButtonaceptar;
    private JSplitPane jsNombreImagenHeroe;
    private JLabel jlImagenHeroe;
    private JList<Heroe> jsListHeroe;
    private JSplitPane jsDescripcionHeroe;
    private JTextArea jtDescripcionHeroe;
    private static int value = 0;
    private static int cant;
    private Heroe heroeFinal;
    private Partida partidaBase;

    public SeleccionHeroe(String nombrejugador1, String nombreJugador2){
        setBounds(0,0,1280,720);
        setTitle("Seleccionar Heroe y Mazo");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        this.setLayout(new BorderLayout());

        value = value + cant;
        cant++;

        //constructorNorth(nombreJugador);
        crearGuiCentral();
        constructorSouth();

        add(jPanelNorth,BorderLayout.NORTH);
        add(jPanelCentral,BorderLayout.CENTER);
        add(jPanelSouth,BorderLayout.SOUTH);

        setVisible(true);
    }

    public void constructorNorth(String nombreJugador){
        jPanelNorth = new JPanel();
        jPanelNorth.setPreferredSize(new Dimension(1280,100));
        jLabelNombreJugador = new JLabel("Jugador "+value);
        if(!nombreJugador.isEmpty()){
            jLabelNombreJugador.setText(nombreJugador);
        }
        jLabelNombreJugador.setFont(TableroGrafico.fontBelweH2);
        jPanelNorth.add(jLabelNombreJugador);
    }

    public void crearGuiCentral(){
        jPanelCentral = new JPanel();
        jPanelCentral.setLayout(new BoxLayout(jPanelCentral,BoxLayout.Y_AXIS));
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

        jPanelCentral.add(jsDescripcionHeroe);
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

    public Heroe getHeroeFinal() {
        return heroeFinal;
    }

    public String getjLabelNombreJugador() {
        return jLabelNombreJugador.toString();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Heroe itemSeleccionado = jsListHeroe.getSelectedValue();
        jtDescripcionHeroe.setText(itemSeleccionado.getDescripcion());
        jlImagenHeroe.setIcon(itemSeleccionado.getImage());
        jtDescripcionHeroe.setCaretPosition(0);
        heroeFinal = itemSeleccionado;
        jButtonaceptar.setEnabled(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButtonaceptar){
            partidaBase= new Partida();
        }
    }
}
*/

