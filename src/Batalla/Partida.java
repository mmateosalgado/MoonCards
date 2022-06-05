package Batalla;

import Excepciones.PasaNullExcepcion;
import Excepciones.PersonajeCongeladoAccionaExcepcion;
import Razas.Orco;
import model.Heroe;
import model.Jugador;
import model.Personaje;

public class Partida {

    private int turno;

    private Jugador jugador1;
    private Jugador jugador2;


    // El constructor correspondiente

    public Partida(Jugador jugador1, Jugador jugador2, Tablero tableroJugador1, Tablero tableroJugador2) {
        try {
            this.turno = 0;
            if(jugador1==null || jugador2==null || tableroJugador1==null || tableroJugador2==null) {
                throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO DATO EN PARTIDA! ");
            }else{
            this.jugador1 = jugador1;
            this.jugador2 = jugador2;}
        }catch (PasaNullExcepcion e){
            e.getMessage();
        }
    }

    //Getters y Setters correspondientes

    //Metodos--------------------------------------------------------------------------------

    public Personaje buscarPersonajePorId(int id, Jugador jugadorAtacante)//aca va excepcion de dato no encontrado, pero falta terminar
    {
        //aca tiene que buscar el personaje que esta ocupando esa casilla de id en el tablero
        //pero para saber en que tablero buscar deberiamos tener tablero dentro del jugador
/*
        for (int i = 0; i < Jugador.tablero.posiciones.lenght; i++) {
            if(Jugador.tablero.posiciones[i].id == id)
            {
                return Jugador.tablero.posiciones[i];
            }
        }
*/
        return null; //aca retornaria personaje enrealidad, lo dejo asi para que no me tire error ahora
    }

    //Metodos de ataque---------------

    //TODO reformar funcion de ataque en funcion a los personajes dentro del tablero de cada jugador
    public void ataque(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo)
    {

        try {
            if((jugadorAtacante == null) || (jugadorDefensor == null)){
                throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO PERSONAJE EN EL ATAQUE");
            }else{
                Personaje atacante = buscarPersonajePorId(idAtacante, jugadorAtacante);

                if (idObjetivo == 0) // si la id del objetivo se puso como 0, quiere decir que ataca al heroe
                {
                    //Funcion que verifica que el enemigo no tenga otros personajes en el campo
                    ataqueAlHeroe(atacante, jugadorDefensor.getHeroeSeleccionado());
                } else {
                    Personaje objetivo = buscarPersonajePorId(idObjetivo, jugadorDefensor);
                    ataquePersonajes(atacante, objetivo);
                }
            }
        }catch (PasaNullExcepcion e){
            e.getMessage();
        }
    }

    public void ataquePersonajes(Personaje atacante, Personaje objetivo) {
        try {
            if(atacante==null || objetivo ==null){
                throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO PERSONAJE EN EL ATAQUE");
            }else if(atacante.getTurnosCongelado()!=0){
                throw new PersonajeCongeladoAccionaExcepcion("ERROR:ATACA JUGADOR CONGELADO!");
            }else {
                if (atacante instanceof Orco && atacante.isRara()) // si es un orco raro robavida
                {
                    atacante.setCantidadDeVida(atacante.getDanoInflige() + atacante.getCantidadDeVida());
                }

                objetivo.setCantidadDeVida(objetivo.getCantidadDeVida() - atacante.getDanoInflige());
                atacante.setEstado();
            }
        }catch (PasaNullExcepcion | PersonajeCongeladoAccionaExcepcion e){
            e.getMessage();
        }
    }

    public void ataqueAlHeroe(Personaje atacante, Heroe defensor) {
        try {
            if (atacante == null || defensor == null) {
                throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO PERSONAJE|HEROE EN EL ATAQUE AL HEROE");
            } else {

                // si es un orco raro robavida
                if (atacante instanceof Orco && atacante.isRara()) {
                    atacante.setCantidadDeVida(atacante.getDanoInflige() + atacante.getCantidadDeVida());
                }
                defensor.setCantVida(defensor.getCantVida() - atacante.getDanoInflige());
            }
        } catch (PasaNullExcepcion e) {
            e.getMessage();
        }
    }
}
