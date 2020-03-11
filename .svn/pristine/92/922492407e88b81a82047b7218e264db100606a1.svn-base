package views.tree;

import models.Parametar;

public class CheckBoxNode extends CheckBoxNodeData{

	private Parametar par;
	
	public CheckBoxNode() {
		super("ne radi", true);
	}
	
	public CheckBoxNode(Parametar objekat, boolean checked) {
		// TODO Auto-generated constructor stub
		super(objekat.getNaziv(), checked);
		this.setPar(objekat);
	}

	public Parametar getPar() {
		return par;
	}

	public void setPar(Parametar par) {
		this.par = par;
	}

	@Override
	public String toString() {
		return par.getNaziv();
	}
}
