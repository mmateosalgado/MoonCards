package model;

public class Heroe {
    private String nombre;
    private int cantVida;
    static int cantidad;

    public Heroe(String nombre, int cantVida) {
        this.nombre = nombre;
        this.cantVida = cantVida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVida() {
        return cantVida;
    }

    public void setCantVida(int cantVida) {
        this.cantVida = cantVida;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        Heroe.cantidad = cantidad;
    }
}
