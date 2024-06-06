package TP05;

import java.util.ArrayList;
import java.util.Iterator;

public class Conjunto {
    
    private ArrayList<Integer> elementos;
    private ArrayList<ArrayList<Integer>> combinaciones;

    public Conjunto(){
        this.combinaciones = new ArrayList<ArrayList<Integer>>();
        this.elementos = new ArrayList<Integer>();
    }
    
    public void addSubconjunto(int num){
        if(!this.elementos.contains(num)){
            this.elementos.add(num);
        }
    }

    public ArrayList<ArrayList<Integer>> combinacionesPosibles(int m){
        for(Integer elem : elementos){
            combinacionesPosibles(m,elem,elem,new ArrayList<Integer>());
        }
        return this.combinaciones;
    }

    private void combinacionesPosibles(int m,Integer actual,Integer sumaActual,ArrayList<Integer> combinacionActual){
        if(!combinacionActual.contains(actual)){
        combinacionActual.add(actual);
        if(sumaActual == m){
            this.combinaciones.add(new ArrayList<>(combinacionActual));
        }
        else if(sumaActual < m){
            Iterator<Integer> it = elementos.iterator();
            while (it.hasNext()) {
                Integer elem = it.next();
                combinacionesPosibles(m, elem, sumaActual+elem, combinacionActual);
            }
        }
        combinacionActual.remove(actual);
        }
    }

}
