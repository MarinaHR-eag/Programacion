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
public abstract class Contenido {
    // Atributos
    private String titulo;
    private int anioEstreno;
    private static int totalContenidos = 0;
    
    // Constructores
    public Contenido(){
        this.titulo = "";
        this.anioEstreno = 0;
        totalContenidos++;
    }
    
    public Contenido(String titulo, int anio){
        this.titulo = titulo;
        this.anioEstreno = anio;
        totalContenidos++;
    }
    
    public Contenido(Contenido c){
        this.titulo = c.titulo;
        this.anioEstreno = c.anioEstreno;
        totalContenidos++;
    }
    
    // Getters
    public String getTitulo(){
        return this.titulo;
    }
    
    public int getAnioEstreno(){
        return this.anioEstreno;
    }
    
    public static int getTotalContenidos(){
        return totalContenidos;
    }
    
    // Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setAnioEstreno(int anio){
        this.anioEstreno = anio;
    }
    
    // Métodos personalizados
    public abstract double calcularValoracion();
    
    public abstract int getDuracion();
    
    // toString
    @Override
    public String toString(){
        String cadena = "Titulo: " + this.titulo + "\n" +
                "Año de estreno: " + this.anioEstreno + "\n";
        
        return cadena;
    }
    
}
