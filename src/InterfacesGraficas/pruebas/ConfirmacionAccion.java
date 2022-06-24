package InterfacesGraficas.pruebas;

import Batalla.Partida;
import Excepciones.ObjetivoInvalidoExcepcion;
import Excepciones.PasaNullExcepcion;
import Excepciones.PersonajeCongeladoAccionaExcepcion;
import InterfacesGraficas.TableroGrafico;
import model.Carta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmacionAccion extends JFrame{

    private JLabel fondo;
    private JLabel jlabelMensajeAccion,imagenCartaEnemiga, imagenCartaTurno, jlabelFlecha;
    private JButton buttonAceptar, buttonCancelar;
    private Carta cartaEnemigo, cartaTurno;
    private Partida partida;

    public ConfirmacionAccion(Partida partida, Carta cartaTurno, Carta cartaEnemigo,String mensaje){
        setBounds(0, 0, 800, 500);
        setTitle("Seleccionar Carta para atacar");
        setLocationRelativeTo(null); // coloca al centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // esto hace que el usuario no pueda jugar con el tamaño de la ventana.
        setLayout(null);
        ImageIcon icono = new ImageIcon("src\\imagenes\\logo.png");
        setIconImage(icono.getImage());




        this.partida = partida;
        this.cartaTurno = cartaTurno;
        this.cartaEnemigo = cartaEnemigo;

        jlabelMensajeAccion = new JLabel(mensaje);
        jlabelMensajeAccion.setFont(TableroGrafico.fontBelweH2);
        jlabelMensajeAccion.setBounds(250,0,700,30);

        add(jlabelMensajeAccion);

        imagenCartaTurno = new JLabel(cartaTurno.getImagen());
        imagenCartaTurno.setBounds(50,45,225,345);
        add(imagenCartaTurno);

        imagenCartaEnemiga = new JLabel(cartaEnemigo.getImagen());
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
                try {
                    System.out.println("CANT DEL tablero antes:"+ partida.getJugadorEnemigo().getTablero().getValidos());
                    partida.ataqueConPersonaje(partida.getJugadorTurno(),partida.getJugadorEnemigo(),cartaTurno.getId(),cartaEnemigo.getId());
                    System.out.println("CANT DEL tablero DESPUÉS:"+ partida.getJugadorEnemigo().getTablero().getValidos());
                    //TODO aca hay que hacer la actualizacion grafica de las cartas
                    JOptionPane.showMessageDialog(null,"Ataque realizado con éxito");
                    setVisible(false);
                    //partida.actualizarValores();
                    new TableroGrafico(partida);
                } catch (PasaNullExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (PersonajeCongeladoAccionaExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (ObjetivoInvalidoExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
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
                partida.actualizarValores ();
                new TableroGrafico(partida);
            }

        });
        add(buttonCancelar);

        ImageIcon fondoImg = new ImageIcon("src\\imagenes\\fondo.png");
        fondo = new JLabel(fondoImg);
        fondo.setBounds(0,0,800,500);
        add(fondo);

        setVisible(true);

    }



}
