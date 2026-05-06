/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.cierreCaja.CorteCajaDTO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.cierreCaja.ControlNegocioCierre;

/**
 *
 * @author MoriTejo
 */
public class ControlPresentacionCierre {
    private ControlNegocioCierre controlNegocio = new ControlNegocioCierre();
    private CorteCajaDTO corteTemporal;

    public void iniciarCierreCaja() {
        // PantallaCierreCaja
    }

    public void procesarConteo(float efectivoFisico, JFrame pantallaAnterior) {
        this.corteTemporal = controlNegocio.calcularCierre(efectivoFisico);
        pantallaAnterior.dispose(); 
        // antallaResumenCierr
    }

    public void confirmarYGuardarCierre(JFrame pantallaAnterior) {
        boolean exito = controlNegocio.guardarCierre(this.corteTemporal);
        if(exito) {
            JOptionPane.showMessageDialog(pantallaAnterior, "Corte guardado en MongoDB exitosamente.");
            pantallaAnterior.dispose();
        }
    }
}
