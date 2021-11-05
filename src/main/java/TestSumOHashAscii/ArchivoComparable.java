/*
 * esta clase define de forma abstarcta un archivo con atributos {nombre, testSum}
 */
package TestSumOHashAscii;

/*
 * @author emilioSaldivar__
 */
public class ArchivoComparable {
    private String rutaDelArchivo;
    private Float testSum;//definimos como la clase envolvente para acceder a mas propiedades de esta
    
    //constructor

    public ArchivoComparable(String rutaDelArchivo, Float testSum) {
        this.rutaDelArchivo = rutaDelArchivo;
        this.testSum = testSum;
    }
    public ArchivoComparable(String rutaDelArchivo) {
        this.rutaDelArchivo = rutaDelArchivo;
    }
    public ArchivoComparable(Float testSum) {
        this.testSum = testSum;
    }
    public ArchivoComparable() {
    
    }
//metodos
    public Float getTestSum() {
        return this.testSum;
    }

    public void setTestSum(Float testSum) {
        this.testSum = testSum;
    }

    public String getRutaDelArchivo() {
        return rutaDelArchivo;
    }

    public void setRutaDelArchivo(String rutaDelArchivo) {
        this.rutaDelArchivo = rutaDelArchivo;
    }
    
    public String getNombreDelArchivo(){
        if(this.rutaDelArchivo.contains("\\")){
            return this.rutaDelArchivo.substring(this.rutaDelArchivo.lastIndexOf("\\")+1);
        }
        else{
            return this.rutaDelArchivo;
        }
    }
    
    
    
    
}
