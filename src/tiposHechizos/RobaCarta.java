package tiposHechizos;

import Excepciones.ManoLlenaExcepcion;
import Excepciones.MazoVacioExcepcion;
import InterfacesCartas.I_RobarCarta;
import model.Hechizo;
import model.Jugador;

import javax.swing.*;

public class RobaCarta extends Hechizo implements I_RobarCarta {
private int cantCartasRobadas;

    ///--------------------------------------Contructor Para guardar en el archivo--------------------------------------
    public RobaCarta(String nombre, boolean isRara, int costoEnergia, ImageIcon imagem, String descrip, int cantCartasRobadas) {
        super(nombre, isRara, costoEnergia, 0, imagem, descrip);
        this.cantCartasRobadas = cantCartasRobadas;
    }

    ///--------------------------------------GETTERS--------------------------------------
    public int getCantCartasRobadas () {
        return cantCartasRobadas;
    }

    public String getTipoCarta() {
        return getClass().getSimpleName();
    }

    ///--------------------------------------SETTERS--------------------------------------
    public void setCantCartasRobadas (int cantCartasRobadas) {
        this.cantCartasRobadas = cantCartasRobadas;
    }

    ///--------------------------------------Implementación Interfaces--------------------------------------
    ///--------------------------------------MUESTRA Excepción en caso de estar la Mano LLena--------------------------------------
    @Override
    public void robarCarta (Jugador objetivo) {

        for(int i=0;i<cantCartasRobadas;i++)
        {
            try {
                objetivo.getManoActual ().robarCarta (objetivo);
            } catch (ManoLlenaExcepcion e) {
                JOptionPane.showMessageDialog(null,"Tu mano esta llena, NO PUEDES AGARRAR MAS CARTAS!");
            }
        }
    }

    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        robarCarta(jugadorEjecutor);

    }
///  --------------------------------------To String--------------------------------------
    @Override
    public String toString() {
        return "RobaCarta{" +
                "cantCartasRobadas=" + cantCartasRobadas +
                "} " + super.toString();
    }
}
