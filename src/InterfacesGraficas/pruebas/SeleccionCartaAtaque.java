package InterfacesGraficas.pruebas;

import Batalla.Partida;
import Batalla.Tablero;
import InterfacesGraficas.TableroGrafico;
import model.Carta;
import model.Heroe;
import model.Personaje;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionCartaAtaque extends JFrame {
    private JButton arrayboton[],jButtonHeroe; // 3 posiciones
    private JPanel jPanelCenter, jPanelSur, jPanelNorth, jPanelWest, jPanelEast;
    private JLabel jLabelMessageSur,jLabelMessageNorth,jLabelImageCarta,jlabelMessageCarta;
    private Dimension personajeDimension = new Dimension(230,330); // importante aqui

    private Carta carta;

    private Partida partida;

    public SeleccionCartaAtaque(Partida partida, Carta carta) {
        setBounds(0, 0, 1280, 720);
        setTitle("Seleccionar Carta para atacar");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        setLayout(new BorderLayout());

        this.carta = carta;
        this.partida = partida;


        constructorNorth();
        constructorCenter(partida.getJugadorEnemigo().getTablero().getPosiciones());
        constructorWest(partida.getJugadorEnemigo().getTablero().getPosHeroe());
        constructorSur();
        constructorEast();

        add(jPanelNorth,BorderLayout.NORTH);
        add(jPanelCenter, BorderLayout.CENTER);
        add(jPanelWest,BorderLayout.WEST);
        add(jPanelSur,BorderLayout.SOUTH);
        add(jPanelEast,BorderLayout.EAST);

        setVisible(true);

    }

    public void constructorNorth(){
        jPanelNorth = new JPanel();
        jLabelMessageNorth = new JLabel("Elija la carta enemiga que desee atacar");
        jLabelMessageNorth.setFont(TableroGrafico.fontBelweH3);

        jPanelNorth.add(jLabelMessageNorth);
    }

    public void constructorWest(Heroe heroe){
        jPanelWest = new JPanel();
        jPanelWest.setLayout(new BoxLayout(jPanelWest,BoxLayout.Y_AXIS));

        JLabel labelMessage = new JLabel("Heroe Enemigo");
        labelMessage.setFont(TableroGrafico.fontBelweH3);
        jPanelWest.add(labelMessage);

        jButtonHeroe = new JButton(heroe.getImage());

        jButtonHeroe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(partida.getJugadorEnemigo().getTablero().isVacio()){
                    jButtonHeroe.setEnabled(true);
                    setVisible(false);
                    ConfirmacionAccionHeroe confirmacionAccionHeroe = new ConfirmacionAccionHeroe(partida, carta, partida.getJugadorEnemigo().getHeroeSeleccionado(), "¿Desea atacar esta carta?");
                }else{
                    jButtonHeroe.setEnabled(false);
                    JOptionPane.showMessageDialog(null,"Primero debe atacar las cartas del tablero antes de atacar al Heroe");
                }
            }
        });
        jPanelWest.add(jButtonHeroe);

    }

    public void constructorEast(){
        jPanelEast = new JPanel();
        jPanelEast.setLayout(new BoxLayout(jPanelEast,BoxLayout.Y_AXIS));
        jlabelMessageCarta = new JLabel();
        jlabelMessageCarta.setText("<html><p style=\"width:120px\">" + "Carta con la que va a efectuar el ataque" + "" + "</p></html>");
        jlabelMessageCarta.setFont(TableroGrafico.fontBelweTextNormal);
        jPanelEast.add(jlabelMessageCarta);
        jLabelImageCarta = new JLabel(carta.getImagen());
        carta.actualizarValoresCarta();
        jPanelEast.add(jLabelImageCarta);

    }

    public void constructorCenter(Personaje arrayPersonaje[]) {
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new BoxLayout(jPanelCenter, BoxLayout.X_AXIS));
        arrayboton = new JButton[3];
        if(!partida.getJugadorEnemigo().getTablero().isVacio()) {
            for (int i = 0; i < partida.getJugadorEnemigo().getTablero().getValidos(); i++) {
                arrayboton[i] = new JButton(partida.getJugadorEnemigo().getTablero().getPersonajeEnPosicion(i).getImagen());
                arrayboton[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < arrayboton.length; i++) {
                            if (arrayboton[i] ==  e.getSource()) {
                                setVisible(false);
                                ConfirmacionAccion confirmacionAccion = new ConfirmacionAccion(partida, carta, partida.getJugadorEnemigo().getTablero().getPersonajeEnPosicion(i), "¿Desea atacar esta carta?");
                            }
                        }
                    }
                });
                jPanelCenter.add(arrayboton[i]);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tablero Enemigo vacio. Solo puede atacar al Heroe.");
        }


    }

    public void constructorSur(){
        jPanelSur = new JPanel();
        jLabelMessageSur = new JLabel("EN CONSTRUCCIÓN JEJE :/ ");
        jPanelSur.add(jLabelMessageSur);
    }


}


