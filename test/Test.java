import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import modelo.Campo;
import modelo.Jugador;
import modelo.ManejadorEquipos;

public class Test {
    public static void main(String[] args) {
ManejadorEquipos manejo=new ManejadorEquipos();
        
        String equipo=manejo.equipoSiguiente("Equipo1");
        ArrayList lista=manejo.cargarEquipo(equipo); 
        Campo campo=new Campo();
        ArrayList<String> listavect=(ArrayList<String>) lista.get(2);
        int[][] generarMatrizAbyasencia = campo.generarMatrizAdyasencia(listavect);
        campo.creacionFormacion((ArrayList<Jugador>)lista.get(1), generarMatrizAbyasencia);
       
        campo.imprimirMatriz(generarMatrizAbyasencia);
    }
}
