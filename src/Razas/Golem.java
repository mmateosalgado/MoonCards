package Razas;

import InterfacesCartas.I_Congelar;
import InterfacesCartas.I_SumarVida;
import model.Personaje;

public class Golem extends Personaje implements I_Congelar, I_SumarVida {

    private int sumarVida;

    public Golem (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int sumarVida) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida );
        this.sumarVida = sumarVida;
    }

    @Override
    public void congelar (Personaje objetivo , int cantTurnos) {
        objetivo.setTurnosCongelado (2);
    }

    @Override
    public void sumarVida(Personaje objetivo, int sumaVida) {
        objetivo.setCantidadDeVida(this.sumarVida);
    }

}
