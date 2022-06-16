package Razas;

import InterfacesCartas.I_AumentarAtaque;
import InterfacesCartas.I_SumarVida;
import model.Jugador;
import model.Personaje;

public class Orco extends Personaje implements I_AumentarAtaque {

    private int danioAdicional;///Si es especial roba Vida

    //Constructor--------------------------------------

    public Orco (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int danioAdicional) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida );
        this.danioAdicional = danioAdicional;
    }

    @Override
    public void aumentarAtaque(Jugador objetivo , int id) {

            for(int i=0;i<3;i++)
            {
                if(objetivo.getTablero ().getPersonajeEnPosicion (i)!=null)
                {
                    objetivo.getTablero ().getPersonajeEnPosicion (i).setDanoInflige ( objetivo.getTablero ().getPersonajeEnPosicion ( i ).getDanoInflige () + danioAdicional);
                }
            }

    }
    public String getTipoCarta() {
        return getClass().getName();
    }

}
