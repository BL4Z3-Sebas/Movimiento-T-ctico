package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Alfonso
 */
public class ManejadorEquipos {

    public static String equipoSiguiente(String equipoActual) {
        try (BufferedReader br = new BufferedReader(new FileReader("archivos/equipos.csv"))) {

            if (equipoActual == null) {
                return br.readLine();
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos[0].equals(equipoActual)) {
                    if ((linea = br.readLine()) == null) {
                        return equipoSiguiente(null);
                    }
                    return linea;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static String equipoAnterior(String equipoActual) {
        try (BufferedReader br = new BufferedReader(new FileReader("archivos/equipos.csv"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String datos[] = linea.split(";");
                String siguiente = equipoSiguiente(datos[0]).split(";")[0];
                if (siguiente.equals(equipoActual)) {
                    return linea;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<ArrayList> cargarEquipo(String equipo) {
        String[] datos_equipo = equipo.split(";");

        String nombre = datos_equipo[0];
        String formacion = datos_equipo[1];
        String[] jugadores = datos_equipo[2].split(" ");
        String[] adyacencia = datos_equipo[3].split(" ");

        ArrayList<String> otros_datos = new ArrayList<>();
        ArrayList<String> listas_adyacencia = procesarListaAdyacencia(adyacencia);
        ArrayList<Jugador> lista_jugadores = procesarJugadores(jugadores);
        ArrayList<ArrayList> procesados = new ArrayList<>();

        otros_datos.add(nombre);
        otros_datos.add(formacion);

        procesados.add(otros_datos);
        procesados.add(lista_jugadores);
        procesados.add(listas_adyacencia);

        return procesados;
    }

    private ArrayList procesarListaAdyacencia(String[] adyacencia) {
        ArrayList<String> lista_adyacencia = new ArrayList<>();
        for (int i = 1; i < adyacencia.length; i++) {
            lista_adyacencia.add(adyacencia[i]);
        }
        return lista_adyacencia;
    }

    private ArrayList procesarJugadores(String[] jugadores) {
        ArrayList<Jugador> lista_jugadores = new ArrayList<>();
        for (String jugador : jugadores) {
            String[] datos = jugador.split(",");
            Jugador j = new Jugador(datos[0],
                    Integer.parseInt(datos[1]),
                    Integer.parseInt(datos[2]),
                    Integer.parseInt(datos[3]));
            lista_jugadores.add(j);
        }
        return lista_jugadores;
    }

    private void asignarAdyacentes(ArrayList listas_adyacencia, ArrayList jugadores) {
        
    }
}
