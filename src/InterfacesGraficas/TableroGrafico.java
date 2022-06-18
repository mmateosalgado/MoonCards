package InterfacesGraficas;

import Batalla.Partida;
import Excepciones.PasaNullExcepcion;
import InterfacesGraficas.pruebas.CartaBoton;
import InterfacesGraficas.pruebas.HeroeBoton;
import InterfacesGraficas.pruebas.SeleccionCartaAtaque;
import model.Carta;
import model.Jugador;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class TableroGrafico extends JFrame {

    Font fontBelweH1 = new Font("Belwe", Font.BOLD, 30);
    Font fontBelweH2 = new Font("Belwe", Font.BOLD, 25);
    Font fontBelweH3 = new Font("Belwe", Font.BOLD, 20);
    Font fontBelweTextNormal = new Font("Belwe", Font.PLAIN, 15);
    Font fontBelweTextNormalNegrita = new Font("Belwe", Font.BOLD, 15);

    private JPanel jPanelSouth, jPanelNorth, jPanelCenter, jPanelWest, jPanelEast;
    private JPanel jPanelCenterTurno, jPanelCenterEnemigo, jPanelWestSouth, jPanelWestCenter;
    private HeroeBoton jButtonHeroeEnemigo;
    private CartaBoton[] jButtonPersonajesEnemigos;
    private JButton jButtonHeroe;
    private CartaBoton[] jButtonPersonajes;
    private JLabel jTextNorth, jTextEspecifaciones, jTextNombre, jTextDescripcion, jTextTipo, jTextObservaciones, jlabelImagenSelec;
    private JLabel jLabelTableroEnemigo, jLabelTableroTurno;
    private JButton jButtonAtacar, jButtonCambiarTurno, jButtonAbandonarPartida, jButtonInvocar, jButtonActivarEfecto;
    private JButton[] jButtonMana;
    private JLabel jLabelCartasMano;
    private CartaBoton[] jCartasMano;

    private Partida partida;


    public TableroGrafico(Partida partida) {
        setBounds(0, 0, 1500, 900);
        setTitle("");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        setLayout(new BorderLayout());

        this.partida = partida;

        constructorNorth(partida.getJugadorTurno());
        constructorCenter(partida);
        constructorSouth();
        constructorWest();
        constructorEast();

        ///jPanelEast.setPreferredSize(new Dimension(120,));

        add(jPanelNorth, BorderLayout.NORTH);
        add(jPanelCenter, BorderLayout.CENTER);
        add(jPanelSouth, BorderLayout.SOUTH);
        add(jPanelWest, BorderLayout.WEST);
        add(jPanelEast, BorderLayout.EAST);


        setVisible(true);


    }

    public void constructorNorth(Jugador jugadorTurno) {
        jPanelNorth = new JPanel();
        jTextNorth = new JLabel("Turno Jugador: " +   jugadorTurno.getNombre().toUpperCase());
        jTextNorth.setFont(fontBelweH2);
        jPanelNorth.add(jTextNorth);
    }


    public void constructorSouth() {
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new BoxLayout(jPanelSouth, BoxLayout.X_AXIS));
        jTextObservaciones = new JLabel("Mana disponible: ");
        jTextObservaciones.setFont(fontBelweTextNormal);
        jPanelSouth.add(jTextObservaciones);

        jButtonMana = new JButton[partida.getJugadorTurno().getManaActual()];

        for(int i = 0; i<jButtonMana.length;i++){
            jButtonMana[i] = new JButton(""+(i+1));
            jButtonMana[i].setPreferredSize(new Dimension(20,10));
            jButtonMana[i].setBackground(Color.cyan);
            jButtonMana[i].setFont(fontBelweTextNormal);
            jPanelSouth.add(jButtonMana[i]);
        }

        jButtonAtacar = new JButton("ATACAR");
        jButtonAtacar.setEnabled(false);
        // jButtonAtacar.addActionListener(this);

        jButtonInvocar = new JButton("INVOCAR EFECTO");
        jButtonInvocar.setEnabled(false);

        jButtonActivarEfecto = new JButton("ACTIVAR EFECTO");
        jButtonActivarEfecto.setEnabled(false);


        jButtonCambiarTurno = new JButton("PASAR DE RONDA");
        jButtonCambiarTurno.setEnabled(true);
        jButtonCambiarTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(partida.getJugadorEnemigo().getHeroeSeleccionado().getCantVida()>0 && partida.getJugadorTurno().getHeroeSeleccionado().getCantVida()>0){
                    JOptionPane.showMessageDialog(null,"Se va a pasar al siguiente jugador");
                   new TableroGrafico(partida.pasarTurno());
                }else{
                    System.out.println("Partida Finalizada");
                }

            }
        });
        // jButtonCambiarTurno.addActionListener(this);

        jButtonAbandonarPartida = new JButton("ABANDONAR PARTIDA");
        //jButtonAbandonarPartida.addActionListener(this);

        jPanelSouth.add(jButtonAtacar);
        jPanelSouth.add(jButtonInvocar);
        jPanelSouth.add(jButtonActivarEfecto);
        jPanelSouth.add(jButtonCambiarTurno);
        jPanelSouth.add(jButtonAbandonarPartida);

    }


    public void constructorWest() {
        jPanelWest = new JPanel();
        jPanelWest.setPreferredSize(new Dimension(220, 600));
        jPanelWestSouth = new JPanel();
        jlabelImagenSelec = new JLabel();
        jPanelWestSouth.add(jlabelImagenSelec);
        jPanelWest.setLayout(new BoxLayout(jPanelWest, BoxLayout.Y_AXIS));

        jTextEspecifaciones = new JLabel();
        jTextNombre = new JLabel();
        jTextNombre.setFont(fontBelweH3);
        jTextTipo = new JLabel();
        jTextTipo.setFont(fontBelweH3);
        jTextDescripcion = new JLabel();
        jTextDescripcion.setFont(fontBelweTextNormal);

        jPanelWestSouth.add(jTextEspecifaciones);
        jPanelWestSouth.add(jTextNombre);
        jPanelWestSouth.add(jTextTipo);
        jPanelWestSouth.add(jTextDescripcion);
        jPanelWest.add(jPanelWestSouth);

        //jPanelWest.add(jPanelWestCenter);
    }

    public void constructorEast() {
        jPanelEast = new JPanel();
        jPanelEast.setPreferredSize(new Dimension(200, 600));
        jPanelEast.setLayout(new BoxLayout(jPanelEast, BoxLayout.Y_AXIS));
        jPanelEast.setBorder(new LineBorder(Color.black));

        jLabelCartasMano = new JLabel("CARTAS EN MANO");
        jLabelCartasMano.setFont(fontBelweH3);
        jPanelEast.add(jLabelCartasMano);
        System.out.println(partida.getJugadorTurno().getManoActual().getValidos());
        jCartasMano = new CartaBoton[partida.getJugadorTurno().getManoActual().getValidos()];

        for (int i = 0; i<jCartasMano.length;i++){
            jCartasMano[i] = new CartaBoton(partida.getJugadorTurno().getManoActual().getMano().get(i));
            jCartasMano[i].setText(partida.getJugadorTurno().getManoActual().getMano().get(i).getNombre() + " ("+ partida.getJugadorTurno().getManoActual().getMano().get(i).getCostoEnergia()+ ")");
            jCartasMano[i].setFont(fontBelweTextNormal);

            jCartasMano[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CartaBoton carta = (CartaBoton) e.getSource();
                    carta.setEstado(true);
                    jlabelImagenSelec.setIcon(carta.getCarta().getImagen());
                    jTextNombre.setText("<html><p style=\"width:100px\">" + carta.getCarta().getNombre() + "" + "</p></html>");
                    jTextTipo.setText("<html><p style=\"width:100px\">" + carta.getCarta().getTipoCarta() + "" + "</p></html>");
                    jTextDescripcion.setText("<html><p style=\"width:100px\">" + carta.getCarta().getDescrip() + "" + "</p></html>");
                }
            });
            jPanelEast.add(jCartasMano[i]);

        }

    }


    public void constructorCenter(Partida partida) {
        jPanelCenter = new JPanel();
        jPanelCenter.setBorder(new LineBorder(Color.black));
        jLabelTableroEnemigo = new JLabel("Tablero del Jugador Enemigo");
        jLabelTableroEnemigo.setFont(fontBelweH3);
        jPanelCenter.setLayout(new BoxLayout(jPanelCenter, BoxLayout.Y_AXIS));
        //jPanelCenter.setPreferredSize(new Dimension(250, 600));
        jPanelCenter.add(jLabelTableroEnemigo);


        jButtonHeroe = new HeroeBoton(partida.getJugadorEnemigo().getTablero().getPosHeroe());
        jPanelCenterEnemigo = new JPanel();
        jPanelCenterEnemigo.setLayout(new BoxLayout(jPanelCenterEnemigo, BoxLayout.X_AXIS));
        //jPanelCenterEnemigo.setPreferredSize(jPanelCenter.getSize());

        jButtonHeroeEnemigo = new HeroeBoton(partida.getJugadorEnemigo().getTablero().getPosHeroe());
        jButtonHeroeEnemigo.setIcon(partida.getJugadorEnemigo().getTablero().getPosHeroe().getImage());
        jButtonHeroeEnemigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una carta suya para iniciar el ataque");
                jButtonAtacar.setEnabled(false);
            }
        });

        jPanelCenterEnemigo.add(jButtonHeroeEnemigo);
        jButtonPersonajesEnemigos = new CartaBoton[partida.getJugadorEnemigo().getTablero().getValidos()];
        for (int i = 0; i < partida.getJugadorEnemigo().getTablero().getValidos(); i++) {
            jButtonPersonajesEnemigos[i] = new CartaBoton(partida.getJugadorEnemigo().getTablero().getPersonajeEnPosicion(i));
            jButtonPersonajesEnemigos[i].setIcon(jButtonPersonajesEnemigos[i].getCarta().getImagen());
            jButtonPersonajesEnemigos[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una carta suya para iniciar el ataque");
                    jButtonAtacar.setEnabled(false);
                }
            });
            jPanelCenterEnemigo.add(jButtonPersonajesEnemigos[i]);
        }

        jPanelCenter.add(jPanelCenterEnemigo);

        jLabelTableroTurno = new JLabel("Tablero que te pertenece");
        jLabelTableroTurno.setFont(fontBelweH3);
        jPanelCenter.add(jLabelTableroTurno);

        jPanelCenterTurno = new JPanel();
        jPanelCenterTurno.setLayout(new BoxLayout(jPanelCenterTurno, BoxLayout.X_AXIS));

        jButtonHeroe = new HeroeBoton(partida.getJugadorTurno().getTablero().getPosHeroe());
        jButtonHeroe.setSize(partida.getJugadorTurno().getTablero().getPosHeroe().getImage().getIconWidth(),partida.getJugadorTurno().getTablero().getPosHeroe().getImage().getIconHeight());
        jButtonHeroe.setIcon(partida.getJugadorTurno().getTablero().getPosHeroe().getImage());
        jButtonHeroe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HeroeBoton heroe = (HeroeBoton) e.getSource();
                jlabelImagenSelec.setIcon(heroe.getHeroe().getImage());
                jTextNombre.setText("<html><p style=\"width:100px\">" + heroe.getHeroe().getNombre() + "" + "</p></html>");
                jTextTipo.setText("<html><p style=\"width:100px\">" + heroe.getHeroe().getClass().toString() + "" + "</p></html>");
                jTextDescripcion.setText("<html><p style=\"width:100px\">" + heroe.getHeroe().getDescripcion() + "" + "</p></html>");
            }
        });

        jPanelCenterTurno.add(jButtonHeroe);

        jButtonPersonajes = new CartaBoton[partida.getJugadorTurno().getTablero().getValidos()];
        for (int i = 0; i < partida.getJugadorTurno().getTablero().getValidos(); i++) {
            jButtonPersonajes[i] = new CartaBoton(partida.getJugadorTurno().getTablero().getPersonajeEnPosicion(i));
            jButtonPersonajes[i].setIcon(jButtonPersonajes[i].getCarta().getImagen());
            jButtonPersonajes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CartaBoton carta = (CartaBoton) e.getSource();
                    carta.setEstado(true);
                    jButtonAtacar.setEnabled(true);
                    jlabelImagenSelec.setIcon(carta.getCarta().getImagen());
                    jTextNombre.setText("<html><p style=\"width:100px\">" + carta.getCarta().getNombre() + "" + "</p></html>");
                    jTextTipo.setText("<html><p style=\"width:100px\">" + carta.getCarta().getTipoCarta() + "" + "</p></html>");
                    jTextDescripcion.setText("<html><p style=\"width:100px\">" + "Esta es un guerrero oriental de la decada del 1945, cuando se creo el nuevo orden mundial, después de la WWII, Con la hegemonia del las naciones de EEUU Y la URSS" + "" + "</p></html>");
                   // SeleccionCartaAtaque seleccionCartaAtaque = new SeleccionCartaAtaque(partida.getJugadorEnemigo().getTablero());

                    //for(int i = 0; i<jButtonPersonajesEnemigos.length;i++){
                    // if(jButtonPersonajesEnemigos[i].getCarta().)
                    //}
                }
            });
            jPanelCenterTurno.add(jButtonPersonajes[i]);
        }


        jPanelCenter.add(jPanelCenterTurno);

    }

}
