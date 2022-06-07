package model;

public abstract class Personaje extends Carta{

    private int cantidadDeVida;
    private boolean estado; // para saber si ya ataco en este turno o no, true = ya ataco / false = no ataco aun
    private int turnosCongelado;//0 --> no esta congelado

    //Constructor--------------------------------------

    public Personaje(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida) {
        super(nombre, isRara, costoEnergia, danoInflige);
        this.cantidadDeVida = cantidadDeVida;
        this.estado = false;
        this.turnosCongelado = 0;
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
