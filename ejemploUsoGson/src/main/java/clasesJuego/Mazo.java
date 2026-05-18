package clasesJuego;
import java.util.ArrayList;

public class Mazo {
    private ArrayList<CartaAtaque> ataque;
    private ArrayList<CartaDefensa> defensa;
    private ArrayList<CartaCuracion> curacion;

    public Mazo() {
        ataque = new ArrayList<>();
        defensa = new ArrayList<>();
        curacion = new ArrayList<>();
    }

    public ArrayList<CartaAtaque> getAtaque(){
        return ataque;
    }

    public ArrayList<CartaDefensa> getDefensa(){
        return defensa;
    }

    public ArrayList<CartaCuracion> getCuracion(){
        return curacion;
    }
}
