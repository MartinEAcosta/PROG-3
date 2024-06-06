package TP05.EJ04;

import java.util.ArrayList;


public class ParticionDeConjunto {

    private ArrayList<Subconjunto> sol;

    public ParticionDeConjunto() {
        this.sol = new ArrayList<Subconjunto>();
    }

    public ArrayList<Subconjunto> obtenerSumaSubconjuntosIguales(Conjunto conjunto) {
        ArrayList<Subconjunto> elementos = conjunto.getElementos();
        ArrayList<Subconjunto> caminoActual = new ArrayList<>();
        for (Subconjunto actual : elementos) {
            caminoActual.add(actual);
            actual.setVisitado(true);
            obtenerSumaSubconjuntosIguales(conjunto, caminoActual, 0, actual.obtenerSuma());
            caminoActual.remove(actual);
            actual.setVisitado(false);
        }
        return sol;

    }

    private ArrayList<Subconjunto> obtenerSumaSubconjuntosIguales(Conjunto conjunto, ArrayList<Subconjunto> caminoActual, int sumaActual, int sumaConjunto) {
        if (sumaActual == sumaConjunto) {
            for(Subconjunto sub : caminoActual){
                if(sub.obtenerSuma() == sumaConjunto){
                    sol.add(new Subconjunto(sub.getElementos()));
                }
            }
            return sol;
        } else {
            sumaActual = 0;
            for (Subconjunto actual : conjunto.getElementos()) {
                if (!actual.estaVisitado()) {
                    caminoActual.add(actual);
                    actual.setVisitado(true);
                    sol = obtenerSumaSubconjuntosIguales(conjunto, caminoActual, sumaActual + actual.obtenerSuma(), sumaConjunto);
                    if(sol != null){
                        return sol;
                    }
                    caminoActual.remove(actual);
                    actual.setVisitado(false);
                }
            }
        }
        return sol;
    }

    public ArrayList<Subconjunto> getSol() {
        return this.sol;
    }
}