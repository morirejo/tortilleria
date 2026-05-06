/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 *
 * @author MoriTejo
 */
public class VentaDTO {
    private int idVenta;
    private float cantidadKG;
    private float montoTotal;
    private Date fecha;

    public VentaDTO() {
    }

    public VentaDTO(int idVenta, float cantidadKG, float montoTotal) {
        this.idVenta = idVenta;
        this.cantidadKG = cantidadKG;
        this.montoTotal = montoTotal;
        this.fecha = new Date();;
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

    public Date getFecha() {
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
