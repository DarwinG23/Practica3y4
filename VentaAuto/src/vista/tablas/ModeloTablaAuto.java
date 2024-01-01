/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.listas.DynamicList;
import exeption.EmptyException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelo.Auto;

/**
 *
 * @author darwi
 */
public class ModeloTablaAuto extends AbstractTableModel{
    private DynamicList<Auto> autos;

    @Override
    public int getRowCount() {
        return autos.getLength();
    }

    @Override
    public int getColumnCount() { //Agregar columnas
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto v;
        try {
            v = (Auto) autos.getInfo(rowIndex);
            switch (columnIndex) {
                case 0:
                    return (v != null) ? v.getId() : " ";
                case 1:
                    return (v != null) ? v.getColor() : " ";
                case 2:
                    return (v != null) ? v.getMarca() : "";
                case 3:
                    return (v != null) ? v.getPrecio() : "";
                 case 4:
                    return (v != null) ? v.getEstado(): "";
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
                return "ID";
            case 1:
                return "COLOR";
            case 2:
                return "MARCA";
            case 3:
                return "PRECIO";
            case 4:
                return "ESTADO";
            default:
                return null;
        }
    }

    /**
     * @return the personas
     */
    public DynamicList getAutos() {
        return autos;
    }

    /**
     *
     * @param autos
     */
    public void setAutos(DynamicList autos) {
        this.autos = autos;
    }
    
}
