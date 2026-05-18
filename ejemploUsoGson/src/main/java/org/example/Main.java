package org.example;

import clasesJuego.*;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader("./archivos/cartas.json");
            Mazo mazo = gson.fromJson(fr, Mazo.class);

            fr.close();

            // Creamos el mazo general
            ArrayList<Carta> mazoGeneral = new ArrayList<>();

            mazoGeneral.addAll(mazo.getAtaque());
            mazoGeneral.addAll(mazo.getDefensa());
            mazoGeneral.addAll(mazo.getCuracion());

            // Mezclamos el mazo
            Collections.shuffle(mazoGeneral);

            // Creamos la mano del jugador
            ArrayList<Carta> mano = new ArrayList<>();

            // Robamos 5 cartas
            for(int i = 0; i < 5; i++){
                Carta robada = mazoGeneral.remove(0);
                mano.add(robada);
            }

            // Mostrar mano
            System.out.println("Mano dle jugador: ");

            for(Carta carta : mano){
                System.out.println(carta);
            }

            // Usamos las cartas
            System.out.println();
            System.out.println("Usamos las cartas: ");

            for(Carta carta : mano){
                carta.usar();
            }

            // Cartas restantes en el mazo
            System.out.println();
            System.out.println("Cartas restantes en el mazo: " + mazoGeneral.size());
        } catch(FileNotFoundException e){
            System.out.println("No se encontro el archivo de cartas.json");
        } catch (IOException e) {
            System.out.println("Error en el archivo de cartas.json");
        }
    }
}