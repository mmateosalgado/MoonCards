package Razas;

import InterfacesCartas.I_Congelar;
import InterfacesCartas.I_SumarVida;
import model.Jugador;
import model.Personaje;

public class Golem extends Personaje implements I_Congelar, I_SumarVida {

    private int sumarVida;
    private int cantTurnosCongela;

    //Constructor--------------------------------------

    public Golem (String nombre , boolean isRara , int costoEnergia , int danoInflige , int cantidadDeVida , int sumarVida , int cantTurnosCongela, boolean esGlobal) {
        super ( nombre , isRara , costoEnergia , danoInflige , cantidadDeVida, esGlobal );
        this.sumarVida         = sumarVida;
        this.cantTurnosCongela = cantTurnosCongela;
    }

    @Override
    public void congelar (Jugador objetivo , int id)  {
        ///Id - 1  porque es una posicion menos en el arreglo
        objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).setTurnosCongelado (objetivo.getTablero ().getPersonajeEnPosicion ( id-1 ).getTurnosCongelado () + cantTurnosCongela);
    }

    @Override
    public void sumarVida(Jugador caster, int id) {
        ///Si es rara Cura a todos
        if (isRara()) {
            for (int i = 0; i < 3; i++) {
                if(caster.getTablero().getPersonajeEnPosicion(i) != null)
                {
                    caster.getTablero().getPersonajeEnPosicion(i).setCantidadDeVida(caster.getTablero().getPersonajeEnPosicion(i).getCantidadDeVida() + sumarVida);
                }
            }
            caster.getTablero().getPosHeroe().setCantVida(caster.getTablero().getPosHeroe().getCantVida() + sumarVida);
        } else {

            if(id == 0)
            {
                caster.getTablero().getPosHeroe().setCantVida(caster.getTablero().getPosHeroe().getCantVida() + sumarVida);

            }
            else // id-1 es la posicion en el arreglo (por ej si un personaje tiene id =2, su pos en el arreglo es 1)
            {
                caster.getTablero().getPersonajeEnPosicion(id-1).setCantidadDeVida(caster.getTablero().getPersonajeEnPosicion(id-1).getCantidadDeVida() + sumarVida);
            }
        }
    }

    @Override
    public void activarEfecto(Jugador jugadorEjecutor, Jugador jugadorRival, int id) {

        if(isRara())
        {
            sumarVida(jugadorEjecutor,0);
            congelar(jugadorRival,id);
        }
        else{
            sumarVida(jugadorEjecutor,id);
        }

    }

    @Override
    public String getTipoCarta() {
        return getClass().getSimpleName();
    }
}
