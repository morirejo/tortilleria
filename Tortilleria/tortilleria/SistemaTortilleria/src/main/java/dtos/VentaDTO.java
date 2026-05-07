/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author MoriTejo
 */
public class VentaDTO {
    private int idVenta;
    private double cantidadKG;
    private double montoTotal;
    private LocalDate fecha;

    public VentaDTO() {
    }

    public VentaDTO(int idVenta, double cantidadKG, double montoTotal, LocalDate fecha) {
        this.idVenta = idVenta;
        this.cantidadKG = cantidadKG;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public double getCantidadKG() {
        return cantidadKG;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setCantidadKG(double cantidadKG) {
        this.cantidadKG = cantidadKG;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
