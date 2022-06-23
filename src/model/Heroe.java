package model;

import InterfacesGraficas.pruebas.CartaGrafico;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Heroe extends DatoPrincipal implements Serializable {
    private String nombre;
    private int cantVida;
    static int cantidad;
    private ImageIcon image; // asociar cada imagen a cada heroe.
    private String descripcion; // va aparecer en cada heroe;

    public Heroe(String nombre, int cantVida, ImageIcon image, String descr) {
        this.nombre = nombre;
        this.cantVida = cantVida;
        this.descripcion = descr;
        this.image = image;
        actualizarValoresCarta();
    }

    public Heroe(String nombre, int cantVida, String descr) {
        this.nombre = nombre;
        this.cantVida = cantVida;
        this.descripcion = descr;
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

    public void setImage(ImageIcon image) {
        this.image = image;
        actualizarValoresCarta();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void actualizarValoresCarta(){
        Image imagePrincipal;
        imagePrincipal = image.getImage();
        BufferedImage imagenCarta = CartaGrafico.toBufferedImage(imagePrincipal);

        Image imageCostoEnergia;
        ImageIcon valorCostoEnergia = CartaGrafico.devolverValorEnArreglo(cantVida);
        imageCostoEnergia = valorCostoEnergia.getImage();
        BufferedImage imagenValorCostoEnergia = CartaGrafico.toBufferedImage(imageCostoEnergia);


        BufferedImage combinedImage = new BufferedImage(image.getIconWidth(),image.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = combinedImage.createGraphics();

        g.drawImage(imagenCarta,0,0,null);
        g.drawImage(imageCostoEnergia,-10,25,null);
        g.dispose();

        image = new ImageIcon(combinedImage);
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
