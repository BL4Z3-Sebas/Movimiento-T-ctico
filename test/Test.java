
import java.util.ArrayList;
import modelo.ManejadorEquipos;

public class Test {

    public static void main(String[] args) {
        ManejadorEquipos manejo = new ManejadorEquipos();

        String equipo;
        equipo = (String) manejo.leerEquipoAnterior("Equipo1").get(0).get(0);
        System.out.println(equipo);
        ArrayList a = manejo.leerEquipo("Equipo1");
//        ArrayList lista = manejo.cargarEquipo(equipo);
//        Campo campo = new Campo();
//        ArrayList<String> listavect = (ArrayList<String>) lista.get(2);
//        int[][] generarMatrizAbyasencia = campo.generarMatrizAdyacencia(listavect);
//        campo.creacionFormacion((ArrayList<Jugador>) lista.get(1), generarMatrizAbyasencia);
//
//        campo.imprimirMatriz(generarMatrizAbyasencia);
    }
}
