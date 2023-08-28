import java.io.*;
import java.util.HashMap;

public class faseLexica {

    private static HashMap<String, String> tablaDeSimbolos = new HashMap<>();

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java faseLexica [ARCHIVO_DE_ENTRADA] [ARCHIVO_DE_SALIDA]");
            return;
        }

        String archivoEntrada = args[0];
        String archivoSalida = args[1]; 

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada));
            String linea;
            int numeroDeLinea = 1;

            // Crear un FileWriter para escribir en el archivo de salida
            FileWriter fileWriter = new FileWriter(archivoSalida);

            while ((linea = reader.readLine()) != null) {
            String resultado = tokenizarLinea(linea, numeroDeLinea);
            //System.out.println(resultado); // Imprimir en la consola
            fileWriter.write(resultado);
            numeroDeLinea++;
        }
            reader.close();
            fileWriter.close(); // Cerrar el archivo de salida
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String tokenizarLinea(String linea, int numeroDeLinea) {
        StringBuilder resultado = new StringBuilder();

        String[] tokens = linea.split("\\s+|(?=[=;()+\\-*\\/])|(?<=[=;()+\\-*\\/])");

        for (String token : tokens) {
            token = token.trim();

            if (token.isEmpty()) {
                continue;
            }

            if (token.matches("\\d+")) {
                resultado.append("Token: " + token + ", Tipo: NUMERO\n");
            } else if (token.matches("[a-zA-Z]+")) {
                resultado.append("Token: " + token + ", Tipo: IDENTIFICADOR\n");

                // Agregar a la tabla de símbolos
                tablaDeSimbolos.put(token, null);
            } else if (token.equals("=")) {
                resultado.append("Token: " + token + ", Tipo: ASIGNACION\n");

                // Actualizar el valor del último identificador agregado
                if (!tablaDeSimbolos.isEmpty()) {
                    String ultimoIdentificador = tablaDeSimbolos.keySet().iterator().next();
                    tablaDeSimbolos.put(ultimoIdentificador, null);
                }
            } else if (token.equals(";")) {
                resultado.append("Token: " + token + ", Tipo: PUNTO_COMA\n");
            } else if (token.equals("+")) {
                resultado.append("Token: " + token + ", Tipo: SUMA\n");
            } else if (token.equals("-")) {
                resultado.append("Token: " + token + ", Tipo: RESTA\n");
            } else if (token.equals("*")) {
                resultado.append("Token: " + token + ", Tipo: MULTIPLICACION\n");
            } else if (token.equals("/")) {
                resultado.append("Token: " + token + ", Tipo: DIVISION\n");
            } else if (token.equals("(")) {
                resultado.append("Token: " + token + ", Tipo: PARENTESIS_IZQ\n");
            } else if (token.equals(")")) {
                resultado.append("Token: " + token + ", Tipo: PARENTESIS_DER\n");
            } else {
                resultado.append("Error [Fase Léxica]: La línea " + numeroDeLinea + " contiene un error, lexema no reconocido: " + token + "\n");
            }
        }

        return resultado.toString();
    }
}