package TP05.EJ04;

import java.util.ArrayList;

public class Conjunto {
    
    private ArrayList<Subconjunto> conjunto;
    

    public Conjunto(ArrayList<Subconjunto> conjunto){
        this.conjunto = conjunto;
    }

    public ArrayList<Subconjunto> getElementos() {
        return new ArrayList<>(conjunto);
    }






}
