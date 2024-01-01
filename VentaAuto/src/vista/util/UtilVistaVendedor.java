/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.util;

import controlador.VendedorControl;
import exeption.EmptyException;
import javax.swing.JComboBox;
import modelo.Vendedor;

/**
 *
 * @author darwi
 */
public class UtilVistaVendedor {
    public static void cargarcomboVendedor(JComboBox cbx) throws EmptyException {
        VendedorControl cc = new VendedorControl();
        cbx.removeAllItems();
        if (cc.getListVendedor().isEmpty()) {
            throw new EmptyException("No hay vendedores que mostrar");
        } else {
            for (int i = 0; i < cc.getListVendedor().getLength(); i++) {
                cbx.addItem(cc.getListVendedor().getInfo(i));
            }
        }
    }

    public static Vendedor obtenerVendedor(JComboBox cbx) {
        return (Vendedor) cbx.getSelectedItem();
    }
    
}
