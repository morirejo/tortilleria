/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.GregorianCalendar;
import dtos.VentaDTO;

/**
 *
 * @author MoriTejo
 */
public class GestorVentas implements IGestorVentas{
    private float precioPorKG = 27.0f; // Asignamos un precio base de 27 pesos el kilo
    private float totalCalculado = 0.0f;
    private float cantidadKGCapturada = 0.0f;

    public GestorVentas() {
    }

    @Override
    public float calcularTotal(float cantidadKG) {
        this.cantidadKGCapturada = cantidadKG;
        this.totalCalculado = cantidadKG * precioPorKG;
        
        return this.totalCalculado;
    }

    @Override
    public float procesarPagoEfectivo(float montoRecibido) {
        float cambio = montoRecibido - this.totalCalculado;
        
        return cambio;
    }
}
