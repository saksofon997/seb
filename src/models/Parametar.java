package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import actions.MyCounter;

public class Parametar implements Serializable{

	String naziv;
	String vrednost;
	Object parent;
	List<Object> children;
	
	public Parametar() {
		this.children = new ArrayList<Object>();
	}
	
	public Object getParent() {
		return parent;
	}
	
	public List<Object> getChildren() {
		return children;
	}

	public Parametar(String naziv, String vrednost) {
		this();
		this.naziv = naziv;
		this.vrednost = vrednost;
	}
	
	public void setParent(Object parent) {
		if(parent instanceof Proizvod)
			this.parent = (Proizvod) parent;
		else if(parent instanceof Parametar)
			this.parent = (Parametar) parent;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
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
		if(this.parent instanceof Proizvod)
			((Proizvod) this.parent).removeParametar(this);
		else if(this.parent instanceof Parametar)
			((Parametar) this.parent).removeParametar(this);
	}
	
	@Override
	public String toString() {
		return naziv;
	}
}
