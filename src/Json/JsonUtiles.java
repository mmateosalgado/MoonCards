package Json;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;

public class JsonUtiles {


    public static void grabarHeroes (JSONArray array) {
        try {
            FileWriter file = new FileWriter ( "archivoHeroes.json" );
            file.write ( array.toString () );
            file.flush ();
            file.close ();

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void grabarCartas (JSONArray array) {
        try {
            FileWriter file = new FileWriter ( "archivoCartas.json" );
            file.write ( array.toString () );
            file.flush ();
            file.close ();

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static String leer () {
        String contenido = "";
        try {
            contenido = new String ( Files.readAllBytes ( Paths.get ( "archivo.json" ) ) );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return contenido;
    }
}
