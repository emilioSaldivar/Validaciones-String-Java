/*
reutilizo un codigo mio para acceder a datos mediante una implementacion con archivos y una interfaz que podria applicarse en forma generalizada
*/
package DiccionarioDePalabras;

import java.io.*;
/*
*@author emilioSaldivar__
*/

public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

   

    @Override
    public void escribir(String escrito, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(escrito);
            salida.close();
            System.out.println("Se ha escrito al archivo" +  escrito);
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("No se encontro el archivo\n");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("No se pudo escribir al archivo\n");
        }
    }

    

    @Override
    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo en memoria");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }
    
    @Override
    public void crearYEscribir(String nombreArchivo, String escrito) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo en memoria");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        escribir(escrito, nombreArchivo, true);
    }

    
   
   
    
}
