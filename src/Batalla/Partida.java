package Batalla;

import Excepciones.*;
import InterfacesGraficas.TableroGrafico;
import Razas.*;
import model.*;
import tiposHechizos.Danio;

import javax.swing.*;

public class Partida {

    private int turno;
    private Jugador jugador1;
    private Jugador jugador2;
    private TableroGrafico tableroGrafico;


    // El constructor correspondiente

    public Partida(Jugador jugador1, Jugador jugador2, TableroGrafico tableroGrafico) throws PasaNullExcepcion {//TODO donde se aplique poner try - catch
            this.turno = 0;
            if(jugador1==null || jugador2==null || jugador1.getTablero()==null || jugador2.getTablero()==null) {
                throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO DATO EN PARTIDA! ");
            }else{
            this.jugador1 = jugador1;
            this.jugador2 = jugador2;
            this.tableroGrafico = tableroGrafico;
            }
    }


    //Getters y Setters correspondientes

    //Metodos--------------------------------------------------------------------------------

    //Metodos de ataque---------------
    //IMPORTANTE: LA FUNCION RETORNA TRUE SI LA PARTIDA SIGUE EN JUEGO DESPUES DEL ATAQUE, FALSE SI EN ESTE ATAQUE SE MATO AL HEROE
    // contemplar los try catch en la clase de la pantalla de la partida, a la hora de llamar a la funcion de ataque

    public int inicioPartida(Jugador jugador1, Jugador jugador2)
    {
        ///Verificar
return 1;
    }



