package actions;

import models.Kompanija;
import views.KompanijaView;
import views.MainFrame;

public class KompanijaController {

	private static Kompanija kompanija;
	private static KompanijaView kompanijaView;
	
	public KompanijaController(Kompanija kompanija, KompanijaView kompanijaView) {
		setKompanija(kompanija);
		setKompanijaView(kompanijaView);
		
	}

	public void setKompanija(Kompanija kompanija) {
		if(kompanija == null) {
			throw new NullPointerException();
		}
		KompanijaController.kompanija = kompanija;
	}

	public void setKompanijaView(KompanijaView kompanijaView) {
		if(kompanijaView == null) {
			throw new NullPointerException();
		}
		KompanijaController.kompanijaView = kompanijaView;
	}
	
	public static Kompanija getKompanija() {
		return kompanija;
	}
	
	public static void resetKompanija() {
		kompanija = new Kompanija();
		kompanijaView.refreshView();
	}

	public KompanijaView getKompanijaView() {
		return kompanijaView;
	}

	public String createKompanija(String naziv, String sediste, String CEO) {
		if(naziv == null) {
			return MainFrame.getInstance().getResourceBundle().getString("gNaziv");
		}
		naziv = naziv.trim();
		if(naziv.isEmpty()) {
			return MainFrame.getInstance().getResourceBundle().getString("gNaziv");
		}
		
		if(sediste == null) {
			return MainFrame.getInstance().getResourceBundle().getString("gSediste");
		}
		sediste = sediste.trim();
		if(sediste.isEmpty()) {
			return MainFrame.getInstance().getResourceBundle().getString("gSediste");
		}
		
		if(CEO == null) {
			return MainFrame.getInstance().getResourceBundle().getString("gCeo");
		}
		CEO = CEO.trim();
		if(CEO.isEmpty()) {
			return MainFrame.getInstance().getResourceBundle().getString("gCeo");
		}
		
		kompanija.setNaziv(naziv);
		kompanija.setSediste(sediste);
		kompanija.setCEO(CEO);
		
		return MainFrame.getInstance().getResourceBundle().getString("statusKompCon");
	}
}
