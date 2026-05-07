/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.ventas;

import java.util.GregorianCalendar;
import dtos.VentaDTO;
import datos.IVentaDAO;
import datos.VentaDAO;
import datos.VentaDAOMock;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author MoriTejo
 */
public class GestorVentas implements IGestorVentas{
    private IVentaDAO ventaDAO = new VentaDAO();
    private final double PRECIO_KG = 27.00;

    @Override
    public double calcularTotal(double kilos) { 
        return kilos * PRECIO_KG; 
    }

    @Override
    public boolean procesarVenta(double kilos, double efectivoRecibido) {
        double total = calcularTotal(kilos);
        
        if (efectivoRecibido >= total) {
            int folioVenta = (int) (Math.random() * 900000) + 100000;
            LocalDate fechaActual = LocalDate.now();
            VentaDTO dto = new VentaDTO(folioVenta, kilos, total, fechaActual);
            return ventaDAO.guardarVenta(dto); 
        }
        return false; 
    }
    
    @Override
    public double calcularTotaldeVentas(List<VentaDTO> ventas) {
        return ventas.stream().mapToDouble(VentaDTO::getMontoTotal).sum();
    }

    public double calcularKilosTotales(List<VentaDTO> ventas) {
        return ventas.stream().mapToDouble(VentaDTO::getCantidadKG).sum();
    }   
}
