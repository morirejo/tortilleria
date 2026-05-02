/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.GregorianCalendar;
import dtos.VentaDTO;
import datos.IVentaDAO;
import datos.VentaDAOMock;

/**
 * @author MoriTejo
 */
public class GestorVentas implements IGestorVentas{
    private float precioPorKG = 27.0f;
    private float totalCalculado = 0.0f;
    private float cantidadKGCapturada = 0.0f;
    
    private IVentaDAO ventaDAO;

    public GestorVentas() {
        this.ventaDAO = new VentaDAOMock();
    }

    @Override
    public float calcularTotal(float cantidadKG) {
        this.cantidadKGCapturada = cantidadKG;
        this.totalCalculado = cantidadKG * precioPorKG;
        return this.totalCalculado;
    }

    @Override
    public float procesarPagoEfectivo(float montoRecibido) {
        if(montoRecibido >= this.totalCalculado) {
            float cambio = montoRecibido - this.totalCalculado;
            
            VentaDTO nuevaVenta = new VentaDTO(1, this.cantidadKGCapturada, this.totalCalculado, new GregorianCalendar());
            
            ventaDAO.guardarVenta(nuevaVenta);
            
            return cambio;
        }
        return -1; 
    }
}
