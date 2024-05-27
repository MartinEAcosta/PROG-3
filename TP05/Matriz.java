package TP05;

public class Matriz {

    private static final int MAXFIL = 3;
    private static final int MAXCOL = 3;


    private Casilla [][] mat;


    public Matriz(Casilla [][] mat){
        this.mat = mat;
    }



    public Casilla getByPos(int x,int y){
        return mat[x][y];
    }

    public int getX(Casilla actual){
        int x = 0;
        for(int i=0;i<MAXFIL;i++){
            for(int j=0;j<MAXCOL;j++){
                if(mat[i][j]==actual){
                    return x;
                }
            }
        }
        return x;
    }

    public int getY(Casilla actual){
        int y = 0;
        for(int i=0;i<MAXFIL;i++){
            for(int j=0;j<MAXCOL;j++){
                if(mat[i][j]==actual){
                    return y;
                }
            }
        }
        return y;
    }


    public Casilla avanzar(String dir,Casilla actual){
        int x = getX(actual);
        int y = getY(actual);
        switch(dir){
            case "N":
                return mat[y-1][x];
            case "S":
                return mat[y+1][x];
            case "E":
                return mat[y][x+1];
            case "O":
                return mat[y][x-1];
            default:
                return null;
        }
    }

}
