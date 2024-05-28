package TP05;


public class Casilla {
    
    private int valor;
    private boolean norte, sur, este, oeste;

    public Casilla(int valor,boolean norte, boolean sur, boolean este, boolean oeste){
        this.valor = valor;
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isNorte() {
        return norte;
    }

    public boolean isSur() {
        return sur;
    }

    public boolean isEste() {
        return este;
    }

    public boolean isOeste() {
        return oeste;
    }

    public boolean tengoAdyacentes() {
        return norte || sur || este || oeste;
    }

    public void setNorte(boolean norte) {
        this.norte = norte;
    }

    public void setSur(boolean sur) {
        this.sur = sur;
    }

    public void setEste(boolean este) {
        this.este = este;
    }

    public void setOeste(boolean oeste) {
        this.oeste = oeste;
    }

    @Override
    public String toString() {
        return "" + this.getValor() + "";
    }
    

}
