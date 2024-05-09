package TP03;

import java.util.ArrayList;
import java.util.List;

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
                this.root = null;
                return true;
            }
            else{
                return delete(this.root, value);
            }
        }
        return false;
    }

    private boolean delete(TreeNode actual,int value){
        if(value > actual.getValue() && actual.getRight() != null){
            if(actual.getRight().getValue() == value){
                actual.getRight().setRight(null);
                return true;
            }
            else{
                delete(actual.getRight(), value);
            }
        }
        else if(value < actual.getValue() && actual.getLeft() != null){
            if(actual.getLeft().getValue() == value){
                actual.getLeft().setLeft(null);
                return true;
            }
            else{
                delete(actual.getLeft(), value);
            }
        }
        return false;
    }

    public int getHeight(){
        if(this.root != null){
            return 0 + Math.max(getHeight(root.getRight()), getHeight(root.getLeft()));
        }
        return 0;
    }

    private int getHeight(TreeNode actual){
        if(actual == null){
            return 0;
        }
        return 1 + Math.max(getHeight(actual.getRight()), getHeight(actual.getLeft()));
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

    public Integer getMaxElem(){
        if(this.root == null){
            return null;
        }
        return getMaxElem(this.root.getRight());
    }

    private Integer getMaxElem(TreeNode actual){
        if(actual != null){
            if(actual.getRight() != null){
                int maxElem = getMaxElem(actual.getRight());
                return maxElem;
            }
            int aux = actual.getValue();
            return aux;
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
        elems = getElemsElderlyThanK(actual.getRight(), num);
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