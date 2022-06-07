package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Mazo {
    private ArrayList<Carta> mazoCartas;
    private int validos;

    //Constructor -------------------------------
    public Mazo(){
        mazoCartas = new ArrayList<Carta>();
        validos = 0;
    }

    //Getters setters

    //Metodos------------------------------------
    public void agregarCarta(Carta nueva){
       mazoCartas.add(nueva);
       validos++;
    }

    public Carta sacarCartaRandom(){
        int numero = (int)(Math.random()*validos+0);
        Carta sacada = mazoCartas.get(numero);
        mazoCartas.remove(numero);
        validos--;
        return sacada;
    }



    //teste
    public String mostrarMazo(){
        return mazoCartas.toString();
    }
}
