/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.ventas;

/**
 *
 * @author MoriTejo
 */
public class ControlNegocioVentas {
    private IGestorVentas gestor = new GestorVentas();

    public float calcularTotal(float kilos) { 
        return gestor.calcularTotal(kilos); 
    }
    
    public boolean confirmarVenta(float kilos, float efectivo) { 
        return gestor.procesarVenta(kilos, efectivo); 
    }
}
