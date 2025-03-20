package tp2;

import java.util.ArrayList;

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
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	public int getRoot(){
		return this.root.getValue();
	}

	public boolean hasElem(int elem){
		return hasElem(this.root, elem);
	}

	private boolean hasElem(TreeNode node,int elem){
		if(node != null){
			if(node.getValue() == elem){
				return true;
			}
			else if(node.getValue() > elem){
				return hasElem(node.getLeft(), elem);
			}
			else{
				return hasElem(node.getRight(), elem);
			}
		}
		return false;
	}

	public boolean isEmpty(){
		return this.root == null;
	}

	public boolean delete(int numero){
		if(this.root != null){
			return delete(this.root, numero);
		}
		return false;

	}

	private boolean delete(TreeNode node,int num){
		if(node.getValue() > num){
			if(node.getRight().getValue() == num){
				TreeNode aux = node.getRight();
				node.setRight(null);
				if(aux.getLeft() != null){
					reordenar(node,aux.getLeft(),true);
				}
				else if(aux.getRight() != null){
					reordenar(node,aux.getRight(),false);
				}
				return true;
			}
			else{
				delete(node.getRight(), num);
			}
		}
		else if(node.getValue() < num){
			if(node.getLeft().getValue() == num){
				TreeNode aux = node.getLeft();
				node.setLeft(null);
				if(aux.getLeft() != null){
					reordenar(node,aux.getLeft(),true);
				}
				else if(aux.getRight() != null){
					reordenar(node,aux.getRight(),false);
				}
				return true;
			}
			else{
				delete(node.getLeft(), num);
			}
		}
		return false;
	}

	private void reordenar(TreeNode padre, TreeNode subArbol, boolean dir) {
		TreeNode maximoDerecho = subArbol;
		while(maximoDerecho.getRight() != null){
			maximoDerecho = maximoDerecho.getRight();
		}
		if(maximoDerecho.getLeft()!= null){
			padre.setRight(maximoDerecho.getLeft());
		}
		else{
			padre.setRight(null);
		}
		if(dir){
			padre.setLeft(maximoDerecho);
		}
		else{
			padre.setRight(maximoDerecho);
		}
	}

	public int getHeight(){
		if (this.root!=null) {
			return Math.max(getHeight(this.root.getLeft()), getHeight(this.root.getRight()));
		}
		return 0;
	}

	private int getHeight(TreeNode nodo) {
		if(nodo == null){
			return 0;
		}
		return 1 + Math.max(getHeight(nodo.getLeft()),getHeight(nodo.getRight()));
	}

	public ArrayList<TreeNode> getFrontera(){
		return getFrontera(this.root);
	}

	private ArrayList<TreeNode> getFrontera(TreeNode nodo) {
		if(nodo == null){
			return new ArrayList<TreeNode>();
		}
		ArrayList<TreeNode> izq = getFrontera(nodo.getLeft());
		ArrayList<TreeNode> der = getFrontera(nodo.getRight());
		ArrayList<TreeNode> frontera = new ArrayList<TreeNode>();
		if(nodo.getLeft() == null && nodo.getRight() == null){
			if(nodo.getValue() > this.root.getValue()){
				der.add(nodo);
			}
			else{
				izq.add(nodo);
			}
		}
		frontera.addAll(izq);
		frontera.addAll(der);
		return frontera;
	}

	public int getElemMax(){
		if(this.root == null){
			return -1;
		}
		return getElemMax(this.root);
	}

	private int getElemMax(TreeNode actual){
		if(actual != null){
			if(actual.getRight() != null){
				int maxElem = getElemMax(actual.getRight());
				return maxElem;
			}
			int soyMax = actual.getValue();
			return soyMax;
		}
		return -1;
	}
	
	public ArrayList<TreeNode> getElemAtLevel(int lvl){
		ArrayList<TreeNode> elementos = new ArrayList<TreeNode>();
		if(this.root != null){
			int piso = 0;
			elementos = getElemAtLevel(lvl,piso,this.root);
		}
		return elementos;
	}

	private ArrayList<TreeNode> getElemAtLevel(int lvl, int piso, TreeNode actual) {
		if(actual == null){
			return new ArrayList<TreeNode>();
		}
		ArrayList<TreeNode> izq = getElemAtLevel(lvl,piso+1,actual.getLeft());
		ArrayList<TreeNode> der = getElemAtLevel(lvl,piso+1,actual.getRight());
		ArrayList<TreeNode> elems = new ArrayList<>();
		if(piso == lvl){
			elems.add(actual);
		}
		return elems;
	}
}
