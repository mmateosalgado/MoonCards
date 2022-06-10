package model;

import Batalla.Tablero;

public class Jugador {
    private Heroe heroeSeleccionado;
    private Mano manoActual;
    private int manaActual;
    private Mazo mazoJugador;
    private String nombre;
    private Tablero tablero;
    private int id;
    private int numeroVictorias;
    private boolean congelado;

    public Jugador(Heroe heroeSeleccionado, Mano manoActual, Mazo mazoJugador, String nombre, int id, int numeroVictorias) {
        //TODO posible error a futuro, a medida que continua el juego se le pasa el mazo vacio
        this.heroeSeleccionado = heroeSeleccionado;
        this.manoActual = manoActual;
        this.mazoJugador = mazoJugador;
        this.nombre = nombre;
        this.id = id;
        this.numeroVictorias = numeroVictorias;
        congelado=false;
        manaActual = 0;
    }

    public Heroe getHeroeSeleccionado() {
        return heroeSeleccionado;
    }

    public void setHeroeSeleccionado(Heroe heroeSeleccionado) {
        this.heroeSeleccionado = heroeSeleccionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(int numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public Mano getManoActual() {
        return manoActual;
    }

    public Mazo getMazoJugador() {
        return mazoJugador;
    }

    public int getValMazo(){
        return mazoJugador.getValidos();
    }

    public void setManoActual(Mano manoActual) {
        this.manoActual = manoActual;
    }

    public void setMazoJugador(Mazo mazoJugador) {
        this.mazoJugador = mazoJugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setCongelado(boolean congelado) {
        this.congelado = congelado;
    }

    public void setManaActual(int manaActual) {
        if(this.manaActual <= 10) {
            this.manaActual = manaActual;
        }else
        {
            this.manaActual = 10;
        }
    }

    public int getManaActual() {
        return manaActual;
    }
}
