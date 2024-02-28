package e1;

public class StringUtilities {
    public static boolean isValidString(String str, String admitted, Integer minLength) {
        if(str == null || str.isEmpty())  //comprueba si es nulo o vacio
            return false;
        else if (str.length() < minLength) {  //comprueba que la longitud del string tiene que ser mayor o igual que el valor pasado por parametro
            return false;
        }
        else{
            for (int i = 0; i < str.length(); i++) {  //comprueba que el valor pasado sea un digito o caracteres incluidos en el String pasado por parametro
                char c = str.charAt(i);
                if (!Character.isDigit(c)) {
                    for (int j = 0; j < admitted.length(); j++) {
                        if (c == admitted.charAt(j)) {
                            break;
                        } else if (j == admitted.length() - 1)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static String lowercaseFirst(String str) {
        StringBuilder upperStr = new StringBuilder();
        StringBuilder lowerStr = new StringBuilder();
        StringBuffer finalstr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c))  //seleccionamos las letras minúsculas
                lowerStr.append(c);
            else if (Character.isUpperCase(c))  //seleccionamos las letras mayúsculas
                upperStr.append(c);
        }
        finalstr.append(lowerStr);
        finalstr.append(upperStr);
        return String.valueOf((finalstr)); //devolvemos el String reordenado
    }

    public static boolean checkTextStats(String str, int min, int max) {
        double sum = 0;double count = 0; int maxlength = 0;double average;
        if(str == null || str.isEmpty()){  //si es nulo o vacio devolvemos una excepción
            throw new IllegalArgumentException("El texto de entrada es nulo o vacio");
        }
        if(min<=0 || max<=0){  //si los parametros pasados son menores que 0 devuelve una excepción
            throw new IllegalArgumentException("min y max tienen que ser positivos");
        }
        String[] words = str.split(" ");
        for (String word : words) {
            sum += word.length();
            count++;
            if (word.length() > maxlength)  //seleccionamos la palabra mas larga del String
                maxlength = word.length();
        }
        average = sum / count;  //realizamos la media
        return average >= min && average <= max && maxlength <= 2 * average;  //devolvemos true o false en funcion de las siguientes condiciones
    }

}