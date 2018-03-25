/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.springmaven.daos;

import java.util.ArrayList;
import java.util.List;
import br.com.springmaven.models.Visitante;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego
 */
@Component
public class VisitanteDao {

    public static List<Visitante> visitantes;

    static {
        System.out.println("bloco esttico");
        System.out.println("bloco esttico");
        System.out.println("bloco esttico");
        System.out.println("bloco esttico");
        System.out.println("bloco esttico");
        System.out.println("bloco esttico");
        System.out.println("bloco esttico");
        visitantes = new ArrayList<>();
        visitantes.add(new Visitante(1, "vi1"));
        visitantes.add(new Visitante(2, "vi2"));
        visitantes.add(new Visitante(3, "vi3"));
    }

    public Visitante get(int id) {
        for (Visitante visitante : visitantes) {
            if (visitante.getId() == id) {
                return visitante;
            }

        }
        return null;
    }

    public Visitante[] getAll() {
        Visitante[] stockArr = visitantes.toArray(new Visitante[visitantes.size()]);
        return stockArr;
    }

    public void insert(Visitante visitante) {
        visitantes.add(visitante);
    }
    
    public void delete(int id) {
        for(Visitante vis:visitantes){
            if(vis.getId() == id){
                visitantes.remove(vis);
            }
        }
    }
    

}
