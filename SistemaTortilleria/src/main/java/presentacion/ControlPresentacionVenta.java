/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import negocio.GestorVentas;
import negocio.IGestorVentas;

/**
 * @author MoriTejo
 */
public class ControlPresentacionVenta {
    private IGestorVentas gestor;
    
    public ControlPresentacionVenta() {
        this.gestor = new GestorVentas();
    }
    
    public float solicitarCalculo(float kilos) {
        return gestor.calcularTotal(kilos);
    }
    
    public float solicitarCobro(float billete) {
        return gestor.procesarPagoEfectivo(billete);
    }
}