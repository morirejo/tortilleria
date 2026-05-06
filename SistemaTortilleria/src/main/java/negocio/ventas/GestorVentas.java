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
import java.util.Date;

/**
 * @author MoriTejo
 */
public class GestorVentas implements IGestorVentas{
    private IVentaDAO ventaDAO = new VentaDAO();
    private final float PRECIO_KG = 27.0f;

    @Override
    public float calcularTotal(float kilos) { 
        return kilos * PRECIO_KG; 
    }

    @Override
    public boolean procesarVenta(float kilos, float efectivoRecibido) {
        float total = calcularTotal(kilos);
        
        if (efectivoRecibido >= total) {
            int folioVenta = (int) (Math.random() * 900000) + 100000; 
            VentaDTO dto = new VentaDTO(folioVenta, kilos, total);
            return ventaDAO.guardarVenta(dto); 
        }
        return false; 
    }
}
