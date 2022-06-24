package Batalla;

import Excepciones.DatoNoEcontradoExcepcion;
import Excepciones.PasaNullExcepcion;
import Excepciones.TableroLlenoExcepcion;
import model.Heroe;
import model.Personaje;

import java.util.Arrays;

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
    
    public void agregarPersonaje(Personaje nuevo) throws PasaNullExcepcion, TableroLlenoExcepcion
    {
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
                    ///Sino incrementa los validos y asigna id del tablero al Personaje
                } else {
                    nuevo.setId (i+1);
                    validos++;
                    posiciones[i] = nuevo;
                }

            }
    }
    
    public void eliminarPersonaje(Personaje eliminado)throws PasaNullExcepcion, DatoNoEcontradoExcepcion {//TODO aplicar try -catch donde corresponda
            if(eliminado==null){
                throw new PasaNullExcepcion("ERROR:PASA NULL COMO PERSONAJE A ELIMINAR DEL TABLERO");
            }else {
                int flag=0;

                for (int i = 0; i < posiciones.length && flag==0; i++) {
                    if(posiciones[i] != null)
                    {
                    if (posiciones[i].equals (eliminado)) {
                        flag=i;
                        System.out.println ("I POS:"+i);
                    }
                    }

                }

               // if(flag!=0){
                    posiciones[flag]=null;
                    System.out.println ("HOLAAAAAA");
                   //validos--;

                //else {
                   // throw new DatoNoEcontradoExcepcion("ERROR: PERSONAJE A ELIMINAR NO ESTA EN EL TABLERO");

            }
    }

    public boolean isVacio ()
    {
        boolean resultado = true;

        for (int i = 0; i < 3 && resultado != false; i++) {
            if(posiciones[i] != null)
            {
                resultado = false;
            }
        }
        return resultado;
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

    @Override
    public String toString() {
        return "Tablero{" +
                "posiciones=" + Arrays.toString(posiciones) +
                ", validos=" + validos +
                ", posHeroe=" + posHeroe +
                '}';
    }
}
