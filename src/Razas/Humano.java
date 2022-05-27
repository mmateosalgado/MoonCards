package Razas;

import InterfacesCartas.I_AumentarAtaque;
import InterfacesCartas.I_SumarVida;
import model.Personaje;

public class Humano extends Personaje implements I_AumentarAtaque, I_SumarVida {

    private int danioAdicional;
    private int sumarVida;

    public Humano (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int danioAdicional , int sumaVida) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida );
        this.danioAdicional = danioAdicional;
        this.sumarVida       = sumaVida;
    }

    @Override
    public void aumentarAtaque(Personaje objetivo, int danioAdicional) {
        objetivo.setDanoInflige(this.danioAdicional);
    }

    @Override
    public void sumarVida(Personaje objetivo, int sumaVida) {
        objetivo.setCantidadDeVida(this.sumarVida);
    }

}
