package TP05.EJ04;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        

        ParticionDeConjunto alg = new ParticionDeConjunto();
    
        Subconjunto sub1 = new Subconjunto();
        sub1.addElemento(5);
        sub1.addElemento(10);
        Subconjunto sub2 = new Subconjunto();
        sub2.addElemento(1);
        sub2.addElemento(3);
        Subconjunto sub3 = new Subconjunto();
        sub3.addElemento(2);
        sub3.addElemento(4);
        Subconjunto sub4 = new Subconjunto();
        sub4.addElemento(6);
        sub4.addElemento(9);
        Subconjunto sub5 = new Subconjunto();
        sub5.addElemento(7);
        sub5.addElemento(7);
        Subconjunto sub6 = new Subconjunto();
        sub6.addElemento(8);
        sub6.addElemento(7);

        ArrayList<Subconjunto> c = new ArrayList<>();
        c.add(sub1);
        c.add(sub2);
        c.add(sub3);
        c.add(sub4);
        c.add(sub5);
        c.add(sub6);
        Conjunto conj = new Conjunto(c);

        System.out.println(alg.obtenerSumaSubconjuntosIguales(conj));
        

    }
}
