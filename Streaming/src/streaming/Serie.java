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
public class Serie extends Contenido{
    // Atributos
    private int numeroTemporadas;
    private Episodio[] episodios;
    
    // Constructores
    public Serie(){
        super();
        this.numeroTemporadas = 0;
        this.episodios = new Episodio[0];
    }
    
    public Serie(String titulo, int anio, int numeroTemporadas, Episodio[] episodios){
        super(titulo, anio);
        this.numeroTemporadas = numeroTemporadas;
        this.episodios = episodios.clone();
    }
    
    public Serie(Serie s){
        super(s);
        this.numeroTemporadas = s.numeroTemporadas;
        this.episodios = s.episodios.clone();
    }
    
    // Getters
    public int getNumeroTemporadas(){
        return this.numeroTemporadas;
    }
    
    public Episodio[] getEpisodios(){
        return this.episodios;
    }
    
    // Métodos personalizados
    @Override
    public int getDuracion(){
        // Recorremos uno a uno los episodios para obtener su duración y la sumamos
        int duracionTotal = 0;
        for(int i = 0; i < this.episodios.length; i++){
            duracionTotal += this.episodios[i].getDuracion();
        }
        
        return duracionTotal;
    }
    
    public void aniadirEpisodio(Episodio nuevoEpisodio){
        // Creamos un nuevo array con un elemento más
        Episodio[] nuevoArray = new Episodio[this.episodios.length + 1];
        // Copiamos el array que ya tenemos
        for(int i = 0; i < this.episodios.length; i++){
            nuevoArray[i] = this.episodios[i];
        }
        // Añadimos el nuevo elemento al final
        nuevoArray[this.episodios.length] = nuevoEpisodio;
        // guardar el nuevo array en el atributo
        this.episodios = nuevoArray;
    }
    
    @Override
    public double calcularValoracion(){
        double sumaValoraciones = 0;
        double valoracionSerie;
        // Primero tenemos que calcular la valoración de cada temporada
        double[] sumaPuntuacionPorTemporada = new double[this.numeroTemporadas];
        int[] episodiosPorTemporada = new int[this.numeroTemporadas];
        double[] valoracionPorTemporada = new double[this.numeroTemporadas];
        
        // Inicializamos los arrays a 0
        // menos el de la media, que luego lo rellenaremos
        for(int i = 0; i < this.numeroTemporadas; i++){
            sumaPuntuacionPorTemporada[i] = 0;
            episodiosPorTemporada[i] = 0;
        }
        
        int temporada; // Este número empezará por 1
        for(int i = 0; i < this.episodios.length; i++){
            temporada = this.episodios[i].getNumeroTemporada();
            // Para acceder en el array de temporadas a la temporada 1
            // tendríamos que acceder a la posición 0 del array
            sumaPuntuacionPorTemporada[temporada - 1] += this.episodios[i].getPuntuacion();
            episodiosPorTemporada[temporada - 1]++;
        }
        
        // Ahora calculamos la media de cada temporada
        int temporadasValidas = 0;
        for(int i = 0; i < this.numeroTemporadas; i++){
            if(episodiosPorTemporada[i] > 0){
                valoracionPorTemporada[i] = sumaPuntuacionPorTemporada[i]/episodiosPorTemporada[i];
                sumaValoraciones += valoracionPorTemporada[i];
                temporadasValidas++;
            }
        }
        
        // Calculamos la valoración completa de la serie
        if(temporadasValidas == 0){
            return 0;
        }
        valoracionSerie = sumaValoraciones / temporadasValidas;
        
        return valoracionSerie;
    }
    
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "Numero de temporadas: " + this.numeroTemporadas +
                "Episodios: \n";
        for(int i = 0; i < this.episodios.length; i++){
            cadena += this.episodios[i];
        }
        
        return cadena;
    }
}
