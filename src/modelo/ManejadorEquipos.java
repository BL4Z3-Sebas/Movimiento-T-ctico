package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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

            if (equipoActual.equals("Equipo1")) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String datos[] = linea.split(";");
                    if (equipoSiguiente(datos[0]) == null) {
                        return linea;
                    }
                }
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                String datos[] = linea.split(";");
                if (equipoSiguiente(datos[0]).split(";")[0].equals(equipoActual)) {
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
        
        
//        ArrayList<int[]> matriz_adyacencia = new ArrayList<>();
//        for (String fila : adyacencia) {
//            String[] elementos = fila.split(",");
//            int[] pos = new int[elementos.length];
//            for (int i = 1; i < elementos.length; i++) {
//                pos[i - 1] = Integer.parseInt(elementos[i]);
//            }
//            matriz_adyacencia.add(pos);
//        }

        ArrayList<String> matriz_adyacencia2 = new ArrayList<>();
        for (int i=1; i<adyacencia.length;i++) {
            
            matriz_adyacencia2.add(adyacencia[i]);
        }
        ArrayList<Jugador> lista_jugadores = new ArrayList<>();
        for (String jugador : jugadores) {
            String[] datos = jugador.split(",");
            Jugador j = new Jugador(datos[0],
                    Integer.parseInt(datos[1]),
                    Integer.parseInt(datos[2]),
                    Integer.parseInt(datos[3]));
            lista_jugadores.add(j);
        }
        
        ArrayList<String> otros_datos = new ArrayList<>();
        otros_datos.add(nombre);
        otros_datos.add(formacion);
        
        ArrayList<ArrayList> procesados = new ArrayList<>();
        procesados.add(otros_datos);
        procesados.add(lista_jugadores);
        procesados.add(matriz_adyacencia2);
     //   procesados.add(matriz_adyacencia);
        
        return procesados;
    }
}
