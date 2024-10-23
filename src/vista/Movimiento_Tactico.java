package vista; 

import modelo.ManejadorEquipos;

/**
 *
 * @author andre
 */
public class Movimiento_Tactico {

    public static void main(String[] args) {
        System.out.println(ManejadorEquipos.equipoSiguiente(null));
        System.out.println(ManejadorEquipos.equipoAnterior("Equipo1"));
    }    
}
