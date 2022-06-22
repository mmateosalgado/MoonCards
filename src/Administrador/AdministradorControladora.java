package Administrador;

import Razas.Golem;
import Razas.Humano;
import Razas.Necrofago;
import Razas.Orco;
import model.Hechizo;
import model.Personaje;
import tiposHechizos.Curacion;
import tiposHechizos.Danio;
import tiposHechizos.Hielo;
import tiposHechizos.RobaCarta;

public class AdministradorControladora {


    public Personaje crearPersonaje(int opcion)
    {
        ///Scanner Visuales que tendrían que estar.
        String nombre="Orco";
        boolean isRara=true;
        int costoEnergia=10;
        int danoInflige=2;
        int cantidadDeVida=4;
        int danioAdicional=12;
        boolean global=false;
        int valorEfecto=10;

        Personaje personaje=null;
        if(opcion==1)
        {
            personaje=new Humano (nombre,isRara,costoEnergia,danoInflige,cantidadDeVida,danioAdicional,global);
        }
        else if(opcion==2)
        {
            personaje=new Orco (nombre,isRara,costoEnergia,danoInflige,cantidadDeVida,valorEfecto,global);

        }
        else if(opcion==3)
        {
            personaje=new Necrofago (nombre,isRara,costoEnergia,danoInflige,cantidadDeVida,valorEfecto,global);
        }
        else if(opcion==4)
        {
            personaje=new Golem (nombre,isRara,costoEnergia,danoInflige,cantidadDeVida,valorEfecto,global);
        }

        return personaje;
    }

    public Hechizo crearHechizo(int opcion)
    {
        ///Scanner Visuales que tendrían que estar.
        String nombre="Orco";
        boolean isRara=true;
        int costoEnergia=10;
        int danoInflige=0;
        int valorEfecto=10;

        Hechizo hechizo=null;
        if(opcion==1)
        {
            hechizo=new Curacion (nombre,isRara,costoEnergia,danoInflige,valorEfecto);
        }
        else if(opcion==2)
        {
            hechizo=new Danio (nombre,isRara,costoEnergia,danoInflige,valorEfecto);
        }
        else if(opcion==3)
        {
            hechizo=new Hielo (nombre,isRara,costoEnergia,danoInflige,valorEfecto);
        }
        else if(opcion==4)
        {
            hechizo=new RobaCarta (nombre,isRara,costoEnergia,danoInflige,valorEfecto);
        }
        return hechizo;
    }

}
