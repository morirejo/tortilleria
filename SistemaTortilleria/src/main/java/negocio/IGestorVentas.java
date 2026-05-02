/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

/**
 *
 * @author MoriTejo
 */
public interface IGestorVentas {
    public float calcularTotal(float cantidadKG);
    public float procesarPagoEfectivo(float montoRecibido);
}
