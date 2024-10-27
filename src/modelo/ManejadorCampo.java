package modelo;

import java.util.ArrayList;

/**
 *
 * @author Alfonso
 */
public class ManejadorCampo {

    private final ManejadorEquipos ME = new ManejadorEquipos();
    public static final int SIGUIENTE = 1;
    public static final int ANTERIOR = -1;

    public Campo crearCampo(String equipo, int avance) {
        ArrayList<ArrayList> datos = new ArrayList<>();
        switch (avance) {
            case 1:
                datos = ME.leerEquipoSiguiente(equipo);
                break;
            case -1:
                datos = ME.leerEquipoAnterior(equipo);
                break;
            case 0:
                datos = ME.leerEquipo(equipo);
                break;
            default:
                System.out.println("Error");
        }

        ArrayList jugadores = datos.get(1);
        String formacion = ((String) datos.get(0).get(1)).replace("-", "");

        Campo campo = new Campo();
        campo.setNombre((String) datos.get(0).get(0));
        campo.setFormacion(Integer.parseInt(formacion));
        campo.setMatrizAdyacencia(generarMatrizAdyacencia(datos.get(2)));
        creacionFormacion(jugadores, campo.getMatrizAdyacencia());
        campo.setListaJugadores(jugadores);

        return campo;
    }

    public int[][] generarMatrizAdyacencia(ArrayList<String> jugadores) {
        int[][] matriz = new int[11][11];
        for (int i = 0; i < 11; i++) {
            String[] marcas = jugadores.get(i).split(",");
            for (int j = 1; j < 12; j++) {
                matriz[i][j - 1] = Integer.parseInt(marcas[j]);
            }
        }
        return matriz;
    }

    public void creacionFormacion(ArrayList<Jugador> jugadores, int[][] matriz) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (matriz[i][j] == 1) {
                    jugadores.get(i).addJugador(jugadores.get(j));
                }
            }
        }
    }
}
