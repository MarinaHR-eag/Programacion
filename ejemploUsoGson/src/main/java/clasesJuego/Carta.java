package clasesJuego;

public abstract class Carta {
    private String nombre, rareza;

    public Carta() {
        this.nombre = "";
        this.rareza = "";
    }

    public Carta(String nombre, String rareza) {
        this.nombre = nombre;
        this.rareza = rareza;
    }

    public Carta(Carta c){
        this.nombre = c.nombre;
        this.rareza = c.rareza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public abstract void usar();

    @Override
    public String toString() {
        return "Carta{\n" +
                "nombre=" + nombre +
                "\n, rareza=" + rareza + "\n}";
    }

}
