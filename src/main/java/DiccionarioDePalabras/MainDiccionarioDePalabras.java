/*
 *ejercicio numero dos de la actividad 2.1 de estructura de datos con Dezeta.
 */
package DiccionarioDePalabras;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/*
 * @author @emilioSaldivar__
 */
public class MainDiccionarioDePalabras {

    public static void main(String[] args) {
        IAccesoDatos accesoDatos = new AccesoDatosImpl();
        Scanner consola = new Scanner(System.in);
        String direccionDelArchivo;
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
                
                //hacemos la prueba de el contador de palabras
                cuentaPalabras(direccionDelArchivo);                                       
            } else {
                cuentaPalabras(direccionDelArchivo);
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                direccionDelArchivo = args[i];
                cuentaPalabras(direccionDelArchivo);
            }

        }
    }

    public static void cuentaPalabras(String direccionDelArchivo) {
        //creamos un diccionario que contendran las palabras y sus repeticiones 
        HashMap<String, Integer> diccionario = new HashMap<>();//diccionario que tene como llave a la palabra y 
        //almacena el contador de las veces que se repite dicha palabra
        try {

            BufferedReader reader = new BufferedReader(new FileReader(direccionDelArchivo));
            String linea;

            //iterar por cada palabra
            while ((linea = reader.readLine()) != null) {
                String textoSinCaracteresEspeciales = getOnlyStrings(linea.toLowerCase());//sin caracteres y en minusculas
                String palabrasSeparadas[] = textoSinCaracteresEspeciales.split(" ");//generamos un array de palabras para posteriormente 
                for (String palabrasSeparada : palabrasSeparadas) {
                    if (!(diccionario.isEmpty()) && diccionario.containsKey(palabrasSeparada)) {
                        //si el diccionario no esta vacio y ademas contiene a la palabra
                        int contadorAuciliar = diccionario.get(palabrasSeparada); //obtenemos el objeto y lo convertimos en entero
                        diccionario.replace(palabrasSeparada, ++contadorAuciliar); //aumentamos contador
                    } else if (!palabrasSeparada.equalsIgnoreCase("")) {
                        //si esta vacio directo entra en esta condicion
                        diccionario.put(palabrasSeparada, 1); //agregamos la palabra y aumentamos el contador cambiamos el valor del contador de palabras a 1
                    }
                }
            }
            reader.close();
            //System.out.println(diccionario);

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo,por favor verifique");
            e.printStackTrace(System.out);
        }
        //volcar todo el hashMap en un array de Palabras(objeto) para poder iterar y ordenar respecto a las repeticiones
        List palabrasYRepeticiones = new ArrayList<Palabra>();

        //ordenamos la lista(de menor a mayor) y lo guardamos en una lista de palabras
        diccionario
                .entrySet()//obtenemos como key y value(llave y valor)
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> palabrasYRepeticiones.add(new Palabra(entry.getKey(), entry.getValue())));
        Collections.sort(palabrasYRepeticiones);//ordenamos la lista de palabras de mayor a menor
        System.out.println("\nEstas son las 10 palabras mas repetidas en el archivo\n");
        //imprimimos la lista
        int contador = 0;
        for (Iterator it = palabrasYRepeticiones.iterator(); it.hasNext();) {//nos aseguramos de no sobrepasar el indice
            Palabra palabra = (Palabra) it.next();
            System.out.println(palabra.getPalabra() + "  " + palabra.getRepeticion());
            contador++;
            if (contador == 10) {//imprimimos solo las 10 palabras mas repetidas
                break;
            }
        }

    }
//utilizamos para aliminar los caracteres especiales 

    public static String getOnlyStrings(String s) {
        Pattern pattern = Pattern.compile("[^a-z A-Z á é í ó ú]");//fueron agregados las tildes a las vocales del codigo consultado
        Matcher matcher = pattern.matcher(s);
        String cadenaSinCaracteres = matcher.replaceAll("");
        return cadenaSinCaracteres;
    }
}
