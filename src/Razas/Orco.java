package Razas;

import InterfacesCartas.I_AumentarAtaque;
import InterfacesCartas.I_SumarVida;
import model.Personaje;

public class Orco extends Personaje implements I_AumentarAtaque {

    private int danioAdicional;///Si es especial roba Vida


    public Orco (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int danioAdicional) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida );
        this.danioAdicional = danioAdicional;
    }

    @Override
    public void aumentarAtaque(Personaje objetivo, int danioAdicional) {
        objetivo.setDanoInflige(this.danioAdicional);
    }



}
