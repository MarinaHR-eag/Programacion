/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming;

/**
 *
 * @author EAG
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos una película
        Pelicula pelicula = new Pelicula(
                "La vida de Edu",
                2026,
                "Fantasía",
                8.8,
                148
        );

        // Creamos un documental
        Documental documental = new Documental(
                "Therians, una nueva especie",
                2022,
                "ciencia",
                9.2,
                90
        );

        // Creamos episodios para una nueva serie
        Episodio e1 = new Episodio("Episodio 1", 45, 8.5, 1);
        Episodio e2 = new Episodio("Episodio 2", 50, 9.0, 1);
        Episodio e3 = new Episodio("Episodio 3", 48, 8.8, 2);
        Episodio e4 = new Episodio("Episodio 4", 52, 9.1, 2);

        // Creamos una nueva serie
        Serie serie = new Serie("Sweet programming", 2021, 2, new Episodio[0]);

        // Añadir episodios a la serie
        serie.aniadirEpisodio(e1);
        serie.aniadirEpisodio(e2);
        serie.aniadirEpisodio(e3);
        serie.aniadirEpisodio(e4);

        // Creamos una plataforma
        Plataforma plataforma = new Plataforma("NetflixFalso");
        
        // Añadimos los contenidos a la plataforma
        plataforma.aniadirContenido(pelicula);
        plataforma.aniadirContenido(documental);
        plataforma.aniadirContenido(serie);

        // Mostramos el catálogo completo
        System.out.println(plataforma);

        // Mostramos la duración total del catálogo
        System.out.println("Duración total del catálogo: "
                + plataforma.calcularDuracionTotal() + " minutos");

        // Mostramos el número de contenidos creados
        System.out.println("Número total de contenidos creados: "
                + Contenido.getTotalContenidos());
    }
    
}
