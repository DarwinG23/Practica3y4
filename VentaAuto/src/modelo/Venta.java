/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author darwi
 */
public class Venta {
    private Integer id;
    private Date fecha;
    private Double comision;
    private Integer id_Auto;
    private Double total;
    private Integer id_Vendedor;

    public Venta(Integer id, Date fecha, Double comision, Integer id_Auto, Double total, Integer id_Vendedor) {
        this.id = id;
        this.fecha = fecha;
        this.comision = comision;
        this.id_Auto = id_Auto;
        this.total = total;
        this.id_Vendedor = id_Vendedor;
    }

    

    public Venta() {
        this.id = null;
        this.fecha = null;
        this.comision = null;
        this.id_Auto = null;
        this.total = null;
        this.id_Vendedor = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Integer getId_Auto() {
        return id_Auto;
    }

    public void setId_Auto(Integer id_Auto) {
        this.id_Auto = id_Auto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta: "+ id;
    } 

    public Integer getId_Vendedor() {
        return id_Vendedor;
    }

    public void setId_Vendedor(Integer id_Vendedor) {
        this.id_Vendedor = id_Vendedor;
    }
    
    
    
    public Boolean compare(Venta a, String field, Integer type) {
        // 0 menor  1 mayor 2 igual
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("comision")) {
                    return Double.compare(comision.doubleValue(), a.getComision()) < 0;
                } else if (field.equalsIgnoreCase("id_Auto")) {
                    return id_Auto.intValue() < a.getId_Auto().intValue();
                } else if (field.equalsIgnoreCase("total")) {
                    return Double.compare(total.doubleValue(), a.getTotal()) < 0;
                } else if (field.equalsIgnoreCase("fecha")) {
                    return fecha.compareTo(a.getFecha()) < 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() < a.getId().intValue();
                } else if (field.equalsIgnoreCase("id")) {
                    return id_Vendedor.intValue() < a.getId_Vendedor().intValue();
                }
            case 1:
                if (field.equalsIgnoreCase("comision")) {
                    return Double.compare(comision.doubleValue(), a.getComision()) > 0;
                } else if (field.equalsIgnoreCase("id_Auto")) {
                    return id_Auto.intValue() > a.getId_Auto().intValue();
                } else if (field.equalsIgnoreCase("total")) {
                    return Double.compare(total.doubleValue(), a.getTotal()) > 0;
                } else if (field.equalsIgnoreCase("fecha")) {
                    return fecha.compareTo(a.getFecha()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() > a.getId().intValue();
                }else if (field.equalsIgnoreCase("id")) {
                    return id_Vendedor.intValue() > a.getId_Vendedor().intValue();
                }
            case 2:
                if (field.equalsIgnoreCase("comision")) {
                    return Double.compare(comision.doubleValue(), a.getComision()) == 0;
                } else if (field.equalsIgnoreCase("id_Auto")) {
                    return id_Auto.intValue() == a.getId_Auto().intValue();
                } else if (field.equalsIgnoreCase("total")) {
                    return Double.compare(total.doubleValue(), a.getTotal()) == 0;
                } else if (field.equalsIgnoreCase("fecha")) {
                    return fecha.compareTo(a.getFecha()) == 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() == a.getId().intValue();
                }else if (field.equalsIgnoreCase("id_Vendedor")) {
                    return id_Vendedor.intValue() == a.getId_Vendedor().intValue();
                }
            default:
                return null;
        }
    }
    
    public Boolean buscar(String texto, String field, Integer tipo) {
        // 0 igual  1 menor
        System.out.println("field" + field);
        System.out.println("tipo" + tipo);
        field.toLowerCase();
        switch (tipo) {
            case 0:
                if (field.equalsIgnoreCase("comision")) {
                    String comisionString = Double.toString(comision);
                    return comisionString.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("id_Auto")) {
                    String idVenta = Integer.toString(id_Auto);
                    return idVenta.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("total")) {
                    String totalString = Double.toString(total);
                    return totalString.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("fecha")) {
                    String fechaString = fecha.toString();
                    return fechaString.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("id")) {
                    String idVenta = Integer.toString(id);
                    return idVenta.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("id_Vendedor")) {
                    String idVendedor = Integer.toString(id_Vendedor);
                    return idVendedor.toLowerCase().contains(texto.toLowerCase());
                }
            default:
                return null;
        }
    }
}
