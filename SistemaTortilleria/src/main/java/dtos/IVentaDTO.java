/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dtos;

import java.util.GregorianCalendar;

/**
 *
 * @author MoriTejo
 */
public interface IVentaDTO {
    public int getIdVenta();
    public float getCantidadKG();
    public float getMontoTotal();
    public GregorianCalendar getFecha();
}
