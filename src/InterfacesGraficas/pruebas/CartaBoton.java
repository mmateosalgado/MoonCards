package InterfacesGraficas.pruebas;

import model.Carta;

import javax.swing.*;
import java.awt.*;

public class CartaBoton extends JButton {

    private Carta carta;
    private boolean estado;

    public CartaBoton(Carta carta){
        this.carta = carta;
        estado = false;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public void setEstado(boolean flag){
        estado = flag;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        super.setIcon(defaultIcon);
    }



}