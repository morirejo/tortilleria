/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.cierreCaja;

import datos.cierreCaja.CajaDAO;
import datos.cierreCaja.ICajaDAO;
import dtos.cierreCaja.CorteCajaDTO;

/**
 *
 * @author MoriTejo
 */
public class GestorCaja implements IGestorCaja {
    private ICajaDAO cajaDAO = new CajaDAO();

    @Override
    public CorteCajaDTO generarCorte(float efectivoFisico) {
        float totalVentas = cajaDAO.obtenerTotalVentasDelDia();
        return new CorteCajaDTO(totalVentas, efectivoFisico);
    }

    @Override
    public boolean confirmarCorte(CorteCajaDTO corte) {
        return cajaDAO.guardarCorte(corte);
    }
}