package model;

import java.util.ArrayList;

public class ColeccionCartas {
    private ArrayList<Carta> listaCartas;

    public ColeccionCartas() {
        this.listaCartas = new ArrayList<Carta>();
    }

    public boolean agregarCarta(Carta nueva){return listaCartas.add(nueva);}

    public Carta[] devolverArregloCartas(){
        return listaCartas.toArray(new Carta[0]);
    }

    @Override
    public String toString() {
        return "ColeccionCartas{" +
                "listaCartas=" + listaCartas +
                '}';
    }
}
