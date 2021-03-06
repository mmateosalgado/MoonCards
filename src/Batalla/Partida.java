package Batalla;

import Excepciones.*;
import InterfacesGraficas.TableroGrafico;
import InterfacesGraficas.pruebas.InvocarHechizoInterfaz;
import InterfacesGraficas.pruebas.InvocarPersonajeInterfaz;
import Razas.*;
import model.*;
import tiposHechizos.Danio;

import javax.swing.*;

public class Partida {

    private int turno;
    private Jugador jugador1;
    private Jugador jugador2;
    //private TableroGrafico tableroGrafico;


    // El constructor correspondiente

    public Partida(Jugador jugador1, Jugador jugador2) throws PasaNullExcepcion {
            this.turno = 1;
            if(jugador1==null || jugador2==null || jugador1.getTablero()==null || jugador2.getTablero()==null) {
                throw new PasaNullExcepcion("ERROR: SE PASA NULL COMO DATO EN PARTIDA! ");
            }else{
            this.jugador1 = jugador1;
            this.jugador2 = jugador2;
            jugador1.setManaActual(turno);
            jugador2.setManaActual(turno);

            }
    }

    public Partida pasarTurno()
    {
        turno++;
        int cantMana = turno/2;
        if(turno%2 != 0)
        {
            cantMana = (turno+1)/2;
        }
        this.getJugadorTurno().setManaActual(cantMana);
        try {
            this.getJugadorTurno().getManoActual().robarCarta(this.getJugadorTurno());
        } catch (ManoLlenaExcepcion e) {
            e.printStackTrace();
        }

        actualizarValoresPersonajes(this.getJugadorTurno());

        return this;
    }

