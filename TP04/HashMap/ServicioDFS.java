package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import TP03.TreeNode;
import tp2.Tree;

public class ServicioDFS<T> {

    private HashMap<Integer, String> colores;
    private HashMap<Integer, LinkedList<Integer>> tiempos;

    public ServicioDFS() {
        this.colores = new HashMap<>();
    }
    
    public void DFS(Grafo<T> grafo){
        //obtengo todos los vertices del grafo que me dan
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()) {
            //tomo el del iterador y los marco como no visidatos ("blanco")
            Integer vertice = it.next();
            colores.put(vertice,"Blanco");
        }
        //se inicializa el tiempo de descubrimiento
        int tiempo = 0;
        Iterator<Integer> it2 = grafo.obtenerVertices();
        //por cada vertice de mi grafo pregunto si esta en blanco, en caso de que este se visita
        while (it2.hasNext()) {
            Integer vertice = it2.next();
            if(colores.get(vertice) == "Blanco"){
                dfsVisit(grafo,vertice,tiempo);
            }
        }
    }

    private void dfsVisit(Grafo<T> grafo, Integer vertice, int tiempo) {
        System.out.println(" " + vertice);
        //lo marco como visitado 
        colores.put(vertice,"Amarillo");
        //itero el tiempo de descubrimiento
        tiempo++;
        //asigno el tiempo de descubrimiento
        tiempos.put(vertice, null);
        tiempos.get(vertice).add(tiempo);
        //obtengo los adyacentes del vertice actual
        Iterator<Integer> ady = grafo.obtenerAdyacentes(vertice);
        while(ady.hasNext()){
            Integer v = ady.next();
            //Si el vertice adyacente no se encuentra visitado ("Blanco") se llama a recursión
            if(colores.get(v) == "Blanco"){
                dfsVisit(grafo, v, tiempo);
            }
            //Si se encuentra visitado ("Amarillo") marca un ciclo
            else if(colores.get(v) == "Amarillo"){
                System.out.println("Hay ciclo");
            }
        }
        colores.put(vertice, "Negro");
        tiempo = tiempo+1;
        tiempos.get(vertice).add(tiempo);
    }

    
}



/*Dado un conjunto N de números enteros distintos, se desea encontrar, si existen, 
4 subconjuntos no vacíos y disjuntos que sean una partición de N (o sea la unión 
de los 4 subconjuntos es igual al conjunto N), tal que la suma de los elementos 
de cada subconjunto sea igual a un número T dado como parámetro. */
ArrayList<ArrayList<Integer>> conjuntoSolucion;

public ArrayList<ArrayList<Integer>> backtracking(ArrayList<Integer> conjunto, int T ){
    ArrayList<Integer> suma = new ArrayList<>();
    Iterator<Integer> it = conjunto.iterator();
    while (it.hasNext()) {
        Integer nro = it.next();
        suma.add(nro);
        backtracking(conjunto, T, suma);
        if(this.conjuntoSolucion.size() == 4){
            return this.conjuntoSolucion;
        }
        suma.remove(nro);
    }
    return this.conjuntoSolucion;
}

public void backtracking(ArrayList<Integer> conjunto, int T, ArrayList<Integer> suma){
    if(this.conjuntoSolucion.size() != 4){
        if(calcularSubconjunto(suma) == T){
            this.conjuntoSolucion.add(new ArrayList<>(suma));
        }
        else{
            Iterator<Integer> it = conjunto.iterator();
            while (it.hasNext()) {
                Integer nro = it.next();
                if(!suma.contains(nro)){
                    suma.add(nro);
                    backtracking(conjunto, T,suma);
                    suma.remove(nro);
                }
            }
        }
    }
}

public Camino verificarCamino(int k, Tree arbol){
    if(arbol.getRoot() != null){
        Camino camino = new Camino();
        verificarCamino(k,arbol.getRoot(),camino);
    }
    return this.sol;
}

private void verificarCamino(int k, TreeNode actual, Camino camino){
    if(actual != null && this.sol == null){
        k -= actual.getValue();
        camino.setK(k);
        camino.add(actual);
        if(camino.getK() > 0){
            if(actual.getRight() == null && actual.getLeft() == null){
                this.sol = camino;
            }
            else{
                    verificarCamino(k, actual.getRight(), camino);
                    verificarCamino(k, actual.getLeft(), camino);
            }
        }
        k += actual.getValue();
        camino.remove(actual);
    }
}

/*Dada una matriz de 5x5, en cuyas casillas se encuentran desordenados los numeros enteros
 * del 1 al 24, y una casilla desocupada en una posicion inicial dada determinar una secuencia
 * de pasos tal que intermcabiando numeros contiguos con la casilla desocupada
 * (en horizontal y en vertical) resume en que los numeros en la matriz queden ordenados y la casilla
 * desocupada quede en la posicion que se muestra
 */

 //Supuse que contengo una Matriz sol inicializada en nulo
 public Matriz ordenarMatriz(Matriz mat, Celda vacia){
    Matriz res = mat;
    for(Celda ad : mat.getAdys(vacia)){
        res.intercambiarPos(vacia,ad);
        //Supuse que el metodo intercambiar pos setea el x e y de
        //La celda tambien.
        ordenarMatriz(res, vacia);
        if(this.sol != null){
            return this.sol;
        }
        res.intercambiarPost(ad,vacia);
    }
 }

 private void ordenarMatriz(Matriz mat, Celda vacia){
    if(mat.isOrdered()){
        if(vacia.getPosX() == 4 && vacia.getPosY() == 4){
            this.sol = mat;
        }
    }
    else{
        Iterator<Celda> it = mat.getAdys(vacia);
        while(it.hasNext()){
            Celda ad = it.next();
            mat.intercambiarPos(vacia,ad);
            ordenarMatriz(mat, vacia);
            if(this.sol != null){
                return this.sol;
            }
            mat.intercambiarPos(ad,vacia);
        }
    }
}