package model;

import javax.swing.*;

public class Heroe extends DatoPrincipal{
    private String nombre;
    private int cantVida;
    static int cantidad;
    private ImageIcon image; // asociar cada imagen a cada heroe.
    private String descripcion; // va aparecer en cada carta;

    public Heroe(String nombre, int cantVida, ImageIcon image, String descr) {
        this.nombre = nombre;
        this.cantVida = cantVida;
        this.descripcion = descr;
        this.image = image;
    }

    public Heroe() {
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVida() {
        return cantVida;
    }

    public void setCantVida(int cantVida) {
        this.cantVida = cantVida;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        Heroe.cantidad = cantidad;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public boolean equals(Object obj){
        if((obj!=null)&& (obj instanceof Heroe))
        {
            if(nombre.equals(((Heroe)obj).getNombre())) // se utiliza el metodo equals de los Strings para comprobar si ambos strings son iguales.
            {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }

    }

    @Override
    public String toString() {
        return nombre;
    }
}
