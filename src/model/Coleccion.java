package model;

import Excepciones.DatoNoEcontradoExcepcion;
import Excepciones.PasaNullExcepcion;

import java.util.ArrayList;


    public class Coleccion <T extends DatoPrincipal>{
    private ArrayList <T> lista;

        //-------------------------------------------------Contructor-------------------------------------------------
     public Coleccion(){
         lista = new ArrayList<T>();
    }



        //-------------------------------------------------Getters-------------------------------------------------

        public T getTipo(){
            if(lista.size()!=0) {
                return lista.get(0);
            }else{
                return null;
            }
        }

        public ArrayList<T> getLista() {
            return lista;
        }

        //-------------------------------------------------Metodos Lista Generica-------------------------------------------------
        public boolean agregar(T t){
            return lista.add(t);
        }

        public T buscarRetornar(String name){
        T t = null;
        for(int i = 0;i< lista.size();i++){
            if(name.equals(lista.get(i).getNombre())){
                t = lista.get(i);
            }
        }
        return t;
    }

    public String listarHeroes(){
        StringBuilder recolector = new StringBuilder();
        for (int i = 0; i < lista.size();i++){
            recolector.append(lista.get(i).getNombre());
            recolector.append("\n");
        }
        return  recolector.toString();
    }

    public Heroe[] devolverArregloHeroe(){
        Heroe[]arreglo=new Heroe[lista.size()];
        for(int i=0;i<arreglo.length;i++){
            arreglo[i]= (Heroe) lista.get(i);
        }
        return arreglo;
    }

    public Carta[] devolverArregloCarta(){
        Carta[]arreglo=new Carta[lista.size()];
        for(int i=0;i<arreglo.length;i++){
            arreglo[i]= (Carta) lista.get(i);
        }
        return arreglo;
    }

    public int cantHeroes(){
        return lista.size();
    }


        //-------------------------------------------------To String-------------------------------------------------

        @Override
        public String toString() {
            return "Coleccion{" +
                    "lista=" + lista +
                    '}';
        }

    }


