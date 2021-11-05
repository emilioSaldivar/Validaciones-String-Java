
package DiccionarioDePalabras;

/*
*@author emilioSaldivar__
*/

public interface IAccesoDatos{
    public boolean existe(String nombreArchivo);
    public void escribir(String escrito, String nombreArchivo, boolean anexar);
    public void crear(String nombreArchivo);
    public void borrar(String nombreArchivo);
    public void crearYEscribir(String nombreArchivo, String escrito);
}
/*La interface contiene las operaciones a ser ejecutadas en el archivo peliculas.txt*/