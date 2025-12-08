/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciotipoexamenbuscadorpeliculas;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class EjercicioTipoExamenBuscadorPeliculas {

    public static boolean contienePelicula(String[] peliculas, String peliculaBuscada){
        boolean peliculaEncontrada = false;
        for(int i = 0; i < peliculas.length; i++){
            if(peliculas[i].equals(peliculaBuscada)){
                peliculaEncontrada = true;
                return peliculaEncontrada;
            }
        }
        return peliculaEncontrada;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Pedir al usuario los 10 títulos de películas
        String[] peliculas = new String[10];
        for(int i = 0; i < 10; i++){
            String tituloPelicula;
            do{
                System.out.println("Introduce el título " + (i + 1));
                tituloPelicula = sc.nextLine();
            }while(tituloPelicula.equals(""));
            peliculas[i] = tituloPelicula;
        }
        
        // Pedir al usuario un título a buscar
        String tituloABuscar;
        System.out.println("Introduce la película que quieres buscar");
        tituloABuscar = sc.nextLine();
        
        boolean peliculaEncontrada = contienePelicula(peliculas, tituloABuscar);
        if(peliculaEncontrada){
            System.out.println("La película " + tituloABuscar + "sí está en el videoclub");
        }else{
            System.out.println("La película " + tituloABuscar + "no está en el videoclub");
        }
    }
    
}
