/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Util.Util;
import controlador.dao.DaoImplement;
import controlador.listas.DynamicList;
import java.lang.reflect.Field;
import modelo.Auto;

/**
 *
 * @author darwi
 */
public class AutoControl extends DaoImplement<Auto> {

    private DynamicList<Auto> listAuto;
    private Auto auto;

    public AutoControl() {
        super(Auto.class);
    }

    public DynamicList<Auto> getListAuto() {
        listAuto = all();
        return listAuto;
    }

    public void setListAuto(DynamicList<Auto> ListC) {
        this.listAuto = ListC;
    }

    public Auto getAuto() {
        if (auto == null) {
            auto = new Auto();
        }
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Boolean persist() {
        auto.setId(all().getLength() + 1);
        return persist(auto);
    }

//    public static void main(String[] args) {
//        AutoControl ac = new AutoControl();
//        ac.getAuto().setColor("Azul");
//        ac.getAuto().setMarca("Audi");
//        ac.getAuto().setPrecio(120500.00);
//        ac.getAuto().setEstado("COMPRADO");
//        ac.persist();
//        ac.setAuto(null);
//                
//    }
    
    public DynamicList<Auto> ordenar(DynamicList<Auto> autos, String field, Integer tipo) {
        Auto[] array = autos.toArray();
        Field atribute = Util.getField(Auto.class, field);
        if (field != null) {
            array = quicksort(array, 0, array.length -1 , field, tipo);
        }
        return autos.toList(array);
    }

    public Auto[] quicksort (Auto[] array, int izq, int der, String field, Integer tipo) {
        if (izq >= der) {
            return array;
        }
        int i = izq, d = der;
        if (izq != der) {
            int pivote = izq;
            Auto aux;
            while (izq != der) {
                if(tipo == 0){
                    while ((array[der].compare(array[pivote], field, 1) || array[der].compare(array[pivote], field, 2)) && izq < der) {
                        der--;
                        while (array[izq].compare(array[pivote], field, 0) && izq < der) {
                            izq++;
                        }
                    }
                    if (izq != der) {
                        aux = array[der];
                        array[der] = array[izq];
                        array[izq] = aux;
                    }
                }else if(tipo == 1){
                    while ((array[der].compare(array[pivote], field, 0) || array[der].compare(array[pivote], field, 2)) && izq < der) {
                        der--;
                        while (array[izq].compare(array[pivote], field, 1) && izq < der) {
                            izq++;
                        }
                    }
                    if (izq != der) {
                        aux = array[izq];
                        array[izq] = array[der];
                        array[der] = aux;
                    }
                }  
                if (izq == der) {
                    quicksort(array, i, izq-1, field, tipo);
                    quicksort(array, izq+1,d,field, tipo);
                }
            }          
        }
        return array;
    }
    
    public DynamicList<Auto> busquedaBinaria(DynamicList<Auto> autos, String texto, String field){
        int centro, primero, ultimo;
        DynamicList<Auto> lista = new DynamicList<>();
        Auto[] array = ordenar(autos, field, 0).toArray();
        Auto valorCentro;
        primero = 0;
        ultimo =  array.length - 1;
        while(primero <= ultimo){
            centro = (primero + ultimo) / 2;
            valorCentro = array[centro];
            if(valorCentro.buscar(texto, field, 0)){
                lista.add(valorCentro);
            }
            if (valorCentro.buscar(texto, field, 1)){
                ultimo = centro - 1; //Desplaza a la izquierda
            }else{
                primero = centro + 1; //Desplaza a la derecha
            }   
        }
        return lista;    
    }
    
    
    public DynamicList<Auto> busquedaLineal (String texto, DynamicList<Auto> vendedores, String field) {
        DynamicList<Auto> lista = new DynamicList<>();
        try {
            Auto[] aux = ordenar(vendedores,field, 0).toArray();
            for (Auto v : aux) {
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
