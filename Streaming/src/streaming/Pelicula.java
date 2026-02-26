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
public class Pelicula extends Contenido {
    // Atributos
    private String genero;
    private double puntuacionMedia;
    private int duracion;
    
    // Constructores
    public Pelicula(){
        super();
        this.genero = "";
        this.puntuacionMedia = 0;
        this.duracion = 0;
    }
    
    public Pelicula(
            String titulo, 
            int anio, 
            String genero, 
            double puntuacion, 
            int duracion
    ){
        super(titulo, anio);
        this.genero = genero;
        // Controlar que la puntuación esté dentro del rango 0 a 10
        if(puntuacion < 0){
            System.out.println("La puntuación no puede ser inferior a 0");
            this.puntuacionMedia = 0;
        }
        else if(puntuacion > 10){
            System.out.println("La puntuación no puede ser superior a 10");
            this.puntuacionMedia = 10;
        }
        else{
            this.puntuacionMedia = puntuacion;
        }
        
        if(duracion < 0){
            System.out.println("Duración no válida");
            this.duracion = 0;
        }
        else{
            this.duracion = duracion;
        }
    }
    
    public Pelicula(Pelicula peliculaACopiar){
        super(peliculaACopiar);
        this.genero = peliculaACopiar.genero;
        this.puntuacionMedia = peliculaACopiar.puntuacionMedia;
        this.duracion = peliculaACopiar.duracion;
    }
    
    // Getters
    public String getGenero(){
        return this.genero;
    }
    
    public double getPuntuacionMedia(){
        return this.puntuacionMedia;
    }
    
    @Override
    public int getDuracion(){
        return this.duracion;
    }
    
    // Setters
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public void setPuntuacionMedia(double puntuacion){
        if(puntuacion < 0){
            System.out.println("La puntuación no puede ser inferior a 0");
            this.puntuacionMedia = 0;
        }
        else if(puntuacion > 10){
            System.out.println("La puntuación no puede ser superior a 10");
            this.puntuacionMedia = 10;
        }
        else{
            this.puntuacionMedia = puntuacion;
        }
    }
    
    public void setDuracion(int duracion){
        if(duracion < 0){
            System.out.println("Duración no válida");
            this.duracion = 0;
        }
        else{
            this.duracion = duracion;
        }
    }
    
    // Metodos personalizados
    @Override
    public double calcularValoracion(){
        double valoracion = this.puntuacionMedia;
        if(this.getAnioEstreno() >= 2020){
            valoracion++;
            if(valoracion > 10){
                valoracion = 10;
            }
        }
        return valoracion;
    }
    
    // toString
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "Genero: " + this.genero + "\n" +
                "Puntuacion media: " + this.puntuacionMedia + "\n" +
                "Duracion: " + this.duracion + "\n";
        
        return cadena;
    }
    
}
