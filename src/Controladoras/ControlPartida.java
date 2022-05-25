package Controladoras;

import Razas.Orco;
import model.Heroe;
import model.Jugador;
import model.Personaje;

public class ControlPartida {

    private int turno;

    private Jugador jugador1;
    private Jugador jugador2;
    /*
    private Tablero tableroJugador1
    private Tablero tableroJugador2
     */

    // El constructor correspondiente

    //Getters y Setters correspondientes

    //Metodos--------------------------------------------------------------------------------

    public Personaje buscarPersonajePorId(int id)
    {
        //aca tiene que buscar el personaje que esta ocupando esa casilla de id en el tablero

        return null; //aca retornaria personaje enrealidad, lo dejo asi para que no me tire error ahora
    }

    //Metodos de ataque---------------

    public void ataque(Jugador jugadorAtacante, Jugador jugadorDefensor, int idAtacante, int idObjetivo)
    {
        Personaje atacante = buscarPersonajePorId(idAtacante);

        if(idObjetivo == 0) // si la id del objetivo se puso como 0, quiere decir que ataca al heroe
        {
            //Funcion que verifica que el enemigo no tenga otros personajes en el campo
            ataqueAlHeroe(atacante,jugadorDefensor.getHeroeSeleccionado());
        }else{
           Personaje objetivo = buscarPersonajePorId(idObjetivo);
            ataquePersonajes(atacante,objetivo);
        }
    }

    public void ataquePersonajes(Personaje atacante, Personaje objetivo)
    {
        if(atacante instanceof Orco && atacante.isRara()) // si es un orco raro robavida
        {
            atacante.setCantidadDeVida(atacante.getDanoInflige() + atacante.getCantidadDeVida());
        }

        objetivo.setCantidadDeVida(objetivo.getCantidadDeVida() - atacante.getDanoInflige());
        atacante.setEstado();
    }

    public void ataqueAlHeroe(Personaje atacante, Heroe defensor)
    {
        defensor.setCantVida(defensor.getCantVida() - atacante.getDanoInflige());
    }


}
