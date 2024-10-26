

import java.util.ArrayList;
import java.util.List;
import modelo.Campo;
import modelo.Jugador;
import reader.LeerJugadores;
import reader.LeerMatriz;

public class TransparentPanelExample {
    public static void main(String[] args) {
        // Ruta de los archivos
        String rutaArchivoJugadores = "src/recursos/jugadores.csv";  // Ajusta esta ruta según la ubicación de tu archivo
        String rutaArchivoMatriz = "src/recursos/matriz_adyacencia.csv";        // Ajusta esta ruta según la ubicación de tu archivo

        // Leer la lista de jugadores desde el archivo
        List<Jugador> listaJugadores = LeerJugadores.leerArchivoJugadores(rutaArchivoJugadores);

        // Leer la matriz de adyacencia desde el archivo
        int[][] matrizAdyacencia = LeerMatriz.leerMatriz(rutaArchivoMatriz);

        // Crear el objeto Campo con los jugadores y la matriz de adyacencia leída
        Campo campo = new Campo(new ArrayList<>(listaJugadores), matrizAdyacencia);

        // Definir una lista de posibles jugadores finales (por ejemplo, delanteros)
        ArrayList<String> delanteros = new ArrayList<>();
        delanteros.add("Jugador3");
        delanteros.add("Jugador4");
        delanteros.add("Jugador5");

        // Realizar el recorrido basado en velocidad desde Jugador1 a uno de los delanteros
        ArrayList<Jugador> caminoVelocidad = campo.recorridoVelocidad("Jugador1", delanteros);
        if (caminoVelocidad != null) {
            System.out.print("Camino óptimo basado en velocidad: ");
            for (Jugador jugador : caminoVelocidad) {
                System.out.print(jugador.getNombre() + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró un camino basado en velocidad.");
        }

        // Realizar el recorrido basado en posesión desde Jugador2 a uno de los delanteros
        ArrayList<Jugador> caminoPosesion = campo.recorridoPosesion("Jugador2", delanteros);
        if (caminoPosesion != null) {
            System.out.print("Camino óptimo basado en posesión: ");
            for (Jugador jugador : caminoPosesion) {
                System.out.print(jugador.getNombre() + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró un camino basado en posesión.");
        }

        // Realizar el recorrido basado en remate desde Jugador5 a uno de los delanteros
        ArrayList<Jugador> caminoRemate = campo.recorridoRemate("Jugador5", delanteros);
        if (caminoRemate != null) {
            System.out.print("Camino óptimo basado en remate: ");
            for (Jugador jugador : caminoRemate) {
                System.out.print(jugador.getNombre() + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró un camino basado en remate.");
        }
    }
}
