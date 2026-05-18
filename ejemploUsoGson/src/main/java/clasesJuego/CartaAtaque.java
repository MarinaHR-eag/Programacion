package clasesJuego;

public class CartaAtaque extends Carta{
    private int danio;
    private String tipoAtaque;

    public CartaAtaque(){
        super();
        this.danio = 0;
        this.tipoAtaque = "";
    }

    public CartaAtaque(String nombre, String rareza, int danio, String tipoAtaque) {
        super(nombre, rareza);
        this.danio = danio;
        this.tipoAtaque = tipoAtaque;
    }

    public CartaAtaque(CartaAtaque c){
        super(c);
        this.danio = c.danio;
        this.tipoAtaque = c.tipoAtaque;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public String getTipoAtaque() {
        return tipoAtaque;
    }

    public void setTipoAtaque(String tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

    @Override
    public void usar(){
        System.out.println(
                this.getNombre() +
                " hace " +
                this.getDanio() +
                " de daño"
        );
    }

    @Override
    public String toString() {
        String cadena = super.toString();
        cadena += "\nDaño: " + this.danio + "\n"
            + "Tipo Ataque: " + this.tipoAtaque;

        return cadena;
    }
}
