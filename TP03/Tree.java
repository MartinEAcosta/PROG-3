package TP03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Node;

import HashMap.Grafo;
import tp4.Arco;

public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} 
        else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}

    public Integer getRoot(){
        return this.root.getValue();
    }

    public boolean hasElem(int value){
        if(this.root != null){
            if(this.root.getValue() == value){
                return true;
            }
            else{
                return hasElem(this.root,value);
            }
        }
        return false;
    }

    private boolean hasElem(TreeNode actual,int value){
        if(actual.getValue() == value){
            return true;
        }
        else if(value > actual.getValue() && actual.getRight() != null){
            return hasElem(actual.getRight(),value);
        }
        else if(value< actual.getValue() && actual.getLeft() != null){
            return hasElem(actual.getRight(), value);
        }
        return false;
    }

    public boolean isEmpty(){
        return this.root == null;
    }


    public boolean delete(int value){
        if(this.root != null){
            if(this.root.getValue() == value){
                if(hasDescendent(this.root)){
                    this.root = reordenarArbol(this.root);
                }
            }
            else{
                return delete(this.root, value);
            }
        }
        return false;
    }

    private TreeNode reordenarArbol(TreeNode nodo) {
        if(nodo.getLeft() != null && nodo.getRight() != null){
            TreeNode aun = obtenerNMISD(nodo.getRight());
            delete(aun.getValue());
            return aun;
        }
        else if(nodo.getLeft() != null && nodo.getRight() == null){
            return nodo.getLeft();
        }
        else if(nodo.getLeft() == null && nodo.getRight() != null){
            return nodo.getRight();
        }
        return null;
    }

    private TreeNode obtenerNMISD(TreeNode nodo) {
        if(nodo.getLeft() == null){
            return nodo;
        }
        return obtenerNMISD(nodo.getLeft());
    }

    private boolean delete(TreeNode actual,int value){
        if(value > actual.getValue() && actual.getRight() != null){
            if(actual.getRight().getValue() == value){
                if(hasDescendent(actual.getRight())){
                    TreeNode aun = reordenarArbol(actual.getRight());
                    actual.setRight(aun);
                    return true;
                }
                else{
                    actual.setRight(null);
                    return true;
                }
            }
            else{
                delete(actual.getRight(), value);
            }
        }
        else if(value < actual.getValue() && actual.getLeft() != null){
            if(actual.getLeft().getValue() == value){
                if(hasDescendent(actual.getRight())){
                    TreeNode aun = reordenarArbol(actual.getRight());
                    actual.setRight(aun);
                    return true;
                }
                else{
                    actual.setRight(null);
                    return true;
                }
            }
            else{
                delete(actual.getLeft(), value);
            }
        }
        return false;
    }


    private boolean hasDescendent(TreeNode right) {
        return right.getLeft() != null || right.getRight() != null;
    }

    public int getHeight(){
        if(this.root != null){
            return 0 + Math.man(getHeight(root.getRight()), getHeight(root.getLeft()));
        }
        return 0;
    }

    private int getHeight(TreeNode actual){
        if(actual == null){
            return 0;
        }
        return 1 + Math.man(getHeight(actual.getRight()), getHeight(actual.getLeft()));
    }

    private void printPosOrder(TreeNode actual){
        if(actual == null){
            return;
        }
        printPosOrder(actual.getRight());
        printPosOrder(actual.getLeft());
        System.out.print(actual.getValue() + "");
    }

    private void printPreOrder(TreeNode actual){
        if(actual == null){
            return;
        }
        System.out.println(actual.getValue() + "");
        printPreOrder(actual.getLeft());
        printPreOrder(actual.getRight());        
    }

    private void printInOrder(TreeNode actual){
        if(actual == null){
            return;
        }
        printInOrder(actual.getLeft());
        System.out.println(actual.getValue() + "");
        printInOrder(actual.getRight());
    }
	
    public void printPosOrder(){
        printPosOrder(this.root);
    }

    public void printPreOrder(){
        printPreOrder(this.root);
    }

    public void printInOrder(){
        printInOrder(this.root);
    }

    public ArrayList<TreeNode> getLongestBranch(){
        if(this.root == null){
            return new ArrayList<>();
        }
        return getLongestBranch(this.root);
    }

    private ArrayList<TreeNode> getLongestBranch(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        ArrayList<TreeNode> izq = getLongestBranch(node.getLeft());

        ArrayList<TreeNode> der = getLongestBranch(node.getRight());

        if (izq.size() >= der.size()) {
            izq.add(node);
            return izq;
        } else {
            der.add(node);
            return der;
        }
    }

    public Integer getManElem(){
        if(this.root == null){
            return null;
        }
        return getManElem(this.root.getRight());
    }

    private Integer getManElem(TreeNode actual){
        if(actual != null){
            if(actual.getRight() != null){
                int manElem = getManElem(actual.getRight());
                return manElem;
            }
            int aun = actual.getValue();
            return aun;
        }
        return null;
    }

    public List<Integer> getFrontera(){
        if(this.root == null){
            return null;
        }
        return getFrontera(this.root);
    }

    private List<Integer> getFrontera(TreeNode actual){
        if(actual == null){
            return new ArrayList<Integer>();
        }
        List<Integer> izq = getFrontera(actual.getLeft());
        List<Integer> der = getFrontera(actual.getRight());
        List<Integer> frontera = new ArrayList<Integer>();

        if(actual.getLeft() == null && actual.getRight() == null){
            if(actual.getValue() > this.getRoot()){
                der.add(actual.getValue());
            }
            else{
                izq.add(actual.getValue());
            }
        }
        frontera.addAll(izq);
        frontera.addAll(der);
        return frontera;
    }

    public List<Integer> getElemAtLevel(int requieredLevel){
        if(this.root == null){
            return null;
        }
        int myLevel = 0;
        List<Integer> listOfLevel = new ArrayList<>();
        if(myLevel != requieredLevel){
            listOfLevel = getElemAtLevel(this.root,myLevel,requieredLevel);
        }
        else{
            listOfLevel.add(root.getValue());
        }
        return listOfLevel;
    }

    private List<Integer> getElemAtLevel(TreeNode actual, int myLevel, int requieredLevel){
        if(actual == null){
            return new ArrayList<Integer>();
        }

        List<Integer> izq = getElemAtLevel(actual.getLeft(),myLevel+1,requieredLevel);
        List<Integer> der = getElemAtLevel(actual.getRight(),myLevel+1,requieredLevel);
        if(myLevel == requieredLevel){
            izq.add(actual.getValue());
        }
        izq.addAll(der);
        return izq;
    }

    public int getTotalAmount(){
        int cant = 0;
        if(this.root == null){
            return cant;
        }
        cant += getTotalAmount(this.root);
        return cant;
    }

    private int getTotalAmount(TreeNode actual){
        if(actual == null){
            return 0;
        }
        int izq = getTotalAmount(actual.getLeft());
        int der = getTotalAmount(actual.getRight());
        
        return izq + der + actual.getValue();

    }

    public List<Integer> getElemsElderlyThanK(int num){
        if(this.root == null){
            return new ArrayList<>();
        }
        List<Integer> elems = getElemsElderlyThanK(this.root,num);
        return elems;
    }

    private List<Integer> getElemsElderlyThanK(TreeNode actual,int num){
        if(actual == null){
            return new ArrayList<>();
        }
        List<Integer> elems = new ArrayList<>();
        if(actual.getValue() > num && actual.getRight() == null && actual.getLeft() == null){
            elems.add(actual.getValue());
            return elems;
        }
        elems.addAll(getElemsElderlyThanK(actual.getRight(), num));
        elems.addAll(getElemsElderlyThanK(actual.getLeft(), num));
        return elems;
    }

    public boolean isVocal(String letra){
        if(letra == "a" || letra == "e" || letra == "i" || letra == "o" || letra == "u"){
            return true;
        }
        return false;
    }

    public void fillTreeNode(){
        if(this.root == null){
            return;
        }
        fillTreeNode(this.root,0);
    }

    private int fillTreeNode(TreeNode actual, int result){
        if(actual == null){
            return 0;
        }
        int izq = fillTreeNode(actual.getLeft(), result);
        int der = fillTreeNode(actual.getRight(), result);
        if(actual.getRight() == null && actual.getLeft() == null){
            return actual.getValue();
        }
        actual.setValue(izq-der);
        return actual.getValue();
    }
    
    public List<String> getElemsVocal(int cant){
        if(this.root == null){
            return new ArrayList<>();
        }
        List<String> elems = new ArrayList<>();
        elems = getElemsVocal(this.root,cant,"",elems);
        return elems;
    }

    private List<String> getElemsVocal(TreeNode actual,int cant,String word,List<String> elems){
        /*Si soy nulo devuelvo arraylist vacio */
        if(actual == null){
            return new ArrayList<>();
        }

        word += actual.getValue();
        int contadorVocales = 0;
        for(int i = 0; i < word.length(); i++){
            if(isVocal(String.valueOf(word.charAt(i)))){
                contadorVocales++;
            }
        }
        if(contadorVocales == cant && actual.getLeft() == null && actual.getRight() == null){
            elems.add(word);
        }

        getElemsVocal(actual.getLeft(), cant, word, elems);
        getElemsVocal(actual.getRight(), cant, word, elems);

        return elems;
    }
}


