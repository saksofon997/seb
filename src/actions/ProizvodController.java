package actions;

import java.awt.Image;

import models.Proizvod;
import views.MainFrame;
import views.ProizvodView;

public class ProizvodController {

	private static Proizvod proizvod;
	private static ProizvodView proizvodView;
	
	public ProizvodController(Proizvod proizvod, ProizvodView proizvodView) {
		setProizvod(proizvod);
		setProizvodView(proizvodView);
	}
	
	public void setProizvod(Proizvod proizvod) {
		if(proizvod == null)
			throw new NullPointerException();
		ProizvodController.proizvod = proizvod;
	}
	
	public void setProizvodView(ProizvodView proizvodView) {
		if(proizvodView == null)
			throw new NullPointerException();
		ProizvodController.proizvodView = proizvodView;
	}

	public static Proizvod getProizvod() {
		return proizvod;
	}

	public static ProizvodView getProizvodView() {
		return proizvodView;
	}
	
	public static void resetProizvod() {
		proizvod = new Proizvod();
		proizvodView.refreshView();
	}
	
	public String createProizvod(String naziv, String kreator, String verzija, Image logo) {
		if(naziv == null)
			return MainFrame.getInstance().getResourceBundle().getString("gNaziv");
		naziv = naziv.trim();
		if(naziv.isEmpty())
			return MainFrame.getInstance().getResourceBundle().getString("gNaziv");
		
		if(kreator == null)
			return MainFrame.getInstance().getResourceBundle().getString("gKreator");
		kreator = kreator.trim();
		if(kreator.isEmpty())
			return MainFrame.getInstance().getResourceBundle().getString("gKreator");
		
		if(verzija == null)
			return MainFrame.getInstance().getResourceBundle().getString("gVerzija");
		verzija = verzija.trim();
		if(verzija.isEmpty())
			return MainFrame.getInstance().getResourceBundle().getString("gVerzija");
		
		proizvod.setNaziv(naziv);
		proizvod.setKreator(kreator);
		proizvod.setVerzija(verzija);
		proizvod.setLogo(logo);
		
		return MainFrame.getInstance().getResourceBundle().getString("statusProCon");
	}
}
