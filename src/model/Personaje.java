package model;

public abstract class Personaje extends Carta{

    private int cantidadDeVida;
    private boolean estado; // para saber si ya ataco en este turno o no, true = ya ataco / false = no ataco aun

    //Constructor--------------------------------------

    public Personaje(String nombre, boolean isRara, int costoEnergia, int costoDanoInflige, int cantidadDeVida) {
        super(nombre, isRara, costoEnergia, costoDanoInflige);
        this.cantidadDeVida = cantidadDeVida;
        this.estado = false;
    }

    //Metodos

    //Getters--------------------

    public int getCantidadDeVida() {
        return cantidadDeVida;
    }

    public boolean isEstado() {
        return estado;
    }

    //Setters---------------------

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
