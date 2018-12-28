/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontactos;

import java.util.Comparator;

/**
 *
 * @author admin1
 */
public class ordenadoapellidonombre implements Comparator<Contacto>{



    @Override
    public int compare(Contacto t, Contacto t1) {
        if(t.getApellidos().compareToIgnoreCase(t1.getApellidos())==0){
            return t.getNombre().compareToIgnoreCase(t1.getNombre());
        }
        return t.getApellidos().compareToIgnoreCase(t1.getApellidos());
    }
    
}
