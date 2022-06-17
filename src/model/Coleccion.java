package model;

import Excepciones.DatoNoEcontradoExcepcion;
import Excepciones.PasaNullExcepcion;

import java.util.ArrayList;


    public class Coleccion <T extends DatoPrincipal>{
    private ArrayList <T> lista;

    public Coleccion(){
        lista = new ArrayList<T>();
    }

    public boolean agregar(T t){
        return lista.add(t);
    }

    public boolean buscar(String nombre) throws PasaNullExcepcion, DatoNoEcontradoExcepcion{ //TODO aplicar try - catch

        if(nombre==null){
            throw new PasaNullExcepcion("ERROR:SE PASA null COMO NOMBRE DEL HEROE A BUSCAR");//
        }//AGREGAR EXCEPCION DE NO ENCONTRADO CAMBIAR METODO?

        boolean flag = false;
        for(int i = 0; i< lista.size();i++) {
            if(nombre.equals(lista.get(i).getNombre())){
                flag = true;
            }
        }

        if(flag==false){
            throw new DatoNoEcontradoExcepcion("ERROR:HEROE NO EXISTE EN COLECCION DE HEROES");
        }
        return flag;
    }

    public T getTipo(){
        if(lista.size()!=0) {
            return lista.get(0);
        }else{
            return null;
        }
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
}


