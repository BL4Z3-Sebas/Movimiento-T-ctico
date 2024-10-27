package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author andre
 */
public class Campo {

    ArrayList<Jugador> Jugadores;
    public static int[][] matrizAdyacencia;

    public Campo() {
        this.Jugadores = new ArrayList<>();
//        matrizAdyacencia = new int[11][11];
    }

    // Método para agregar un jugador a la lista
    public void addJugador(Jugador jugador) {
        Jugadores.add(jugador);
    }

    // Método para obtener un jugador por su nombre de manera iterativa
    public Jugador getJugador(String nombre) {
        for (Jugador jugador : Jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;  // Retorna null si no se encuentra el jugador
    }

    // Método para realizar el recorrido basado en velocidad
    // Método para realizar el recorrido hacia varios posibles jugadores finales basado en velocidad
    public ArrayList<Jugador> recorridoVelocidad(String nombre1, ArrayList<String> nombresFinales) {
        Jugador jugadorInicial = getJugador(nombre1);
        ArrayList<Jugador> jugadoresFinales = new ArrayList<>();

        for (String nombreFinal : nombresFinales) {
            Jugador jugadorFinal = getJugador(nombreFinal);
            if (jugadorFinal != null) {
                jugadoresFinales.add(jugadorFinal);
            }
        }

        if (jugadorInicial == null || jugadoresFinales.isEmpty()) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarMejorCaminoOptimo(jugadorInicial, jugadoresFinales, "velocidad");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }

// Método para encontrar el mejor camino óptimo hacia múltiples jugadores finales
    private ArrayList<Jugador> encontrarMejorCaminoOptimo(Jugador jugadorInicial, ArrayList<Jugador> jugadoresFinales, String criterio) {
        int numJugadores = Jugadores.size();
        boolean[] visitado = new boolean[numJugadores];
        int[] distancias = new int[numJugadores];
        int[] predecesores = new int[numJugadores]; // Para reconstruir el camino

        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(predecesores, -1);
        int indiceInicial = Jugadores.indexOf(jugadorInicial);
        distancias[indiceInicial] = 0;

        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>((a, b) -> Integer.compare(distancias[a], distancias[b]));
        colaPrioridad.offer(indiceInicial);

        while (!colaPrioridad.isEmpty()) {
            int indiceActual = colaPrioridad.poll();
            if (visitado[indiceActual]) {
                continue;
            }
            visitado[indiceActual] = true;

            for (int i = 0; i < numJugadores; i++) {
                if (matrizAdyacencia[indiceActual][i] == 1 && !visitado[i]) {
                    int peso = 0;
                    switch (criterio) {
                        case "velocidad":
                            peso = Jugadores.get(i).getVelocidad();
                            break;
                        case "posesión":
                            peso = Jugadores.get(i).getPosesion();
                            break;
                        case "remate":
                            peso = Jugadores.get(i).getRemate();
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
        }

        // Encontrar el mejor camino a cualquier jugador final
        ArrayList<Jugador> mejorCamino = null;
        int mejorDistancia = Integer.MAX_VALUE;
        for (Jugador jugadorFinal : jugadoresFinales) {
            ArrayList<Jugador> caminoActual = new ArrayList<>();
            int indiceFinal = Jugadores.indexOf(jugadorFinal);
            for (int at = indiceFinal; at != -1; at = predecesores[at]) {
                caminoActual.add(0, Jugadores.get(at)); // Agregar al principio
            }

            // Verificar si se encontró un camino y comparar distancias
            if (!caminoActual.isEmpty() && caminoActual.get(0).equals(jugadorInicial)) {
                int distanciaFinal = distancias[indiceFinal];
                if (distanciaFinal < mejorDistancia) {
                    mejorDistancia = distanciaFinal;
                    mejorCamino = caminoActual;
                }
            }
        }

        return mejorCamino;
    }

//    public void recorridoVelocidad(String nombre1, String nombre2) {
//        Camino camino = new Camino();
//        Jugador jugadori = this.getJugador(nombre1);
//        Jugador jugadorf = this.getJugador(nombre2);
//        recorridoVelocidadRecursivo(nombre1, nombre2, camino, 0);
//
//    }
    public static int[][] generarMatrizAdyacencia(ArrayList<String> equipos) {
        int[][] matriz = new int[11][11];
        for (String equipo : equipos) {
            String[] marcas = equipo.split(",");

            for (int i = 1; i < equipos.size(); i++) {
                matriz[equipos.indexOf(equipo)][i - 1] = Integer.parseInt(marcas[i]);
            }
        }
        return matriz;
    }

    public void creacionFormacion(ArrayList<Jugador> jugadores, int[][] matriz) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] == 1) {
                    jugadores.get(i).addJugador(jugadores.get(j));
                }
            }
        }

    }

    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
//
//    public void recorridoVelocidadRecursivo(String nombre1, String nombre2, Camino camino, int i) {
//
//    }

// Método para realizar el recorrido hacia varios posibles jugadores finales basado en remate
    public ArrayList<Jugador> recorridoRemate(String nombre1, ArrayList<String> nombresFinales) {
        Jugador jugadorInicial = getJugador(nombre1);
        ArrayList<Jugador> jugadoresFinales = new ArrayList<>();

        for (String nombreFinal : nombresFinales) {
            Jugador jugadorFinal = getJugador(nombreFinal);
            if (jugadorFinal != null) {
                jugadoresFinales.add(jugadorFinal);
            }
        }

        if (jugadorInicial == null || jugadoresFinales.isEmpty()) {
            System.out.println("Jugador no encontrado.");
            return null;
        }

        ArrayList<Jugador> caminoOptimo = encontrarMejorCaminoOptimo(jugadorInicial, jugadoresFinales, "remate");

        // Devolver el camino (o realizar otras acciones)
        return caminoOptimo;
    }
}
