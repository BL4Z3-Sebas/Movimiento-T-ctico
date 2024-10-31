package modelo;

public class FloydWarshall {

    // Valor infinito para representar la ausencia de una arista
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void floydWarshall(int[][] distancias, String[][] recorrido) {
        int D = distancias.length;

        int[][] distancia_minima = new int[D][D];
        String[][] recorrido_minimo = new String[D][D];

        // Inicializamos la matriz de distancias con los valores del grafo
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < D; j++) {
                distancia_minima[i][j] = distancias[i][j];
                recorrido_minimo[i][j] = recorrido[i][j];
            }
        }

        // Calcular las distancias mínimas entre todos los pares de nodos
        for (int k = 0; k < D; k++) {
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < D; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (distancia_minima[i][k] + distancia_minima[k][j] < distancia_minima[i][j]) {
                        distancia_minima[i][j] = distancia_minima[i][k] + distancia_minima[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias mínimas
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < D; j++) {
                if (distancia_minima[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distancia_minima[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grafo = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

//        floydWarshall(grafo);
    }
}
