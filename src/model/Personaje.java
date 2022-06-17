package model;

import InterfacesCartas.I_ActivarEfecto;

public abstract class Personaje extends Carta  {

    private int cantidadDeVida;
    private boolean estado; // para saber si ya ataco en este turno o no, true = ya ataco / false = no ataco aun
    private int turnosCongelado;//0 --> no esta congelado
    private boolean rangoGlobal; //true -> global ... false -> individual

    //Constructor--------------------------------------

    public Personaje(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida, boolean rangoGlobal) {
        super(nombre, isRara, costoEnergia, danoInflige);
        this.cantidadDeVida = cantidadDeVida;
        this.estado = false;
        this.turnosCongelado = 0;
        this.rangoGlobal = rangoGlobal;
    }

    //Metodos


    //Getters--------------------

    public int getCantidadDeVida() {
        return cantidadDeVida;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getTurnosCongelado() {
        return turnosCongelado;
    }

    public boolean isGlobal() {
        return rangoGlobal;
    }

    public void setRangoGlobal(boolean rangoGlobal) {
        this.rangoGlobal = rangoGlobal;
    }

    //Setters---------------------

    public void setTurnosCongelado (int turnosCongelado) {
        this.turnosCongelado = turnosCongelado;
    }

    public void setEstado() {
        if(estado) {
            this.estado = false;
        } else {
            this.estado = true;
        }

    }

    public void setCantidadDeVida(int cantidadDeVida) {
        this.cantidadDeVida = cantidadDeVida;
    }
}
