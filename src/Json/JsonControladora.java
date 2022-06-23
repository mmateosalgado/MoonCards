package Json;

import Razas.Golem;
import Razas.Humano;
import Razas.Necrofago;
import Razas.Orco;
import model.Carta;
import model.Hechizo;
import model.Heroe;
import model.Personaje;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tiposHechizos.Curacion;
import tiposHechizos.Danio;
import tiposHechizos.Hielo;
import tiposHechizos.RobaCarta;

import java.util.ArrayList;

public class JsonControladora {

    public static void grabarEnJsonCartas(ArrayList<Carta> listaCartas)
    {
        JSONArray jsonMoonCards = new JSONArray ();
        try {
        for (Carta carta:listaCartas) {
            JSONObject jsonCarta = new JSONObject ();

            jsonCarta.put ( "Nombre" , carta.getNombre () );
            jsonCarta.put ( "id" , carta.getId () );
            jsonCarta.put ( "TipoCarta" , carta.getTipoCarta () );
            jsonCarta.put ( "CostoEnergia" , carta.getCostoEnergia () );
            jsonCarta.put ( "DanioInglige" , carta.getDanoInflige () );
            jsonCarta.put ( "Imagen" , carta.getImagen () );
            jsonCarta.put ( "isRara" , carta.isRara () );
            jsonCarta.put ( "isAlta" , carta.isAlta () );
            jsonCarta.put ( "Descripcion" , carta.getDescrip () );

            if (carta instanceof Personaje )
            {
                jsonCarta.put ( "CantidadDeVida" , ((Personaje) carta).getCantidadDeVida ());
                jsonCarta.put ( "Estado" , ((Personaje) carta).isEstado ());
                jsonCarta.put ( "TurnosCongelado" , ((Personaje) carta).getTurnosCongelado ());
                jsonCarta.put ( "RangoGlobal" , ((Personaje) carta).isGlobal ());
                if ( carta instanceof Orco )
                {
                 jsonCarta.put ("DanioAdicional",((Orco) carta).getDanioAdicional ());
                }
                if ( carta instanceof Humano )
                {
                    jsonCarta.put ("DanioAdicional",((Humano) carta).getDanioAdicional ());
                    jsonCarta.put ("SumarVida",((Humano) carta).getSumarVida ());
                }
                if ( carta instanceof Golem )
                {
                    jsonCarta.put ("TurnosCongela",((Golem) carta).getCantTurnosCongela());
                    jsonCarta.put ("SumarVida",((Golem) carta).getSumarVida ());
                }
                if ( carta instanceof Necrofago )
                {
                    jsonCarta.put ("CantCartasRobadas",((Necrofago) carta).getCantCartasRobadas ());
                    jsonCarta.put ("CantidadDanioInflige",((Necrofago) carta).getcantDañoInflige ());
                }
            }
            else if(carta instanceof Hechizo )
            {
                if(carta instanceof Curacion)
                {
                    jsonCarta.put ("SumarVida",((Curacion) carta).getSumarVida ());
                }
                if(carta instanceof Danio)
                {
                    jsonCarta.put ("CantDanioInflige",((Danio) carta).getCantDanioInflige ());
                }
                if(carta instanceof Hielo)
                {
                    jsonCarta.put ("CantTurnosCongela",((Hielo) carta).getCantTurnosCongela ());
                }
                if(carta instanceof RobaCarta)
                {
                    jsonCarta.put ("CantCartasRobadas",((RobaCarta) carta).getCantCartasRobadas ());
                }
            }
            jsonMoonCards.put (jsonCarta);
        }
        }
        catch (JSONException e) {
                e.printStackTrace ();
            }
        JsonUtiles.grabarCartas (jsonMoonCards);
    }

    public static void grabarEnJsonHeroes(ArrayList<Heroe> listaHeroes)
    {
        JSONArray jsonMoonHeroes = new JSONArray ();
        try{
            for (Heroe heroe:listaHeroes) {
                JSONObject jsonHeroe = new JSONObject ();
                jsonHeroe.put ("CantVida",heroe.getCantVida ());
                jsonHeroe.put ("Nombre",heroe.getNombre ());
                jsonHeroe.put ("Image",heroe.getImage ());
                jsonHeroe.put ("Descripcion",heroe.getDescripcion ());
                jsonMoonHeroes.put (jsonHeroe);
            }
            }
        catch (JSONException e)
        {
            e.printStackTrace ();
        }


        JsonUtiles.grabarHeroes (jsonMoonHeroes);
    }

}
