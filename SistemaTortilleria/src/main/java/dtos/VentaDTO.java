/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.GregorianCalendar;

/**
 *
 * @author MoriTejo
 */
public class VentaDTO {
    private int idVenta;
    private float cantidadKG;
    private float montoTotal;
    private GregorianCalendar fecha;

    public VentaDTO() {
    }

    public VentaDTO(int idVenta, float cantidadKG, float montoTotal, GregorianCalendar fecha) {
        this.idVenta = idVenta;
        this.cantidadKG = cantidadKG;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public float getCantidadKG() {
        return cantidadKG;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setCantidadKG(float cantidadKG) {
        this.cantidadKG = cantidadKG;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
}
