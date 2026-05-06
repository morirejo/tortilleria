/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos.cierreCaja;

import java.util.Date;

/**
 *
 * @author MoriTejo
 */
public class CorteCajaDTO {
    private float totalEsperado;
    private float totalContado;
    private float diferencia;
    private Date fechaHora;

    public CorteCajaDTO(float totalEsperado, float totalContado) {
        this.totalEsperado = totalEsperado;
        this.totalContado = totalContado;
        this.diferencia = totalContado - totalEsperado;
        this.fechaHora = new Date();
    }

    public CorteCajaDTO() {
    }

    public float getTotalEsperado() {
        return totalEsperado;
    }

    public void setTotalEsperado(float totalEsperado) {
        this.totalEsperado = totalEsperado;
    }

    public float getTotalContado() {
        return totalContado;
    }

    public void setTotalContado(float totalContado) {
        this.totalContado = totalContado;
    }

    public float getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(float diferencia) {
        this.diferencia = diferencia;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
       
}
