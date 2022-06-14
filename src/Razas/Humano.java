package Razas;

import InterfacesCartas.I_AumentarAtaque;
import InterfacesCartas.I_SumarVida;
import model.Jugador;
import model.Personaje;

public class Humano extends Personaje implements I_AumentarAtaque, I_SumarVida {

    private int danioAdicional;
    private int sumarVida;

    //Constructor--------------------------------------

    public Humano (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int danioAdicional , int sumaVida, boolean esGlobal) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida, esGlobal );
        this.danioAdicional = danioAdicional;
        this.sumarVida = sumaVida;
    }

    @Override
    public void aumentarAtaque(Jugador objetivo , int id) {
        if(isRara ()) {
            for (int i = 0; i < 3; i++) {
                if(objetivo.getTablero().getPersonajeEnPosicion(i) != null)
                {
                    objetivo.getTablero().getPersonajeEnPosicion(i).setDanoInflige(objetivo.getTablero().getPersonajeEnPosicion(i).getDanoInflige() + danioAdicional);
                }
            }
        }else{
            objetivo.getTablero().getPersonajeEnPosicion(id - 1).setDanoInflige(objetivo.getTablero().getPersonajeEnPosicion(id - 1).getDanoInflige() + danioAdicional);

        }
        }

    @Override
    public void sumarVida(Jugador caster, int id) {
        if(isRara ())
        {
        for (int i = 0; i < 3; i++) {
            if(caster.getTablero().getPersonajeEnPosicion(i) != null)
            {
                caster.getTablero().getPersonajeEnPosicion(i).setCantidadDeVida(caster.getTablero().getPersonajeEnPosicion(i).getCantidadDeVida() + sumarVida);
            }
        }
            caster.getTablero().getPosHeroe().setCantVida(caster.getTablero().getPosHeroe().getCantVida() + sumarVida);
        }
    }

    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        if(isRara())
        {
            aumentarAtaque(jugadorEjecutor,0);
            sumarVida(jugadorEjecutor,0);
        }
        else
        {
            aumentarAtaque(jugadorEjecutor,id);
        }
    }
}
