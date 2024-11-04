package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author andre
 */
public class Campo {

    private String nombre;
    private int formacion;
    private ArrayList<Jugador> jugadores;
    private int[][] matrizAdyacencia;

    public Campo() {
        this.jugadores = new ArrayList<>();
//        matrizAdyacencia = new int[11][11];
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public Jugador getJugador(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;  // Retorna null si no se encuentra el jugador
    }

    public void setListaJugadores(ArrayList lista_jugadores) {
        this.jugadores = lista_jugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setMatrizAdyacencia(int[][] matriz_adyacencia) {
        this.matrizAdyacencia = matriz_adyacencia;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFormacion() {
        return formacion;
    }

    public void setFormacion(int formacion) {
        this.formacion = formacion;
    }

    public double[] getPromedio() {
        double[] promedio = new double[11];
        for (int i = 0; i < 11; i++) {
            Jugador j = jugadores.get(i);
            promedio[0] += j.getVelocidad();
            promedio[1] += j.getPosesion();
            promedio[2] += j.getRemate();
        }
        promedio[0] = promedio[0] / 11;
        promedio[1] = promedio[1] / 11;
        promedio[2] = promedio[2] / 11;

        return promedio;
    }

    //========================================================================//
    public ArrayList<Jugador> recorridoVelocidad(Jugador inicial, ArrayList<Jugador> jugadoresFinales) {
        return encontrarCaminoOptimo(inicial, jugadoresFinales, "velocidad");
    }

    public ArrayList<Jugador> recorridoRemate(Jugador inicial, ArrayList<Jugador> jugadoresFinales) {
        return encontrarCaminoOptimo(inicial, jugadoresFinales, "remate");
    }

    public ArrayList<Jugador> recorridoPosesion(Jugador inicial, ArrayList<Jugador> jugadoresFinales) {
        return encontrarCaminoOptimo(inicial, jugadoresFinales, "posesion");
    }

    private ArrayList<Jugador> encontrarCaminoOptimo(Jugador inicial, ArrayList<Jugador> jugadoresFinales, String criterio) {
        int numJugadores = jugadores.size();
        boolean[] visitado = new boolean[numJugadores];
        int[] distancias = new int[numJugadores];
        int[] predecesores = new int[numJugadores]; // Para reconstruir el camino

        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(predecesores, -1);
        int indiceInicial = jugadores.indexOf(inicial);
        distancias[indiceInicial] = 0;

        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>((a, b) -> Integer.compare(distancias[a], distancias[b]));
        colaPrioridad.offer(indiceInicial);

        while (!colaPrioridad.isEmpty()) {
            int indiceActual = colaPrioridad.poll();
            if (visitado[indiceActual]) {
                continue;
            }
            visitado[indiceActual] = true;

            // Si encontramos un jugador final con el camino más corto, detenemos la búsqueda
            if (jugadoresFinales.contains(jugadores.get(indiceActual))) {
                ArrayList<Jugador> caminoOptimo = new ArrayList<>();
                for (int at = indiceActual; at != -1; at = predecesores[at]) {
                    caminoOptimo.add(0, jugadores.get(at)); // Reconstruimos el camino en orden
                }
                return caminoOptimo; // Devolvemos el camino óptimo inmediatamente
            }

            // Relajación de aristas
            for (int i = 0; i < numJugadores; i++) {
                if (matrizAdyacencia[indiceActual][i] != 1 || visitado[i]) {
                    continue;
                }
                int peso = 0;
                switch (criterio) {
                    case "velocidad":
                        peso = jugadores.get(i).getVelocidad();
                        break;
                    case "posesion":
                        peso = jugadores.get(i).getPosesion();
                        break;
                    case "remate":
                        peso = jugadores.get(i).getRemate();
                        break;
                    default:
                        break;
                }
                int nuevaDistancia = distancias[indiceActual] + peso;

                if (nuevaDistancia < distancias[i]) {
                    distancias[i] = nuevaDistancia;
                    predecesores[i] = indiceActual;
                    colaPrioridad.offer(i);
                }
            }
        }

        // Si no se encuentra ningún camino, devolvemos null o una lista vacía
        return null;
    }

    public void imprimirMatriz(int[][] matriz) {
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz1[j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] matrizDistancia(int criterio) {
        int[][] distancias = new int[11][11];
        for (int i = 0; i < 11; i++) {
            Jugador j1 = jugadores.get(i);
            for (int j = 0; j < 11; j++) {
                Jugador j2 = jugadores.get(j);
                if (i == j) {
                    distancias[i][j] = 0;
                } else {
                    int dist = 0;
                    switch (criterio) {
                        case 1:
                            dist = j1.getVelocidad() + j2.getVelocidad();
                            break;
                        case 2:
                            dist = j1.getPosesion() + j2.getPosesion();
                            break;
                        case 3:
                            dist = j1.getRemate() + j1.getRemate();
                            break;
                        default:
                            System.out.println("Criterio inválido.");
                    }
                    distancias[i][j] = dist;
                }
            }
        }
        return distancias;
    }

    public String[][] matrizRecorrido() {
        String[][] matriz = new String[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                matriz[i][j] = jugadores.get(j).getNombre();
            }
        }
        return matriz;
    }
}
