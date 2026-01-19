/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploclases;
// Como ambas clases están en el mismo paquete y las dos son públicas
// no es necesario importar Alumno

/**
 *
 * @author marin
 */
public class Curso {
    // Atributos
    private String nombre, codigo;
    private int numMaxAlumnos;
    private Alumno[] alumnos;
    
    // Constructores
    // Constructor por defecto
    public Curso(){
        this.nombre = "";
        this.codigo = "";
        this.numMaxAlumnos = 0;
        this.alumnos = new Alumno[0];
    }
    
    // Constructor por parámetros
    public Curso(String nombre, String codigo, int numMax, Alumno[] alumnos){
        this.nombre = nombre;
        this.codigo = codigo;
        this.numMaxAlumnos = numMax;
        // Como queremos hacer una copia del array y no usar la referencia,
        // no podemos usar this.alumnos = alumnos, sino que tenemos que usar 
        // un método para copiar todos los valores, en este caso clone()
        this.alumnos = alumnos.clone();
    }
    
    // Constructor de copia
    public Curso(Curso c){
        this.nombre = c.nombre;
        this.codigo = c.codigo;
        this.numMaxAlumnos = c.numMaxAlumnos;
        this.alumnos = c.alumnos.clone();
    }
    
    // Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public int getNumMaxAlumnos(){
        return this.numMaxAlumnos;
    }
    
    public Alumno[] getAlumnos(){
        return this.alumnos;
    }
    
    // Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setNumMaxAlumnos(int numMax){
        this.numMaxAlumnos = numMax;
    }
    
    public void setAlumnos(Alumno[] alumnos){
        this.alumnos = alumnos;
    }
    
    // Métodos personalizados 
    // Este método devuelve true en caso de que sí se pueda añadir el alumno, y false en caso contrario
    public boolean aniadirAlumno(Alumno alumno){
        // Antes de añadir un nuevo alumno, tenemos que comprobar si hemos alcanzado
        // el número máximo de alumnos
        if(this.alumnos.length == this.numMaxAlumnos){
            System.out.println("No se puede añadir un nuevo alumno, número máximo alcanzado.");
            return false;
        }
        else{
            // Como tenemos un atributo de tipo array de enteros, cuando queremos
            // añadir un alumno nuevo tenemos que sobreescribir el que ya teníamos
            // añadiendole uno nuevo

            // Creo un array de enteros nuevo con 1 elemento más que el array alumnos
            Alumno[] arrayNuevoAlumnos = new Alumno[this.alumnos.length + 1];

            // Creo un bucle para copiar los elementos del array de alumnos y añadirle uno nuevo
            for(int i = 0; i < arrayNuevoAlumnos.length - 1; i++){
                arrayNuevoAlumnos[i] = this.alumnos[i];
            }
            // Añado en el último elemento el nuevo alumno
            arrayNuevoAlumnos[arrayNuevoAlumnos.length - 1] = alumno;

            // Ahora guardamos en this.alumnos el nuevo array que hemos creado
            this.setAlumnos(arrayNuevoAlumnos); 
            
            return true;
        }
    }
    
    // toString
    public String toString(){
        String cadena = "Nombre curso: " + this.nombre + "\n" +
                "Código: " + this.codigo + "\n" +
                "Número máximo de alumnos: " + this.numMaxAlumnos + "\n" +
                "Alumnos: " + "\n";
        
        // Añadimos todos los alumnos a la cadena 
        for(int i = 0; i<this.alumnos.length ; i++){
            cadena += alumnos[i] + "\n";
        }
        
        return cadena;
    }
            
}
