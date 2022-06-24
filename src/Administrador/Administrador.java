package Administrador;

import model.Carta;
import model.Coleccion;
import model.Heroe;

import java.io.*;

public class Administrador {

    ///-------------------------------------------------Cargar Coleccion de Cartas desde el Archivo de Cartas------------------------------------------------
    public static Coleccion<Carta> cargarColeccionDeCartas()
    {
        Coleccion<Carta> coleccionCartas= new Coleccion<> ();
        try {
            //Creamos el file input stream que transforma los bytes
            FileInputStream fileInputStream = new FileInputStream("cartas.bin");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            int lectura = 1;
            while(lectura == 1) {
                Carta auxCarta = (Carta) objectInputStream.readObject();
                coleccionCartas.agregar(auxCarta);
            }

            objectInputStream.close();

        }catch(EOFException e){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coleccionCartas;
    }
    ///-------------------------------------------------Asigna ID automaticamente------------------------------------------------
    public int agregarId()
    { int id=0;

        Coleccion <Carta> coleccionId = new Coleccion<> ();
        coleccionId = cargarColeccionDeCartas ();
        for (Carta carta:coleccionId.getLista ()) {
            id=carta.getId ();
        }

        return id+1;
    }
    ///-------------------------------------------------Cargar Archivo Cartas desde la Coleccion de Cartas------------------------------------------------
    public void cargarArchivoCartas (Coleccion<Carta> coleccion)
    {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("cartas.bin");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (int i = 0; i < coleccion.getLista().size(); i++) {

                Carta aux = coleccion.getLista().get(i);

                objectOutputStream.writeObject(aux);
            }

            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    ///-------------------------------------------------Cargar Archivo Heroes desde la Coleccion de Heroes------------------------------------------------
    public void cargarArchivoHeroes (Coleccion<Heroe> coleccion)
    {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("heroes.bin");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (int i = 0; i < coleccion.getLista().size(); i++) {

                Heroe aux = coleccion.getLista().get(i);

                objectOutputStream.writeObject(aux);
            }

            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///-------------------------------------------------Cargar Coleccion Heroes desde el Archivo de Heroes------------------------------------------------
    public Coleccion<Heroe> cargarColeccionDeHeroes()
    {
        Coleccion<Heroe> coleccionHeroes= new Coleccion<> ();
        try {
            //Creamos el file input stream que transforma los bytes
            FileInputStream fileInputStream = new FileInputStream("heroes.bin");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


            int lectura = 1;
            while(lectura == 1) {
                Heroe auxHeroe = (Heroe) objectInputStream.readObject();
                coleccionHeroes.agregar(auxHeroe);
            }

            objectInputStream.close();

        }catch(EOFException e){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coleccionHeroes;
    }
    ///-------------------------------------------------Valida los nombres al crear o modificar una Carta------------------------------------------------
    public boolean validarNombreCarta(String nuevo)
    {
        boolean control=true;
        Coleccion<Carta> coleccion=cargarColeccionDeCartas();

        for (Carta carta: coleccion.getLista ()) {
            if (carta.getNombre().contains (nuevo))
            {
                control=false;
            }
        }
        return control;
    }
    ///-------------------------------------------------Valida los nombres al crear o modificar un Heroe------------------------------------------------
    public boolean validarNombreHeroes(String nuevo)
    {
        boolean control=true;
        Coleccion<Heroe> coleccion=cargarColeccionDeHeroes();
        for (Heroe heroe: coleccion.getLista ()) {
            if (heroe.getNombre ().contains (nuevo))
            {
                control=false;
            }
        }
        return control;
    }


}
