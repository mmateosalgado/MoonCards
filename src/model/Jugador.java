package model;

public class Jugador {
    private Heroe heroeSeleccionado;
    //private Mano manoActual
    //private Mazo mazoJugador
    String nombre;
    int id;
    int numeroVictorias;

    public Jugador(Heroe heroeSeleccionado, String nombre, int id, int numeroVictorias) {
        this.heroeSeleccionado = heroeSeleccionado;
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
}
