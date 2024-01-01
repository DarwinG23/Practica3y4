/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.dao.DaoImplement;
import controlador.listas.DynamicList;
import modelo.Vendedor;

/**
 *
 * @author darwi
 */
public class VendedorControl extends DaoImplement<Vendedor>{
    private DynamicList<Vendedor> listVendedor;
    private Vendedor vendedor;

    public VendedorControl() {
        super(Vendedor.class);
    }
    

    public DynamicList<Vendedor> getListVendedor() {
        listVendedor = all();
        return listVendedor;
    }

    public void setListVendedor(DynamicList<Vendedor> ListTipoCasa) {
        this.listVendedor= ListTipoCasa;
    }

    public Vendedor getVendedor() {
        if (vendedor == null){
            vendedor = new Vendedor();
        }
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public Boolean persist(){
        vendedor.setId(all().getLength()+1);
        return persist(vendedor);
    }
    
//    public static void main(String[] args) {
//        VendedorControl vc = new VendedorControl();
//        vc.getVendedor().setNombre("Darwin");
//        vc.getVendedor().setApellido("Granda");
//        vc.getVendedor().setCelular("0979411882");
//        vc.getVendedor().setCedula("1106006123");
//        vc.getVendedor().setRuc("0294627248 001");
//        vc.persist();
//        vc.setVendedor(null);
//    }
    
    public DynamicList<Vendedor> shell (DynamicList<Vendedor> vendedores, String field, Integer tipo){
        int intervalo, i, j,k; 
        Vendedor aux;
        Vendedor[] array = vendedores.toArray();
        intervalo = array.length/2;
        while(intervalo>0){
            for(i =intervalo; i < array.length; i++){
                j = i - intervalo;
                while(j >= 0){
                    k = j + intervalo;
                    if (array[j].compare(array[k], field, tipo)||array[j].compare(array[k], field, 2)) {
                        j=-1;   
                    }else{
                        aux = array[j];
                        array[j] = array[k];
                        array[k] = aux;
                        j = j - intervalo;
                    }
                    
                }
                
            }
            intervalo = intervalo/2;
        }       
        return vendedores.toList(array);
    }
    
    public DynamicList<Vendedor> busquedaLineal (String texto, DynamicList<Vendedor> vendedores, String field) {
        DynamicList<Vendedor> lista = new DynamicList<>();
        try {
            Vendedor[] aux = shell(vendedores,field, 0).toArray();
            for (Vendedor v : aux) {
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
