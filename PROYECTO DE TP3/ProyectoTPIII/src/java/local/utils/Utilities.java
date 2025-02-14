package local.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Utilities {

    private String listaAString(List lista) {
        StringBuffer sb = new StringBuffer();
        ////////////////////////////////////////////////////////////////////////
        Iterator i = lista.iterator();
        while (i.hasNext()) {
            String[] arreglo = (String[]) i.next();
            sb.append("[" + arreglo[0] + "," + arreglo[1] + "]");
        }
        ////////////////////////////////////////////////////////////////////////
        return sb + "";
    }
    
    public static boolean esEspacioEnBlanco(String id) {
        for (int i = 0; i < id.length(); i++) {
            char letra = id.charAt(i);
            if (letra == ' ') {
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean esEmail (String x){
        int cont=x.length();
        for (int i=0; i < cont; i++){
            char []cadena = x.toCharArray();
                if(Character.isWhitespace(cadena[i])){
                    return false;
                }
        }
        return true;
    }
    
    public static boolean esLetraOConEspacio(String x) {
        int cont = x.length();
        for (int i = 0; i < cont; i++) {
            char []cadena = x.toCharArray();
                if (!Character.isLetter(cadena[i]) && !Character.isWhitespace(cadena[i])) {
                    return false;
                }
        }
        return true;
    }
    
    public static boolean esLetraDigito(String x) {
        int cont = x.length();
        for (int i = 0; i < cont; i++) {
            char []cadena = x.toCharArray();
                if (!Character.isLetterOrDigit(cadena[i])) {
                    return false;
                }
        }
        return true;
    }
    
    public static boolean esDigito(String x) {
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean esFechaValida(String date) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}