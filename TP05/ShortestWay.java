package TP05;

import java.util.ArrayList;

public class ShortestWay {
    
    private int caminoCorto = 200;

    
    public int getShortestWay(Matriz mat,int eX, int eY, int dX, int dY){
        return getShortestWay(mat, eX, eY, dX, dY, 0);
    }


    private int getShortestWay(Matriz mat, int eX, int eY, int dX, int dY, int sumaCamino) {
        Casilla actual = mat.getByPos(eX, eY);
        sumaCamino += actual.getValor();
        if(eX == dX && eY == dY){
            if(sumaCamino < caminoCorto){
                caminoCorto = sumaCamino;
            }
            return caminoCorto;
        }
        else{
            while(actual.tengoAdyacentes()){
                if(actual.isNorte()){
                    sumaCamino = getShortestWay(mat, eX, eY-1, dX, dY, sumaCamino);
                    actual.setNorte(false);
                }
                else if(actual.isSur()){
                    sumaCamino = getShortestWay(mat, eX, eY+1,dX, dY,sumaCamino);
                    actual.setSur(false);
                }
                else if(actual.isEste()){
                    sumaCamino = getShortestWay(mat,eX+1, eY, dX, dY,sumaCamino);
                    actual.setEste(false);
                }
                else if(actual.isOeste()){
                    sumaCamino = getShortestWay(mat, eX-1, eY, dX, dY, sumaCamino);
                    actual.setOeste(false);
                }
                sumaCamino = actual.getValor();
            }
        }
        return caminoCorto;
    }

    public int calcularCamino(ArrayList<Integer> valores){
        int camino = 0;
        for(int i = 0; i<valores.size();i++){
            camino += valores.get(i);
        }
        return camino;
    }
}
