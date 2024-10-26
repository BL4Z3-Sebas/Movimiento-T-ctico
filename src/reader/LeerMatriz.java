package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerMatriz{

    public static int[][] leerMatriz(String rutaArchivo) {
        int[][] matriz = new int[11][11];  // Suponiendo que tienes 11 jugadores

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int fila = 0;
            
            // Leer la primera línea y descartarla (nombres de los jugadores en la primera fila)
            br.readLine();

            // Leer las demás líneas que contienen la matriz de adyacencia
            while ((linea = br.readLine()) != null && fila < matriz.length) {
                // Dividir la línea en partes separadas por comas
                String[] datos = linea.split(",");

                // Asegurarse de que los datos tengan al menos 12 columnas (1 nombre + 11 valores de matriz)
                if (datos.length != 12) {
                    System.out.println("Error: La línea no contiene el número correcto de columnas.");
                    continue; // Saltar esta línea y continuar con la siguiente
                }

                // Ignorar el primer valor que es el nombre del jugador
                for (int columna = 1; columna < datos.length; columna++) {
                    try {
                        // Convertir solo los valores numéricos (0 o 1) a enteros
                        matriz[fila][columna - 1] = Integer.parseInt(datos[columna]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el valor: " + datos[columna]);
                    }
                }
                fila++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer la matriz de adyacencia: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de los límites de la matriz.");
        }
        return matriz;
    }
}