public ArrayList<Node> greedy(Matriz mat){
    ArrayList<Node> camino = new ArrayList<>();
    //busco la mejor opción segun el criterio de empezar por el numero mas grande de la matriz
    Node aun = obtenerMejorCandidato(mat);
    camino.add(aun);
    //mientras que tenga movimientos
    while(aun.hasMovement()){
        aun = obtenerMejorCandidato(mat,aun,camino);
        if(aun != null){
            camino.add(aun);
        }
    }
    return camino;
}

public Node obtenerMejorCandidato(Matriz mat){
    Node mejor = null;
    int mejorCosto = Integer.MIN_VALUE;
    for(int i = 0; i < mat.getFilas(); i++){
        for(int j = 0; j < mat.getColumnas(); j++){
            if(mat.getValor(i,j) > mejorCosto){
                mejor = mat.getNode(i,j);
            }
        }
    }
    return mejor;
}

public Node obtenerMejorCandidato(Matriz mat, Node aun, ArrayList<Node> camino){
    Node mejor = null;
    int mejorOpcion = Integer.MIN_VALUE;
    for(Node ady : mat.getAdyacentes(aun)){
        if(!camino.contains(ady)){
            if(aun.getValor() >= ady.getValor()){
                if(ady.getValor() > mejorOpcion){
                    mejor = ady;
                    mejorOpcion = ady.getValor();
                }
            }
        }
    }
    return mejor;
}

