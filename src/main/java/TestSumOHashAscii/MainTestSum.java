/*
 *Un testsum es un número entero de 32 bits calculado mediante la suma de todos los caracteres de un
 *archivo de texto ASCII. Dos archivos iguales deben tener el mismo testsum. Escriba un programa Java cuyo
 *método main reciba como argumentos de línea de comandos: una lista de nombres de archivos de texto y por
 *cada uno de ellos calcule el testsum de cada archivo y los imprima en pantalla.
 */
package TestSumOHashAscii;


import java.io.*;
import java.util.*;

/*
 *@author emilioSaldivar__
 */
public class MainTestSum {
    public static void main(String[] args) {
        IAccesoDatos accesoDatos = new AccesoDatosImpl();
        Scanner consola = new Scanner(System.in);
        String direccionDelArchivo;
        ArrayList <ArchivoComparable> archivosComparabes = new ArrayList<ArchivoComparable>();//almacenamos las rutas y sus respectivos test sum
        if (args.length == 0) {
            System.out.println("Ingrese la ruta absoluta del archivo:\n");
            direccionDelArchivo = consola.nextLine();
            if (!accesoDatos.existe(direccionDelArchivo)) {
                System.out.println("El archivo no existe o la ruta al archivo es la incorrecta, creamos un archivo con el nombre de dicha ruta para la prueba");
                
                direccionDelArchivo = direccionDelArchivo.substring(direccionDelArchivo.lastIndexOf("\\")+1);//aca solo nos centramos en el nombre del archivo que quiere abrir el usuario no la ruta
                
                //creamos archivo
                accesoDatos.crear(direccionDelArchivo);
                
                //escribimos en el archivo para la prueba
                accesoDatos.escribir("TODO ESTE TEXTO ES DE PRUEBA \nPodemos volver a pedir al usuario si quiere agregar algo "
                        + "al archivo nuevo, todo esto va escrito en el archivo creado \n"
                        + "repiten palabras repetidas repetidas ESTRUCtura de Datos, estructura, \n"
                        + " datos datos estructura datos estructura de de  repeticiones ", direccionDelArchivo, true);
                
                //hacemos el test sum de la prueba
                archivosComparabes.add(testSum(direccionDelArchivo));                                       
            } else {
                archivosComparabes.add(testSum(direccionDelArchivo));    
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                direccionDelArchivo = args[i];
                archivosComparabes.add(testSum(direccionDelArchivo));
            }
            
        }
        
        for (Iterator<ArchivoComparable> iterator = archivosComparabes.iterator(); iterator.hasNext();) {
            ArchivoComparable next = (ArchivoComparable)iterator.next();
            System.out.println("El archivo: " + next.getNombreDelArchivo() + " tiene un test sum de: " + next.getTestSum());
            
        }
    }
    public static ArchivoComparable testSum(String direccionDelArchivo){
        ArchivoComparable archivoYTestSum = new ArchivoComparable(direccionDelArchivo);
        try {

            BufferedReader reader = new BufferedReader(new FileReader(direccionDelArchivo));
            String linea;
            Float testSum = 0f ;
            //iterar por cada palabra
            while ((linea = reader.readLine()) != null) {
                
                for (int i = 0; i < linea.length(); i++) {
                    testSum = testSum + (int)linea.charAt(i);//obtenemos en codigo ascii
                }
                
            }
            reader.close();
            archivoYTestSum.setTestSum(testSum);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo,por favor verifique");
            e.printStackTrace(System.out);
        }
        return archivoYTestSum;
    }
}
