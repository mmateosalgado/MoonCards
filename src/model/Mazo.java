package model;

import java.net.PortUnreachableException;
import java.util.Stack;

public class Mazo {
    private Stack<Carta> mazoCartas;

    //Constructor -------------------------------
    public Mazo(){
        mazoCartas = new Stack<Carta>();
    }

    //Metodos------------------------------------
    public Carta apilarCarta(Carta nueva){
       return mazoCartas.push(nueva);
    }

    //teste
    public String mostrarMazo(){
        return mazoCartas.toString();
    }
}
