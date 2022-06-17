package InterfacesGraficas.pruebas;

import model.Carta;
import model.Heroe;

import javax.swing.*;

public class HeroeBoton extends JButton {
    private Heroe heroe;

    public HeroeBoton(Heroe heroe){
        this.heroe = heroe;
    }

    public Heroe getHeroe() {
        return heroe;
    }

    public void setHeroe(Heroe heroe) {
        this.heroe = heroe;
    }

    @Override
    public void setIcon(Icon defaultIcon) {
        super.setIcon(defaultIcon);
    }

}


