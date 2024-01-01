/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.listas.DynamicList;
import exeption.EmptyException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelo.Vendedor;

/**
 *
 * @author darwi
 */
public class ModeloTablaVendedor extends AbstractTableModel {

    private DynamicList<Vendedor> vendedores;

    @Override
    public int getRowCount() {
        return vendedores.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendedor v;
        try {
            v = (Vendedor) vendedores.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (v != null) ? v.getCedula() : " ";
                case 1:
                    return (v != null) ? v.getApellido() : " ";
                case 2:
                    return (v != null) ? v.getNombre() : "";
                case 3:
                    return (v != null) ? v.getRuc() : "";
                case 4:
                    return (v != null) ? v.getCelular() : "";
                case 5:
                    return (v != null) ? v.getId() : "";
                default:
                    return null;
            }
        } catch (EmptyException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener la información. Por favor, inténtelo de nuevo o contacte al soporte.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "CEDULA";
            case 1:
                return "APELLIDO";
            case 2:
                return "NOMBRE";
            case 3:
                return "RUC";
            case 4:
                return "CELULAR";
            case 5:
                return "ID";
            default:
                return null;
        }
    }

    /**
     * @return the personas
     */
    public DynamicList getVendedores() {
        return vendedores;
    }

    /**
     *
     * @param vendedores
     */
    public void setVendedores(DynamicList vendedores) {
        this.vendedores = vendedores;
    }

}
