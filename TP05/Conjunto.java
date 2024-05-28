package TP05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Conjunto {
    
    private ArrayList<Integer> elementos;
    private HashMap<Integer,ArrayList<Integer>> combinaciones;

    public Conjunto(){
        this.combinaciones = new HashMap<>();
        this.elementos = new ArrayList<>();
    }
    
    public void addSubconjunto(int num){
        if(!this.elementos.contains(num)){
            this.elementos.add(num);
        }
    }

}
