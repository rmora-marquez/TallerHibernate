/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm.test;

import orm.data.RelacionesDao;

/**
 *
 * @author user10
 */
public class RelacionesTest {
 
    public static void main(String[] args) {
        RelacionesDao reltest = new RelacionesDao();
        //reltest.ejemploUnoAUno();
        //reltest.ejemploUnoAMuchos();
        reltest.ejemploMuchosAMuchos();
    }
}
