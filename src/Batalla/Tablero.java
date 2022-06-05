package Batalla;

import Excepciones.PasaNullExcepcion;
import Excepciones.TableroLlenoExcepcion;
import model.Heroe;
import model.Personaje;

public class Tablero {

    private Personaje[] posiciones;
    private int validos;
    private Heroe posHeroe;

    public Tablero(Heroe posHeroe) {
        this.posiciones = new Personaje[3];
        this.validos = 0;
        this.posHeroe = posHeroe;
    }
    //Getters y setters abajo*
    //Metodos---------------------------------------------------------------------
    
    public void agregarPersonaje(Personaje nuevo)
    {
        try{
            if(nuevo==null){
                throw new PasaNullExcepcion("ERROR: PASA NULL A LA HORA DE AGREGAR PERSONAJE AL TABLERO");
            }else if(validos==posiciones.length){
                throw new TableroLlenoExcepcion("ERROR: NO SE PUEDEN AGREGAR MAS PERSONAJES TABLERO LLENO!");
            }else{
                int i = 0;
                while (i < posiciones.length && posiciones[i] != null) //asi siempre se agrega en la primera disponible
                {
                    i++;
                }

                if (i == posiciones.length) {
                    //lanzar exepcion de que el tablero ya esta lleno y no se puede agregar mas
                } else {
                    posiciones[i] = nuevo;
                }
            }
        }catch (PasaNullExcepcion | TableroLlenoExcepcion e){
            e.getMessage();
        }
    }
    
    public void eliminarPersonaje(Personaje eliminado) {
        try {
            if(eliminado==null){
                throw new PasaNullExcepcion("ERROR:PASA NULL COMO PERSONAJE A ELIMINAR DEL TABLERO");
            }else {
                for (int i = 0; i < posiciones.length; i++) {
                    if (posiciones[i] == eliminado) {
                        posiciones[i] = null;
                    }
                }// hay que hacer una expecion para que si se quisiera un personaje que no esta en el tablero, la lanze
            }
        }catch (PasaNullExcepcion e){
            e.getMessage();
        }
    }
    
    //Getters y Setters-----------------------------------------------------------


    public Personaje[] getPosiciones() {
        return posiciones;
    }

    public Personaje getPersonajeEnPosicion(int pos) {
        return posiciones[pos];
    }

    public void setPosiciones(Personaje[] posiciones) {
        this.posiciones = posiciones;
    }

    public int getValidos() {
        return validos;
    }

    public void setValidos(int validos) {
        this.validos = validos;
    }

    public Heroe getPosHeroe() {
        return posHeroe;
    }

    public void setPosHeroe(Heroe posHeroe) {
        this.posHeroe = posHeroe;
    }
}
