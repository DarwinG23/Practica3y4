/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.DaoImplement;
import controlador.listas.DynamicList;
import java.util.Date;
import modelo.Venta;

/**
 *
 * @author darwi
 */
public class VentaControl extends DaoImplement<Venta> {
    private DynamicList<Venta> listVenta;
    private Venta venta;

    public VentaControl() {
        super(Venta.class);
    }
    

    public DynamicList<Venta> getListVenta() {
        listVenta = all();
        return listVenta;
    }

    public void setListVenta(DynamicList<Venta> listVenta) {
        this.listVenta = listVenta;
    }

    public Venta getVenta() {
        if (venta == null){
            venta = new Venta();
        }
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public Boolean persist(){
        venta.setId(all().getLength()+1);
        return persist(venta);
    }
    
//    public static void main(String[] args) {
//        VentaControl vc = new VentaControl();
//        vc.getVenta().setComision(30000.00);
//        vc.getVenta().setId_Auto(1);
//        vc.getVenta().setFecha(new Date(2023, 12, 22));
//        vc.getVenta().setTotal(1530000.00);
//        vc.persist();
//        vc.setVenta(null);
//    }
    public DynamicList<Venta> shell(DynamicList<Venta> ventas, String field, Integer tipo) {
        int intervalo, i, j, k;
        Venta aux;
        Venta[] array = ventas.toArray();
        intervalo = array.length / 2;
        while (intervalo > 0) {
            for (i = intervalo; i < array.length; i++) {
                j = i - intervalo;
                while (j >= 0) {
                    k = j + intervalo;
                    if (array[j].compare(array[k], field, tipo) || array[j].compare(array[k], field, 2)) {
                        j = -1;
                    } else {
                        aux = array[j];
                        array[j] = array[k];
                        array[k] = aux;
                        j = j - intervalo;
                    }

                }

            }
            intervalo = intervalo / 2;
        }
        return ventas.toList(array);
    }
    
    public DynamicList<Venta> busquedaLineal (String texto, DynamicList<Venta> ventas, String field) {
        DynamicList<Venta> lista = new DynamicList<>();
        try {
            Venta[] aux = shell(ventas,field, 0).toArray();
            for (Venta v : aux) {
                if (v.buscar(texto, field, 0)) {
                    lista.add(v);
                }
            }

        } catch (Exception e) {
            System.out.println("Error al buscar");
        }
        return lista;
    }
    
}
