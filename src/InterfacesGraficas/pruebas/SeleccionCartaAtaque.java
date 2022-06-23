package InterfacesGraficas.pruebas;

import Batalla.Tablero;
import model.Carta;
import model.Heroe;
import model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionCartaAtaque extends JFrame implements ActionListener {
    private JButton arrayboton[],jButtonHeroe; // 3 posiciones
    private JPanel jPanelCenter, jPanelSur, jPanelNorth, jPanelWest;
    private JLabel jLabelMessageSur,jLabelMessageNorth;
    private Dimension personajeDimension = new Dimension(230,330); // importante aqui

    private Carta carta;

    public SeleccionCartaAtaque(Tablero tablero, Carta carta) {
        setBounds(0, 0, 1280, 720);
        setTitle("Seleccionar Carta");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        setLayout(new BorderLayout());

        this.carta = carta;
        System.out.println(carta.toString());
        constructorNorth();
        constructorCenter(tablero.getPosiciones());
        constructorWest(tablero.getPosHeroe());
        constructorSur();

        add(jPanelNorth,BorderLayout.NORTH);
        add(jPanelCenter, BorderLayout.CENTER);
        add(jPanelWest,BorderLayout.WEST);
        add(jPanelSur,BorderLayout.SOUTH);

        setVisible(true);

    }

    public void constructorNorth(){
        jPanelNorth = new JPanel();
        jLabelMessageNorth = new JLabel("Elija la carta enemiga que desee atacar");
        jPanelNorth.add(jLabelMessageNorth);
    }

    public void constructorWest(Heroe heroe){
        jPanelWest = new JPanel();
        jButtonHeroe = new JButton(heroe.getImage());
        jButtonHeroe.addActionListener(this);
        jPanelWest.add(jButtonHeroe);

    }

    public void constructorCenter(Personaje arrayPersonaje[]) {
        jPanelCenter = new JPanel();
        arrayboton = new JButton[3];
        for (int i = 0; i < arrayboton.length; i++) {
            arrayboton[i] = new JButton(arrayPersonaje[i].getImagen());
            //arrayboton[i].setMaximumSize(personajeDimension);
            arrayboton[i].addActionListener(this::actionPerformed);
        }
        jPanelCenter.setLayout(new BoxLayout(jPanelCenter, BoxLayout.X_AXIS));
        jPanelCenter.setBackground(Color.RED);
        for (int i = 0; i < arrayboton.length; i++) {
            jPanelCenter.add(arrayboton[i]);
        }
    }

    public void constructorSur(){
        jPanelSur = new JPanel();
        jLabelMessageSur = new JLabel("EN CONSTRUCCIÓN JEJE :/ ");
        jPanelSur.add(jLabelMessageSur);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==arrayboton[0]){
            System.out.println("esta es la carta nro 1");
        }
        if(e.getSource()==arrayboton[1]){
            System.out.println("esta es la carta nro 2");
        }
        if(e.getSource()== arrayboton[2]){
            System.out.println("esta es la carta nro 3");
        }
        if(e.getSource()==jButtonHeroe){
            System.out.println("es la carta del HEROE");
        }
    }
}

