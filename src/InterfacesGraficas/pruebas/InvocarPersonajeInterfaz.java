package InterfacesGraficas.pruebas;

import Batalla.Partida;
import InterfacesGraficas.TableroGrafico;
import model.Jugador;
import model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvocarPersonajeInterfaz extends JFrame{
    CartaBoton[] personajes;
    private JPanel jPanelSouth, jPanelNorth, jPanelCenter;
    JLabel jLabelMensaje;
    JButton aceptar;
    Jugador jugador;
    Jugador jugadorRival;
    Personaje personaje;
    Partida partida;

    public InvocarPersonajeInterfaz(Partida partida, Personaje personaje, Jugador jugador , Jugador jugadorRival){
        setBounds(0, 0, 1280, 720);
        setTitle("Seleccionar Carta para activar efecto");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        setLayout(new BorderLayout());
        this.jugador = jugador;
        this.jugadorRival = jugadorRival;
        this.personaje = personaje;
        this.partida = partida;


        constructorCenter();
        constructorSouth();
        constructorNorth();

        this.add(jPanelNorth,BorderLayout.SOUTH);
        this.add(jPanelCenter,BorderLayout.CENTER);
        this.add(jPanelSouth,BorderLayout.NORTH);




        this.setVisible(true);

    }

    public void constructorSouth(){
        jPanelSouth = new JPanel();
        jLabelMensaje = new JLabel("Seleccione carta a la que quiere aplicar el efecto");
        jLabelMensaje.setFont(TableroGrafico.fontBelweH3);
        jPanelSouth.add(jLabelMensaje);
    }
    public void constructorNorth(){
        jPanelNorth = new JPanel();
        aceptar = new JButton("Aceptar");
        aceptar.setFont(TableroGrafico.fontBelweTextNormal);
        aceptar.setEnabled(false);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i<personajes.length;i++){
                    if(personajes[i].isEstado()){
                        personaje.activarEfecto(jugador,jugadorRival,personajes[i].getCarta().getId());
                        JOptionPane.showMessageDialog(null,"Se ha invocado con éxito");
                        setVisible(false);
                        new TableroGrafico(partida);

                    }
                }
            }
        });
        jPanelNorth.add(aceptar);
    }

    public void constructorCenter(){
        jPanelCenter = new JPanel();
        personajes = new CartaBoton[jugador.getTablero().getValidos()];
        for (int i = 0; i<jugador.getTablero().getValidos();i++){
            personajes[i] = new CartaBoton(jugador.getTablero().getPersonajeEnPosicion(i));
            personajes[i].setIcon(jugador.getTablero().getPersonajeEnPosicion(i).getImagen());
            personajes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    aceptar.setEnabled(true);
                    CartaBoton carta = (CartaBoton) e.getSource();
                    for(int z = 0; z< personajes.length; z++){
                        if(personajes[z].getCarta().equals(carta.getCarta())){
                            carta.setEstado(true);
                        }else{
                           personajes[z].setEstado(false);
                        }
                    }
                }
            });

        }
        jPanelCenter.setLayout(new BoxLayout(jPanelCenter,BoxLayout.X_AXIS));
        for(int i = 0; i<personajes.length;i++){
            jPanelCenter.add(personajes[i]);
        }
    }


}
