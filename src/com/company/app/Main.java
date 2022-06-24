package com.company.app;

import Administrador.Administrador;
import Batalla.Partida;
import Excepciones.PasaNullExcepcion;
import InterfacesGraficas.PantallaInicio;
import InterfacesGraficas.TableroGrafico;
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

       menu();


       /*
       // Profe!
      //  Dejamos comentado este codigo pues si bien son TEST tambien esta el codigo de cargar las Cartas
       // y los Heroes basicos a mano , por si se llegan a borrar los archivos

        //ESCRIBIMOS EN LOS ARCHIVOS LAS CARTAS Y LOS HEROES

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
        coleccionCartas.agregar (new Humano ("Zeldan´t",false,3,2,2,false,iconoH4,"Descripcion",2));
        coleccionCartas.agregar (new Humano ("Olaf",false,4,3,3,false,iconoH2,"Descripcion",3));
        coleccionCartas.agregar (new Humano ("Merlin",true,7,4,5,false,iconoH3,"Descripcion",2));

        coleccionCartas.agregar (new Orco ("Bob el Orco",false,1,2,1,false,iconoO1,"Descripcion",1));
        coleccionCartas.agregar (new Orco ("Bers-Erker Jr",false,4,3,2,false,iconoO2,"Descripcion",2));
        coleccionCartas.agregar (new Orco ("Chaman",true,7,4,2,false,iconoO3,"Descripcion",2));


        coleccionCartas.agregar (new Golem ("La Roca",false,3,3,3,false,iconoG1,"Descripcion",2));
        coleccionCartas.agregar (new Golem ("Gullveig",false,5,4,5,false,iconoG2,"Descripcion",3));
        coleccionCartas.agregar (new Golem ("Guadian de Notenhaim",true,8,5,7,false,iconoG3,"Descripcion",2));

        coleccionCartas.agregar (new Necrofago ("Larry",false,10,1,1,false,iconoN1,"Descripcion",1));
        coleccionCartas.agregar (new Necrofago ("Viajero de Hel",false,10,4,2,false,iconoN2,"Descripcion",2));
        coleccionCartas.agregar (new Necrofago ("LuhK-az",true,10,4,3,false,iconoN3,"Descripcion",2));

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
      */

    }

        public static void menu() {
            PantallaInicio inicio = new PantallaInicio();
        }

    }

