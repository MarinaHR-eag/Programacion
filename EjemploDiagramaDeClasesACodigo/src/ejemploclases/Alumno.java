/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploclases;
// Como ambas clases están en el mismo paquete y las dos son públicas
// no es necesario importar Curso

/**
 *
 * @author marin
 */
public class Alumno {
    // Atributos
    private String nombre;
    private int edad;
    private int numeroExpediente;
    private Curso cursoMatriculado;
    
    // Constructores
    // Constructor por defecto
    public Alumno(){
        this.nombre = "";
        this.edad = 0;
        this.numeroExpediente = 0;
        // Asumimos que por defecto, cuando se crea un alumno este no está matriculado en nada
        this.cursoMatriculado = null;
    }
    
    // Constructor por parámetros
    public Alumno(String nombre, int edad, int numExp, Curso curso){
        this.nombre = nombre;
        this.edad = edad;
        this.numeroExpediente = numExp;
        this.cursoMatriculado = curso;
    }
    
    // Constructor de copia
    public Alumno(Alumno alumnoACopiar){
        this.nombre = alumnoACopiar.nombre;
        this.edad = alumnoACopiar.edad;
        this.numeroExpediente = alumnoACopiar.numeroExpediente;
        // Para copiar el curso, usamos el constructor de copia de los cursos
        // pero comprobamos que su valor no sea nulo antes de copiarlo
        if(alumnoACopiar.cursoMatriculado != null){
            this.cursoMatriculado = new Curso(alumnoACopiar.cursoMatriculado);
        }
        // en el caso de que el curso matriculado sea null en el alumno a copiar, 
        // lo ponemos también a null en nuestro caso
        else{
            this.cursoMatriculado = null;
        }
    }
    
    // Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public int getNumeroExpediente(){
        return this.numeroExpediente;
    }
    
    public Curso getCursoMatriculado(){
        return this.cursoMatriculado;
    }
    
    // Setters 
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setNumeroExpediente(int numExp){
        this.numeroExpediente = numExp;
    }

    public void setCursoMatriculado(Curso curso){
        this.cursoMatriculado = curso;
    }
    
    public boolean matricular(Curso curso){
        // Añadimos un nuevo alumno en el curso en el que nos queremos matricular
        boolean alumnoAniadido = curso.aniadirAlumno(this);
        if(alumnoAniadido){
            // En el caso de que el curso permita más alumnos y nos podamos matricular, 
            // Lo marcamos como matriculado en el alumno
            this.setCursoMatriculado(curso);
            System.out.println("Matriculado en el curso " + curso);
            
            return true;
        }
        else{
            System.out.println("No se ha podido matricular en el curso");
            return false;
        }      
    }
 
    @Override
    public String toString(){
        String cadena =  "Nombre alumno: " + this.nombre +
                "\n Edad: " + this.edad +
                "\n Numero expediente: " + this.numeroExpediente;
        
        // Para evitar un bucle infinito de llamadas recursivas
        // No usamos el toString de Curso, sino que solo imprimimos su nombre
        // Hay que tener en cuenta que le curso puede ser nulo
        if(this.cursoMatriculado != null){
            cadena += "\n Curso: " + this.cursoMatriculado.getNombre();
        }
        else{
            cadena += "\n Curso: no matriculado todavía";
        }
        return cadena;
    }
}
