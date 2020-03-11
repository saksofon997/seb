package actions;

import models.Parametar;
import views.MainFrame;
import views.ParametarView;

public class ParametarController {

	private static Parametar parametar;
	private static ParametarView parametarView;
	
	public ParametarController(Parametar parametar, ParametarView parametarView) {
		setParametar(parametar);
		setParametarView(parametarView);	
	}

	public static Parametar getParametar() {
		return parametar;
	}

	public static void setParametar(Parametar parametar) {
		if(parametar == null)
			throw new NullPointerException();
		ParametarController.parametar = parametar;
	}

	public static ParametarView getParametarView() {
		return parametarView;
	}
	
	public static void resetParametar() {
		parametar = new Parametar();
		parametarView.refreshView();
	}

	public static void setParametarView(ParametarView parametarView) {
		if(parametarView == null)
			throw new NullPointerException();
		ParametarController.parametarView = parametarView;
	}
	
	public String createParametar(String naziv, String vrednost) {
		if(naziv == null) {
			return MainFrame.getInstance().getResourceBundle().getString("gNaziv");
		}
		naziv = naziv.trim();
		if(naziv.isEmpty()) {
			return MainFrame.getInstance().getResourceBundle().getString("gNaziv");
		}
		
		if(vrednost == null) {
			return MainFrame.getInstance().getResourceBundle().getString("gVrednost");
		}
		vrednost = vrednost.trim();
		if(vrednost.isEmpty()) {
			return MainFrame.getInstance().getResourceBundle().getString("gVrednost");
		}
		
		parametar.setNaziv(naziv);
		parametar.setVrednost(vrednost);
		
		return MainFrame.getInstance().getResourceBundle().getString("statusParCon");
	}
}
