package controlador; 

import modelo.ManejadorEquipos;
import recursos.Main;

/**
 *
 * @author Alfonso
 */
public class Controlador {
    
    private Main vista;
    private ManejadorEquipos modelo;

    public Controlador(Main vista, ManejadorEquipos modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    
    
}
