package Batalla;

import Excepciones.*;
import Razas.*;
import model.*;
import tiposHechizos.Danio;

import javax.swing.*;

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
            this.jugador2 = jugador2;
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
            resultado = controlarMuertes(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo); //Si devuelve false quiere decir que la partida termina luego de este ataque

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
    { //TODO verificar reduccion de validos al morir
        if(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getCantidadDeVida() < 0 && jugadorAtacante.getTablero().getPosiciones()[idAtacante-1] != null)
        {//Si el que ataco murio en el ataque lo quitamos y primero verificamos si es un necrofago para activar su efecto:
            eliminarAtacante(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo);
        }

        if(idObjetivo != 0) { // Si el objetivo es un esbirro
            if (jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1].getCantidadDeVida() < 0) { //si se murio

                boolean necrofagoActivaEfecto = eliminarDefensor(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo);

                if(necrofagoActivaEfecto)
                {
                    if(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getCantidadDeVida() < 0)
                    {//Si el que ataco murio en la devolucion del efecto del necrofago, lo quitamos y primero verificamos si es un necrofago para activar su efecto:
                        eliminarAtacante(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo);
                    }
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

    //CASO 2
    public void eliminarAtacante (Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo )
    {
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

    //CASO 1
    public boolean eliminarDefensor (Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo )
    {
        boolean necrofagoActivaEfecto = false;
        if(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1] instanceof Necrofago) // si es necrofago
        {
            jugadorDefensor.getTablero ().getPosiciones ()[idObjetivo-1].activarEfecto (jugadorDefensor,jugadorAtacante,idAtacante); ///Se pasa al revés, hace el efecto a la carta atacante
            if( jugadorDefensor.getTablero ().getPosiciones ()[idObjetivo-1].isRara()) // si somos el necrofago raro devolvemos true para saber si tenemos que verificar si se muere el hdp que nos ataco cuando le devolvamos el que nos dio con nuestro efecto.
            {
                necrofagoActivaEfecto = true;
            }
        }

        try {
            jugadorDefensor.getTablero().eliminarPersonaje(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1]);
        }catch (PasaNullExcepcion | DatoNoEcontradoExcepcion e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return necrofagoActivaEfecto;
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
            int idObjetivo = 2; //esto esta hardcodeado, aca iria la id que recibe del usuario
            hechizo.activarEfecto(jugadorEjecutor,jugadorRival,idObjetivo);
            if(hechizo instanceof Danio)
            {
                //controlarMuertes (jugadorEjecutor,jugadorRival,0,idObjetivo);//TODO verificar si muere al que matamos con bola de fuego
            }
        }
        else{
            //TODO hacer la ventana emergente que no pide una id, solo explica el hechizo
            hechizo.activarEfecto(jugadorEjecutor,jugadorRival,0);
            if(hechizo instanceof Danio)
            {
               //TODO controlar todos los que murieron en el tablero
            }
        }
        //se asigna una id al personaje segun el lugar en el tablero
    }


}
