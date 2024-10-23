package vista;

import Modelo.ManejadorEquipos;

/**
 *
 * @author andre
 */
public class Movimiento_Tactico {

    public static void main(String[] args) {
        System.out.println(ManejadorEquipos.equipoSiguiente("Equipo7"));
        System.out.println(ManejadorEquipos.equipoAnterior("Equipo7"));
    }    
}
