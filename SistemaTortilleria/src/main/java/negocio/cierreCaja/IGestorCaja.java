/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.cierreCaja;

import dtos.cierreCaja.CorteCajaDTO;

/**
 *
 * @author MoriTejo
 */
public interface IGestorCaja {
    public CorteCajaDTO generarCorte(float efectivoFisico);
    public boolean confirmarCorte(CorteCajaDTO corte);
}
