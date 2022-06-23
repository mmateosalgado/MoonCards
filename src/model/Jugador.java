package model;

import Administrador.Administrador;
import Batalla.Tablero;
import Excepciones.ManoLlenaExcepcion;

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

    //------------------------------------Contructor------------------------------------
    public Jugador(Heroe heroeSeleccionado, String nombre, int id) {
        //TODO posible error a futuro, a medida que continua el juego se le pasa el mazo vacio
        this.heroeSeleccionado = heroeSeleccionado;
        this.mazoJugador = new Mazo(Administrador.cargarColeccionDeCartas()); // agarra las primeras 20 cartas del archivo------------------------------------
        this.nombre = nombre;
        this.id = id;
        //this.numeroVictorias = numeroVictorias;
        tablero = new Tablero(heroeSeleccionado);
        congelado=false;
        manaActual = 0;

        //------------------------------------ Aca hago esto asi la mano directamente arranca con 3 cartas del mazo------------------------------------
        manoActual = new Mano();
        try {
            manoActual.robarCarta(this);
            manoActual.robarCarta(this);
            manoActual.robarCarta(this);
        } catch (ManoLlenaExcepcion e) {
            e.printStackTrace(); //Nunca deberia llegar a esta excepcion al crear un jugador
        }
    }
    //------------------------------------------GETTERS---------------------------------------------

    public Heroe getHeroeSeleccionado() {
        return heroeSeleccionado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getNumeroVictorias() {
        return numeroVictorias;
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

    public int getManaActual() {
        return manaActual;
    }

    public Tablero getTablero() {
        return tablero;
    }


    //------------------------------------------SETTERS---------------------------------------------

    public void setNumeroVictorias(int numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public void setManoActual(Mano manoActual) {
        this.manoActual = manoActual;
    }

    public void setMazoJugador(Mazo mazoJugador) {
        this.mazoJugador = mazoJugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeroeSeleccionado(Heroe heroeSeleccionado) {
        this.heroeSeleccionado = heroeSeleccionado;
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

    //------------------------------------------To String---------------------------------------------

    @Override
    public String toString() {
        return "Jugador{" +
                "heroeSeleccionado=" + heroeSeleccionado +
                ", manoActual=" + manoActual +
                ", manaActual=" + manaActual +
                ", mazoJugador=" + mazoJugador +
                ", nombre='" + nombre + '\'' +
                ", tablero=" + tablero +
                ", id=" + id +
                ", numeroVictorias=" + numeroVictorias +
                ", congelado=" + congelado +
                '}';
    }
}
