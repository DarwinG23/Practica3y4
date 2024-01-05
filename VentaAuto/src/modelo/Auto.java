/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author darwi
 */
public class Auto {
    
    private Integer id;
    private String color;
    private Double precio;
    private String marca;
    private String estado;
    
    public Auto(Integer id, String color, Double precio, String marca, String estado) {
        this.id = id;
        this.color = color;
        this.precio = precio;
        this.marca = marca;
        this.estado = estado;
    }
    
    public Auto() {
        this.id = null;
        this.color = null;
        this.precio = null;
        this.marca = null;
        this.estado = null;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Codigo: " + id + " Precio: " + precio;
    }
    
    public Boolean compare(Auto a, String field, Integer type) {
        // 0 menor  1 mayor 2 igual
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("marca")) {
                    return marca.compareTo(a.getMarca()) < 0;
                } else if (field.equalsIgnoreCase("color")) {
                    return color.compareTo(a.getColor()) < 0;
                } else if (field.equalsIgnoreCase("estado")) {
                    return estado.compareTo(a.getEstado()) < 0;
                } else if (field.equalsIgnoreCase("precio")) {
                    return Double.compare(precio.doubleValue(), a.getPrecio()) < 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() < a.getId().intValue();
                }
            case 1:
                if (field.equalsIgnoreCase("marca")) {
                    return marca.compareTo(a.getMarca()) > 0;
                } else if (field.equalsIgnoreCase("color")) {
                    return color.compareTo(a.getColor()) > 0;
                } else if (field.equalsIgnoreCase("estado")) {
                    return estado.compareTo(a.getEstado()) > 0;
                } else if (field.equalsIgnoreCase("precio")) {
                    return Double.compare(precio.doubleValue(), a.getPrecio()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() > a.getId().intValue();
                }
            case 2:
                if (field.equalsIgnoreCase("marca")) {
                    return marca.equalsIgnoreCase(a.getMarca());
                } else if (field.equalsIgnoreCase("color")) {
                    return color.equalsIgnoreCase(a.getColor());
                } else if (field.equalsIgnoreCase("estado")) {
                    return estado.equalsIgnoreCase(a.getEstado());
                } else if (field.equalsIgnoreCase("precio")) {
                    return Double.compare(precio.doubleValue(), a.getPrecio()) == 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() == a.getId().intValue();
                }
            
            default:
                return null;
        }
    }
    
    public Boolean buscar(String texto, String field, Integer tipo) {
        // 0 igual  1 menor
        field.toLowerCase();
        switch (tipo){
            case 0:
                if (field.equalsIgnoreCase("marca")) {
                    return marca.contains(texto);
                } else if (field.equalsIgnoreCase("color")) {
                    return color.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("estado")) {
                    return estado.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("precio")) {
                    String precioAuto = Double.toString(precio);
                    return precioAuto.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("id")) {
                    String idAuto = Integer.toString(id);
                    return idAuto.toLowerCase().contains(texto.toLowerCase());
                } else {
                    return false;
                }
            case 1:
                if (field.equalsIgnoreCase("marca")) {
                    return marca.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("color")) {
                    System.out.println(color);
                    System.out.println(texto);
                    return color.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("estado")) {
                    return estado.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("precio")) {
                    String precioAuto = Double.toString(precio);
                    return precioAuto.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    String idAuto = Integer.toString(id);
                    return idAuto.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else {
                    return false;
                }           
            default:
                return null;
        }
    }
    
}
