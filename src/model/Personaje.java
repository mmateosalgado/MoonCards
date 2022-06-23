package model;

import InterfacesCartas.I_ActivarEfecto;
import InterfacesGraficas.pruebas.CartaGrafico;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Personaje extends Carta {

    private int cantidadDeVida;
    private boolean estado; // para saber si ya ataco en este turno o no, true = ya ataco / false = no ataco aun
    private int turnosCongelado;//0 --> no esta congelado
    private boolean rangoGlobal; //true -> global ... false -> individual

    //Constructor--------------------------------------

    public Personaje(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida, boolean rangoGlobal) {
        super(nombre, isRara, costoEnergia, danoInflige);
        this.cantidadDeVida = cantidadDeVida;
        this.estado = false;
        this.turnosCongelado = 1; //Cuando se las invoca, empiezan congelados. No pueden atacar hasta el siguiente turno
        this.rangoGlobal = rangoGlobal;
    }
    public Personaje(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida, boolean rangoGlobal,ImageIcon imagen, String descripcion) {
        super(nombre, isRara, costoEnergia, danoInflige,imagen,descripcion);
        this.cantidadDeVida = cantidadDeVida;
        this.estado = false;
        this.turnosCongelado = 1; //Cuando se las invoca, empiezan congelados. No pueden atacar hasta el siguiente turno
        this.rangoGlobal = rangoGlobal;

        actualizarValoresCarta();
    }



    //Metodos


    //Getters--------------------

    public int getCantidadDeVida() {
        return cantidadDeVida;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getTurnosCongelado() {
        return turnosCongelado;
    }

    public boolean isGlobal() {
        return rangoGlobal;
    }

    public void setRangoGlobal(boolean rangoGlobal) {
        this.rangoGlobal = rangoGlobal;
    }

    @Override
    public ImageIcon getImagen(){
       return super.getImagen();
    }
    //Setters---------------------

    public void setTurnosCongelado(int turnosCongelado) {
        if (turnosCongelado < 0) {
            turnosCongelado = 0;
        } else {
            this.turnosCongelado = turnosCongelado;
        }

    }

    public void setEstado() {
        if (estado) {
            this.estado = false;
        } else {
            this.estado = true;
        }

    }



    public void setCantidadDeVida(int cantidadDeVida) {
        this.cantidadDeVida = cantidadDeVida;
    }

    @Override
    public void actualizarValoresCarta() {
        Image imagePrincipal;
        imagePrincipal = this.getImagen().getImage();
        BufferedImage imagenCarta = CartaGrafico.toBufferedImage(imagePrincipal);

        Image imageCostoEnergia;
        ImageIcon valorCostoEnergia = CartaGrafico.devolverValorEnArreglo(super.getCostoEnergia());
        imageCostoEnergia = valorCostoEnergia.getImage();
        BufferedImage imagenValorCostoEnergia = CartaGrafico.toBufferedImage(imageCostoEnergia);

        Image imageCostoAtaque;
        ImageIcon valorAtaque = CartaGrafico.devolverValorEnArreglo(super.getDanoInflige());
        imageCostoAtaque = valorAtaque.getImage();
        BufferedImage imagenValorAtaque = CartaGrafico.toBufferedImage(imageCostoAtaque);


        Image imageCantVida;
        ImageIcon valorVida = CartaGrafico.devolverValorEnArreglo(cantidadDeVida);
        imageCantVida = valorVida.getImage();
        BufferedImage imagenValorCantVida = CartaGrafico.toBufferedImage(imageCantVida);

        BufferedImage combinedImage = new BufferedImage(super.getImagen().getIconWidth(),super.getImagen().getIconHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = combinedImage.createGraphics();

        g.drawImage(imagePrincipal,0,0,null);
        g.drawImage(imageCostoEnergia,0,25,null);
        g.drawImage(imagenValorAtaque,5,255,null);
        g.drawImage(imagenValorCantVida,160,255,null);

        g.dispose();

        super.setImagen(new ImageIcon(combinedImage));

    }

    @Override
    public String toString() {
        return "Personaje{" +
                "cantidadDeVida=" + cantidadDeVida +
                ", estado=" + estado +
                ", turnosCongelado=" + turnosCongelado +
                ", rangoGlobal=" + rangoGlobal +
                "} " + super.toString();
    }
}


