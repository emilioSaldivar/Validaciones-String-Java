
package SubconjuntoCadena;

/*
 *@author emilioSaldivar__ 
 */
public class SubconjuntoCadena {

    public static void main(String[] args) {
        
        String str1 = "ASDFGHJ";
        String str2 = "ZXCVBNASDFGHJ";
        
        System.out.println(str1 + "\n" + str2);
        if (subConjuntos(str1, str2)){
            System.out.println("El conjunto de caracteres Str1 es un subconjunto de Str2");
        }
        else {
            System.out.println("El conjunto de caracteres Str1 no es un subconjunto de Str2");
        }
            

    }
    public static boolean subConjuntos (String str1, String str2){
        boolean bandera = false;
        for (int i = 0; i < str1.length(); i++) {
            
            for (int j = 0; j < str2.length(); j++) {
                
                    if(str1.charAt(i) == str2.charAt(j)){
                        bandera = true;//si almenos una letra de toda la cadena es igual ya se considera 
                                      //como subconjunto segun teoria de conjunto
                                      //si queremos el subconjunto de caracteres podriamos condicionar para que se guarden
                                      //en un array de caracteres cada vez que esta condicion if se cumpla.(no es lo que pide el ejercicio)
                    }
                
            }
            
            
        }
        return bandera;
    }
}
