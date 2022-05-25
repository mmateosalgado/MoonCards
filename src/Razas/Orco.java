package Razas;

import InterfacesCartas.I_AumentoAtaque;
import InterfacesCartas.I_SumaVida;
import model.Personaje;

public class Orco extends Personaje implements I_AumentoAtaque, I_SumaVida {

    public Orco(String nombre, boolean isRara, int costoEnergia, int danoInflige, int cantidadDeVida) {
        super(nombre, isRara, costoEnergia, danoInflige, cantidadDeVida);
    }

    @Override
    public void auementaAtaque(Personaje entrada, int danioAdicional) { entrada.setDanoInflige(danioAdicional);}

    @Override
    public void sumaVida(Personaje entrada, int sumaVida) {
        entrada.setCantidadDeVida(sumaVida);
    }
}
