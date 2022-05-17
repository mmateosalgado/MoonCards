package model;

import java.net.PortUnreachableException;
import java.util.Stack;

public class Mazo {
    private Stack<Carta> mazoCartas;

    public Mazo(){
        mazoCartas = new Stack<Carta>();
    }

    public void addCarta(Carta nueva){
        mazoCartas.add(nueva);
    }
}
