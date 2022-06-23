package com.company.app;

import Administrador.Administrador;
import InterfacesGraficas.PantallaInicio;
import Json.JsonControladora;
import Razas.Golem;
import Razas.Humano;
import Razas.Necrofago;
import Razas.Orco;
import model.Carta;
import model.Coleccion;
import model.Heroe;
import model.Jugador;
import tiposHechizos.Curacion;
import tiposHechizos.Danio;
import tiposHechizos.Hielo;
import tiposHechizos.RobaCarta;

import javax.swing.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

/*
        ArrayList<Carta> listaCartas= new ArrayList<Carta> ();
        listaCartas.add (new Orco("Orco",true,10,10,10,10,true));
        listaCartas.add (new Humano("Humano",true,10,10,10,10,100,true));
        listaCartas.add (new Necrofago("Necrofago",true,10,10,10,10,10,true));
        listaCartas.add (new Golem("Golem",true,10,10,10,10,10,true));
        listaCartas.add (new Curacion("HCuracion",true,10,10,10));
        listaCartas.add (new Danio("HDanio",true,10,10,10));
        listaCartas.add (new Hielo("HHielo",true,10,10,10));
        listaCartas.add (new RobaCarta("HRobarCarta",true,10,10,10));

        JsonControladora jsonControladora = new JsonControladora ();
        jsonControladora.grabarEnJsonCartas (listaCartas);
        ArrayList<Heroe> listaHeroes = new ArrayList<Heroe> ();
        listaHeroes.add (new Heroe("Pepe",10,"GranSapoPepe"));
        listaHeroes.add (new Heroe ("Juan",20,"GranJuansettoo"));
        listaHeroes.add (new Heroe ("Cristian",15,"GranCristi"));
        listaHeroes.add (new Heroe ("Esteban",12,"Estebianaajaa"));
        jsonControladora.grabarEnJsonHeroes (listaHeroes);


        Administrador admin= new Administrador();

        //ESCRIBIMOS EN LOS ARCHIVOS ALGUNAS CARTAS
       Coleccion<Carta> coleccionCartas= new Coleccion<> ();
       Coleccion<Heroe>coleccionHeroes= new Coleccion<>();

        coleccionCartas.agregar (new Orco ("Orco",true,10,10,10,10,true));
        coleccionCartas.agregar(new Humano ("Humano",true,10,10,10,10,100,true));
        coleccionCartas.agregar (new Necrofago ("Necrofago",true,10,10,10,10,10,true));
        coleccionCartas.agregar(new Golem ("Golem",true,10,10,10,10,10,true));
        coleccionCartas.agregar(new Curacion ("HCuracion",true,10,10,10));
        coleccionCartas.agregar(new Danio ("HDanio",true,10,10,10));
        coleccionCartas.agregar(new Hielo ("HHielo",true,10,10,10));
        coleccionCartas.agregar(new RobaCarta ("HRobarCarta",true,10,10,10));
*/
/*
        Administrador admin= new Administrador();

        Coleccion<Carta> coleccionCartas= new Coleccion<> ();
        Coleccion<Heroe>coleccionHeroes= new Coleccion<>();

        ImageIcon iconoH1 = new ImageIcon("src\\imagenes\\Cartas\\H1.png");
        ImageIcon iconoH2 = new ImageIcon("src\\imagenes\\Cartas\\H2.png");
        ImageIcon iconoH3 = new ImageIcon("src\\imagenes\\Cartas\\H3.png");
        ImageIcon iconoH4 = new ImageIcon("src\\imagenes\\Cartas\\H4.png");
        ImageIcon iconoO1 = new ImageIcon("src\\imagenes\\Cartas\\O1.png");
        ImageIcon iconoO2 = new ImageIcon("src\\imagenes\\Cartas\\O2.png");
        ImageIcon iconoO3 = new ImageIcon("src\\imagenes\\Cartas\\O3.png");
        ImageIcon iconoG1 = new ImageIcon("src\\imagenes\\Cartas\\G1.png");
        ImageIcon iconoG2 = new ImageIcon("src\\imagenes\\Cartas\\G2.png");
        ImageIcon iconoG3 = new ImageIcon("src\\imagenes\\Cartas\\G3.png");
        ImageIcon iconoN1 = new ImageIcon("src\\imagenes\\Cartas\\N1.png");
        ImageIcon iconoN2 = new ImageIcon("src\\imagenes\\Cartas\\N2.png");
        ImageIcon iconoN3 = new ImageIcon("src\\imagenes\\Cartas\\N3.png");

        ImageIcon iconoD1 = new ImageIcon("src\\imagenes\\Cartas\\D1.png");
        ImageIcon iconoD2 = new ImageIcon("src\\imagenes\\Cartas\\D2.png");
        ImageIcon iconoR1 = new ImageIcon("src\\imagenes\\Cartas\\R1.png");
        ImageIcon iconoR2 = new ImageIcon("src\\imagenes\\Cartas\\R2.png");
        ImageIcon iconoC1 = new ImageIcon("src\\imagenes\\Cartas\\C1.png");
        ImageIcon iconoC2 = new ImageIcon("src\\imagenes\\Cartas\\C2.png");
        ImageIcon iconoHi1 = new ImageIcon("src\\imagenes\\Cartas\\Hi1.png");
        ImageIcon iconoHi2 = new ImageIcon("src\\imagenes\\Cartas\\Hi2.png");

        ImageIcon iconoHero1 = new ImageIcon("src\\imagenes\\Heroes\\Elemental_Rochet.png");
        ImageIcon iconoHero2 = new ImageIcon("src\\imagenes\\Heroes\\General_Ferrari.png");
        ImageIcon iconoHero3 = new ImageIcon("src\\imagenes\\Heroes\\Lord_Romulo.png");
        ImageIcon iconoHero4 = new ImageIcon("src\\imagenes\\Heroes\\Rey_Nilluz.png");


        coleccionHeroes.agregar (new Heroe ("Rey Nilluz",20,iconoHero4,"Descripcion"));
        coleccionHeroes.agregar (new Heroe ("Lord Rómulo",20,iconoHero3,"Descripcion"));
        coleccionHeroes.agregar (new Heroe ("General Ferrari",20,iconoHero2,"Descripcion"));
        coleccionHeroes.agregar (new Heroe ("Elemental  Rochet",20,iconoHero1,"Descripcion"));



        coleccionCartas.agregar (new Humano ("Galahad",false,1,1,2,false,iconoH1,"Descripcion",1));
        coleccionCartas.agregar (new Humano ("Zeldan´t",false,3,2,2,false,iconoH2,"Descripcion",2));
        coleccionCartas.agregar (new Humano ("Olaf",false,4,3,3,false,iconoH3,"Descripcion",3));
        coleccionCartas.agregar (new Humano ("Merlin",true,7,4,5,true,iconoH4,"Descripcion",2));

        coleccionCartas.agregar (new Orco ("Bob el Orco",false,1,2,1,true,iconoO1,"Descripcion",1));
        coleccionCartas.agregar (new Orco ("Bers-Erker Jr",false,4,3,2,true,iconoO2,"Descripcion",2));
        coleccionCartas.agregar (new Orco ("Chaman",true,7,4,2,true,iconoO3,"Descripcion",2));


        coleccionCartas.agregar (new Golem ("La Roca",false,3,3,3,false,iconoG1,"Descripcion",2));
        coleccionCartas.agregar (new Golem ("Gullveig",false,5,4,5,false,iconoG2,"Descripcion",3));
        coleccionCartas.agregar (new Golem ("Guadian de Notenhaim",true,8,5,7,true,iconoG3,"Descripcion",2));

        coleccionCartas.agregar (new Necrofago ("Larry",false,3,1,1,false,iconoN1,"Descripcion",1));
        coleccionCartas.agregar (new Necrofago ("Viajero de Hel",false,5,4,2,false,iconoN2,"Descripcion",2));
        coleccionCartas.agregar (new Necrofago ("LuhK-az",true,8,4,3,false,iconoN3,"Descripcion",2));

        coleccionCartas.agregar (new Danio ("Deformacion",false,2,iconoD1,"Descripcion",2));
        coleccionCartas.agregar (new Danio ("Ignicion",true,4,iconoD2,"Descripcion",2));

        coleccionCartas.agregar (new Hielo ("Rayo Escarcha",false,3,iconoHi1,"Descripcion",4));
        coleccionCartas.agregar (new Hielo ("Lluvia Helada",true,5,iconoHi2,"Descripcion",2));

        coleccionCartas.agregar (new Curacion ("Sanacion",false,2,iconoC1,"Descripcion",2));
        coleccionCartas.agregar (new Curacion ("Escudo de Fe",true,6,iconoC2,"Descripcion",3));

        coleccionCartas.agregar (new RobaCarta ("Robo Amateur",false,3,iconoR1,"Descripcion",2));
        coleccionCartas.agregar (new RobaCarta ("Exceso de Abundancia",true,5,iconoR2,"Descripcion",3));

        admin.cargarArchivoCartas(coleccionCartas);
        admin.cargarArchivoHeroes(coleccionHeroes);

        JsonControladora.grabarEnJsonCartas(coleccionCartas.getLista());
        JsonControladora.grabarEnJsonHeroes(coleccionHeroes.getLista());

        //LEEMOS DEL ARCHIVO
        Coleccion<Carta>coleccionCartas2= new Coleccion<Carta> ();

        coleccionCartas2 = admin.cargarColeccionDeCartas();

        System.out.println(coleccionCartas2);
*/

        ImageIcon iconoHero45 = new ImageIcon("src\\imagenes\\Heroes\\Rey_Nilluz.png");
        Heroe heroe= new Heroe ("Rey Nilluz",20,iconoHero45,"Descripcion");
        Jugador jugador = new Jugador(heroe,"Ferra",1);
        //System.out.println(jugador);

        UISistema(); // Esto define el diseño UI DEL SISTEMA
        menu();

       // ImageIcon icono1 = new ImageIcon("src\\imagenes\\testHeroe1.png");
        //ImageIcon icono2 = new ImageIcon("src\\imagenes\\testHeroe2.png");


        /*
        ColeccionHeroe coleccion = new ColeccionHeroe();
        coleccion.agregarHeroe(heroeTest);
        coleccion.agregarHeroe(heroeTest2);

        SeleccionHeroe seleccionHeroe = new SeleccionHeroe(coleccion);



        //SeleccionMoficarCarta test=new SeleccionMoficarCarta();

/*
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

            Partida partida = new Partida(jugador1,jugador2);

            TableroGrafico tablero = new TableroGrafico(partida);





        } catch (PasaNullExcepcion e) {
            e.printStackTrace();
        } catch (TableroLlenoExcepcion e) {
            e.printStackTrace();
        }
*/


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

