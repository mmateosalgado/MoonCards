package model;

import Excepciones.ManoLlenaExcepcion;
import Excepciones.MazoVacioExcepcion;
import InterfacesCartas.I_RobarCarta;

import javax.swing.*;
import java.util.ArrayList;

public class Mano implements I_RobarCarta {
    private ArrayList <Carta> mano;
    private int validos;

    //------------------------------------Contructor------------------------------------
    public Mano() {
        this.mano = new ArrayList<>();
        this.validos = 0;
    }



    //------------------------------------Getters------------------------------------
    public ArrayList<Carta> getMano() {
        return mano;
    }

    public int getValidos() {
        return validos;
    }

    //------------------------------------Setters------------------------------------
    public void setValidos(int validos) {
        this.validos = validos;
    }


    //------------------------------------Metodos------------------------------------
    public void agregarMano(Carta carta){
        mano.add(carta);
        validos++;
    }
    @Override
    public void robarCarta (Jugador jugador) throws ManoLlenaExcepcion {
        if(validos<10)
        {
            try {
                int val = jugador.getMazoJugador().getValidos();
                if (val != 0) {
                    Carta nueva = jugador.getMazoJugador().sacarCartaRandom();
                    if (nueva != null) {
                        mano.add(nueva);
                        validos++;
                    }
                }
            }catch (MazoVacioExcepcion e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                jugador.getHeroeSeleccionado().setCantVida(0);
            }
        }
        else
        {
            throw new ManoLlenaExcepcion(" ATENCION: LA MANO ESTA LLENA ! NO PUEDES ROBAR MAS CARTAS! ");
        }
    }

    //------------------------------------To String------------------------------------

    @Override
    public String toString() {
        return "\nMano{" +
                "mano=" + mano +
                ", validos=" + validos +
                '}';
    }
}
