package Administrador;

import model.Carta;
import model.Coleccion;
import model.Heroe;

import java.io.*;

public class Administrador {


    public Coleccion<Carta> cargarColeccionDeCartas ()
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

    public Coleccion<Heroe> cargarColeccionDeHeroes ()
    {
        Coleccion<Heroe> coleccionHeroes= new Coleccion<Heroe> ();
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


}
