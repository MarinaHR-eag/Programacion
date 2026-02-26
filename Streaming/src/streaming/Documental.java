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
public class Documental extends Contenido {
    // Atributos
    private String tematica;
    private double puntuacionMedia;
    private int duracion;
    
    // Constructores
    public Documental(){
        super();
        this.tematica = "";
        this.puntuacionMedia = 0;
        this.duracion = 0;
    }
    
    public Documental(
            String titulo, 
            int anio, 
            String tematica, 
            double puntuacion, 
            int duracion
    ){
        super(titulo, anio);
        this.tematica = tematica;
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
    
    public Documental(Documental documentalACopiar){
        super(documentalACopiar);
        this.tematica = documentalACopiar.tematica;
        this.puntuacionMedia = documentalACopiar.puntuacionMedia;
        this.duracion = documentalACopiar.duracion;
    }
    
    // Getters
    public String getTematica(){
        return this.tematica;
    }
    
    public double getPuntuacionMedia(){
        return this.puntuacionMedia;
    }
   
    @Override
    public int getDuracion(){
        return this.duracion;
    }
    
    // Setters
    public void setTematica(String tematica){
        this.tematica = tematica;
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
        if(this.tematica.equals("ciencia") || this.tematica.equals("naturaleza")){
            valoracion += 0.5;
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
        cadena += "Temática: " + this.tematica + "\n" +
                "Puntuacion media: " + this.puntuacionMedia + "\n" +
                "Duracion: " + this.duracion + "\n";
        
        return cadena;
    }
    
}
