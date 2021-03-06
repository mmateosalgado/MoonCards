package tiposHechizos;

import InterfacesCartas.I_Congelar;
import model.Hechizo;
import model.Jugador;
import model.Personaje;

import javax.swing.*;

public class Hielo extends Hechizo implements I_Congelar {

    private int cantTurnosCongela;

    //--------------------------------------Constructor Para guardar en el archivo--------------------------------------

    public Hielo(String nombre, boolean isRara, int costoEnergia, ImageIcon imagem, String descrip, int cantTurnosCongela) {
        super(nombre, isRara, costoEnergia, 0, imagem, descrip);
        this.cantTurnosCongela = cantTurnosCongela;
    }

    //--------------------------------------GETTERS--------------------------------------
    public int getCantTurnosCongela () {
        return cantTurnosCongela;
    }

    public String getTipoCarta() {
        return getClass().getSimpleName();
    }

    ///--------------------------------------Interfaces que implementa--------------------------------------
    @Override
    public void congelar (Jugador objetivo , int id) {
            if ( isRara () ) {
                for (int i = 0; i < 3; i++) {
                    if ( objetivo.getTablero ().getPersonajeEnPosicion ( i ) != null ) {
                        objetivo.getTablero ().getPersonajeEnPosicion ( i ).setTurnosCongelado (objetivo.getTablero ().getPersonajeEnPosicion ( i ).getTurnosCongelado () + cantTurnosCongela);
                    }
                }
            } else {// id-1 es la posicion en el arreglo (por ej si un personaje tiene id =2, su pos en el arreglo es 1)
               ///Si la id es 0 no podría congelar al heroe

                    objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).setTurnosCongelado (objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).getTurnosCongelado () + cantTurnosCongela);
            }
        }
        
    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        congelar(jugadorRival,id);

    }
    ///--------------------------------------To String--------------------------------------

    @Override
    public String toString() {
        return "Hielo{" +
                "cantTurnosCongela=" + cantTurnosCongela +
                "} " + super.toString();
    }
}
