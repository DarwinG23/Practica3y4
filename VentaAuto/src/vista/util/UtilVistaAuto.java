/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.util;

import controlador.AutoControl;
import exeption.EmptyException;
import javax.swing.JComboBox;
import modelo.Auto;

/**
 *
 * @author darwi
 */
public class UtilVistaAuto {
    public static void cargarcomboAuto(JComboBox cbx) throws EmptyException {
        AutoControl cc = new AutoControl();
        cbx.removeAllItems();
        if (cc.getListAuto().isEmpty()) {
            throw new EmptyException("No hay Autos que mostrar");
        } else {
            for (int i = 0; i < cc.getListAuto().getLength(); i++) {
                if(cc.getListAuto().getInfo(i).getEstado().equalsIgnoreCase("DISPONIBLE")){
                    cbx.addItem(cc.getListAuto().getInfo(i));
                }   
            }
        }
    }

    public static Auto obtenerAuto(JComboBox cbx) {
        return (Auto) cbx.getSelectedItem();
    }
    
}
