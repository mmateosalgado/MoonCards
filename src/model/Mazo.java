package model;

import java.net.PortUnreachableException;
import java.util.Stack;

public class Mazo {
    private Stack<Carta> mazoCartas;

    public Mazo(){
        mazoCartas = new Stack<Carta>();
    }

    public Carta apilarCarta(Carta nueva){
       return mazoCartas.push(nueva);
    }

    public String mostrarMazo(){
        return mazoCartas.toString();
    }
}
