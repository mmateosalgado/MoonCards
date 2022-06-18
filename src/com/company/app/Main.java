package com.company.app;

import Batalla.Partida;
import Batalla.Tablero;
import Excepciones.PasaNullExcepcion;
import Excepciones.TableroLlenoExcepcion;
import InterfacesGraficas.PantallaInicio;
import InterfacesGraficas.SeleccionMoficarCarta;
import InterfacesGraficas.TableroGrafico;
import InterfacesGraficas.pruebas.SeleccionCartaAtaque;
import Razas.Humano;
import model.*;

import javax.swing.*;



public class Main {

    public static void main(String[] args) {

        UISistema(); // Esto define el diseño UI DEL SISTEMA
        //menu();
/*
        ImageIcon icono1 = new ImageIcon("src\\imagenes\\testHeroe1.png");
        ImageIcon icono2 = new ImageIcon("src\\imagenes\\testHeroe2.png");
        Heroe heroeTest = new Heroe("Ekcros",100,icono1,"Este es un heroe muy poderoso y legendario. Con 100 de vida. Casi imposible de aniquilar.");
        Heroe heroeTest2 = new Heroe("Kratos",50,icono2,"Este es un heroe poderoso y casi legendario. Con 50 de vida. Dificil de aniquilar.");

        ColeccionHeroe coleccion = new ColeccionHeroe();
        coleccion.agregarHeroe(heroeTest);
        coleccion.agregarHeroe(heroeTest2);

        SeleccionHeroe seleccionHeroe = new SeleccionHeroe(coleccion);
*/

        //test();
       // menu();

        //SeleccionMoficarCarta test=new SeleccionMoficarCarta();


        ImageIcon icono1 = new ImageIcon("src\\imagenes\\testHeroe1.png");
        Carta carta = new Humano("Gonzalo", false, 4, 7, 5, 0, 0,true);
        carta.setDescrip("Esta es un guerrero oriental de la decada del 1945, cuando se creo el nuevo orden mundial, después de la WWII, Con la hegemonia del las naciones de EEUU Y la URSS");
        carta.setImagen(icono1);

        ImageIcon icono2 = new ImageIcon("src\\imagenes\\testHeroe1.png");
        Carta carta2 = new Humano("Gonzalo", false, 4, 7, 5, 0, 0,true);
        carta2.setDescrip("Esta es un guerrero oriental de la decada del 1945, cuando se creo el nuevo orden mundial, después de la WWII, Con la hegemonia del las naciones de EEUU Y la URSS");
        carta2.setImagen(icono2);

        ImageIcon icono3 = new ImageIcon("src\\imagenes\\testHeroe1.png");
        Carta carta3 = new Humano("Gonzalo", false, 4, 7, 5, 0, 0,true);
        carta3.setDescrip("Esta es un guerrero oriental de la decada del 1945, cuando se creo el nuevo orden mundial, después de la WWII, Con la hegemonia del las naciones de EEUU Y la URSS");
        carta3.setImagen(icono3);

        Carta arrayCarta[] = new Carta[3];
        arrayCarta[0] = carta;
        arrayCarta[1] = carta;
        arrayCarta[2] = carta;

        ImageIcon icono4 = new ImageIcon("src\\imagenes\\testHeroe1.png");
        ImageIcon icono5 = new ImageIcon("src\\imagenes\\testHeroe2.png");
        Heroe heroeTest = new Heroe("Ekcros", 100, icono4, "Este es un heroe muy poderoso y legendario. Con 100 de vida. Casi imposible de aniquilar.");
        Heroe heroeTest2 = new Heroe("Kratos", 50, icono5, "Este es un heroe poderoso y casi legendario. Con 50 de vida. Dificil de aniquilar.");

        Jugador jugador1 = new Jugador(heroeTest,null,null,"Gonzalo",1,100);
        Jugador jugador2 = new Jugador(heroeTest2,null,null,"Salga",2,50);

        Mazo mazo1 = new Mazo();
        mazo1.agregarCarta(carta);
        mazo1.agregarCarta(carta2);
        mazo1.agregarCarta(carta3);

        Mano mano = new Mano();
        mano.agregarMano(carta);
        mano.agregarMano(carta2);
        mano.agregarMano(carta3);

        jugador1.setManoActual(mano);
        jugador2.setManoActual(mano);

        Tablero batalla = new Tablero(heroeTest);


        try {
            batalla.agregarPersonaje((Personaje) carta);
            batalla.agregarPersonaje((Personaje) carta2);
            batalla.agregarPersonaje((Personaje) carta3);
            batalla.setValidos(3);

            jugador1.setTablero(batalla);
            jugador2.setTablero(batalla);

            //Partida partida = new Partida(jugador1,jugador2,)

           // TableroGrafico tablerito = new TableroGrafico(jugador1,jugador2);



        } catch (PasaNullExcepcion e) {
            e.printStackTrace();
        } catch (TableroLlenoExcepcion e) {
            e.printStackTrace();
        }



    }

        public static void UISistema () {
            UIManager.LookAndFeelInfo info[] = UIManager.getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo look : info)
                // System.out.println(look.getClassName());
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }

        }

        public static void menu() {
            PantallaInicio inicio = new PantallaInicio();
        }

        public static void test() {
            JOptionPane.showMessageDialog(null, "error : dato no encontrado");
        }
    }

