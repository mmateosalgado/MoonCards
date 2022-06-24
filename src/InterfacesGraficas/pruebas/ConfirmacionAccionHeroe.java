package InterfacesGraficas.pruebas;

import Batalla.Partida;
import Excepciones.ObjetivoInvalidoExcepcion;
import Excepciones.PasaNullExcepcion;
import Excepciones.PersonajeCongeladoAccionaExcepcion;
import InterfacesGraficas.TableroGrafico;
import model.Carta;
import model.Heroe;
import model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmacionAccionHeroe extends JFrame {
    private JLabel jlabelMensajeAccion,imagenCartaEnemiga, imagenCartaTurno, jlabelFlecha;
    private JButton buttonAceptar, buttonCancelar;
    private Carta cartaTurno;
    private Heroe heroeEnemigo;
    private Partida partida;

        public ConfirmacionAccionHeroe(Partida partida, Carta cartaTurno, Heroe heroeEnemigo,String mensaje){
            setBounds(0, 0, 800, 500);
            setTitle("Confirmar Ataque");
            setLocationRelativeTo(null); // coloca al centro de la pantalla
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
            setLayout(null);


            this.partida = partida;
            this.cartaTurno = cartaTurno;
            this.heroeEnemigo = heroeEnemigo;

            jlabelMensajeAccion = new JLabel(mensaje);
            jlabelMensajeAccion.setFont(TableroGrafico.fontBelweH2);
            jlabelMensajeAccion.setBounds(250,0,700,30);

            add(jlabelMensajeAccion);

            imagenCartaTurno = new JLabel(cartaTurno.getImagen());
            imagenCartaTurno.setBounds(50,45,225,345);
            add(imagenCartaTurno);

            imagenCartaEnemiga = new JLabel(heroeEnemigo.getImage());
            imagenCartaEnemiga.setBounds(450,45,225,345);
            add(imagenCartaEnemiga);

            ImageIcon imageIcon = new ImageIcon("src\\imagenes\\flecha.png");

            jlabelFlecha = new JLabel(imageIcon);
            jlabelFlecha.setBounds(300,200,150,75);
            jlabelFlecha.setPreferredSize(new Dimension(150,75));
            add(jlabelFlecha);

            buttonAceptar = new JButton("Atacar");
            buttonAceptar.setBounds(100,400,150,50);
            buttonAceptar.setFont(TableroGrafico.fontBelweTextNormal);
            buttonAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("VIDA DEL HEROE antes:"+ partida.getJugadorEnemigo().getHeroeSeleccionado().getCantVida());
                    partida.ataqueAlHeroe((Personaje) cartaTurno,heroeEnemigo);
                    System.out.println("VIDA DEL HEROE después:"+ partida.getJugadorEnemigo().getHeroeSeleccionado().getCantVida());
                    //TODO aca hay que hacer la actualizacion grafica de las cartas
                    JOptionPane.showMessageDialog(null,"Ataque realizado con éxito");
                    setVisible(false);
                    partida.actualizarValores();
                    new TableroGrafico(partida);

                }
            });
            add(buttonAceptar);

            buttonCancelar = new JButton("Cancelar Ataque");
            buttonCancelar.setBounds(500,400,150,50);
            buttonCancelar.setFont(TableroGrafico.fontBelweTextNormal);
            buttonCancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });
            add(buttonCancelar);

            setVisible(true);

        }



}

