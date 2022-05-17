package model;

public abstract class Carta {

    private static int totalCartas=0;
    private int id;
    private String nombre;
    private boolean isRara;
    private boolean alta;
    int costoEnergia;
    int costoDanoInflige;

    //CONSTRUCTOR
    public Carta(String nombre, boolean isRara, int costoEnergia, int costoDanoInflige) {
        this.id=totalCartas;
        totalCartas++;
        this.nombre = nombre;
        this.isRara = isRara;
        this.alta=false;
        this.costoEnergia = costoEnergia;
        this.costoDanoInflige = costoDanoInflige;
    }

    //METODOS

    //GETTERS

    public static int getTotalCartas() {
        return totalCartas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isRara() {
        return isRara;
    }

    public boolean isAlta() {
        return alta;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public int getCostoDanoInflige() {
        return costoDanoInflige;
    }

    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRara(boolean rara) {
        isRara = rara;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public void setCostoDanoInflige(int costoDanoInflige) {
        this.costoDanoInflige = costoDanoInflige;
    }
}
