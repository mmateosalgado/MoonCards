package model;

import javax.swing.*;

public abstract class Hechizo extends Carta {

    ///-------------------------------------------------Contructor-------------------------------------------------
    public Hechizo(String nombre, boolean isRara, int costoEnergia, int danoInflige, ImageIcon imagem, String descrip) {
        super(nombre, isRara, costoEnergia, danoInflige, imagem, descrip);
    }

    ///-------------------------------------------------To String-------------------------------------------------
    @Override
    public String toString() {
        return "Hechizo{} " + super.toString();
    }
}
