package Batalla;

import Excepciones.PasaNullExcepcion;
import Excepciones.PersonajeCongeladoAccionaExcepcion;
import Razas.Necrofago;
import Razas.Orco;
import model.Heroe;
import model.Jugador;
import model.Personaje;

public class Partida {

    private int turno;

    private Jugador jugador1;
    private Jugador jugador2;


    // El constructor correspondiente

    public Partida(Jugador jugador1, Jugador jugador2) throws PasaNullExcepcion {//TODO donde se aplique poner try - catch
            this.turno = 0;
            if(jugador1==null || jugador2==null || jugador1.getTablero()==null || jugador2.getTablero()==null) {
                throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO DATO EN PARTIDA! ");
            }else{
            this.jugador1 = jugador1;
            this.jugador2 = jugador2;}
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
    //IMPORTANTE: LA FUNCION RETORNA TRUE SI LA PARTIDA SIGUE EN JUEGO DESPUES DEL ATAQUE, FALSE SI EN ESTE ATAQUE SE MATO AL HEROE

    public boolean ataqueConPersonaje(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo) throws PasaNullExcepcion,PersonajeCongeladoAccionaExcepcion
    {
        boolean resultado = true;

        if(( jugadorAtacante.getTablero().getPosiciones()[idAtacante-1] == null) || (jugadorDefensor.getTablero().getPosiciones()[idObjetivo-1] == null) && idObjetivo != 0){
            throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO PERSONAJE EN EL ATAQUE O EN EL OBJETIVO");
            //controlamos que la id no sea 0 porque eso quiere decir que ataca al heroe
        }else if (jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getTurnosCongelado() > 0) {
            throw new PersonajeCongeladoAccionaExcepcion("ERROR: EL PERSONAJE ATACANTE SELECCIONADO ESTA CONGELADO");
        }else{ //Si se verifican las 2 cosas entonces se realiza el ataque:


            if (idObjetivo == 0){ // si la id del objetivo se puso como 0, quiere decir que ataca al heroe{
                    //Funcion que verifica que el enemigo no tenga otros personajes en el campo
                ataqueAlHeroe(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1], jugadorDefensor.getHeroeSeleccionado());
            } else {
            ataqueAlPersonaje(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1], jugadorDefensor.getTablero().getPosiciones()[idObjetivo-1]);
            }

            jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].setEstado();
            resultado = controlarMuertes(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo);

            }

        return resultado;
    }

    public void ataqueAlPersonaje(Personaje atacante, Personaje objetivo) {

                objetivo.setCantidadDeVida(objetivo.getCantidadDeVida() - atacante.getDanoInflige());
                atacante.setCantidadDeVida(atacante.getCantidadDeVida() - objetivo.getDanoInflige());
                if (atacante instanceof Orco && atacante.isRara() && atacante.getCantidadDeVida() > 0)
                {// si es un orco raro robavida y aun sigue vivo despues del ataque:
                    atacante.setCantidadDeVida(atacante.getDanoInflige() + atacante.getCantidadDeVida());
                }
    }

    public void ataqueAlHeroe(Personaje atacante, Heroe defensor) {
                // si es un orco raro robavida
              defensor.setCantVida(defensor.getCantVida() - atacante.getDanoInflige());
                if (atacante instanceof Orco && atacante.isRara()) {
                    atacante.setCantidadDeVida(atacante.getDanoInflige() + atacante.getCantidadDeVida());
                }
    }

    //Metodos de muerte--------------

    public boolean controlarMuertes(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo)
    {
        if(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getCantidadDeVida() < 0)
        {//Si el que ataco murio en el ataque lo quitamos y primero verificamos si es un necrofago para activar su efecto:
            if(jugadorAtacante.getTablero().getPosiciones()[idAtacante - 1] instanceof Necrofago) // si es necrofago
            {
                efectoNecrofago( (Necrofago) jugadorAtacante.getTablero().getPosiciones()[idAtacante - 1], jugadorAtacante);
            }
            try {
                jugadorAtacante.getTablero().eliminarPersonaje(jugadorAtacante.getTablero().getPosiciones()[idAtacante - 1]);
            }catch (PasaNullExcepcion e){

            }
        }

        if(idObjetivo != 0) { // Si el objetivo es un esbirro
            if (jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1].getCantidadDeVida() < 0) { //si se murio
                try {
                    jugadorDefensor.getTablero().eliminarPersonaje(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1]);
                }catch (PasaNullExcepcion e){

                }
                if(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1] instanceof Necrofago) // si es necrofago
                {
                    efectoNecrofago((Necrofago) jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1], jugadorDefensor);
                }
            }
        }else {
            if(jugadorDefensor.getHeroeSeleccionado().getCantVida() < 0) // si el objetivo es un heroe
            {
                return false;
            }
        }
        return true;
    }

    ///Puede usarse tanto para el que ataca si es que muere como para el que defiende si se muere
    public void efectoNecrofago(Necrofago personaje, Jugador ejecutor)
    {
        ///Implementa su efecto de robar carta
        personaje.RobarCarta (ejecutor);

        if(personaje.isRara())
        {
            //TODO Funcion de danio (como la de deformacion)
        }
    }
}
