package model;

import Batalla.Tablero;

public class Jugador {
    private Heroe heroeSeleccionado;
    private Mano manoActual;
    private Mazo mazoJugador;
    private String nombre;
    private Tablero tablero;
    private int id;
    private int numeroVictorias;

    public Jugador(Heroe heroeSeleccionado, Mano manoActual, Mazo mazoJugador, String nombre, int id, int numeroVictorias) {
        this.heroeSeleccionado = heroeSeleccionado;
        this.manoActual = manoActual;
        this.mazoJugador = mazoJugador;
        this.nombre = nombre;
        this.id = id;
        this.numeroVictorias = numeroVictorias;
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
}
