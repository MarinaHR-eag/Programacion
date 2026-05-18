package clasesJuego;

public class CartaCuracion extends Carta{
    private int vida;

    public CartaCuracion(){
        super();
        this.vida = 0;
    }

    public CartaCuracion(String nombre, String rareza, int vida) {
        super(nombre, rareza);
        this.vida = vida;
    }

    public CartaCuracion(CartaCuracion c){
        super(c);
        this.vida = c.vida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public void usar(){
        System.out.println(
                this.getNombre() +
                        " cura " +
                        this.getVida() +
                        " puntos de vida"
        );
    }

    @Override
    public String toString() {
        String cadena = super.toString();
        cadena += "\nVida: " + this.vida;

        return cadena;
    }
}
