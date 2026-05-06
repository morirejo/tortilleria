/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.ventas.ControlNegocioVentas;
import negocio.ventas.GestorVentas;
import negocio.ventas.IGestorVentas;

/**
 * @author MoriTejo
 */
public class ControlPresentacionVenta {
    private ControlNegocioVentas controlNegocio;
    private float kilosActuales;
    private float totalActual;

    public ControlPresentacionVenta() {
        this.controlNegocio = new ControlNegocioVentas();
    }

    // login a Comprar Tortillas
    public void navegarAPantallaVenta(JFrame pantallaAnterior) {
        if(pantallaAnterior != null) pantallaAnterior.dispose();
        new PantallaVenta(this).setVisible(true);
    }

    // calcular total en la pantalla de compras
    public float calcularTotal(float kilos) {
        this.kilosActuales = kilos;
        this.totalActual = controlNegocio.calcularTotal(kilos);
        return this.totalActual;
    }

    // comprar Tortillas a metodo pago
    public void navegarAPantallaPago(JFrame pantallaActual) {
        int respuesta = JOptionPane.showConfirmDialog(pantallaActual, "¿Desea continuar con el pago?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (respuesta == JOptionPane.YES_OPTION) {
            pantallaActual.dispose();
            new PantallaMetodoPago(this).setVisible(true);
        }
    }

    // guardar venta y a la Pantalla de Éxito
    public void solicitarCobro(float efectivoRecibido, JFrame pantallaActual) {
        if (efectivoRecibido >= totalActual) {
            boolean exito = controlNegocio.confirmarVenta(kilosActuales, efectivoRecibido);
            if (exito) {
                pantallaActual.dispose();
                new PantallaExito(this, kilosActuales, totalActual).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(pantallaActual, "Error al guardar en la base de datos.");
            }
        } else {
            JOptionPane.showMessageDialog(pantallaActual, "El pago ingresado es insuficiente.");
        }
    }

    // pantalla de Éxito de regreso a Comprar Tortillas
    public void finalizarYReiniciar(JFrame pantallaActual) {
        this.kilosActuales = 0;
        this.totalActual = 0;
        pantallaActual.dispose();
        navegarAPantallaVenta(null);
    }
}