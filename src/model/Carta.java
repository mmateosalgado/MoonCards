package model;

import InterfacesCartas.I_ActivarEfecto;
import InterfacesGraficas.pruebas.CartaGrafico;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Carta extends DatoPrincipal implements I_ActivarEfecto, Serializable {

    private static int totalCartas=0;
    private int id;
    private String nombre;
    private boolean isRara;
    private boolean alta;///Para saber si atacó o no
    private int costoEnergia;
    private int danoInflige;
    private ImageIcon imagen;
    private String descrip;

    //CONSTRUCTOR
    public Carta(String nombre, boolean isRara, int costoEnergia, int danoInflige) {
        this.id=totalCartas + 1;
        totalCartas++;
        this.nombre = nombre;
        this.isRara = isRara;
        this.alta = false; // aca no convendria crearla directamente dandola de alta? asi no tenemos que andar dando a todas de alta dsp xd
        this.costoEnergia = costoEnergia;
        this.danoInflige = danoInflige;
        //actualizarValoresCarta();
    }

    public Carta(String nombre, boolean isRara, int costoEnergia, int danoInflige,ImageIcon imagem, String descrip) {
        this.id=totalCartas + 1;
        totalCartas++;
        this.nombre = nombre;
        this.isRara = isRara;
        this.alta = false; // aca no convendria crearla directamente dandola de alta? asi no tenemos que andar dando a todas de alta dsp xd
        this.costoEnergia = costoEnergia;
        this.danoInflige = danoInflige;
        this.imagen = imagem;
        this.descrip = descrip;
        actualizarValoresCarta();
    }

    //METODOS

    //GETTERS

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public static int getTotalCartas() {
        return totalCartas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public boolean isRara() {
        return isRara;
    }

    public boolean isAlta() {
        return alta;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public int getDanoInflige() {
        return danoInflige;
    }

    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRara(boolean rara) {
        isRara = rara;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public void setDanoInflige(int danoInflige) {
        this.danoInflige += danoInflige;
    }

    public void actualizarValoresCarta(){
        Image imagePrincipal;
        imagePrincipal = imagen.getImage();
        BufferedImage imagenCarta = CartaGrafico.toBufferedImage(imagePrincipal);

        Image imageCostoEnergia;
        ImageIcon valorCostoEnergia = CartaGrafico.devolverValorEnArreglo(costoEnergia);
        imageCostoEnergia = valorCostoEnergia.getImage();
        BufferedImage imagenValorCostoEnergia = CartaGrafico.toBufferedImage(imageCostoEnergia);

        Image imageCostoAtaque;
        ImageIcon valorAtaque = CartaGrafico.devolverValorEnArreglo(danoInflige);
        imageCostoAtaque = valorAtaque.getImage();
        BufferedImage imagenValorAtaque = CartaGrafico.toBufferedImage(imageCostoAtaque);

        BufferedImage combinedImage = new BufferedImage(imagen.getIconWidth(),imagen.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = combinedImage.createGraphics();

        g.drawImage(imagenCarta,0,0,null);
        g.drawImage(imageCostoEnergia,0,25,null);
        g.drawImage(imagenValorAtaque,5,255,null);
        g.dispose();

        imagen = new ImageIcon(combinedImage);
    }


    @Override
    public String toString() {
        return "\nCarta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", isRara=" + isRara +
                ", alta=" + alta +
                ", costoEnergia=" + costoEnergia +
                ", danoInflige=" + danoInflige +
                ", imagen=" + imagen +
                ", descrip='" + descrip + '\'' +
                "} " + super.toString();
    }

    public abstract String getTipoCarta();

    public ImageIcon getImage() {
        return imagen;
    }
}
