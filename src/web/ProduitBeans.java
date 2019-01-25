package web;

import java.util.ArrayList;

import metier.Produit;

public class ProduitBeans {
	private Produit produit = new Produit();
	private ArrayList<Produit> list = new ArrayList<Produit>();
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit
	}
	
	
	public ArrayList<Produit> getList() {
		return list;
	}
	public void setList(ArrayList<Produit> arrayList) {
		this.list = arrayList;
	}
	
	
}
