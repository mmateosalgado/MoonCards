package model;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class ColeccionHeroe {
    private ArrayList <Heroe> listaHeroes;

    public ColeccionHeroe(){
        listaHeroes = new ArrayList<Heroe>();
    }

    public boolean agregarHeroe(Heroe heroe){
        return listaHeroes.add(heroe);
    }

    public boolean buscarHeroe(String name){
        boolean flag = false;
        for(int i = 0; i< listaHeroes.size();i++) {
            if(name.equals(listaHeroes.get(i).getNombre())){
                flag = true;
            }
        }
        return flag;
    }

    public Heroe buscarRetornarHeroe(String name){
        Heroe heroe = null;
        for(int i = 0;i< listaHeroes.size();i++){
            if(name.equals(listaHeroes.get(i).getNombre())){
                heroe = listaHeroes.get(i);
            }
        }
        return heroe;
    }

    public String listarHeroes(){
        StringBuilder recolector = new StringBuilder();
        for (int i = 0; i < listaHeroes.size();i++){
            recolector.append(listaHeroes.get(i).getNombre());
            recolector.append("\n");
        }
        return  recolector.toString();
    }

    public Heroe[] devolverArregloHeroes(){
        return listaHeroes.toArray(new Heroe[0]);
    }

    public String[] devolverArregloNombreHeroes(){
        String[] nombres = new String[listaHeroes.size()];

        for (int i = 0; i< listaHeroes.size();i++){
            nombres[i] = listaHeroes.get(i).getNombre();
        }
        return nombres;
    }

    public int cantHeroes(){
        return listaHeroes.size();
    }
}


