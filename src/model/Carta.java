package model;

import InterfacesCartas.I_ActivarEfecto;

import javax.swing.*;

public abstract class Carta implements I_ActivarEfecto {

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

    public ImageIcon getImage(){
        return imagen;
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



    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", isRara=" + isRara +
                ", alta=" + alta +
                ", costoEnergia=" + costoEnergia +
                ", danoInflige=" + danoInflige +
                '}';
    }
    public abstract String getTipoCarta();
}
