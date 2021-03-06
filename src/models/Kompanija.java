package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import actions.MyCounter;

public class Kompanija implements Serializable{

	String naziv;
	String sediste;
	String CEO;
	Workspace parent;
	List<Object> children;
	
	public Kompanija() {
		this.children = new ArrayList<Object>();
		this.naziv = "";
		this.sediste = "";
		this.CEO = "";
	}
	
	public Kompanija(String naziv, String sediste, String CEO) {
		this();
		this.naziv = naziv;
		this.sediste = sediste;
		this.CEO = CEO;
	}
	
	public void setParent(Workspace parent) {
		this.parent = parent;
	}

	public String getSediste() {
		return sediste;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}
	
	public void setProizvod(List<Object> proizvodi) {
		this.children = proizvodi;
	}
	
	public List<Object> getChildren() {
		return children;
	}

	public void addProizvod(Proizvod newproizvod) {
		this.children.add(newproizvod);
	}
	
	public void removeProizvod(Proizvod proizvod) {
		this.children.remove(proizvod);
		proizvod.setParent(null);
	}

	public void removeFromParent() {
		// TODO Auto-generated method stub
		this.parent.removeKompanija(this);
		
	}
}
