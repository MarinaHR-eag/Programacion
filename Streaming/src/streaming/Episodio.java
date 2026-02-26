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
public class Episodio {
    // Atributos
    private String titulo;
    private int duracion;
    private double puntuacion;
    private int numeroTemporada;
    
    // Constructores
    public Episodio(){
        this.titulo = "";
        this.duracion = 0;
        this.puntuacion = 0;
        this.numeroTemporada = 0;
    }
    
    public Episodio(String titulo, int duracion, double puntuacion, int numeroTemporada){
        this.titulo = titulo;
        // Validamos que la duración no sea negativa
        if(duracion < 0){
            System.out.println("Duración no válida");
            this.duracion = 0;
        }
        else{
            this.duracion = duracion;
        }
        // Controlar que la puntuación esté dentro del rango 0 a 10
        if(puntuacion < 0){
            System.out.println("La puntuación no puede ser inferior a 0");
            this.puntuacion = 0;
        }
        else if(puntuacion > 10){
            System.out.println("La puntuación no puede ser superior a 10");
            this.puntuacion = 10;
        }
        else{
            this.puntuacion = puntuacion;
        }
        this.numeroTemporada = numeroTemporada;
    }
    
    public Episodio(Episodio e){
        this.titulo = e.titulo;
        this.duracion = e.duracion;
        this.puntuacion = e.puntuacion;
        this.numeroTemporada = e.numeroTemporada;
    }
    
    // Getters
    public String getTitulo(){
        return this.titulo;
    }
    
    public int getDuracion(){
        return this.duracion;
    }
    
    public double getPuntuacion(){
        return this.puntuacion;
    }
    
    public int getNumeroTemporada(){
        return this.numeroTemporada;
    }
    
    // Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setDuracion(int duracion){
        // Validamos que la duración no sea negativa
        if(duracion < 0){
            System.out.println("Duración no válida");
            this.duracion = 0;
        }
        else{
            this.duracion = duracion;
        }
    }
    
    public void setPuntuacion(double puntuacion){
        // Controlar que la puntuación esté dentro del rango 0 a 10
        if(puntuacion < 0){
            System.out.println("La puntuación no puede ser inferior a 0");
            this.puntuacion = 0;
        }
        else if(puntuacion > 10){
            System.out.println("La puntuación no puede ser superior a 10");
            this.puntuacion = 10;
        }
        else{
            this.puntuacion = puntuacion;
        }
    }
    
    public void setNumeroTemporada(int numeroTemporada){
        this.numeroTemporada = numeroTemporada;
    }
    
    // toString
    @Override
    public String toString(){
        String cadena = "Titulo del episodio: " + this.titulo + "\n" +
                "Duración: " + this.duracion + "\n" +
                "Puntuación de los usuarios: " + this.puntuacion + "\n" +
                "Temporada: " + this.numeroTemporada + "\n";
        return cadena;
    }
    
}
