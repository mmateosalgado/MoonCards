package model;

import Excepciones.MazoVacioExcepcion;

import java.util.ArrayList;


public class Mazo {
    private ArrayList<Carta> mazoCartas;
    private int validos;

    //Constructor -------------------------------
   /* public Mazo(){
        mazoCartas = new ArrayList<Carta>();
        validos = 0;
    }*/

    public Mazo(Coleccion<Carta> cartas)
    {
        mazoCartas = new ArrayList<Carta>();
        validos = 0;
        for (int i = 0; i < cartas.getLista().size(); i++) {
            mazoCartas.add(cartas.getLista().get(i));
            validos++;
        }
    }

    //Getters setters

    //Metodos------------------------------------
    public void agregarCarta(Carta nueva){
       mazoCartas.add(nueva);
       validos++;
    }

    public Carta sacarCartaRandom() throws MazoVacioExcepcion {
        Carta sacada=null;

        if(mazoCartas.size()!=0){
            int numero = (int)(Math.random()*validos+0);
            sacada = mazoCartas.get(numero);
            mazoCartas.remove(numero);
            validos--;
        }else {
            throw new MazoVacioExcepcion("SE TERMINO TU MAZO! HAS PERDIDO!!");
        }

        return sacada;
    }

    public int getValidos() {
        return validos;
    }

    //teste
    public String mostrarMazo(){
        return mazoCartas.toString();
    }

    @Override
    public String toString() {
        return "\n\nMazo{" +
                "mazoCartas=" + mazoCartas +
                ", validos=" + validos +
                '}';
    }
}
