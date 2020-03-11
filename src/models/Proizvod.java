package models;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import actions.MyCounter;

public class Proizvod implements Serializable{

	String naziv;
	String verzija;
	String kreator;
	Image logo;
	Kompanija parent;
	List<Object> children;
	
	public List<Object> getChildren() {
		return children;
	}

	public Proizvod() {
		this.children = new ArrayList<Object>();
	}
	
	public Proizvod(String naziv, String verzija, String kreator) {
		this();
		this.naziv = naziv;
		this.verzija = verzija;
		this.kreator = kreator;
		this.logo = null;
	}
	
	public Proizvod(String naziv, String verzija, String kreator, Image logo) {
		setNaziv(naziv);
		setKreator(kreator);
		setVerzija(verzija);
		setLogo(logo);
	}
	
	public void setParent(Kompanija parent) {
		this.parent = parent;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getVerzija() {
		return verzija;
	}

	public void setVerzija(String verzija) {
		this.verzija = verzija;
	}

	public String getKreator() {
		return kreator;
	}

	public void setKreator(String kreator) {
		this.kreator = kreator;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
	
	public void setParametri(List<Object> parametri) {
		this.children = parametri;
	}
	
	public void addParametar(Parametar newparam) {
		this.children.add(newparam);
	}
	
	public void removeParametar(Parametar param) {
		this.children.remove(param);
		param.setParent(null);
	}

	public void removeFromParent() {
		// TODO Auto-generated method stub
		this.parent.removeProizvod(this);
	}
	
	@Override
	public String toString() {
		return naziv;
	}
}
