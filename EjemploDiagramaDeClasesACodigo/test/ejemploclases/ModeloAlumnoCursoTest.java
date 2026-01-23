package ejemploclases;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ModeloAlumnoCursoTest {

    /*
     * TEST 1
     * Matrícula correcta y coherencia Alumno - Curso
     */
    @Test
    void testMatriculaCorrectaAlumnoCurso() {
        // Creamos un curso con máximo un alumno
        Curso curso = new Curso();
        curso.setNombre("Primero de DAW");
        curso.setNumMaxAlumnos(1);
        
        // Creamos un alumno
        Alumno alumno = new Alumno("Ana", 20, 1, null);

        // Matriculamos al alumno en el curso
        boolean resultado = alumno.matricular(curso);

        // Comprobamos que se ha podido matricular de forma correcta
        assertTrue(resultado);
        // Comprobamos que el curso matriculado del alumno coincide con el curso creado
        assertEquals(curso, alumno.getCursoMatriculado());
        // Comprobamos que en el curso sólo hay 1 alumno matriculado
        assertEquals(1, curso.getAlumnos().length);
        // Comprobamos que el alumno matriculado es el que hemos creado
        assertEquals(alumno, curso.getAlumnos()[0]);
    }

    /*
     * TEST 2
     * No se puede superar el número máximo de alumnos
     */
    @Test
    void testNoSePuedeSuperarNumeroMaximoDeAlumnos() {
        // Creamos un curso por defecto en el que sólo se puede matricular 1 alumno
        Curso curso = new Curso();
        curso.setNumMaxAlumnos(1);

        // Creamos dos alumnos distintos
        Alumno a1 = new Alumno("Ana", 20, 1, null);
        Alumno a2 = new Alumno("Luis", 22, 2, null);

        // Matriculamos al alumno 1 en el curso y comprobamos que se puede
        assertTrue(a1.matricular(curso));
        // Comprobamos que no se puede matricular al segundo alumno
        assertFalse(a2.matricular(curso));
        // Comprobamos que sólo hay un alumno matriculado en el curso
        assertEquals(1, curso.getAlumnos().length);
    }

    /*
     * TEST 3
     * Constructor copia de Curso: independencia entre las copias
     */
    @Test
    void testConstructorCopiaCursoDebeSerIndependiente() {
        // Creamos un curso 
        Curso original = new Curso();
        original.setNombre("Primero de DAW");

        // Creamos un curso nuevo que sea copia del anterior
        Curso copia = new Curso(original);
        // Le cambiamos el nombre a la copia
        copia.setNombre("Primero de DAW COPIA");

        // Comprobamos que el nombre del original no ha cambiado mientras que el de la copia si
        assertEquals("Primero de DAW", original.getNombre());
        assertEquals("Primero de DAW COPIA", copia.getNombre());
    }

    /*
     * TEST 4
     * toString de Alumno: información básica 
     */
    @Test
    void testToStringAlumnoContieneInformacionBasica() {
        // Creamos un alumno con información básica
        Alumno alumno = new Alumno("Ana", 20, 1, null);

        // Llamamos al método toString para comprobar que contiene le información mínima
        String texto = alumno.toString();

        // Comprobamos que el toString tiene como mínimo la información que hemos usado
        // para configurar el alumno
        assertTrue(texto.contains("Ana"));
        assertTrue(texto.contains("20"));
        assertTrue(texto.contains("1"));
    }

    /*
     * TEST 5
     * toString de Curso: información del curso y alumnos
     */
    @Test
    void toStringCursoContieneInformacionBasica() {
        // Creamos un curso con información básica
        Curso curso = new Curso();
        curso.setNombre("Primero de DAW");
        curso.setCodigo("1TDAW");
        curso.setNumMaxAlumnos(1);

        // Creamos un alumno y lo matriculamos en el curso anterior
        Alumno alumno = new Alumno("Ana", 20, 1, null);
        alumno.matricular(curso);

        // Llamos al toString para analizar la cadena resultante
        String texto = curso.toString();

        // Comprobamos que la cadena contiene la información básica sobre el curso y sobre el alumno
        assertTrue(texto.contains("Primero de DAW"));
        assertTrue(texto.contains("1TDAW"));
        assertTrue(texto.contains("Ana"));
    }
}
