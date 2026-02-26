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
public class Plataforma {
    // Atributos
    private String nombre;
    private Contenido[] catalogo;
    
    // Constructores
    public Plataforma(){
        this.nombre = "";
        this.catalogo = new Contenido[0];
    }
    
    public Plataforma(String nombre){
        this.nombre = nombre;
    }
    
    public Plataforma(Plataforma p){
        this.nombre = p.nombre;
        this.catalogo = p.catalogo.clone();
    }
    
    // Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public Contenido[] getCatalogo(){
        return this.catalogo;
    }
    
    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    // Métodos personalizados    
    public void aniadirContenido(Contenido c){
        if(c != null){
            // Creamos un nuevo array con un elemento más
            Contenido[] nuevoArray = new Contenido[this.catalogo.length + 1];
            // Copiamos el array que ya tenemos
            for(int i = 0; i < this.catalogo.length; i++){
                nuevoArray[i] = this.catalogo[i];
            }
            // Añadimos el nuevo elemento al final
            nuevoArray[this.catalogo.length] = c;
            // guardar el nuevo array en el atributo
            this.catalogo = nuevoArray;
        }
    }
    
    public int calcularDuracionTotal(){
        int duracionTotal= 0;
        
        // Recorrer todo el catalogo y calcular la duración de cada elemento
        for(int i = 0; i < this.catalogo.length; i++){
            duracionTotal += this.catalogo[i].getDuracion();
        }
        
        return duracionTotal;
    }
    
    @Override
    public String toString(){
        String cadena = "Nombre plataforma: " + this.nombre + "\nCatalogo: \n";
        for(int i = 0; i < this.catalogo.length; i++){
            cadena += this.catalogo[i];
        }
        
        return cadena;
    }
}