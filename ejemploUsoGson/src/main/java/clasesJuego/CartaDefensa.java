package clasesJuego;

public class CartaDefensa extends Carta{
    private int escudo;
    private String tipoDefensa;

    public CartaDefensa(){
        super();
        this.escudo = 0;
        this.tipoDefensa = "";
    }

    public CartaDefensa(String nombre, String rareza, int escudo, String tipoDefensa) {
        super(nombre, rareza);
        this.escudo = escudo;
        this.tipoDefensa = tipoDefensa;
    }

    public CartaDefensa(CartaDefensa c){
        super(c);
        this.escudo = c.escudo;
        this.tipoDefensa = c.tipoDefensa;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public String getTipoDefensa() { return this.tipoDefensa; }

    public void setTipoDefensa(String tipoDefensa) { this.tipoDefensa = tipoDefensa; }

    @Override
    public void usar(){
        System.out.println(
                this.getNombre() +
                        " defiende " +
                        this.getEscudo() +
                        " puntos de defensa" +
                        " de tipo " +
                        this.getTipoDefensa()
        );
    }

    @Override
    public String toString() {
        String cadena = super.toString();
        cadena += "\nEscudo: " + this.escudo
            + "\nTipo defensa: " + this.tipoDefensa;

        return cadena;
    }
}
