package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import actions.MyCounter;


public class Workspace implements Serializable{
	String name;
	List<Object> children;
	
	public Workspace() {
		this.children = new ArrayList<Object>();
	}
	
	public Workspace(String name) {
		this();
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Object> getChildren() {
		return children;
	}

	public void setChildren(List<Object> kompanije) {
		this.children = kompanije;
	}
	
	public void addKompanija(Kompanija newkomp) {
		this.children.add(newkomp);
	}
	
	public void removeKompanija(Kompanija kompanija) {
		this.children.remove(kompanija);
		kompanija.setParent(null);
	}
}
