package model;

import InterfacesCartas.I_ActivarEfecto;
import InterfacesGraficas.pruebas.CartaGrafico;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public abstract class Personaje extends Carta {

    private int cantidadDeVida;
    private boolean estado; // para saber si ya ataco en este turno o no, true = ya ataco / false = no ataco aun
    private int turnosCongelado;//0 --> no esta congelado
    private boolean rangoGlobal; //true -> global ... false -> individual

    //--------------------------------------Constructor para guardar en el Archivo--------------------------------------
    public Personaje(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida, boolean rangoGlobal,ImageIcon imagen, String descripcion) {
        super(nombre, isRara, costoEnergia, danoInflige,imagen,descripcion);
        this.cantidadDeVida = cantidadDeVida;
        this.estado = false;
        this.turnosCongelado = 1; //Cuando se las invoca, empiezan congelados. No pueden atacar hasta el siguiente turno
        this.rangoGlobal = rangoGlobal;

       // actualizarValoresCarta();
    }


    ///------------------------------------------------------GETTERS---------------------------------------------------------

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

    @Override
    public ImageIcon getImagen(){
        return super.getImagen();
    }
    ///------------------------------------------------------SETTERS---------------------------------------------------------
    public void setRangoGlobal(boolean rangoGlobal) {
        this.rangoGlobal = rangoGlobal;
    }

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

    ///------------------------------------------------------Actualiza Imagen en el Tablero Gráfico---------------------------------------------------------
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

        if(cantidadDeVida>0) {
            Image imageCantVida;
            ImageIcon valorVida = CartaGrafico.devolverValorEnArreglo(cantidadDeVida);
            imageCantVida = valorVida.getImage();
            BufferedImage imagenValorCantVida = CartaGrafico.toBufferedImage(imageCantVida);

            BufferedImage combinedImage = new BufferedImage(super.getImagen().getIconWidth(), super.getImagen().getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = combinedImage.createGraphics();

            g.drawImage(imagenCarta, 0, 0, null);
            g.drawImage(imagenValorCostoEnergia, 0, 15, null);
            g.drawImage(imagenValorAtaque, 5, 255, null);
            g.drawImage(imagenValorCantVida, 160, 255, null);

            g.dispose();

            super.setImagen(new ImageIcon(combinedImage));
        }

    }

    ///------------------------------------------------------To String---------------------------------------------------------
    @Override
    public String toString() {
        return "Personaje{" +
                "cantidadDeVida=" + cantidadDeVida +
                ", estado=" + estado +
                ", turnosCongelado=" + turnosCongelado +
                ", rangoGlobal=" + rangoGlobal +
                "} " + super.toString();
    }

    @Override
    public boolean equals (Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof Personaje) ) return false;
        if ( !super.equals ( o ) ) return false;
        Personaje personaje = (Personaje) o;
        return getCantidadDeVida () == personaje.getCantidadDeVida () && isEstado () == personaje.isEstado () && getTurnosCongelado () == personaje.getTurnosCongelado () && rangoGlobal == personaje.rangoGlobal;
    }

    @Override
    public int hashCode () {
        return Objects.hash ( getCantidadDeVida () , isEstado () , getTurnosCongelado () , rangoGlobal );
    }
}


