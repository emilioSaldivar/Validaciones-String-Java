/*
 * Esta clase contiene una palabra y la cantidad de repeticiones
 */
package DiccionarioDePalabras;


/*
 * @emilioSaldivar__
 */
public class Palabra implements Comparable<Palabra> {//implementamos la clase comparable para poder ordenar las palabas mas adelante

    private String palabra;
    private int repeticion;

    public Palabra(String palabra, int repeticion) {
        this.palabra = palabra;
        this.repeticion = repeticion;
    }

    public String getPalabra() {
        return this.palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getRepeticion() {
        return this.repeticion;
    }

    public void setRepeticion(int repeticion) {
        this.repeticion = repeticion;
    }

    @Override
    public int compareTo(Palabra argPalabra) {//implementamos la operacion pero indicando que es de mayor a menor
        
            if (argPalabra.getRepeticion() > this.repeticion) {
                return 1;
            } else if (argPalabra.getRepeticion() > this.repeticion) {
                return 0;
            } else {
                return -1;
            }
        
    }


    
    
}
