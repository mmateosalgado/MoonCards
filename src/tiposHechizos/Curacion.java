package tiposHechizos;

import InterfacesCartas.I_SumarVida;
import model.Hechizo;
import model.Personaje;

public class Curacion extends Hechizo implements I_SumarVida {
    private int sumarVida;

    //CONSTRUCTOR

    public Curacion(String nombre, boolean isRara, int costoEnergia, int danoInflige, int sumaVida) {
        super(nombre, isRara, costoEnergia, danoInflige);
        this.sumarVida = sumaVida;
    }

    @Override
    public void sumarVida(Personaje objetivo, int sumarVida) {
        if (isRara()) {
            objetivo.setCantidadDeVida(objetivo.getCantidadDeVida() + sumarVida);
        } else {

        }
    }
}
