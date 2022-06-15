package InterfacesGraficas.pruebas;

import model.Carta;

import javax.swing.*;
import java.awt.*;

public class CartaBoton extends JButton {

    private Carta carta;
    private CartaGrafico cartaGrafico;
    private boolean estado;

    public CartaBoton(Carta carta){
        this.carta = carta;
        cartaGrafico = new CartaGrafico(carta);
        estado = false;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public CartaGrafico getCartaGrafico() {
        return cartaGrafico;
    }

    public void setCartaGrafico(CartaGrafico cartaGrafico) {
        this.cartaGrafico = cartaGrafico;
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