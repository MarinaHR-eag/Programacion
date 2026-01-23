/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploclases;

/**
 *
 * @author marin
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos un curso con máximo de 2 alumnos
        // Probamos el constructor por defecto
        Curso primeroDaw = new Curso();
        // Probamos los setters setNombre, setCodigo y setNumMaxAlumnos
        primeroDaw.setNombre("Primero de DAW");
        primeroDaw.setCodigo("1TDAW");
        primeroDaw.setNumMaxAlumnos(2);
        
        System.out.println("CREACIÓN DE UN CURSO POR DEFECTO Y USO DE SETTERS");
        System.out.println("Curso creado: ");
        // Probamos el toString
        System.out.println(primeroDaw);
        
        // Prueba de getters de Curso
        System.out.println();
        System.out.println("PRUEBA DE GETTERS DE CURSO");
        System.out.println("Nombre esperado: Primero de DAW -> " + 
                primeroDaw.getNombre());
        System.out.println("Código esperado: 1TDAW -> " + 
                primeroDaw.getCodigo());
        System.out.println("Máx alumnos esperado: 2 -> " + 
                primeroDaw.getNumMaxAlumnos());
        System.out.println("Alumnos esperados: 0 -> " + 
                primeroDaw.getAlumnos().length);
        
        // Creamos 3 alumnos
        // Usamos el constructor por defecto
        Alumno alumnoPorDefecto = new Alumno();
        // Usamos el constructor por parámetros
        Alumno luis = new Alumno("Luis", 22, 1002, null);
        Alumno marta = new Alumno("Marta", 21, 1003, null);
        
        // Probamos el toString de Alumno
        System.out.println();
        System.out.println("CREACIÓN DE ALUMNOS POR DEFECTO Y CON PARÁMETROS");
        System.out.println("Alumno creado: ");
        System.out.println(luis);

        // Prueba de getters de Alumno 
        System.out.println();
        System.out.println("PRUEBA DE GETTERS DE ALUMNO");
        System.out.println("Nombre esperado: Luis -> " + 
                luis.getNombre());
        System.out.println("Edad esperada: 22 -> " + 
                luis.getEdad());
        System.out.println("Expediente esperado: 1002 -> " + 
                luis.getNumeroExpediente());
        System.out.println("Curso esperado: null -> " + 
                luis.getCursoMatriculado());

        System.out.println("Nombre esperado: (cadena vacía) -> " + 
                alumnoPorDefecto.getNombre());
        System.out.println("Edad esperada: 0 -> " + 
                alumnoPorDefecto.getEdad());
        System.out.println("Expediente esperado: 0 -> " + 
                alumnoPorDefecto.getNumeroExpediente());
        System.out.println("Curso esperado: null -> " + 
                alumnoPorDefecto.getCursoMatriculado());
        
        // Probamos los setters de la clase Alumno
        System.out.println();
        System.out.println("PRUEBA DE SETTERS DE ALUMNO");
        alumnoPorDefecto.setNombre("Ana");
        alumnoPorDefecto.setEdad(20);
        alumnoPorDefecto.setNumeroExpediente(1001);
        
        System.out.println("Nombre esperado: Ana -> " + 
                alumnoPorDefecto.getNombre());
        System.out.println("Edad esperada: 20 -> " + 
                alumnoPorDefecto.getEdad());
        System.out.println("Expediente esperado: 1001 -> " + 
                alumnoPorDefecto.getNumeroExpediente());
        System.out.println("Curso esperado: null -> " + 
                alumnoPorDefecto.getCursoMatriculado());
        
        // Probamos el método matricular
        System.out.println();
        System.out.println("PRUEBA DE MATRICULACIÓN EN UN CURSO");
        luis.matricular(primeroDaw);
        marta.matricular(primeroDaw);
        // Ahora al volver a intentar matricular a otro alumno debería decirnos que el curso está lleno
        System.out.println();
        System.out.println("PRUEBA DE MATRICULACIÓN EN UN CURSO LLENO");
        alumnoPorDefecto.matricular(primeroDaw);
        
        // Prueba getters tras matrícula
        System.out.println();
        System.out.println("PRUEBA DE GETTERS TRAS LA MATRÍCULA");
        System.out.println("Curso de Luis esperado: Primero de DAW -> " + 
                luis.getCursoMatriculado().getNombre());
        System.out.println("Curso de Marta esperado: Primero de DAW -> " + 
                marta.getCursoMatriculado().getNombre());
        System.out.println("Curso de Ana esperado: null -> " + 
                alumnoPorDefecto.getCursoMatriculado());

        // Prueba getter array alumnos
        System.out.println();
        System.out.println("PRUEBA DE GETTERS CON UN ARRAY DE ALUMNOS");
        Alumno[] alumnosCurso = primeroDaw.getAlumnos();
        System.out.println("Número de alumnos esperado: 2 -> " + 
                alumnosCurso.length);
        for (int i = 0; i < alumnosCurso.length; i++) {
            System.out.println("Alumno " + (i + 1) + ": " + alumnosCurso[i].getNombre());
        }

        // Constructor de copia Alumno
        Alumno copiaAna = new Alumno(alumnoPorDefecto);
        System.out.println(copiaAna);

        // Constructor de copia Curso
        Curso copiaCurso = new Curso(primeroDaw);
        System.out.println(copiaCurso);

        // Probamos la independencia de las copias
        System.out.println();
        System.out.println("PRUEBA DE INDEPENDENCIA DE COPIAS");
        System.out.println("Prueba de la independencia de las copias");
        copiaCurso.setNombre("Primero de DAW COPIA");
        System.out.println("Nombre curso original esperado: Primero de DAW -> " + primeroDaw.getNombre());
        System.out.println("Nombre curso copia esperado: Primero de DAW COPIA -> " + copiaCurso.getNombre());      
    }
    
}
