/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm.test;

import java.util.List;
import orm.data.ProductosDao;
import orm.persistencia.Producto;

/**
 *
 * @author user10
 */
public class ProductosTest {
    
    public static void main(String[] args) {        
        ProductosDao pdao = new ProductosDao();
        List<Producto> lista = pdao.findAll();
        for(Producto p : lista){
            System.out.println(p.toString());
        }        
        pdao.ejemploLeer();
                
        List<Producto> lista2 = pdao.buscarPorPrecio(140.0);
        for(Producto p : lista2){
            System.out.println(p.toString());
        } 
        
        List<Producto> lista3 = pdao.buscarOrdenAsc();
        for(Producto p : lista3){
            System.out.println(p.toString());
        } 
        
        List<Producto> lista4 = pdao.masHql();
        for(Producto p : lista4){
            System.out.println(p.toString());
        } 
       
    }
    
}
