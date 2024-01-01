/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author darwi
 */
public class Vendedor {

    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String celular;
    private String ruc;

    public Vendedor(Integer id, String nombre, String apellido, String cedula, String celular, String ruc) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
        this.ruc = ruc;
    }

    public Vendedor() {
        this.id = null;
        this.nombre = null;
        this.apellido = null;
        this.cedula = null;
        this.celular = null;
        this.ruc = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " Cedula: " + cedula;
    }

    public Boolean compare(Vendedor a, String field, Integer type) {
        // 0 menor  1 mayor 2 igual
        switch (type) {
            case 0:
                if (field.equalsIgnoreCase("nombre")) {
                    return nombre.compareTo(a.getNombre()) < 0;
                } else if (field.equalsIgnoreCase("apellido")) {
                    return apellido.compareTo(a.getApellido()) < 0;
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.compareTo(a.getCedula()) < 0;
                } else if (field.equalsIgnoreCase("celular")) {
                    return celular.compareTo(a.getCelular()) < 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() < a.getId().intValue();
                } else if (field.equalsIgnoreCase("ruc")) {
                    return ruc.compareTo(a.getRuc()) < 0;
                }
            case 1:
                if (field.equalsIgnoreCase("nombre")) {
                    return nombre.compareTo(a.getNombre()) > 0;
                } else if (field.equalsIgnoreCase("apellido")) {
                    return apellido.compareTo(a.getApellido()) > 0;
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.compareTo(a.getCedula()) > 0;
                } else if (field.equalsIgnoreCase("celular")) {
                    return celular.compareTo(a.getCelular()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() > a.getId().intValue();
                } else if (field.equalsIgnoreCase("ruc")) {
                    return ruc.compareTo(a.getRuc()) > 0;
                }
            case 2:
                if (field.equalsIgnoreCase("nombre")) {
                    return nombre.equalsIgnoreCase(a.getNombre());
                } else if (field.equalsIgnoreCase("apellido")) {
                    return apellido.equalsIgnoreCase(a.getApellido());
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.equalsIgnoreCase(a.getCedula());
                } else if (field.equalsIgnoreCase("celular")) {
                    return celular.equalsIgnoreCase(a.getCelular());
                } else if (field.equalsIgnoreCase("id")) {
                    return id.intValue() == a.getId().intValue();
                } else if (field.equalsIgnoreCase("ruc")) {
                    return ruc.equalsIgnoreCase(a.getRuc());
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
                if (field.equalsIgnoreCase("nombre")) {
                    return nombre.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("apellido")) {
                    return apellido.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("celular")) {
                    return celular.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("id")) {
                    String idAuto = Integer.toString(id);
                    return idAuto.toLowerCase().contains(texto.toLowerCase());
                } else if (field.equalsIgnoreCase("ruc")) {
                    return ruc.toLowerCase().contains(texto.toLowerCase());
                }
            case 1:
                if (field.equalsIgnoreCase("nombre")) {
                    return nombre.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("apellido")) {
                    return apellido.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("cedula")) {
                    return cedula.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("celular")) {
                    return celular.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("id")) {
                    String idAuto = Integer.toString(id);
                    return idAuto.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                } else if (field.equalsIgnoreCase("ruc")) {
                    return ruc.toLowerCase().compareTo(texto.toLowerCase()) > 0;
                }
            default:
                return null;
        }
    }
}