    public void actualizarValoresPersonajes(Jugador jugador)
    {
        for (int i = 0; i < 3; i++) {
            if(jugador.getTablero().getPersonajeEnPosicion(i) != null)
            {
                jugador.getTablero().getPersonajeEnPosicion(i).setEstado();
                jugador.getTablero().getPersonajeEnPosicion(i).setTurnosCongelado(jugador.getTablero().getPersonajeEnPosicion(i).getTurnosCongelado() - 1);
            }
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


///1Caso de que defensor muere
    //2 Caso muere atacante
    ///3 Caso mueren ambos
    public boolean ataqueConPersonaje(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo) throws PasaNullExcepcion,PersonajeCongeladoAccionaExcepcion,ObjetivoInvalidoExcepcion
    {
        boolean resultado = true;
        ///Verifica que la posicion del atacante ni del defensor  sea null                         que no ataque al heroe y que no est?? congelado el atacante
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

            //-----------Se congela, no puede atacar mas ese turno
            jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].setTurnosCongelado (jugadorAtacante.getTablero ().getPosiciones ()[idAtacante-1].getTurnosCongelado ()+1);
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

    public void ataqueAlHeroe(Personaje atacante, Heroe defensor)throws PersonajeCongeladoAccionaExcepcion {
                // si es un orco raro robavida
              if(atacante.getTurnosCongelado ()==0)
              {
                  defensor.setCantVida(defensor.getCantVida() - atacante.getDanoInflige());
                  if (atacante instanceof Orco && atacante.isRara()) {
                      atacante.setCantidadDeVida(atacante.getDanoInflige() + atacante.getCantidadDeVida());
                  }
                  atacante.setTurnosCongelado (atacante.getTurnosCongelado ()+1);
              }
              else
              {
                  throw new PersonajeCongeladoAccionaExcepcion ("ERROR, PERSONAJE CONGELADO NO PUEDE ATACAR");
              }
    }

    //Metodos de muerte--------------

    public boolean controlarMuertes(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo)///Retorna true si el heroe sigue vivo, sino retorna false y finaliza la partida
    {
        if(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getCantidadDeVida() <= 0 && jugadorAtacante.getTablero().getPosiciones()[idAtacante-1] != null)
        {//Si el que ataco murio en el ataque lo quitamos y primero verificamos si es un necrofago para activar su efecto:
            eliminarAtacante(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo);
        }

        if(idObjetivo != 0) { // Si el objetivo es un esbirro
            if (jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1].getCantidadDeVida() <= 0) { //si se murio

                boolean necrofagoActivaEfecto = eliminarDefensor(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo);

                if(necrofagoActivaEfecto)
                {
                    if(jugadorAtacante.getTablero().getPosiciones()[idAtacante-1].getCantidadDeVida() <= 0)
                    {//Si el que ataco murio en la devolucion del efecto del necrofago, lo quitamos y primero verificamos si es un necrofago para activar su efecto:
                        eliminarAtacante(jugadorAtacante,jugadorDefensor,idAtacante,idObjetivo);
                    }
                }
            }
        }else {
            if(jugadorDefensor.getHeroeSeleccionado().getCantVida() <= 0) // si el objetivo es un heroe
            {
                return false;
            }
        }
        return true;
    }



    //CASO 1
    public boolean eliminarDefensor (Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo )
    {
        boolean necrofagoActivaEfecto = false;
        if(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1] instanceof Necrofago) // si es necrofago
        {
            jugadorDefensor.getTablero ().getPosiciones ()[idObjetivo-1].activarEfecto (jugadorDefensor,jugadorAtacante,idAtacante); ///Se pasa al rev??s, hace el efecto a la carta atacante
            if( jugadorDefensor.getTablero ().getPosiciones ()[idObjetivo-1].isRara()) // si somos el necrofago raro devolvemos true para saber si tenemos que verificar si se muere el hdp que nos ataco cuando le devolvamos el que nos dio con nuestro efecto.
            {
                necrofagoActivaEfecto = true;
            }
        }

        try {
            jugadorDefensor.getTablero().eliminarPersonaje(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1]);
            jugadorDefensor.getTablero().setValidos(jugadorDefensor.getTablero().getValidos()-1);
        }catch (PasaNullExcepcion | DatoNoEcontradoExcepcion e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return necrofagoActivaEfecto;
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
            jugadorAtacante.getTablero().setValidos(jugadorAtacante.getTablero().getValidos()-1);

        }catch (PasaNullExcepcion | DatoNoEcontradoExcepcion e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
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
            throw new ManaInsuficienteExcepcion("ERROR: MANA/ENERGIA INSUFICIENTE");
        }
        else{
            ///Empezamos a ver si la carta es un hechizo o personaje
            if(cartaUsada instanceof Hechizo)
            {

                invocarHechizo ((Hechizo) cartaUsada, jugadorEjecutor, jugadorRival);

            }
            else if(cartaUsada instanceof Personaje)
            {
                if(!(cartaUsada instanceof Necrofago))
                {
                    invocarPersonaje((Personaje) cartaUsada, jugadorEjecutor, jugadorRival);
                    //No activa su efecto porque ??ste se activa al morir
                }else
                {
                    jugadorEjecutor.getTablero().agregarPersonaje((Personaje)cartaUsada);
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
            new InvocarPersonajeInterfaz(this,personaje,jugadorEjecutor,jugadorRival);
           // int id = invocar.getIdSeleccionada(); //esto esta hardcodeado, aca iria la id que recibe del usuario
            //System.out.println("ESTA ES LA ID: "+id);

            //personaje.activarEfecto(jugadorEjecutor,jugadorRival,id);
        }
        else{
            personaje.activarEfecto(jugadorEjecutor,jugadorRival,0);
        }
        //se asigna una id al personaje segun el lugar en el tablero
    }

    public boolean controlarMuerteHechizoDanio(Jugador jugadorAtacante, Jugador jugadorDefensor, int idObjetivo)
    {
        ///El da??o ya se hizo
        if(idObjetivo != 0) { // Si el objetivo es un esbirro
            if (jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1].getCantidadDeVida() < 0) { //si se murio

                if(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1] instanceof Necrofago) // si es necrofago
                {
                    jugadorDefensor.getTablero ().getPosiciones ()[idObjetivo-1].activarEfecto (jugadorDefensor,jugadorAtacante,0); ///Se pasa al rev??s, hace el efecto a la carta atacante

                }

                try {
                    jugadorDefensor.getTablero().eliminarPersonaje(jugadorDefensor.getTablero().getPosiciones()[idObjetivo - 1]);
                }catch (PasaNullExcepcion | DatoNoEcontradoExcepcion e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
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

    public boolean invocarHechizo(Hechizo hechizo, Jugador jugadorEjecutor, Jugador jugadorRival) throws PasaNullExcepcion, TableroLlenoExcepcion {
        ///No se invoca en el tablero porque es un hechizo
        boolean partidaEnCurso=true;

        if(!hechizo.isRara ()) // si no es rara, osea que no tiene efecto en area
        {
            new InvocarHechizoInterfaz(this,hechizo,this.getJugadorTurno(),this.getJugadorEnemigo());

            /*if(hechizo instanceof Danio)
            {
                partidaEnCurso= controlarMuerteHechizoDanio (jugadorEjecutor,jugadorRival,idObjetivo);//Verificamos si muere al que fue afectado con bola de fuego
            }*/

        }
        else{
            hechizo.activarEfecto(jugadorEjecutor,jugadorRival,0);
            if(hechizo instanceof Danio)
            {
                //Controlar todos los que murieron en el tablero por el efecto global
                for (int i = 0; i < 3; i++) {
                    if(jugadorRival.getTablero().getPersonajeEnPosicion(i) != null)
                    {
                        controlarMuerteHechizoDanio (jugadorEjecutor,jugadorRival,jugadorRival.getTablero ().getPersonajeEnPosicion (i).getId());
                    }
                }
                ///Controla que no haya muerto el heroe
                partidaEnCurso = controlarMuerteHechizoDanio (jugadorEjecutor,jugadorRival,0);
            }

            new TableroGrafico(this);

        }
        return partidaEnCurso;
    }


    public Jugador getJugadorTurno() {
        Jugador jugador = null;
        if(turno%2==0){
            jugador = jugador1;
        }else{
            jugador = jugador2;
        }
        return jugador;
    }

    public Jugador getJugadorEnemigo(){
        Jugador jugador = null;
        if (turno%2==0){
            jugador = jugador2;
        }else{
            jugador = jugador1;
        }
        return jugador;
    }

    public void actualizarValores(){
        getJugadorTurno().getHeroeSeleccionado().actualizarValoresCarta();
        for (int i = 0; i<this.getJugadorTurno().getTablero().getValidos();i++){
          getJugadorTurno().getTablero().getPersonajeEnPosicion(i).actualizarValoresCarta();
        }
        getJugadorEnemigo().getHeroeSeleccionado().actualizarValoresCarta();
        for (int i = 0; i<this.getJugadorEnemigo().getTablero().getValidos();i++){
            getJugadorEnemigo().getTablero().getPersonajeEnPosicion(i).actualizarValoresCarta();
        }
    }
}