    public boolean ataqueConPersonaje(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo) throws PasaNullExcepcion,PersonajeCongeladoAccionaExcepcion,ObjetivoInvalidoExcepcion
    {
        boolean resultado = true;
        if(( jugadorAtacante.getTablero().getPosiciones()[idAtacante-1] == null) || (jugadorDefensor.getTablero().getPosiciones()[idObjetivo-1] == null) && idObjetivo != 0){
            throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO PERSONAJE EN EL ATAQUE O EN EL OBJETIVO");
            //controlamos que la id no sea 0 porque eso quiere decir que ataca al heroe
        }else if (jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getTurnosCongelado() > 0) {
            throw new PersonajeCongeladoAccionaExcepcion("ERROR: EL PERSONAJE ATACANTE SELECCIONADO ESTA CONGELADO");
        }else{ //Si se verifican las 2 cosas entonces se realiza el ataque:


            if (idObjetivo == 0 && jugadorDefensor.getTablero().isVacio()){ // si la id del objetivo se puso como 0, quiere decir que ataca al heroe{
                    //Funcion que verifica que el enemigo no tenga otros personajes en el campo
                ataqueAlHeroe(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1], jugadorDefensor.getHeroeSeleccionado());
            } else if(idObjetivo == 0 && jugadorDefensor.getTablero().isVacio() == false){
                throw new ObjetivoInvalidoExcepcion("ERROR: EL TABLERO DEL ENEMIGO DEBE ESTAR VACIO");
            }else {
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

    public boolean controlarMuertes(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo)///Retorna true si el heroe sigue vivo, sino retorna false y finaliza la partida
    {
        if(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getCantidadDeVida() < 0)
        {//Si el que ataco murio en el ataque lo quitamos y primero verificamos si es un necrofago para activar su efecto:
            if(jugadorAtacante.getTablero().getPosiciones()[idAtacante - 1] instanceof Necrofago) // si es necrofago
            {
                jugadorAtacante.getTablero ().getPosiciones ()[idAtacante-1].activarEfecto (jugadorAtacante,jugadorDefensor,idObjetivo);///Hace el efecto a la carta defensora
            }
            try {
                jugadorAtacante.getTablero().eliminarPersonaje(jugadorAtacante.getTablero().getPosiciones()[idAtacante - 1]);
            }catch (PasaNullExcepcion | DatoNoEcontradoExcepcion e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }

        if(idObjetivo != 0) { // Si el objetivo es un esbirro
            if (jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1].getCantidadDeVida() < 0) { //si se murio
                try {
                    jugadorDefensor.getTablero().eliminarPersonaje(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1]);
                }catch (PasaNullExcepcion | DatoNoEcontradoExcepcion e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
                if(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1] instanceof Necrofago) // si es necrofago
                {
                    jugadorDefensor.getTablero ().getPosiciones ()[idObjetivo-1].activarEfecto (jugadorDefensor,jugadorAtacante,idAtacante); ///Se pasa al revés, hace el efecto a la carta atacante
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


    public boolean usarCarta(int idCarta, Jugador jugadorEjecutor, Jugador jugadorRival) throws DatoNoEcontradoExcepcion, ManaInsuficienteExcepcion, PasaNullExcepcion, TableroLlenoExcepcion {
        boolean control=true;
      Carta cartaUsada = buscarCartaEnMano(idCarta, jugadorEjecutor);

        if(cartaUsada == null || idCarta <= 0)
        {
            throw new DatoNoEcontradoExcepcion("ERROR: CARTA NO ENCONTRADA");
        }
        else if((jugadorEjecutor.getManaActual() - cartaUsada.getCostoEnergia()) < 0)
        {
            throw new ManaInsuficienteExcepcion("ERROR: MANA/ENERGIA INSUFICIENTE"); //TODO hacer try catchs
        }
        else{
            ///Empezamos a ver si la carta es un hechizo o personaje
            if(cartaUsada instanceof Hechizo)
            {

                invocarHechizo ((Hechizo) cartaUsada, jugadorEjecutor, jugadorRival);
                if(cartaUsada instanceof Danio)
                {
                    controlarMuertes (jugadorEjecutor,jugadorRival,idCarta,0);//TODO verificar que funcione bien
                }
            }
            else if(cartaUsada instanceof Personaje)
            {
                if(cartaUsada instanceof Necrofago)
                {
                    ///No activa su efecto porque éste se activa al morir
                }
                else
                {
                    invocarPersonaje((Personaje) cartaUsada, jugadorEjecutor, jugadorRival); //TODO hacer try catch de tablero lleno o dato nulo
                }
            }

            jugadorEjecutor.getManoActual().getMano().remove(cartaUsada); //eliminamos la carta de la mano
            jugadorEjecutor.getManoActual().setValidos(jugadorEjecutor.getManoActual().getValidos() - 1);//restamos a los validos
            jugadorEjecutor.setManaActual(jugadorEjecutor.getManaActual() - cartaUsada.getCostoEnergia());///Restamos la energia usada
        }

return control;
    }

    public Carta buscarCartaEnMano (int idCarta, Jugador jugadorEjecutor)
    {
        Carta encontrada = null;

            for (Carta carta: jugadorEjecutor.getManoActual().getMano()) { //esto es un for each
                if(idCarta == carta.getId())
                {
                    encontrada = carta;
                }
            }
        return encontrada;
    }

    public void invocarPersonaje(Personaje personaje, Jugador jugadorEjecutor, Jugador jugadorRival) throws PasaNullExcepcion, TableroLlenoExcepcion {
        jugadorEjecutor.getTablero().agregarPersonaje(personaje);
        if(!personaje.isGlobal()) // si no es global
        {
            //TODO hacer la ventana emergente que pida la id y la almacene en una variable, mientras la hardcodeo
            int id = 2; //esto esta hardcodeado, aca iria la id que recibe del usuario
            personaje.activarEfecto(jugadorEjecutor,jugadorRival,id);
        }
        else{
            //TODO hacer la ventana emergente que no pide una id, solo explica el efecto
            personaje.activarEfecto(jugadorEjecutor,jugadorRival,0);
        }
        //se asigna una id al personaje segun el lugar en el tablero
    }

    public void invocarHechizo(Hechizo hechizo, Jugador jugadorEjecutor, Jugador jugadorRival) throws PasaNullExcepcion, TableroLlenoExcepcion {
        ///No se invoca en el tablero porque es un hechizo
        if(!hechizo.isRara ()) // si no es rara, osea que no tiene efecto en area
        {
            //TODO hacer la ventana emergente que pida la id y la almacene en una variable, mientras la hardcodeo
            int id = 2; //esto esta hardcodeado, aca iria la id que recibe del usuario
            hechizo.activarEfecto(jugadorEjecutor,jugadorRival,id);
        }
        else{
            //TODO hacer la ventana emergente que no pide una id, solo explica el hechizo
            hechizo.activarEfecto(jugadorEjecutor,jugadorRival,0);
        }
        //se asigna una id al personaje segun el lugar en el tablero
    }


    public Jugador getJugadorTurno() {
        Jugador jugador = null;
        if(turno==1){
            jugador = jugador2;
        }else{
            jugador = jugador1;
        }
        return jugador;
    }

    public Jugador getJugadorEnemigo(){
        Jugador jugador = null;
        if (turno==1){
            jugador = jugador1;
        }else{
            jugador = jugador2;
        }
        return jugador;
    }
}
