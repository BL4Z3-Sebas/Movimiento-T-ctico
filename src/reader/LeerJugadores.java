package reader;

/**
 *
 * @author andre
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nodelo.Jugador;

public class LeerJugadores {
    
    public static List<Jugador> leerArchivoJugadores(String archivo) {
        List<Jugador> jugadores = new ArrayList<>();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            // Leer la primera línea que contiene los encabezados
            br.readLine();
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int velocidad = Integer.parseInt(datos[1]);
                int remates = Integer.parseInt(datos[2]);
                int posesion = Integer.parseInt(datos[3]);
                Jugador jugador = new Jugador(nombre, velocidad, remates, posesion);
                jugadores.add(jugador);
            }
        } catch (IOException e) {
        }
        return jugadores;
    }
}