public Solucion backtracking(int n, int v ){
    ArrayList<Integer> combinacion = new ArrayList<>();
    int i = 1;
    while(i < n){
        combinacion.add(i);
        if(sumar(combinacion)<v){
            backtracking(n, v, i,combinacion);
        }
        combinacion.remove(i);
    }
    return sol;
}

private void backtracking(int n, int v, int actual, ArrayList<Integer> combinacion){
    if(sumar(combinacion) == v){
        if(!sol.esRepetida(combinacion)){
            sol.agregarSolucion(combinacion);
        }
    }
    else{
        if(sumar(combinacion) < v){
            int i = 1;
            while(i< n){
                if(!limiteRepetidos(i,combinacion)){
                    combinacion.add(i);
                    backtracking(n, v, i, combinacion);
                    combinacion.remove(i);
                }
                i++;
            }
        }
    }
}

public Figura trazar(Vertice origen, Grafo g){
    //Figura tendra como atributo un lista de arcos 
    Figura sol = new Figura(new ArrayList<Arco>());
    //Por cada arco adyacente, es decir un posible movimiento.
    for(Arco ad : g.obtenerArcos(origen)){
        sol.addCamino(ad);
        sol = trazar(sol.getVerticeDestino(), g,sol);
        if(sol != null){
            return sol;
        }
        sol.removeCamino(ad);
    }
    return null;
}

private Figura trazar(Vertice actual, Grafo<T> g, Figura sol){
    //Si llego a 6 quiere decir que no me quedan arcos por visitar
    //Ya que solo puedo pasar una vez por cada vertice (Son 5 vertices en total)
    //Y no puedo levantar el lapiz del trazo.
    if(sol.getCamino().length == 6){
        return sol;
    }
    else{
        //Por cada arco adyacente, es decir un posible movimiento.
        Iterator<Arco> it = g.obtenerArcos(actual);
        while(it.hasNext()){
            Arco<T> sig = it.next();
            //Si esta visitado no me interesa viajar a el por lo tanto chequeo antes.
            if(!sol.hasVisited(sig)){
                sol.addCamino(sig);
                sol = trazar(sig.getVerticeDestino(), g, sol);
                if(sol != null){
                    return sol;
                }
                sol.removeCamino(sig);
            }
            //en caso de no estar visitado entra denuevo en el while y busca si hay mas arcos adyacentes
        }
        return null;
    }
}

//Asumo que tengo un HashMap de visitados.
public boolean obtenerCicloIgual(int x, Grafo g){
    ArrayList<Vertice> camino = new ArrayList<>();
    
    //Por cada vertice que tomare como origen
    //pinto a todos los vertices de blanco
    
    for(Vertice sel : g.obtenerVertices()){

        for(Vertice v : g.obtenerVertices()){

            visitados.put(v,"Blanco");

        }

        if(visitados.get(sel) == "Blanco"){
            dfsModified(x,sel,g,camino);
            if(cumple != false){
                return cumple;
            }
        }

    }
    return false;
}

private void dfsModified(int x, Vertice actual, Grafo g, ArrayList<Vertice> camino){
    visitados.put(actual,"Amarillo");
    camino.add(actual);
    Iterator<Vertice> it = g.obtenerAdyacentes(actual);
    while(it.hasNext()){
        Vertice sig = it.next();
        if(visitados.get(sig) == "Blanco"){
            dfsModified(x,sig,g,camino);
        }
        else if(visitados.get(sig) == "Amarillo"){
            //si el vertice ya fue visitado y no es el origen
            //entonces hay un ciclo
            int suma = recopilarTotalCiclo(camino,sig);
            this.cumple = (x == suma);
        }
    }
    camino.remove(actual);
    visitados.put(actual,"Negro");
}